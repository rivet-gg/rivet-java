package com.rivet.api.resources.cloud.games.games;

import com.rivet.api.resources.cloud.games.games.requests.GetAnalyticsRequest;
import com.rivet.api.resources.cloud.games.games.requests.GetGameByIdRequest;
import com.rivet.api.resources.cloud.games.games.requests.GetGamesRequest;
import com.rivet.api.resources.cloud.games.games.types.CreateGameRequest;
import com.rivet.api.resources.cloud.games.games.types.CreateGameResponse;
import com.rivet.api.resources.cloud.games.games.types.GameBannerUploadPrepareRequest;
import com.rivet.api.resources.cloud.games.games.types.GameBannerUploadPrepareResponse;
import com.rivet.api.resources.cloud.games.games.types.GameLogoUploadPrepareRequest;
import com.rivet.api.resources.cloud.games.games.types.GameLogoUploadPrepareResponse;
import com.rivet.api.resources.cloud.games.games.types.GetAnalyticsResponse;
import com.rivet.api.resources.cloud.games.games.types.GetGameByIdResponse;
import com.rivet.api.resources.cloud.games.games.types.GetGamesResponse;
import com.rivet.api.resources.cloud.games.games.types.ValidateGameRequest;
import com.rivet.api.resources.cloud.games.games.types.ValidateGameResponse;
import java.util.UUID;

public interface GamesClient {
  GetGamesResponse getGames(GetGamesRequest request);

  CreateGameResponse createGame(CreateGameRequest request);

  ValidateGameResponse validateGame(ValidateGameRequest request);

  GetGameByIdResponse getGameById(UUID gameId, GetGameByIdRequest request);

  GameBannerUploadPrepareResponse gameBannerUploadPrepare(UUID gameId,
      GameBannerUploadPrepareRequest request);

  void gameBannerUploadComplete(UUID gameId, UUID uploadId);

  GameLogoUploadPrepareResponse gameLogoUploadPrepare(UUID gameId,
      GameLogoUploadPrepareRequest request);

  void gameLogoUploadComplete(UUID gameId, UUID uploadId);

  GetAnalyticsResponse getAnalytics(GetAnalyticsRequest request);
}
