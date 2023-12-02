package com.rivet.api.resources.cloud.games.avatars;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.cloud.games.avatars.types.ListGameCustomAvatarsResponse;
import com.rivet.api.resources.cloud.games.avatars.types.PrepareCustomAvatarUploadRequest;
import com.rivet.api.resources.cloud.games.avatars.types.PrepareCustomAvatarUploadResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AvatarsClient {
    protected final ClientOptions clientOptions;

    public AvatarsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ListGameCustomAvatarsResponse listGameCustomAvatars(UUID gameId) {
        return listGameCustomAvatars(gameId, null);
    }

    public ListGameCustomAvatarsResponse listGameCustomAvatars(UUID gameId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("avatars")
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), ListGameCustomAvatarsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PrepareCustomAvatarUploadResponse prepareCustomAvatarUpload(
            UUID gameId, PrepareCustomAvatarUploadRequest request) {
        return prepareCustomAvatarUpload(gameId, request, null);
    }

    public PrepareCustomAvatarUploadResponse prepareCustomAvatarUpload(
            UUID gameId, PrepareCustomAvatarUploadRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("prepare")
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
                        _response.body().string(), PrepareCustomAvatarUploadResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void completeCustomAvatarUpload(UUID gameId, UUID uploadId) {
        completeCustomAvatarUpload(gameId, uploadId, null);
    }

    public void completeCustomAvatarUpload(UUID gameId, UUID uploadId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("avatar-upload")
                .addPathSegment(uploadId.toString())
                .addPathSegments("complete")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
