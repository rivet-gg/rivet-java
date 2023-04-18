package com.rivet.api.resources.cloud.logs;

import com.rivet.api.resources.cloud.logs.types.GetRayPerfLogsResponse;
import java.util.UUID;

public interface LogsClient {
  GetRayPerfLogsResponse getRayPerfLogs(UUID rayId);
}
