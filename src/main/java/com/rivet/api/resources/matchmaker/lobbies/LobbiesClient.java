package com.rivet.api.resources.matchmaker.lobbies;

import com.rivet.api.resources.matchmaker.lobbies.requests.FindLobbyRequest;
import com.rivet.api.resources.matchmaker.lobbies.requests.JoinLobbyRequest;
import com.rivet.api.resources.matchmaker.lobbies.requests.SetLobbyClosedRequest;
import com.rivet.api.resources.matchmaker.lobbies.types.FindLobbyResponse;
import com.rivet.api.resources.matchmaker.lobbies.types.JoinLobbyResponse;
import com.rivet.api.resources.matchmaker.lobbies.types.ListLobbiesResponse;

public interface LobbiesClient {
  void ready();

  void setClosed(SetLobbyClosedRequest request);

  FindLobbyResponse find(FindLobbyRequest request);

  JoinLobbyResponse join(JoinLobbyRequest request);

  ListLobbiesResponse list();
}
