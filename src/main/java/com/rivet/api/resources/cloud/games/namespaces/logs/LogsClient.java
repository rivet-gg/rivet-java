package com.rivet.api.resources.cloud.games.namespaces.logs;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.cloud.games.namespaces.logs.requests.ListNamespaceLobbiesRequest;
import com.rivet.api.resources.cloud.games.namespaces.logs.types.GetNamespaceLobbyResponse;
import com.rivet.api.resources.cloud.games.namespaces.logs.types.ListNamespaceLobbiesResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LogsClient {
    protected final ClientOptions clientOptions;

    public LogsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ListNamespaceLobbiesResponse listNamespaceLobbies(
            UUID gameId, UUID namespaceId, ListNamespaceLobbiesRequest request) {
        return listNamespaceLobbies(gameId, namespaceId, request, null);
    }

    public ListNamespaceLobbiesResponse listNamespaceLobbies(
            UUID gameId, UUID namespaceId, ListNamespaceLobbiesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("logs/lobbies");
        if (request.getBeforeCreateTs().isPresent()) {
            _httpUrl.addQueryParameter(
                    "before_create_ts", request.getBeforeCreateTs().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), ListNamespaceLobbiesResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetNamespaceLobbyResponse getNamespaceLobby(UUID gameId, UUID namespaceId, UUID lobbyId) {
        return getNamespaceLobby(gameId, namespaceId, lobbyId, null);
    }

    public GetNamespaceLobbyResponse getNamespaceLobby(
            UUID gameId, UUID namespaceId, UUID lobbyId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("logs/lobbies")
                .addPathSegment(lobbyId.toString())
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetNamespaceLobbyResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
