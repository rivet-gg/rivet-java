package com.rivet.api.resources.cloud.games.builds;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.cloud.games.builds.types.CreateGameBuildRequest;
import com.rivet.api.resources.cloud.games.builds.types.CreateGameBuildResponse;
import com.rivet.api.resources.cloud.games.builds.types.ListGameBuildsResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BuildsClient {
    protected final ClientOptions clientOptions;

    public BuildsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ListGameBuildsResponse listGameBuilds(UUID gameId) {
        return listGameBuilds(gameId, null);
    }

    public ListGameBuildsResponse listGameBuilds(UUID gameId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL())
                .newBuilder()
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("builds")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListGameBuildsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CreateGameBuildResponse createGameBuild(UUID gameId, CreateGameBuildRequest request) {
        return createGameBuild(gameId, request, null);
    }

    public CreateGameBuildResponse createGameBuild(
            UUID gameId, CreateGameBuildRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL())
                .newBuilder()
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("builds")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateGameBuildResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
