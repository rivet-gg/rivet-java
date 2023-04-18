package com.rivet.api.resources.cloud.games.tokens;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.games.tokens.types.CreateCloudTokenResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class TokensClientImpl implements TokensClient {
  private final ClientOptions clientOptions;

  public TokensClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public CreateCloudTokenResponse createCloudToken(UUID gameId) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("tokens/cloud")
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("POST", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateCloudTokenResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
