package com.rivet.api.resources.identity.links;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.identity.links.requests.GetGameLinkRequest;
import com.rivet.api.resources.identity.links.types.GetGameLinkResponse;
import com.rivet.api.resources.identity.links.types.PrepareGameLinkResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class LinksClientImpl implements LinksClient {
  private final ClientOptions clientOptions;

  public LinksClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public PrepareGameLinkResponse prepare() {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
      .addPathSegments("game-links")
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("POST", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PrepareGameLinkResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public GetGameLinkResponse get(GetGameLinkRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
      .addPathSegments("game-links")
      ;_httpUrlBuilder.addQueryParameter("identity_link_token", request.getIdentityLinkToken());
      if (request.getWatchIndex().isPresent()) {
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetGameLinkResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
