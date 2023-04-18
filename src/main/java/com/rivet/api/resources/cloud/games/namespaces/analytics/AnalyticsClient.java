package com.rivet.api.resources.cloud.games.namespaces.analytics;

import com.rivet.api.resources.cloud.games.namespaces.analytics.types.GetAnalyticsMatchmakerLiveResponse;
import java.util.UUID;

public interface AnalyticsClient {
  GetAnalyticsMatchmakerLiveResponse getAnalyticsMatchmakerLive(UUID gameId, UUID namespaceId);
}
