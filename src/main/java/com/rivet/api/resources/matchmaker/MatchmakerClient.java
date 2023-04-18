package com.rivet.api.resources.matchmaker;

import com.rivet.api.resources.matchmaker.lobbies.LobbiesClient;
import com.rivet.api.resources.matchmaker.players.PlayersClient;
import com.rivet.api.resources.matchmaker.regions.RegionsClient;

public interface MatchmakerClient {
  LobbiesClient lobbies();

  PlayersClient players();

  RegionsClient regions();
}
