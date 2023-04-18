package com.rivet.api.resources.cloud.games.namespaces.logs;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.games.namespaces.logs.requests.ListNamespaceLobbiesRequest;
import com.rivet.api.resources.cloud.games.namespaces.logs.types.GetNamespaceLobbyResponse;
import com.rivet.api.resources.cloud.games.namespaces.logs.types.ListNamespaceLobbiesResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class LogsClientImpl implements LogsClient {
  private final ClientOptions clientOptions;

  public LogsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public ListNamespaceLobbiesResponse listNamespaceLobbies(UUID gameId, UUID namespaceId,
      ListNamespaceLobbiesRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("games/")
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      ;if (request.getBeforeCreateTs().isPresent()) {
        _httpUrlBuilder.addQueryParameter("before_create_ts", request.getBeforeCreateTs().get());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListNamespaceLobbiesResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public GetNamespaceLobbyResponse getNamespaceLobby(UUID gameId, UUID namespaceId,
        UUID lobbyId) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegments("games/")
        .addPathSegment(gameId.toString())
        .addPathSegments("namespaces/")
        .addPathSegment(namespaceId.toString())
        .addPathSegment(lobbyId.toString())
        .build();Request _request = new Request.Builder()
        .url(_httpUrl)
        .method("GET", RequestBody.create("", null))
        .headers(Headers.of(clientOptions.headers()))
        .build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetNamespaceLobbyResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
