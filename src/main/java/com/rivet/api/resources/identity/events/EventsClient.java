package com.rivet.api.resources.identity.events;

import com.rivet.api.resources.identity.events.requests.WatchEventsRequest;
import com.rivet.api.resources.identity.events.types.WatchEventsResponse;

public interface EventsClient {
  WatchEventsResponse watch(WatchEventsRequest request);
}
