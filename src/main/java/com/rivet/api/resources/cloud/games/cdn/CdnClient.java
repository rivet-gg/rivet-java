package com.rivet.api.resources.cloud.games.cdn;

import com.rivet.api.resources.cloud.games.cdn.types.CreateGameCdnSiteRequest;
import com.rivet.api.resources.cloud.games.cdn.types.CreateGameCdnSiteResponse;
import com.rivet.api.resources.cloud.games.cdn.types.ListGameCdnSitesResponse;
import java.util.UUID;

public interface CdnClient {
  ListGameCdnSitesResponse listGameCdnSites(UUID gameId);

  CreateGameCdnSiteResponse createGameCdnSite(UUID gameId, CreateGameCdnSiteRequest request);
}
