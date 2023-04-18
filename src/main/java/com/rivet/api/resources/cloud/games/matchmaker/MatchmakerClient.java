package com.rivet.api.resources.cloud.games.matchmaker;

import com.rivet.api.resources.cloud.games.matchmaker.requests.GetLobbyLogsRequest;
import com.rivet.api.resources.cloud.games.matchmaker.types.DeleteMatchmakerLobbyResponse;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportLobbyLogsRequest;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportLobbyLogsResponse;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportMatchmakerLobbyHistoryRequest;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportMatchmakerLobbyHistoryResponse;
import com.rivet.api.resources.cloud.games.matchmaker.types.GetLobbyLogsResponse;
import java.util.UUID;

public interface MatchmakerClient {
  ExportMatchmakerLobbyHistoryResponse exportMatchmakerLobbyHistory(UUID gameId,
      ExportMatchmakerLobbyHistoryRequest request);

  DeleteMatchmakerLobbyResponse deleteMatchmakerLobby(UUID gameId, UUID lobbyId);

  GetLobbyLogsResponse getLobbyLogs(UUID gameId, UUID lobbyId, GetLobbyLogsRequest request);

  ExportLobbyLogsResponse exportLobbyLogs(UUID gameId, UUID lobbyId,
      ExportLobbyLogsRequest request);
}
