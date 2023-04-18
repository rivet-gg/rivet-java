package com.rivet.api.resources.group.join.requests;

import com.rivet.api.resources.group.join.requests.types.ResolveJoinRequestRequest;
import java.util.UUID;

public interface JoinRequestsClient {
  void createJoinRequest(UUID groupId);

  void resolveJoinRequest(UUID groupId, UUID identityId, ResolveJoinRequestRequest request);
}
