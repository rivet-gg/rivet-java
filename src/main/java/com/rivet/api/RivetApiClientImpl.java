package com.rivet.api;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Environment;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.chat.ChatClient;
import com.rivet.api.resources.chat.ChatClientImpl;
import com.rivet.api.resources.cloud.CloudClient;
import com.rivet.api.resources.cloud.CloudClientImpl;
import com.rivet.api.resources.group.GroupClient;
import com.rivet.api.resources.group.GroupClientImpl;
import com.rivet.api.resources.identity.IdentityClient;
import com.rivet.api.resources.identity.IdentityClientImpl;
import com.rivet.api.resources.kv.KvClient;
import com.rivet.api.resources.kv.KvClientImpl;
import com.rivet.api.resources.matchmaker.MatchmakerClient;
import com.rivet.api.resources.matchmaker.MatchmakerClientImpl;
import com.rivet.api.resources.party.PartyClient;
import com.rivet.api.resources.party.PartyClientImpl;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

public final class RivetApiClientImpl implements RivetApiClient {
  private final ClientOptions clientOptions;

  private final Supplier<ChatClient> chatClient;

  private final Supplier<CloudClient> cloudClient;

  private final Supplier<GroupClient> groupClient;

  private final Supplier<IdentityClient> identityClient;

  private final Supplier<KvClient> kvClient;

  private final Supplier<PartyClient> partyClient;

  private final Supplier<MatchmakerClient> matchmakerClient;

  public RivetApiClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.chatClient = Suppliers.memoize(() -> new ChatClientImpl(clientOptions));
    this.cloudClient = Suppliers.memoize(() -> new CloudClientImpl(clientOptions));
    this.groupClient = Suppliers.memoize(() -> new GroupClientImpl(clientOptions));
    this.identityClient = Suppliers.memoize(() -> new IdentityClientImpl(clientOptions));
    this.kvClient = Suppliers.memoize(() -> new KvClientImpl(clientOptions));
    this.partyClient = Suppliers.memoize(() -> new PartyClientImpl(clientOptions));
    this.matchmakerClient = Suppliers.memoize(() -> new MatchmakerClientImpl(clientOptions));
  }

  @Override
  public ChatClient chat() {
    return this.chatClient.get();
  }

  @Override
  public CloudClient cloud() {
    return this.cloudClient.get();
  }

  @Override
  public GroupClient group() {
    return this.groupClient.get();
  }

  @Override
  public IdentityClient identity() {
    return this.identityClient.get();
  }

  @Override
  public KvClient kv() {
    return this.kvClient.get();
  }

  @Override
  public PartyClient party() {
    return this.partyClient.get();
  }

  @Override
  public MatchmakerClient matchmaker() {
    return this.matchmakerClient.get();
  }

  public static final class Builder implements RivetApiClient.Builder {
    ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    Environment environment = Environment.PRODUCTION;

    @Override
    public RivetApiClient.Builder token(String token) {
      this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + token);
      return this;
    }

    @Override
    public RivetApiClient.Builder environment(Environment environment) {
      this.environment = environment;
      return this;
    }

    @Override
    public RivetApiClient build() {
      clientOptionsBuilder.environment(this.environment);
      return new RivetApiClientImpl(clientOptionsBuilder.build());
    }
  }
}
