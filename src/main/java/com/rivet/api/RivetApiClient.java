package com.rivet.api;

import com.rivet.api.core.Environment;
import com.rivet.api.resources.chat.ChatClient;
import com.rivet.api.resources.cloud.CloudClient;
import com.rivet.api.resources.group.GroupClient;
import com.rivet.api.resources.identity.IdentityClient;
import com.rivet.api.resources.kv.KvClient;
import com.rivet.api.resources.matchmaker.MatchmakerClient;
import com.rivet.api.resources.party.PartyClient;
import java.lang.String;

public interface RivetApiClient {
  ChatClient chat();

  CloudClient cloud();

  GroupClient group();

  IdentityClient identity();

  KvClient kv();

  PartyClient party();

  MatchmakerClient matchmaker();

  static Builder builder() {
    return new RivetApiClientImpl.Builder();
  }

  interface Builder {
    Builder token(String token);

    Builder environment(Environment environment);

    RivetApiClient build();
  }
}
