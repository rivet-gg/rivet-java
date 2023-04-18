package com.rivet.api.resources.cloud.auth;

import com.rivet.api.resources.cloud.auth.types.InspectResponse;

public interface AuthClient {
  InspectResponse inspect();
}
