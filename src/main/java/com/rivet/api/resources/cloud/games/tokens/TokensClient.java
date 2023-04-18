package com.rivet.api.resources.cloud.games.tokens;

import com.rivet.api.resources.cloud.games.tokens.types.CreateCloudTokenResponse;
import java.util.UUID;

public interface TokensClient {
  CreateCloudTokenResponse createCloudToken(UUID gameId);
}
