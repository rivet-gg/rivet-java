package com.rivet.api.resources.chat.identity;

import com.rivet.api.resources.chat.identity.types.GetDirectThreadResponse;
import java.util.UUID;

public interface IdentityClient {
  GetDirectThreadResponse getDirectThread(UUID identityId);
}
