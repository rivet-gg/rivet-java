package com.rivet.api.resources.cloud.games;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.cloud.games.avatars.AvatarsClient;
import com.rivet.api.resources.cloud.games.avatars.AvatarsClientImpl;
import com.rivet.api.resources.cloud.games.builds.BuildsClient;
import com.rivet.api.resources.cloud.games.builds.BuildsClientImpl;
import com.rivet.api.resources.cloud.games.cdn.CdnClient;
import com.rivet.api.resources.cloud.games.cdn.CdnClientImpl;
import com.rivet.api.resources.cloud.games.matchmaker.MatchmakerClient;
import com.rivet.api.resources.cloud.games.matchmaker.MatchmakerClientImpl;
import com.rivet.api.resources.cloud.games.namespaces.NamespacesClient;
import com.rivet.api.resources.cloud.games.namespaces.NamespacesClientImpl;
import com.rivet.api.resources.cloud.games.tokens.TokensClient;
import com.rivet.api.resources.cloud.games.tokens.TokensClientImpl;
import com.rivet.api.resources.cloud.games.versions.VersionsClient;
import com.rivet.api.resources.cloud.games.versions.VersionsClientImpl;
import java.lang.Override;
import java.util.function.Supplier;

public final class GamesClientImpl implements GamesClient {
  private final ClientOptions clientOptions;

  private final Supplier<NamespacesClient> namespacesClient;

  private final Supplier<AvatarsClient> avatarsClient;

  private final Supplier<BuildsClient> buildsClient;

  private final Supplier<CdnClient> cdnClient;

  private final Supplier<com.rivet.api.resources.cloud.games.games.GamesClient> gamesClient;

  private final Supplier<MatchmakerClient> matchmakerClient;

  private final Supplier<TokensClient> tokensClient;

  private final Supplier<VersionsClient> versionsClient;

  public GamesClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.namespacesClient = Suppliers.memoize(() -> new NamespacesClientImpl(clientOptions));
    this.avatarsClient = Suppliers.memoize(() -> new AvatarsClientImpl(clientOptions));
    this.buildsClient = Suppliers.memoize(() -> new BuildsClientImpl(clientOptions));
    this.cdnClient = Suppliers.memoize(() -> new CdnClientImpl(clientOptions));
    this.gamesClient = Suppliers.memoize(() -> new com.rivet.api.resources.cloud.games.games.GamesClientImpl(clientOptions));
    this.matchmakerClient = Suppliers.memoize(() -> new MatchmakerClientImpl(clientOptions));
    this.tokensClient = Suppliers.memoize(() -> new TokensClientImpl(clientOptions));
    this.versionsClient = Suppliers.memoize(() -> new VersionsClientImpl(clientOptions));
  }

  @Override
  public NamespacesClient namespaces() {
    return this.namespacesClient.get();
  }

  @Override
  public AvatarsClient avatars() {
    return this.avatarsClient.get();
  }

  @Override
  public BuildsClient builds() {
    return this.buildsClient.get();
  }

  @Override
  public CdnClient cdn() {
    return this.cdnClient.get();
  }

  @Override
  public com.rivet.api.resources.cloud.games.games.GamesClient games() {
    return this.gamesClient.get();
  }

  @Override
  public MatchmakerClient matchmaker() {
    return this.matchmakerClient.get();
  }

  @Override
  public TokensClient tokens() {
    return this.tokensClient.get();
  }

  @Override
  public VersionsClient versions() {
    return this.versionsClient.get();
  }
}
