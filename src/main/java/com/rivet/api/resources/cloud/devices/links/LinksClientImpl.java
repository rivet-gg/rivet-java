package com.rivet.api.resources.cloud.devices.links;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.devices.links.requests.GetDeviceLinkRequest;
import com.rivet.api.resources.cloud.devices.links.types.GetDeviceLinkResponse;
import com.rivet.api.resources.cloud.devices.links.types.PrepareDeviceLinkResponse;
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
  public PrepareDeviceLinkResponse prepare() {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("devices/links")
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("POST", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PrepareDeviceLinkResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public GetDeviceLinkResponse get(GetDeviceLinkRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("devices/links")
      ;_httpUrlBuilder.addQueryParameter("device_link_token", request.getDeviceLinkToken());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetDeviceLinkResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
