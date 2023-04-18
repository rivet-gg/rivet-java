package com.rivet.api.resources.cloud.devices;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.cloud.devices.links.LinksClient;
import com.rivet.api.resources.cloud.devices.links.LinksClientImpl;
import java.lang.Override;
import java.util.function.Supplier;

public final class DevicesClientImpl implements DevicesClient {
  private final ClientOptions clientOptions;

  private final Supplier<LinksClient> linksClient;

  public DevicesClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.linksClient = Suppliers.memoize(() -> new LinksClientImpl(clientOptions));
  }

  @Override
  public LinksClient links() {
    return this.linksClient.get();
  }
}
