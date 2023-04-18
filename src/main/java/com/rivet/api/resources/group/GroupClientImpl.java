package com.rivet.api.resources.group;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.group.invites.InvitesClient;
import com.rivet.api.resources.group.invites.InvitesClientImpl;
import com.rivet.api.resources.group.join.requests.JoinRequestsClient;
import com.rivet.api.resources.group.join.requests.JoinRequestsClientImpl;
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
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.util.UUID;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class GroupClientImpl implements GroupClient {
  private final ClientOptions clientOptions;

  private final Supplier<InvitesClient> invitesClient;

  private final Supplier<JoinRequestsClient> joinRequestsClient;

  public GroupClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.invitesClient = Suppliers.memoize(() -> new InvitesClientImpl(clientOptions));
    this.joinRequestsClient = Suppliers.memoize(() -> new JoinRequestsClientImpl(clientOptions));
  }

  @Override
  public ListSuggestedResponse listSuggested(ListSuggestedRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
      .addPathSegments("groups")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListSuggestedResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public CreateResponse create(CreateRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
        .addPathSegments("groups")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public PrepareAvatarUploadResponse prepareAvatarUpload(PrepareAvatarUploadRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
        .addPathSegments("groups")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PrepareAvatarUploadResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public ValidateProfileResponse validateProfile(ValidateProfileRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
        .addPathSegments("groups")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ValidateProfileResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public SearchResponse search(SearchRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
        .addPathSegments("groups")
        ;_httpUrlBuilder.addQueryParameter("query", request.getQuery());
        if (request.getAnchor().isPresent()) {
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
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SearchResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public void completeAvatarUpload(UUID groupId, UUID uploadId) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
          .addPathSegments("groups")
          .addPathSegment(groupId.toString())
          .addPathSegments("avatar-upload/")
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
      public GetBansResponse getBans(UUID groupId, GetBansRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
          .addPathSegments("groups")
          .addPathSegment(groupId.toString())
          .addPathSegments("bans")
          ;if (request.getAnchor().isPresent()) {
            _httpUrlBuilder.addQueryParameter("anchor", request.getAnchor().get());
          }
          if (request.getCount().isPresent()) {
            _httpUrlBuilder.addQueryParameter("count", request.getCount().get().toString());
          }
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
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetBansResponse.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }

        @Override
        public void banIdentity(UUID groupId, UUID identityId) {
          HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
            .addPathSegments("groups")
            .addPathSegment(groupId.toString())
            .addPathSegments("bans/")
            .addPathSegment(identityId.toString())
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
        public void unbanIdentity(UUID groupId, UUID identityId) {
          HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
            .addPathSegments("groups")
            .addPathSegment(groupId.toString())
            .addPathSegments("bans/")
            .addPathSegment(identityId.toString())
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
        public GetJoinRequestsResponse getJoinRequests(UUID groupId,
            GetJoinRequestsRequest request) {
          HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
            .addPathSegments("groups")
            .addPathSegment(groupId.toString())
            .addPathSegments("join-requests")
            ;if (request.getAnchor().isPresent()) {
              _httpUrlBuilder.addQueryParameter("anchor", request.getAnchor().get());
            }
            if (request.getCount().isPresent()) {
              _httpUrlBuilder.addQueryParameter("count", request.getCount().get().toString());
            }
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetJoinRequestsResponse.class);
              }
              throw new RuntimeException();
            }
            catch (Exception e) {
              throw new RuntimeException(e);
            }
          }

          @Override
          public void kickMember(UUID groupId, UUID identityId) {
            HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
              .addPathSegments("groups")
              .addPathSegment(groupId.toString())
              .addPathSegments("kick/")
              .addPathSegment(identityId.toString())
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
          public void leave(UUID groupId) {
            HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
              .addPathSegments("groups")
              .addPathSegment(groupId.toString())
              .addPathSegments("leave")
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
          public GetMembersResponse getMembers(UUID groupId, GetMembersRequest request) {
            HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
              .addPathSegments("groups")
              .addPathSegment(groupId.toString())
              .addPathSegments("members")
              ;if (request.getAnchor().isPresent()) {
                _httpUrlBuilder.addQueryParameter("anchor", request.getAnchor().get());
              }
              if (request.getCount().isPresent()) {
                _httpUrlBuilder.addQueryParameter("count", request.getCount().get().toString());
              }
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
                  return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetMembersResponse.class);
                }
                throw new RuntimeException();
              }
              catch (Exception e) {
                throw new RuntimeException(e);
              }
            }

            @Override
            public GetProfileResponse getProfile(UUID groupId, GetProfileRequest request) {
              HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
                .addPathSegments("groups")
                .addPathSegment(groupId.toString())
                .addPathSegments("profile")
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
                    return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetProfileResponse.class);
                  }
                  throw new RuntimeException();
                }
                catch (Exception e) {
                  throw new RuntimeException(e);
                }
              }

              @Override
              public void updateProfile(UUID groupId, UpdateProfileRequest request) {
                HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
                  .addPathSegments("groups")
                  .addPathSegment(groupId.toString())
                  .addPathSegments("profile")
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
              public GetSummaryResponse getSummary(UUID groupId) {
                HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
                  .addPathSegments("groups")
                  .addPathSegment(groupId.toString())
                  .addPathSegments("summary")
                  .build();Request _request = new Request.Builder()
                  .url(_httpUrl)
                  .method("GET", RequestBody.create("", null))
                  .headers(Headers.of(clientOptions.headers()))
                  .build();
                try {
                  Response _response = clientOptions.httpClient().newCall(_request).execute();
                  if (_response.isSuccessful()) {
                    return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetSummaryResponse.class);
                  }
                  throw new RuntimeException();
                }
                catch (Exception e) {
                  throw new RuntimeException(e);
                }
              }

              @Override
              public void transferOwnership(UUID groupId, TransferOwnershipRequest request) {
                HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
                  .addPathSegments("groups")
                  .addPathSegment(groupId.toString())
                  .addPathSegments("transfer-owner")
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
              public InvitesClient invites() {
                return this.invitesClient.get();
              }

              @Override
              public JoinRequestsClient joinRequests() {
                return this.joinRequestsClient.get();
              }
            }
