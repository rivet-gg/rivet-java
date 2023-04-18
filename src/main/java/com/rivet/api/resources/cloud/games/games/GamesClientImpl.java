package com.rivet.api.resources.cloud.games.games;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.games.games.requests.GetAnalyticsRequest;
import com.rivet.api.resources.cloud.games.games.requests.GetGameByIdRequest;
import com.rivet.api.resources.cloud.games.games.requests.GetGamesRequest;
import com.rivet.api.resources.cloud.games.games.types.CreateGameRequest;
import com.rivet.api.resources.cloud.games.games.types.CreateGameResponse;
import com.rivet.api.resources.cloud.games.games.types.GameBannerUploadPrepareRequest;
import com.rivet.api.resources.cloud.games.games.types.GameBannerUploadPrepareResponse;
import com.rivet.api.resources.cloud.games.games.types.GameLogoUploadPrepareRequest;
import com.rivet.api.resources.cloud.games.games.types.GameLogoUploadPrepareResponse;
import com.rivet.api.resources.cloud.games.games.types.GetAnalyticsResponse;
import com.rivet.api.resources.cloud.games.games.types.GetGameByIdResponse;
import com.rivet.api.resources.cloud.games.games.types.GetGamesResponse;
import com.rivet.api.resources.cloud.games.games.types.ValidateGameRequest;
import com.rivet.api.resources.cloud.games.games.types.ValidateGameResponse;
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

public final class GamesClientImpl implements GamesClient {
  private final ClientOptions clientOptions;

  public GamesClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public GetGamesResponse getGames(GetGamesRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("games")
      ;if (request.getWatchIndex().isPresent()) {
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetGamesResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public CreateGameResponse createGame(CreateGameRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegments("games")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateGameResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public ValidateGameResponse validateGame(ValidateGameRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegments("games")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ValidateGameResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public GetGameByIdResponse getGameById(UUID gameId, GetGameByIdRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegments("games")
        .addPathSegment(gameId.toString())
        ;if (request.getWatchIndex().isPresent()) {
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
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetGameByIdResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public GameBannerUploadPrepareResponse gameBannerUploadPrepare(UUID gameId,
          GameBannerUploadPrepareRequest request) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
          .addPathSegments("games")
          .addPathSegment(gameId.toString())
          .addPathSegments("banner-upload/prepare")
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
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GameBannerUploadPrepareResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public void gameBannerUploadComplete(UUID gameId, UUID uploadId) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
          .addPathSegments("games")
          .addPathSegment(gameId.toString())
          .addPathSegments("banner-upload/")
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

      @Override
      public GameLogoUploadPrepareResponse gameLogoUploadPrepare(UUID gameId,
          GameLogoUploadPrepareRequest request) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
          .addPathSegments("games")
          .addPathSegment(gameId.toString())
          .addPathSegments("logo-upload/prepare")
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
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GameLogoUploadPrepareResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public void gameLogoUploadComplete(UUID gameId, UUID uploadId) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
          .addPathSegments("games")
          .addPathSegment(gameId.toString())
          .addPathSegments("logo-upload/")
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

      @Override
      public GetAnalyticsResponse getAnalytics(GetAnalyticsRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
          .addPathSegments("games")
          ;_httpUrlBuilder.addQueryParameter("query_start", request.getQueryStart());
          _httpUrlBuilder.addQueryParameter("query_end", request.getQueryEnd());
          if (request.getGameIds().isPresent()) {
            _httpUrlBuilder.addQueryParameter("game_ids", request.getGameIds().get());
          }
          if (request.getNamespaceIds().isPresent()) {
            _httpUrlBuilder.addQueryParameter("namespace_ids", request.getNamespaceIds().get());
          }
          _httpUrlBuilder.addQueryParameter("variants", request.getVariants().toString());
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
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetAnalyticsResponse.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
      }
