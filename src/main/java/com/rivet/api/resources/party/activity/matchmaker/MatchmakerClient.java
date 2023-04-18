package com.rivet.api.resources.party.activity.matchmaker;

import com.rivet.api.resources.party.activity.matchmaker.types.FindMatchmakerLobbyForPartyRequest;
import com.rivet.api.resources.party.activity.matchmaker.types.JoinMatchmakerLobbyForPartyRequest;

public interface MatchmakerClient {
  void findLobbyForParty(FindMatchmakerLobbyForPartyRequest request);

  void joinLobbyForParty(JoinMatchmakerLobbyForPartyRequest request);

  void requestPlayer();
}
