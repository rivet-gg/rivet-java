package com.rivet.api.resources.cloud.games.matchmaker;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.games.matchmaker.requests.GetLobbyLogsRequest;
import com.rivet.api.resources.cloud.games.matchmaker.types.DeleteMatchmakerLobbyResponse;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportLobbyLogsRequest;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportLobbyLogsResponse;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportMatchmakerLobbyHistoryRequest;
import com.rivet.api.resources.cloud.games.matchmaker.types.ExportMatchmakerLobbyHistoryResponse;
import com.rivet.api.resources.cloud.games.matchmaker.types.GetLobbyLogsResponse;
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

public final class MatchmakerClientImpl implements MatchmakerClient {
  private final ClientOptions clientOptions;

  public MatchmakerClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public ExportMatchmakerLobbyHistoryResponse exportMatchmakerLobbyHistory(UUID gameId,
      ExportMatchmakerLobbyHistoryRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("games/")
      .addPathSegment(gameId.toString())
      .addPathSegments("matchmaker/lobbies")
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
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ExportMatchmakerLobbyHistoryResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public DeleteMatchmakerLobbyResponse deleteMatchmakerLobby(UUID gameId, UUID lobbyId) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("games/")
      .addPathSegment(gameId.toString())
      .addPathSegments("matchmaker/lobbies")
      .addPathSegment(lobbyId.toString())
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("DELETE", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), DeleteMatchmakerLobbyResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public GetLobbyLogsResponse getLobbyLogs(UUID gameId, UUID lobbyId, GetLobbyLogsRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("games/")
      .addPathSegment(gameId.toString())
      .addPathSegments("matchmaker/lobbies")
      .addPathSegment(lobbyId.toString())
      .addPathSegments("logs")
      ;_httpUrlBuilder.addQueryParameter("stream", request.getStream().toString());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetLobbyLogsResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public ExportLobbyLogsResponse exportLobbyLogs(UUID gameId, UUID lobbyId,
        ExportLobbyLogsRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegments("games/")
        .addPathSegment(gameId.toString())
        .addPathSegments("matchmaker/lobbies")
        .addPathSegment(lobbyId.toString())
        .addPathSegments("logs/export")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ExportLobbyLogsResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
