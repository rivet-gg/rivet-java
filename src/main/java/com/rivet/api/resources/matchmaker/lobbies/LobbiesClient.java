package com.rivet.api.resources.matchmaker.lobbies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.matchmaker.lobbies.requests.CreateLobbyRequest;
import com.rivet.api.resources.matchmaker.lobbies.requests.FindLobbyRequest;
import com.rivet.api.resources.matchmaker.lobbies.requests.JoinLobbyRequest;
import com.rivet.api.resources.matchmaker.lobbies.requests.ListLobbiesRequest;
import com.rivet.api.resources.matchmaker.lobbies.requests.SetLobbyClosedRequest;
import com.rivet.api.resources.matchmaker.lobbies.types.CreateLobbyResponse;
import com.rivet.api.resources.matchmaker.lobbies.types.FindLobbyResponse;
import com.rivet.api.resources.matchmaker.lobbies.types.JoinLobbyResponse;
import com.rivet.api.resources.matchmaker.lobbies.types.ListLobbiesResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LobbiesClient {
    protected final ClientOptions clientOptions;

    public LobbiesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public void ready() {
        ready(null);
    }

    public void ready(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL())
                .newBuilder()
                .addPathSegments("lobbies")
                .addPathSegments("ready")
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

    public void setClosed(SetLobbyClosedRequest request) {
        setClosed(request, null);
    }

    public void setClosed(SetLobbyClosedRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL())
                .newBuilder()
                .addPathSegments("lobbies")
                .addPathSegments("closed")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("is_closed", request.getIsClosed());
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
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

    public void setState(Optional<Object> request) {
        setState(request, null);
    }

    public void setState(Optional<Object> request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL())
                .newBuilder()
                .addPathSegments("lobbies")
                .addPathSegments("state")
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

    public Optional<Object> getState(UUID lobbyId) {
        return getState(lobbyId, null);
    }

    public Optional<Object> getState(UUID lobbyId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL())
                .newBuilder()
                .addPathSegments("lobbies")
                .addPathSegment(lobbyId.toString())
                .addPathSegments("state")
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
                        _response.body().string(), new TypeReference<Optional<Object>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FindLobbyResponse find(FindLobbyRequest request) {
        return find(request, null);
    }

    public FindLobbyResponse find(FindLobbyRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL())
                .newBuilder()
                .addPathSegments("lobbies")
                .addPathSegments("find")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("game_modes", request.getGameModes());
        if (request.getRegions().isPresent()) {
            _requestBodyProperties.put("regions", request.getRegions());
        }
        if (request.getPreventAutoCreateLobby().isPresent()) {
            _requestBodyProperties.put("prevent_auto_create_lobby", request.getPreventAutoCreateLobby());
        }
        if (request.getCaptcha().isPresent()) {
            _requestBodyProperties.put("captcha", request.getCaptcha());
        }
        if (request.getVerificationData().isPresent()) {
            _requestBodyProperties.put("verification_data", request.getVerificationData());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getOrigin().isPresent()) {
            _requestBuilder.addHeader("origin", request.getOrigin().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), FindLobbyResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JoinLobbyResponse join(JoinLobbyRequest request) {
        return join(request, null);
    }

    public JoinLobbyResponse join(JoinLobbyRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL())
                .newBuilder()
                .addPathSegments("lobbies")
                .addPathSegments("join")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("lobby_id", request.getLobbyId());
        if (request.getCaptcha().isPresent()) {
            _requestBodyProperties.put("captcha", request.getCaptcha());
        }
        if (request.getVerificationData().isPresent()) {
            _requestBodyProperties.put("verification_data", request.getVerificationData());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), JoinLobbyResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CreateLobbyResponse create(CreateLobbyRequest request) {
        return create(request, null);
    }

    public CreateLobbyResponse create(CreateLobbyRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getmatchmakerURL())
                .newBuilder()
                .addPathSegments("lobbies")
                .addPathSegments("create")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("game_mode", request.getGameMode());
        if (request.getRegion().isPresent()) {
            _requestBodyProperties.put("region", request.getRegion());
        }
        if (request.getCaptcha().isPresent()) {
            _requestBodyProperties.put("captcha", request.getCaptcha());
        }
        _requestBodyProperties.put("publicity", request.getPublicity());
        if (request.getLobbyConfig().isPresent()) {
            _requestBodyProperties.put("lobby_config", request.getLobbyConfig());
        }
        if (request.getVerificationData().isPresent()) {
            _requestBodyProperties.put("verification_data", request.getVerificationData());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateLobbyResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ListLobbiesResponse list(ListLobbiesRequest request) {
        return list(request, null);
    }

    public ListLobbiesResponse list(ListLobbiesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getmatchmakerURL())
                .newBuilder()
                .addPathSegments("lobbies")
                .addPathSegments("list");
        if (request.getIncludeState().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_state", request.getIncludeState().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListLobbiesResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
