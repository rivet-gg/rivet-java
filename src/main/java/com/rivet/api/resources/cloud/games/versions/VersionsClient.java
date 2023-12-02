package com.rivet.api.resources.cloud.games.versions;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.cloud.games.versions.types.CreateGameVersionRequest;
import com.rivet.api.resources.cloud.games.versions.types.CreateGameVersionResponse;
import com.rivet.api.resources.cloud.games.versions.types.GetGameVersionByIdResponse;
import com.rivet.api.resources.cloud.games.versions.types.ValidateGameVersionRequest;
import com.rivet.api.resources.cloud.games.versions.types.ValidateGameVersionResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class VersionsClient {
    protected final ClientOptions clientOptions;

    public VersionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public CreateGameVersionResponse createGameVersion(UUID gameId, CreateGameVersionRequest request) {
        return createGameVersion(gameId, request, null);
    }

    public CreateGameVersionResponse createGameVersion(
            UUID gameId, CreateGameVersionRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("versions")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateGameVersionResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ValidateGameVersionResponse validateGameVersion(UUID gameId, ValidateGameVersionRequest request) {
        return validateGameVersion(gameId, request, null);
    }

    public ValidateGameVersionResponse validateGameVersion(
            UUID gameId, ValidateGameVersionRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("versions")
                .addPathSegments("validate")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), ValidateGameVersionResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetGameVersionByIdResponse getGameVersionById(UUID gameId, UUID versionId) {
        return getGameVersionById(gameId, versionId, null);
    }

    public GetGameVersionByIdResponse getGameVersionById(UUID gameId, UUID versionId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("versions")
                .addPathSegment(versionId.toString())
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetGameVersionByIdResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
