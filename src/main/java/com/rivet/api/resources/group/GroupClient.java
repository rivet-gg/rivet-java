package com.rivet.api.resources.group;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.group.invites.InvitesClient;
import com.rivet.api.resources.group.joinrequests.JoinRequestsClient;
import com.rivet.api.resources.group.requests.GetBansRequest;
import com.rivet.api.resources.group.requests.GetJoinRequestsRequest;
import com.rivet.api.resources.group.requests.GetMembersRequest;
import com.rivet.api.resources.group.requests.GetProfileRequest;
import com.rivet.api.resources.group.requests.ListSuggestedRequest;
import com.rivet.api.resources.group.requests.SearchRequest;
import com.rivet.api.resources.group.types.CreateRequest;
import com.rivet.api.resources.group.types.CreateResponse;
import com.rivet.api.resources.group.types.GetBansResponse;
import com.rivet.api.resources.group.types.GetJoinRequestsResponse;
import com.rivet.api.resources.group.types.GetMembersResponse;
import com.rivet.api.resources.group.types.GetProfileResponse;
import com.rivet.api.resources.group.types.GetSummaryResponse;
import com.rivet.api.resources.group.types.ListSuggestedResponse;
import com.rivet.api.resources.group.types.PrepareAvatarUploadRequest;
import com.rivet.api.resources.group.types.PrepareAvatarUploadResponse;
import com.rivet.api.resources.group.types.SearchResponse;
import com.rivet.api.resources.group.types.TransferOwnershipRequest;
import com.rivet.api.resources.group.types.UpdateProfileRequest;
import com.rivet.api.resources.group.types.ValidateProfileRequest;
import com.rivet.api.resources.group.types.ValidateProfileResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GroupClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<InvitesClient> invitesClient;

    protected final Supplier<JoinRequestsClient> joinRequestsClient;

    public GroupClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.invitesClient = Suppliers.memoize(() -> new InvitesClient(clientOptions));
        this.joinRequestsClient = Suppliers.memoize(() -> new JoinRequestsClient(clientOptions));
    }

    public ListSuggestedResponse listSuggested(ListSuggestedRequest request) {
        return listSuggested(request, null);
    }

    public ListSuggestedResponse listSuggested(ListSuggestedRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups");
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListSuggestedResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CreateResponse create(CreateRequest request) {
        return create(request, null);
    }

    public CreateResponse create(CreateRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateResponse.class);
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
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegments("avatar-upload/prepare")
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
                        _response.body().string(), PrepareAvatarUploadResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ValidateProfileResponse validateProfile(ValidateProfileRequest request) {
        return validateProfile(request, null);
    }

    public ValidateProfileResponse validateProfile(ValidateProfileRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegments("profile/validate")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ValidateProfileResponse.class);
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
                        this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
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

    public void completeAvatarUpload(UUID groupId, UUID uploadId) {
        completeAvatarUpload(groupId, uploadId, null);
    }

    public void completeAvatarUpload(UUID groupId, UUID uploadId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
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

    public GetBansResponse getBans(UUID groupId, GetBansRequest request) {
        return getBans(groupId, request, null);
    }

    public GetBansResponse getBans(UUID groupId, GetBansRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("bans");
        if (request.getAnchor().isPresent()) {
            _httpUrl.addQueryParameter("anchor", request.getAnchor().get());
        }
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetBansResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void banIdentity(UUID groupId, UUID identityId) {
        banIdentity(groupId, identityId, null);
    }

    public void banIdentity(UUID groupId, UUID identityId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("bans")
                .addPathSegment(identityId.toString())
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

    public void unbanIdentity(UUID groupId, UUID identityId) {
        unbanIdentity(groupId, identityId, null);
    }

    public void unbanIdentity(UUID groupId, UUID identityId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("bans")
                .addPathSegment(identityId.toString())
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

    public GetJoinRequestsResponse getJoinRequests(UUID groupId, GetJoinRequestsRequest request) {
        return getJoinRequests(groupId, request, null);
    }

    public GetJoinRequestsResponse getJoinRequests(
            UUID groupId, GetJoinRequestsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("join-requests");
        if (request.getAnchor().isPresent()) {
            _httpUrl.addQueryParameter("anchor", request.getAnchor().get());
        }
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetJoinRequestsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void kickMember(UUID groupId, UUID identityId) {
        kickMember(groupId, identityId, null);
    }

    public void kickMember(UUID groupId, UUID identityId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("kick")
                .addPathSegment(identityId.toString())
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

    public void leave(UUID groupId) {
        leave(groupId, null);
    }

    public void leave(UUID groupId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("leave")
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

    public GetMembersResponse getMembers(UUID groupId, GetMembersRequest request) {
        return getMembers(groupId, request, null);
    }

    public GetMembersResponse getMembers(UUID groupId, GetMembersRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("members");
        if (request.getAnchor().isPresent()) {
            _httpUrl.addQueryParameter("anchor", request.getAnchor().get());
        }
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetMembersResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetProfileResponse getProfile(UUID groupId, GetProfileRequest request) {
        return getProfile(groupId, request, null);
    }

    public GetProfileResponse getProfile(UUID groupId, GetProfileRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
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

    public void updateProfile(UUID groupId, UpdateProfileRequest request) {
        updateProfile(groupId, request, null);
    }

    public void updateProfile(UUID groupId, UpdateProfileRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("profile")
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

    public GetSummaryResponse getSummary(UUID groupId) {
        return getSummary(groupId, null);
    }

    public GetSummaryResponse getSummary(UUID groupId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("summary")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetSummaryResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void transferOwnership(UUID groupId, TransferOwnershipRequest request) {
        transferOwnership(groupId, request, null);
    }

    public void transferOwnership(UUID groupId, TransferOwnershipRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL())
                .newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("transfer-owner")
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

    public InvitesClient invites() {
        return this.invitesClient.get();
    }

    public JoinRequestsClient joinRequests() {
        return this.joinRequestsClient.get();
    }
}
