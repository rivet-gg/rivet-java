package com.rivet.api.resources.cloud.games.matchmaker;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.cloud.games.matchmaker.requests.GetLobbyLogsRequest;
import com.rivet.api.resources.cloud.games.matchmaker.types.DeleteMatchmakerLobbyResponse;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportLobbyLogsRequest;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportLobbyLogsResponse;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportMatchmakerLobbyHistoryRequest;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportMatchmakerLobbyHistoryResponse;
import com.rivet.api.resources.cloud.games.matchmaker.types.GetLobbyLogsResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MatchmakerClient {
    protected final ClientOptions clientOptions;

    public MatchmakerClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ExportMatchmakerLobbyHistoryResponse exportMatchmakerLobbyHistory(
            UUID gameId, ExportMatchmakerLobbyHistoryRequest request) {
        return exportMatchmakerLobbyHistory(gameId, request, null);
    }

    public ExportMatchmakerLobbyHistoryResponse exportMatchmakerLobbyHistory(
            UUID gameId, ExportMatchmakerLobbyHistoryRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL())
                .newBuilder()
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("matchmaker/lobbies")
                .addPathSegments("export-history")
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
                        _response.body().string(), ExportMatchmakerLobbyHistoryResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DeleteMatchmakerLobbyResponse deleteMatchmakerLobby(UUID gameId, UUID lobbyId) {
        return deleteMatchmakerLobby(gameId, lobbyId, null);
    }

    public DeleteMatchmakerLobbyResponse deleteMatchmakerLobby(
            UUID gameId, UUID lobbyId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL())
                .newBuilder()
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("matchmaker/lobbies")
                .addPathSegment(lobbyId.toString())
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), DeleteMatchmakerLobbyResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetLobbyLogsResponse getLobbyLogs(UUID gameId, UUID lobbyId, GetLobbyLogsRequest request) {
        return getLobbyLogs(gameId, lobbyId, request, null);
    }

    public GetLobbyLogsResponse getLobbyLogs(
            UUID gameId, UUID lobbyId, GetLobbyLogsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getcloudURL())
                .newBuilder()
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("matchmaker/lobbies")
                .addPathSegment(lobbyId.toString())
                .addPathSegments("logs");
        _httpUrl.addQueryParameter("stream", request.getStream().toString());
        if (request.getWatchIndex().isPresent()) {
            _httpUrl.addQueryParameter("watch_index", request.getWatchIndex().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetLobbyLogsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ExportLobbyLogsResponse exportLobbyLogs(UUID gameId, UUID lobbyId, ExportLobbyLogsRequest request) {
        return exportLobbyLogs(gameId, lobbyId, request, null);
    }

    public ExportLobbyLogsResponse exportLobbyLogs(
            UUID gameId, UUID lobbyId, ExportLobbyLogsRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL())
                .newBuilder()
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("matchmaker/lobbies")
                .addPathSegment(lobbyId.toString())
                .addPathSegments("logs/export")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ExportLobbyLogsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
