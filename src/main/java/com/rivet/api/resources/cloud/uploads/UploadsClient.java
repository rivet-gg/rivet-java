package com.rivet.api.resources.cloud.uploads;

import java.util.UUID;

public interface UploadsClient {
  void completeUpload(UUID uploadId);
}
