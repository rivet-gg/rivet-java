package com.rivet.api.resources.cloud.games;

import com.rivet.api.resources.cloud.games.avatars.AvatarsClient;
import com.rivet.api.resources.cloud.games.builds.BuildsClient;
import com.rivet.api.resources.cloud.games.cdn.CdnClient;
import com.rivet.api.resources.cloud.games.matchmaker.MatchmakerClient;
import com.rivet.api.resources.cloud.games.namespaces.NamespacesClient;
import com.rivet.api.resources.cloud.games.tokens.TokensClient;
import com.rivet.api.resources.cloud.games.versions.VersionsClient;

public interface GamesClient {
  NamespacesClient namespaces();

  AvatarsClient avatars();

  BuildsClient builds();

  CdnClient cdn();

  com.rivet.api.resources.cloud.games.games.GamesClient games();

  MatchmakerClient matchmaker();

  TokensClient tokens();

  VersionsClient versions();
}
