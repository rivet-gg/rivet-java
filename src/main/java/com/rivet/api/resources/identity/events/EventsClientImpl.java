package com.rivet.api.resources.identity.events;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.identity.events.requests.WatchEventsRequest;
import com.rivet.api.resources.identity.events.types.WatchEventsResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class EventsClientImpl implements EventsClient {
  private final ClientOptions clientOptions;

  public EventsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public WatchEventsResponse watch(WatchEventsRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
      .addPathSegments("events")
      ;if (request.getWatchIndex().isPresent()) {
        _httpUrlBuilder.addQueryParameter("watch_index", request.getWatchIndex().get());
      }
      HttpUrl _httpUrl = _httpUrlBuilder.build();
      RequestBody _requestBody = RequestBody.create("", null);
      Request.Builder _requestBuilder = new Request.Builder()
        .url(_httpUrl)
        .method("GET", _requestBody)
        .headers(Headers.of(clientOptions.headers()));
      Request _request = _requestBuilder.build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), WatchEventsResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
