package com.rivet.api.resources.identity.links;

import com.rivet.api.resources.identity.links.requests.GetGameLinkRequest;
import com.rivet.api.resources.identity.links.types.GetGameLinkResponse;
import com.rivet.api.resources.identity.links.types.PrepareGameLinkResponse;

public interface LinksClient {
  PrepareGameLinkResponse prepare();

  GetGameLinkResponse get(GetGameLinkRequest request);
}
