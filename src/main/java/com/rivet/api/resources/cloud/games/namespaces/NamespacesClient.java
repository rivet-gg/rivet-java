package com.rivet.api.resources.cloud.games.namespaces;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.cloud.games.namespaces.analytics.AnalyticsClient;
import com.rivet.api.resources.cloud.games.namespaces.logs.LogsClient;
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
import java.io.IOException;
import java.util.UUID;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NamespacesClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AnalyticsClient> analyticsClient;

    protected final Supplier<LogsClient> logsClient;

    public NamespacesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.analyticsClient = Suppliers.memoize(() -> new AnalyticsClient(clientOptions));
        this.logsClient = Suppliers.memoize(() -> new LogsClient(clientOptions));
    }

    public CreateGameNamespaceResponse createGameNamespace(UUID gameId, CreateGameNamespaceRequest request) {
        return createGameNamespace(gameId, request, null);
    }

    public CreateGameNamespaceResponse createGameNamespace(
            UUID gameId, CreateGameNamespaceRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
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
                        _response.body().string(), CreateGameNamespaceResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ValidateGameNamespaceResponse validateGameNamespace(UUID gameId, ValidateGameNamespaceRequest request) {
        return validateGameNamespace(gameId, request, null);
    }

    public ValidateGameNamespaceResponse validateGameNamespace(
            UUID gameId, ValidateGameNamespaceRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces/validate")
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
                        _response.body().string(), ValidateGameNamespaceResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetGameNamespaceByIdResponse getGameNamespaceById(UUID gameId, UUID namespaceId) {
        return getGameNamespaceById(gameId, namespaceId, null);
    }

    public GetGameNamespaceByIdResponse getGameNamespaceById(
            UUID gameId, UUID namespaceId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
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
                        _response.body().string(), GetGameNamespaceByIdResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateNamespaceCdnAuthUser(UUID gameId, UUID namespaceId, UpdateNamespaceCdnAuthUserRequest request) {
        updateNamespaceCdnAuthUser(gameId, namespaceId, request, null);
    }

    public void updateNamespaceCdnAuthUser(
            UUID gameId, UUID namespaceId, UpdateNamespaceCdnAuthUserRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("auth-user")
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
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeNamespaceCdnAuthUser(UUID gameId, UUID namespaceId, String user) {
        removeNamespaceCdnAuthUser(gameId, namespaceId, user, null);
    }

    public void removeNamespaceCdnAuthUser(UUID gameId, UUID namespaceId, String user, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("auth-user")
                .addPathSegment(user)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", null)
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

    public void setNamespaceCdnAuthType(UUID gameId, UUID namespaceId, SetNamespaceCdnAuthTypeRequest request) {
        setNamespaceCdnAuthType(gameId, namespaceId, request, null);
    }

    public void setNamespaceCdnAuthType(
            UUID gameId, UUID namespaceId, SetNamespaceCdnAuthTypeRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("cdn-auth")
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
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
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

    public void toggleNamespaceDomainPublicAuth(
            UUID gameId, UUID namespaceId, ToggleNamespaceDomainPublicAuthRequest request) {
        toggleNamespaceDomainPublicAuth(gameId, namespaceId, request, null);
    }

    public void toggleNamespaceDomainPublicAuth(
            UUID gameId,
            UUID namespaceId,
            ToggleNamespaceDomainPublicAuthRequest request,
            RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("domain-public-auth")
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
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
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

    public void addNamespaceDomain(UUID gameId, UUID namespaceId, AddNamespaceDomainRequest request) {
        addNamespaceDomain(gameId, namespaceId, request, null);
    }

    public void addNamespaceDomain(
            UUID gameId, UUID namespaceId, AddNamespaceDomainRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("domains")
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
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeNamespaceDomain(UUID gameId, UUID namespaceId, String domain) {
        removeNamespaceDomain(gameId, namespaceId, domain, null);
    }

    public void removeNamespaceDomain(UUID gameId, UUID namespaceId, String domain, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("domains")
                .addPathSegment(domain)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", null)
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

    public void updateGameNamespaceMatchmakerConfig(
            UUID gameId, UUID namespaceId, UpdateGameNamespaceMatchmakerConfigRequest request) {
        updateGameNamespaceMatchmakerConfig(gameId, namespaceId, request, null);
    }

    public void updateGameNamespaceMatchmakerConfig(
            UUID gameId,
            UUID namespaceId,
            UpdateGameNamespaceMatchmakerConfigRequest request,
            RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("mm-config")
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
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetGameNamespaceVersionHistoryResponse getGameNamespaceVersionHistoryList(
            String gameId, String namespaceId, GetGameNamespaceVersionHistoryRequest request) {
        return getGameNamespaceVersionHistoryList(gameId, namespaceId, request, null);
    }

    public GetGameNamespaceVersionHistoryResponse getGameNamespaceVersionHistoryList(
            String gameId,
            String namespaceId,
            GetGameNamespaceVersionHistoryRequest request,
            RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId)
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId)
                .addPathSegments("version-history");
        if (request.getAnchor().isPresent()) {
            _httpUrl.addQueryParameter("anchor", request.getAnchor().get());
        }
        if (request.getLimit().isPresent()) {
            _httpUrl.addQueryParameter("limit", request.getLimit().get().toString());
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
                        _response.body().string(), GetGameNamespaceVersionHistoryResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ValidateGameNamespaceMatchmakerConfigResponse validateGameNamespaceMatchmakerConfig(
            UUID gameId, UUID namespaceId, ValidateGameNamespaceMatchmakerConfigRequest request) {
        return validateGameNamespaceMatchmakerConfig(gameId, namespaceId, request, null);
    }

    public ValidateGameNamespaceMatchmakerConfigResponse validateGameNamespaceMatchmakerConfig(
            UUID gameId,
            UUID namespaceId,
            ValidateGameNamespaceMatchmakerConfigRequest request,
            RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("mm-config/validate")
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
                        _response.body().string(), ValidateGameNamespaceMatchmakerConfigResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CreateGameNamespaceTokenDevelopmentResponse createGameNamespaceTokenDevelopment(
            UUID gameId, UUID namespaceId, CreateGameNamespaceTokenDevelopmentRequest request) {
        return createGameNamespaceTokenDevelopment(gameId, namespaceId, request, null);
    }

    public CreateGameNamespaceTokenDevelopmentResponse createGameNamespaceTokenDevelopment(
            UUID gameId,
            UUID namespaceId,
            CreateGameNamespaceTokenDevelopmentRequest request,
            RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("tokens/development")
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
                        _response.body().string(), CreateGameNamespaceTokenDevelopmentResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ValidateGameNamespaceTokenDevelopmentResponse validateGameNamespaceTokenDevelopment(
            UUID gameId, UUID namespaceId, ValidateGameNamespaceTokenDevelopmentRequest request) {
        return validateGameNamespaceTokenDevelopment(gameId, namespaceId, request, null);
    }

    public ValidateGameNamespaceTokenDevelopmentResponse validateGameNamespaceTokenDevelopment(
            UUID gameId,
            UUID namespaceId,
            ValidateGameNamespaceTokenDevelopmentRequest request,
            RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("tokens/development/validate")
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
                        _response.body().string(), ValidateGameNamespaceTokenDevelopmentResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CreateGameNamespaceTokenPublicResponse createGameNamespaceTokenPublic(UUID gameId, UUID namespaceId) {
        return createGameNamespaceTokenPublic(gameId, namespaceId, null);
    }

    public CreateGameNamespaceTokenPublicResponse createGameNamespaceTokenPublic(
            UUID gameId, UUID namespaceId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("tokens/public")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), CreateGameNamespaceTokenPublicResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGameNamespaceVersion(UUID gameId, UUID namespaceId, UpdateGameNamespaceVersionRequest request) {
        updateGameNamespaceVersion(gameId, namespaceId, request, null);
    }

    public void updateGameNamespaceVersion(
            UUID gameId, UUID namespaceId, UpdateGameNamespaceVersionRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("version")
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
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
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

    public AnalyticsClient analytics() {
        return this.analyticsClient.get();
    }

    public LogsClient logs() {
        return this.logsClient.get();
    }
}
