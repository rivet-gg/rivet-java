package com.rivet.api.resources.cloud.games.namespaces;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.cloud.games.namespaces.analytics.AnalyticsClient;
import com.rivet.api.resources.cloud.games.namespaces.analytics.AnalyticsClientImpl;
import com.rivet.api.resources.cloud.games.namespaces.logs.LogsClient;
import com.rivet.api.resources.cloud.games.namespaces.logs.LogsClientImpl;
import com.rivet.api.resources.cloud.games.namespaces.requests.GetGameNamespaceVersionHistoryRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.AddNamespaceDomainRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceTokenDevelopmentRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceTokenDevelopmentResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceTokenPublicResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.GetGameNamespaceByIdResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.GetGameNamespaceVersionHistoryResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.SetNamespaceCdnAuthTypeRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ToggleNamespaceDomainPublicAuthRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.UpdateGameNamespaceMatchmakerConfigRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.UpdateGameNamespaceVersionRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.UpdateNamespaceCdnAuthUserRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceMatchmakerConfigRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceMatchmakerConfigResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceTokenDevelopmentRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceTokenDevelopmentResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.UUID;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class NamespacesClientImpl implements NamespacesClient {
  private final ClientOptions clientOptions;

  private final Supplier<AnalyticsClient> analyticsClient;

  private final Supplier<LogsClient> logsClient;

  public NamespacesClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.analyticsClient = Suppliers.memoize(() -> new AnalyticsClientImpl(clientOptions));
    this.logsClient = Suppliers.memoize(() -> new LogsClientImpl(clientOptions));
  }

  @Override
  public CreateGameNamespaceResponse createGameNamespace(UUID gameId,
      CreateGameNamespaceRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces")
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
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateGameNamespaceResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ValidateGameNamespaceResponse validateGameNamespace(UUID gameId,
      ValidateGameNamespaceRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/validate")
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
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ValidateGameNamespaceResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public GetGameNamespaceByIdResponse getGameNamespaceById(UUID gameId, UUID namespaceId) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("GET", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetGameNamespaceByIdResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void updateNamespaceCdnAuthUser(UUID gameId, UUID namespaceId,
      UpdateNamespaceCdnAuthUserRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      .addPathSegments("auth-user")
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
        return;
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void removeNamespaceCdnAuthUser(UUID gameId, UUID namespaceId, String user) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      .addPathSegments("auth-user/")
      .addPathSegment(user)
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("DELETE", RequestBody.create("", null))
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
  public void setNamespaceCdnAuthType(UUID gameId, UUID namespaceId,
      SetNamespaceCdnAuthTypeRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      .addPathSegments("cdn-auth")
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
      .method("PUT", _requestBody)
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
  public void toggleNamespaceDomainPublicAuth(UUID gameId, UUID namespaceId,
      ToggleNamespaceDomainPublicAuthRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      .addPathSegments("domain-public-auth")
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
      .method("PUT", _requestBody)
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
  public void addNamespaceDomain(UUID gameId, UUID namespaceId, AddNamespaceDomainRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      .addPathSegments("domains")
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
        return;
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void removeNamespaceDomain(UUID gameId, UUID namespaceId, String domain) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      .addPathSegments("domains/")
      .addPathSegment(domain)
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("DELETE", RequestBody.create("", null))
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
  public void updateGameNamespaceMatchmakerConfig(UUID gameId, UUID namespaceId,
      UpdateGameNamespaceMatchmakerConfigRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId.toString())
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId.toString())
      .addPathSegments("mm-config")
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
        return;
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public GetGameNamespaceVersionHistoryResponse getGameNamespaceVersionHistoryList(String gameId,
      String namespaceId, GetGameNamespaceVersionHistoryRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegment(gameId)
      .addPathSegments("namespaces/")
      .addPathSegment(namespaceId)
      .addPathSegments("version-history")
      ;if (request.getAnchor().isPresent()) {
        _httpUrlBuilder.addQueryParameter("anchor", request.getAnchor().get());
      }
      if (request.getLimit().isPresent()) {
        _httpUrlBuilder.addQueryParameter("limit", request.getLimit().get().toString());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetGameNamespaceVersionHistoryResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public ValidateGameNamespaceMatchmakerConfigResponse validateGameNamespaceMatchmakerConfig(
        UUID gameId, UUID namespaceId, ValidateGameNamespaceMatchmakerConfigRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegment(gameId.toString())
        .addPathSegments("namespaces/")
        .addPathSegment(namespaceId.toString())
        .addPathSegments("mm-config/validate")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ValidateGameNamespaceMatchmakerConfigResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public CreateGameNamespaceTokenDevelopmentResponse createGameNamespaceTokenDevelopment(
        UUID gameId, UUID namespaceId, CreateGameNamespaceTokenDevelopmentRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegment(gameId.toString())
        .addPathSegments("namespaces/")
        .addPathSegment(namespaceId.toString())
        .addPathSegments("tokens/development")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateGameNamespaceTokenDevelopmentResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public ValidateGameNamespaceTokenDevelopmentResponse validateGameNamespaceTokenDevelopment(
        UUID gameId, UUID namespaceId, ValidateGameNamespaceTokenDevelopmentRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegment(gameId.toString())
        .addPathSegments("namespaces/")
        .addPathSegment(namespaceId.toString())
        .addPathSegments("tokens/development/validate")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ValidateGameNamespaceTokenDevelopmentResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public CreateGameNamespaceTokenPublicResponse createGameNamespaceTokenPublic(UUID gameId,
        UUID namespaceId) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegment(gameId.toString())
        .addPathSegments("namespaces/")
        .addPathSegment(namespaceId.toString())
        .addPathSegments("tokens/public")
        .build();Request _request = new Request.Builder()
        .url(_httpUrl)
        .method("POST", RequestBody.create("", null))
        .headers(Headers.of(clientOptions.headers()))
        .build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateGameNamespaceTokenPublicResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void updateGameNamespaceVersion(UUID gameId, UUID namespaceId,
        UpdateGameNamespaceVersionRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegment(gameId.toString())
        .addPathSegments("namespaces/")
        .addPathSegment(namespaceId.toString())
        .addPathSegments("version")
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
        .method("PUT", _requestBody)
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
    public AnalyticsClient analytics() {
      return this.analyticsClient.get();
    }

    @Override
    public LogsClient logs() {
      return this.logsClient.get();
    }
  }
