package com.rivet.api.resources.cloud.auth;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.auth.types.InspectResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class AuthClientImpl implements AuthClient {
  private final ClientOptions clientOptions;

  public AuthClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public InspectResponse inspect() {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("auth")
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("GET", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), InspectResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
