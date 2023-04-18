package com.rivet.api.resources.matchmaker.lobbies;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.matchmaker.lobbies.requests.FindLobbyRequest;
import com.rivet.api.resources.matchmaker.lobbies.requests.JoinLobbyRequest;
import com.rivet.api.resources.matchmaker.lobbies.requests.SetLobbyClosedRequest;
import com.rivet.api.resources.matchmaker.lobbies.types.FindLobbyResponse;
import com.rivet.api.resources.matchmaker.lobbies.types.JoinLobbyResponse;
import com.rivet.api.resources.matchmaker.lobbies.types.ListLobbiesResponse;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class LobbiesClientImpl implements LobbiesClient {
  private final ClientOptions clientOptions;

  public LobbiesClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public void ready() {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL()).newBuilder()
      .addPathSegments("lobbies")
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

  @Override
  public void setClosed(SetLobbyClosedRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL()).newBuilder()
      .addPathSegments("lobbies")
      ;HttpUrl _httpUrl = _httpUrlBuilder.build();
      Map<String, Object> _requestBodyProperties = new HashMap<>();
      _requestBodyProperties.put("is_closed", request.getIsClosed());
      RequestBody _requestBody;
      try {
        _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties), MediaType.parse("application/json"));
      }
      catch(Exception e) {
        throw new RuntimeException(e);
      }
      Request.Builder _requestBuilder = new Request.Builder()
        .url(_httpUrl)
        .method("PUT", _requestBody)
        .headers(Headers.of(clientOptions.headers()));
      Request _request = _requestBuilder.build();
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

    @Override
    public FindLobbyResponse find(FindLobbyRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL()).newBuilder()
        .addPathSegments("lobbies")
        ;HttpUrl _httpUrl = _httpUrlBuilder.build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("game_modes", request.getGameModes());
        _requestBodyProperties.put("regions", request.getRegions());
        _requestBodyProperties.put("prevent_auto_create_lobby", request.getPreventAutoCreateLobby());
        _requestBodyProperties.put("captcha", request.getCaptcha());
        RequestBody _requestBody;
        try {
          _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties), MediaType.parse("application/json"));
        }
        catch(Exception e) {
          throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
          .url(_httpUrl)
          .method("POST", _requestBody)
          .headers(Headers.of(clientOptions.headers()));
        if (request.getOrigin().isPresent()) {
          _requestBuilder.addHeader("origin", request.getOrigin().get());
        }
        Request _request = _requestBuilder.build();
        try {
          Response _response = clientOptions.httpClient().newCall(_request).execute();
          if (_response.isSuccessful()) {
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), FindLobbyResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public JoinLobbyResponse join(JoinLobbyRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL()).newBuilder()
          .addPathSegments("lobbies")
          ;HttpUrl _httpUrl = _httpUrlBuilder.build();
          Map<String, Object> _requestBodyProperties = new HashMap<>();
          _requestBodyProperties.put("lobby_id", request.getLobbyId());
          _requestBodyProperties.put("captcha", request.getCaptcha());
          RequestBody _requestBody;
          try {
            _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties), MediaType.parse("application/json"));
          }
          catch(Exception e) {
            throw new RuntimeException(e);
          }
          Request.Builder _requestBuilder = new Request.Builder()
            .url(_httpUrl)
            .method("POST", _requestBody)
            .headers(Headers.of(clientOptions.headers()));
          Request _request = _requestBuilder.build();
          try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), JoinLobbyResponse.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }

        @Override
        public ListLobbiesResponse list() {
          HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL()).newBuilder()
            .addPathSegments("lobbies")
            .build();Request _request = new Request.Builder()
            .url(_httpUrl)
            .method("GET", RequestBody.create("", null))
            .headers(Headers.of(clientOptions.headers()))
            .build();
          try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListLobbiesResponse.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
      }
