package com.rivet.api.resources.party;

import com.rivet.api.resources.party.activity.ActivityClient;
import com.rivet.api.resources.party.parties.PartiesClient;

public interface PartyClient {
  ActivityClient activity();

  PartiesClient parties();
}
