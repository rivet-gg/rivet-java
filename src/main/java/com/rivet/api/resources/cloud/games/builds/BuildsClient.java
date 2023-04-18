package com.rivet.api.resources.cloud.games.builds;

import com.rivet.api.resources.cloud.games.builds.types.CreateGameBuildRequest;
import com.rivet.api.resources.cloud.games.builds.types.CreateGameBuildResponse;
import com.rivet.api.resources.cloud.games.builds.types.ListGameBuildsResponse;
import java.util.UUID;

public interface BuildsClient {
  ListGameBuildsResponse listGameBuilds(UUID gameId);

  CreateGameBuildResponse createGameBuild(UUID gameId, CreateGameBuildRequest request);
}
