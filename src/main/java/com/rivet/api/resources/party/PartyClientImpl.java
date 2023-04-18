package com.rivet.api.resources.party;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.party.activity.ActivityClient;
import com.rivet.api.resources.party.activity.ActivityClientImpl;
import com.rivet.api.resources.party.parties.PartiesClient;
import com.rivet.api.resources.party.parties.PartiesClientImpl;
import java.lang.Override;
import java.util.function.Supplier;

public final class PartyClientImpl implements PartyClient {
  private final ClientOptions clientOptions;

  private final Supplier<ActivityClient> activityClient;

  private final Supplier<PartiesClient> partiesClient;

  public PartyClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.activityClient = Suppliers.memoize(() -> new ActivityClientImpl(clientOptions));
    this.partiesClient = Suppliers.memoize(() -> new PartiesClientImpl(clientOptions));
  }

  @Override
  public ActivityClient activity() {
    return this.activityClient.get();
  }

  @Override
  public PartiesClient parties() {
    return this.partiesClient.get();
  }
}
