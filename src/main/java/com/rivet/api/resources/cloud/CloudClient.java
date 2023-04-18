package com.rivet.api.resources.cloud;

import com.rivet.api.resources.cloud.auth.AuthClient;
import com.rivet.api.resources.cloud.devices.DevicesClient;
import com.rivet.api.resources.cloud.games.GamesClient;
import com.rivet.api.resources.cloud.groups.GroupsClient;
import com.rivet.api.resources.cloud.logs.LogsClient;
import com.rivet.api.resources.cloud.tiers.TiersClient;
import com.rivet.api.resources.cloud.uploads.UploadsClient;

public interface CloudClient {
  GamesClient games();

  AuthClient auth();

  DevicesClient devices();

  GroupsClient groups();

  LogsClient logs();

  TiersClient tiers();

  UploadsClient uploads();
}
