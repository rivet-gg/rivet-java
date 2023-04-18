package com.rivet.api.resources.cloud;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.cloud.auth.AuthClient;
import com.rivet.api.resources.cloud.auth.AuthClientImpl;
import com.rivet.api.resources.cloud.devices.DevicesClient;
import com.rivet.api.resources.cloud.devices.DevicesClientImpl;
import com.rivet.api.resources.cloud.games.GamesClient;
import com.rivet.api.resources.cloud.games.GamesClientImpl;
import com.rivet.api.resources.cloud.groups.GroupsClient;
import com.rivet.api.resources.cloud.groups.GroupsClientImpl;
import com.rivet.api.resources.cloud.logs.LogsClient;
import com.rivet.api.resources.cloud.logs.LogsClientImpl;
import com.rivet.api.resources.cloud.tiers.TiersClient;
import com.rivet.api.resources.cloud.tiers.TiersClientImpl;
import com.rivet.api.resources.cloud.uploads.UploadsClient;
import com.rivet.api.resources.cloud.uploads.UploadsClientImpl;
import java.lang.Override;
import java.util.function.Supplier;

public final class CloudClientImpl implements CloudClient {
  private final ClientOptions clientOptions;

  private final Supplier<GamesClient> gamesClient;

  private final Supplier<AuthClient> authClient;

  private final Supplier<DevicesClient> devicesClient;

  private final Supplier<GroupsClient> groupsClient;

  private final Supplier<LogsClient> logsClient;

  private final Supplier<TiersClient> tiersClient;

  private final Supplier<UploadsClient> uploadsClient;

  public CloudClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.gamesClient = Suppliers.memoize(() -> new GamesClientImpl(clientOptions));
    this.authClient = Suppliers.memoize(() -> new AuthClientImpl(clientOptions));
    this.devicesClient = Suppliers.memoize(() -> new DevicesClientImpl(clientOptions));
    this.groupsClient = Suppliers.memoize(() -> new GroupsClientImpl(clientOptions));
    this.logsClient = Suppliers.memoize(() -> new LogsClientImpl(clientOptions));
    this.tiersClient = Suppliers.memoize(() -> new TiersClientImpl(clientOptions));
    this.uploadsClient = Suppliers.memoize(() -> new UploadsClientImpl(clientOptions));
  }

  @Override
  public GamesClient games() {
    return this.gamesClient.get();
  }

  @Override
  public AuthClient auth() {
    return this.authClient.get();
  }

  @Override
  public DevicesClient devices() {
    return this.devicesClient.get();
  }

  @Override
  public GroupsClient groups() {
    return this.groupsClient.get();
  }

  @Override
  public LogsClient logs() {
    return this.logsClient.get();
  }

  @Override
  public TiersClient tiers() {
    return this.tiersClient.get();
  }

  @Override
  public UploadsClient uploads() {
    return this.uploadsClient.get();
  }
}
