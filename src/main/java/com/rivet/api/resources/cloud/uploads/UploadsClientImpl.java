package com.rivet.api.resources.cloud.uploads;

import com.rivet.api.core.ClientOptions;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class UploadsClientImpl implements UploadsClient {
  private final ClientOptions clientOptions;

  public UploadsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public void completeUpload(UUID uploadId) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("uploads")
      .addPathSegment(uploadId.toString())
      .addPathSegments("complete")
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("POST", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return;
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
