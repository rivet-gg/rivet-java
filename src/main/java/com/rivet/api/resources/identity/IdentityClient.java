package com.rivet.api.resources.identity;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.identity.events.EventsClient;
import com.rivet.api.resources.identity.links.LinksClient;
import com.rivet.api.resources.identity.requests.GetHandlesRequest;
import com.rivet.api.resources.identity.requests.GetProfileRequest;
import com.rivet.api.resources.identity.requests.GetSelfProfileRequest;
import com.rivet.api.resources.identity.requests.GetSummariesRequest;
import com.rivet.api.resources.identity.requests.ListFollowersRequest;
import com.rivet.api.resources.identity.requests.ListFollowingRequest;
import com.rivet.api.resources.identity.requests.ListFriendsRequest;
import com.rivet.api.resources.identity.requests.ListMutualFriendsRequest;
import com.rivet.api.resources.identity.requests.ListRecentFollowersRequest;
import com.rivet.api.resources.identity.requests.PrepareAvatarUploadRequest;
import com.rivet.api.resources.identity.requests.ReportRequest;
import com.rivet.api.resources.identity.requests.SearchRequest;
import com.rivet.api.resources.identity.requests.SetGameActivityRequest;
import com.rivet.api.resources.identity.requests.SetupRequest;
import com.rivet.api.resources.identity.requests.SignupForBetaRequest;
import com.rivet.api.resources.identity.requests.UpdateProfileRequest;
import com.rivet.api.resources.identity.requests.UpdateStatusRequest;
import com.rivet.api.resources.identity.requests.ValidateProfileRequest;
import com.rivet.api.resources.identity.types.GetHandlesResponse;
import com.rivet.api.resources.identity.types.GetProfileResponse;
import com.rivet.api.resources.identity.types.GetSummariesResponse;
import com.rivet.api.resources.identity.types.ListFollowersResponse;
import com.rivet.api.resources.identity.types.ListFollowingResponse;
import com.rivet.api.resources.identity.types.ListFriendsResponse;
import com.rivet.api.resources.identity.types.ListMutualFriendsResponse;
import com.rivet.api.resources.identity.types.ListRecentFollowersResponse;
import com.rivet.api.resources.identity.types.PrepareAvatarUploadResponse;
import com.rivet.api.resources.identity.types.SearchResponse;
import com.rivet.api.resources.identity.types.SetupResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class IdentityClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<EventsClient> eventsClient;

    protected final Supplier<LinksClient> linksClient;

    public IdentityClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.eventsClient = Suppliers.memoize(() -> new EventsClient(clientOptions));
        this.linksClient = Suppliers.memoize(() -> new LinksClient(clientOptions));
    }

    public SetupResponse setup(SetupRequest request) {
        return setup(request, null);
    }

    public SetupResponse setup(SetupRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getExistingIdentityToken().isPresent()) {
            _requestBodyProperties.put("existing_identity_token", request.getExistingIdentityToken());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SetupResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetProfileResponse getProfile(UUID identityId, GetProfileRequest request) {
        return getProfile(identityId, request, null);
    }

    public GetProfileResponse getProfile(UUID identityId, GetProfileRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegment(identityId.toString())
                .addPathSegments("profile");
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetProfileResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetProfileResponse getSelfProfile(GetSelfProfileRequest request) {
        return getSelfProfile(request, null);
    }

    public GetProfileResponse getSelfProfile(GetSelfProfileRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/profile");
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetProfileResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetHandlesResponse getHandles(GetHandlesRequest request) {
        return getHandles(request, null);
    }

    public GetHandlesResponse getHandles(GetHandlesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("batch/handle");
        _httpUrl.addQueryParameter("identity_ids", request.getIdentityIds());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetHandlesResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetSummariesResponse getSummaries(GetSummariesRequest request) {
        return getSummaries(request, null);
    }

    public GetSummariesResponse getSummaries(GetSummariesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("batch/summary");
        _httpUrl.addQueryParameter("identity_ids", request.getIdentityIds());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetSummariesResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProfile(UpdateProfileRequest request) {
        updateProfile(request, null);
    }

    public void updateProfile(UpdateProfileRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/profile")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getDisplayName().isPresent()) {
            _requestBodyProperties.put("display_name", request.getDisplayName());
        }
        if (request.getAccountNumber().isPresent()) {
            _requestBodyProperties.put("account_number", request.getAccountNumber());
        }
        if (request.getBio().isPresent()) {
            _requestBodyProperties.put("bio", request.getBio());
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
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void validateProfile(ValidateProfileRequest request) {
        validateProfile(request, null);
    }

    public void validateProfile(ValidateProfileRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/profile/validate")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getDisplayName().isPresent()) {
            _requestBodyProperties.put("display_name", request.getDisplayName());
        }
        if (request.getAccountNumber().isPresent()) {
            _requestBodyProperties.put("account_number", request.getAccountNumber());
        }
        if (request.getBio().isPresent()) {
            _requestBodyProperties.put("bio", request.getBio());
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
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SearchResponse search(SearchRequest request) {
        return search(request, null);
    }

    public SearchResponse search(SearchRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("search");
        _httpUrl.addQueryParameter("query", request.getQuery());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SearchResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setGameActivity(SetGameActivityRequest request) {
        setGameActivity(request, null);
    }

    public void setGameActivity(SetGameActivityRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/activity")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("game_activity", request.getGameActivity());
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
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeGameActivity() {
        removeGameActivity(null);
    }

    public void removeGameActivity(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/activity")
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

    public void updateStatus(UpdateStatusRequest request) {
        updateStatus(request, null);
    }

    public void updateStatus(UpdateStatusRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("identities/self/status")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("status", request.getStatus());
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
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void follow(UUID identityId) {
        follow(identityId, null);
    }

    public void follow(UUID identityId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegment(identityId.toString())
                .addPathSegments("follow")
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

    public void unfollow(UUID identityId) {
        unfollow(identityId, null);
    }

    public void unfollow(UUID identityId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegment(identityId.toString())
                .addPathSegments("follow")
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

    public PrepareAvatarUploadResponse prepareAvatarUpload(PrepareAvatarUploadRequest request) {
        return prepareAvatarUpload(request, null);
    }

    public PrepareAvatarUploadResponse prepareAvatarUpload(
            PrepareAvatarUploadRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("avatar-upload/prepare")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("path", request.getPath());
        _requestBodyProperties.put("mime", request.getMime());
        _requestBodyProperties.put("content_length", request.getContentLength());
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), PrepareAvatarUploadResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void completeAvatarUpload(UUID uploadId) {
        completeAvatarUpload(uploadId, null);
    }

    public void completeAvatarUpload(UUID uploadId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
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

    public void signupForBeta(SignupForBetaRequest request) {
        signupForBeta(request, null);
    }

    public void signupForBeta(SignupForBetaRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/beta-signup")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("name", request.getName());
        if (request.getCompanyName().isPresent()) {
            _requestBodyProperties.put("company_name", request.getCompanyName());
        }
        _requestBodyProperties.put("company_size", request.getCompanySize());
        _requestBodyProperties.put("preferred_tools", request.getPreferredTools());
        _requestBodyProperties.put("goals", request.getGoals());
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
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void report(UUID identityId, ReportRequest request) {
        report(identityId, request, null);
    }

    public void report(UUID identityId, ReportRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegment(identityId.toString())
                .addPathSegments("report")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getReason().isPresent()) {
            _requestBodyProperties.put("reason", request.getReason());
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
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ListFollowersResponse listFollowers(UUID identityId, ListFollowersRequest request) {
        return listFollowers(identityId, request, null);
    }

    public ListFollowersResponse listFollowers(
            UUID identityId, ListFollowersRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegment(identityId.toString())
                .addPathSegments("followers");
        if (request.getAnchor().isPresent()) {
            _httpUrl.addQueryParameter("anchor", request.getAnchor().get());
        }
        if (request.getLimit().isPresent()) {
            _httpUrl.addQueryParameter("limit", request.getLimit().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListFollowersResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ListFollowingResponse listFollowing(UUID identityId, ListFollowingRequest request) {
        return listFollowing(identityId, request, null);
    }

    public ListFollowingResponse listFollowing(
            UUID identityId, ListFollowingRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegment(identityId.toString())
                .addPathSegments("following");
        if (request.getAnchor().isPresent()) {
            _httpUrl.addQueryParameter("anchor", request.getAnchor().get());
        }
        if (request.getLimit().isPresent()) {
            _httpUrl.addQueryParameter("limit", request.getLimit().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListFollowingResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ListFriendsResponse listFriends(ListFriendsRequest request) {
        return listFriends(request, null);
    }

    public ListFriendsResponse listFriends(ListFriendsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/friends");
        if (request.getAnchor().isPresent()) {
            _httpUrl.addQueryParameter("anchor", request.getAnchor().get());
        }
        if (request.getLimit().isPresent()) {
            _httpUrl.addQueryParameter("limit", request.getLimit().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListFriendsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ListMutualFriendsResponse listMutualFriends(UUID identityId, ListMutualFriendsRequest request) {
        return listMutualFriends(identityId, request, null);
    }

    public ListMutualFriendsResponse listMutualFriends(
            UUID identityId, ListMutualFriendsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegment(identityId.toString())
                .addPathSegments("mutual-friends");
        if (request.getAnchor().isPresent()) {
            _httpUrl.addQueryParameter("anchor", request.getAnchor().get());
        }
        if (request.getLimit().isPresent()) {
            _httpUrl.addQueryParameter("limit", request.getLimit().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListMutualFriendsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ListRecentFollowersResponse listRecentFollowers(ListRecentFollowersRequest request) {
        return listRecentFollowers(request, null);
    }

    public ListRecentFollowersResponse listRecentFollowers(
            ListRecentFollowersRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/recent-followers");
        if (request.getCount().isPresent()) {
            _httpUrl.addQueryParameter("count", request.getCount().get().toString());
        }
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), ListRecentFollowersResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ignoreRecentFollower(UUID identityId) {
        ignoreRecentFollower(identityId, null);
    }

    public void ignoreRecentFollower(UUID identityId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/recent-followers")
                .addPathSegment(identityId.toString())
                .addPathSegments("ignore")
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

    public void markDeletion() {
        markDeletion(null);
    }

    public void markDeletion(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/delete-request")
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

    public void unmarkDeletion() {
        unmarkDeletion(null);
    }

    public void unmarkDeletion(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegments("self/delete-request")
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

    public EventsClient events() {
        return this.eventsClient.get();
    }

    public LinksClient links() {
        return this.linksClient.get();
    }
}
