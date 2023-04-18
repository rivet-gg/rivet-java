package com.rivet.api.resources.cloud.games.versions;

import com.rivet.api.resources.cloud.games.versions.types.CreateGameVersionRequest;
import com.rivet.api.resources.cloud.games.versions.types.CreateGameVersionResponse;
import com.rivet.api.resources.cloud.games.versions.types.GetGameVersionByIdResponse;
import com.rivet.api.resources.cloud.games.versions.types.ValidateGameVersionRequest;
import com.rivet.api.resources.cloud.games.versions.types.ValidateGameVersionResponse;
import java.util.UUID;

public interface VersionsClient {
  CreateGameVersionResponse createGameVersion(UUID gameId, CreateGameVersionRequest request);

  ValidateGameVersionResponse validateGameVersion(UUID gameId, ValidateGameVersionRequest request);

  GetGameVersionByIdResponse getGameVersionById(UUID gameId, UUID versionId);
}
