package com.rivet.api.resources.matchmaker.players;

import com.rivet.api.resources.matchmaker.players.requests.PlayerConnectedRequest;
import com.rivet.api.resources.matchmaker.players.requests.PlayerDisconnectedRequest;
import com.rivet.api.resources.matchmaker.players.types.GetStatisticsResponse;

public interface PlayersClient {
  void connected(PlayerConnectedRequest request);

  void disconnected(PlayerDisconnectedRequest request);

  GetStatisticsResponse getStatistics();
}
