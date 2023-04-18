package com.rivet.api.resources.cloud.games.namespaces.analytics;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.games.namespaces.analytics.types.GetAnalyticsMatchmakerLiveResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class AnalyticsClientImpl implements AnalyticsClient {
  private final ClientOptions clientOptions;

  public AnalyticsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public GetAnalyticsMatchmakerLiveResponse getAnalyticsMatchmakerLive(UUID gameId,
      UUID namespaceId) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("games/")
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      .addPathSegments("analytics")
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("GET", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetAnalyticsMatchmakerLiveResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
