package com.rivet.api.resources.party.activity;

import com.rivet.api.resources.party.activity.matchmaker.MatchmakerClient;

public interface ActivityClient {
  void setPartyToIdle();

  MatchmakerClient matchmaker();
}
