package com.rivet.api.resources.cloud.tiers;

import com.rivet.api.resources.cloud.tiers.types.GetRegionTiersResponse;

public interface TiersClient {
  GetRegionTiersResponse getRegionTiers();
}
