package com.rivet.api.resources.cloud.games.versions;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.games.versions.types.CreateGameVersionRequest;
import com.rivet.api.resources.cloud.games.versions.types.CreateGameVersionResponse;
import com.rivet.api.resources.cloud.games.versions.types.GetGameVersionByIdResponse;
import com.rivet.api.resources.cloud.games.versions.types.ValidateGameVersionRequest;
import com.rivet.api.resources.cloud.games.versions.types.ValidateGameVersionResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class VersionsClientImpl implements VersionsClient {
  private final ClientOptions clientOptions;

  public VersionsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public CreateGameVersionResponse createGameVersion(UUID gameId,
      CreateGameVersionRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("games/")
      .addPathSegment(gameId.toString())
      .addPathSegments("versions")
      .build();
    RequestBody _requestBody;
    try {
      _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
    }
    catch(Exception e) {
      throw new RuntimeException(e);
    }
    Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("POST", _requestBody)
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateGameVersionResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ValidateGameVersionResponse validateGameVersion(UUID gameId,
      ValidateGameVersionRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("games/")
      .addPathSegment(gameId.toString())
      .addPathSegments("versions")
      .build();
    RequestBody _requestBody;
    try {
      _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
    }
    catch(Exception e) {
      throw new RuntimeException(e);
    }
    Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("POST", _requestBody)
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ValidateGameVersionResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public GetGameVersionByIdResponse getGameVersionById(UUID gameId, UUID versionId) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("games/")
      .addPathSegment(gameId.toString())
      .addPathSegments("versions")
      .addPathSegment(versionId.toString())
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("GET", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetGameVersionByIdResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
