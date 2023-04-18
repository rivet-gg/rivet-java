package com.rivet.api.resources.cloud.devices.links;

import com.rivet.api.resources.cloud.devices.links.requests.GetDeviceLinkRequest;
import com.rivet.api.resources.cloud.devices.links.types.GetDeviceLinkResponse;
import com.rivet.api.resources.cloud.devices.links.types.PrepareDeviceLinkResponse;

public interface LinksClient {
  PrepareDeviceLinkResponse prepare();

  GetDeviceLinkResponse get(GetDeviceLinkRequest request);
}
