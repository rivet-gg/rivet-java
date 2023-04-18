package com.rivet.api.resources.identity;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.identity.events.EventsClient;
import com.rivet.api.resources.identity.events.EventsClientImpl;
import com.rivet.api.resources.identity.links.LinksClient;
import com.rivet.api.resources.identity.links.LinksClientImpl;
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
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
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

public final class IdentityClientImpl implements IdentityClient {
  private final ClientOptions clientOptions;

  private final Supplier<EventsClient> eventsClient;

  private final Supplier<LinksClient> linksClient;

  public IdentityClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.eventsClient = Suppliers.memoize(() -> new EventsClientImpl(clientOptions));
    this.linksClient = Suppliers.memoize(() -> new LinksClientImpl(clientOptions));
  }

  @Override
  public SetupResponse setup(SetupRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
      .addPathSegments("identities")
      ;HttpUrl _httpUrl = _httpUrlBuilder.build();
      Map<String, Object> _requestBodyProperties = new HashMap<>();
      _requestBodyProperties.put("existing_identity_token", request.getExistingIdentityToken());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SetupResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public GetProfileResponse getProfile(UUID identityId, GetProfileRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
        .addPathSegments("identities")
        .addPathSegment(identityId.toString())
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
      public GetProfileResponse getSelfProfile(GetSelfProfileRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
          .addPathSegments("identities")
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
        public GetHandlesResponse getHandles(GetHandlesRequest request) {
          HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
            .addPathSegments("identities")
            ;_httpUrlBuilder.addQueryParameter("identity_ids", request.getIdentityIds());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetHandlesResponse.class);
              }
              throw new RuntimeException();
            }
            catch (Exception e) {
              throw new RuntimeException(e);
            }
          }

          @Override
          public GetSummariesResponse getSummaries(GetSummariesRequest request) {
            HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
              .addPathSegments("identities")
              ;_httpUrlBuilder.addQueryParameter("identity_ids", request.getIdentityIds());
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
                  return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetSummariesResponse.class);
                }
                throw new RuntimeException();
              }
              catch (Exception e) {
                throw new RuntimeException(e);
              }
            }

            @Override
            public void updateProfile(UpdateProfileRequest request) {
              HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                .addPathSegments("identities")
                ;HttpUrl _httpUrl = _httpUrlBuilder.build();
                Map<String, Object> _requestBodyProperties = new HashMap<>();
                _requestBodyProperties.put("display_name", request.getDisplayName());
                _requestBodyProperties.put("account_number", request.getAccountNumber());
                _requestBodyProperties.put("bio", request.getBio());
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
                    return;
                  }
                  throw new RuntimeException();
                }
                catch (Exception e) {
                  throw new RuntimeException(e);
                }
              }

              @Override
              public void validateProfile(ValidateProfileRequest request) {
                HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                  .addPathSegments("identities")
                  ;HttpUrl _httpUrl = _httpUrlBuilder.build();
                  Map<String, Object> _requestBodyProperties = new HashMap<>();
                  _requestBodyProperties.put("display_name", request.getDisplayName());
                  _requestBodyProperties.put("account_number", request.getAccountNumber());
                  _requestBodyProperties.put("bio", request.getBio());
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
                      return;
                    }
                    throw new RuntimeException();
                  }
                  catch (Exception e) {
                    throw new RuntimeException(e);
                  }
                }

                @Override
                public SearchResponse search(SearchRequest request) {
                  HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                    .addPathSegments("identities")
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
                  public void setGameActivity(SetGameActivityRequest request) {
                    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                      .addPathSegments("identities")
                      ;HttpUrl _httpUrl = _httpUrlBuilder.build();
                      Map<String, Object> _requestBodyProperties = new HashMap<>();
                      _requestBodyProperties.put("game_activity", request.getGameActivity());
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
                          return;
                        }
                        throw new RuntimeException();
                      }
                      catch (Exception e) {
                        throw new RuntimeException(e);
                      }
                    }

                    @Override
                    public void removeGameActivity() {
                      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                        .addPathSegments("identities")
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
                    public void updateStatus(UpdateStatusRequest request) {
                      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                        .addPathSegments("identities")
                        ;HttpUrl _httpUrl = _httpUrlBuilder.build();
                        Map<String, Object> _requestBodyProperties = new HashMap<>();
                        _requestBodyProperties.put("status", request.getStatus());
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
                            return;
                          }
                          throw new RuntimeException();
                        }
                        catch (Exception e) {
                          throw new RuntimeException(e);
                        }
                      }

                      @Override
                      public void follow(UUID identityId) {
                        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                          .addPathSegments("identities")
                          .addPathSegment(identityId.toString())
                          .addPathSegments("follow")
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
                      public void unfollow(UUID identityId) {
                        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                          .addPathSegments("identities")
                          .addPathSegment(identityId.toString())
                          .addPathSegments("follow")
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
                      public PrepareAvatarUploadResponse prepareAvatarUpload(
                          PrepareAvatarUploadRequest request) {
                        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                          .addPathSegments("identities")
                          ;HttpUrl _httpUrl = _httpUrlBuilder.build();
                          Map<String, Object> _requestBodyProperties = new HashMap<>();
                          _requestBodyProperties.put("path", request.getPath());
                          _requestBodyProperties.put("mime", request.getMime());
                          _requestBodyProperties.put("content_length", request.getContentLength());
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
                              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PrepareAvatarUploadResponse.class);
                            }
                            throw new RuntimeException();
                          }
                          catch (Exception e) {
                            throw new RuntimeException(e);
                          }
                        }

                        @Override
                        public void completeAvatarUpload(UUID uploadId) {
                          HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                            .addPathSegments("identities")
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
                        public void signupForBeta(SignupForBetaRequest request) {
                          HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                            .addPathSegments("identities")
                            ;HttpUrl _httpUrl = _httpUrlBuilder.build();
                            Map<String, Object> _requestBodyProperties = new HashMap<>();
                            _requestBodyProperties.put("name", request.getName());
                            _requestBodyProperties.put("company_name", request.getCompanyName());
                            _requestBodyProperties.put("company_size", request.getCompanySize());
                            _requestBodyProperties.put("preferred_tools", request.getPreferredTools());
                            _requestBodyProperties.put("goals", request.getGoals());
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
                                return;
                              }
                              throw new RuntimeException();
                            }
                            catch (Exception e) {
                              throw new RuntimeException(e);
                            }
                          }

                          @Override
                          public void report(UUID identityId, ReportRequest request) {
                            HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                              .addPathSegments("identities")
                              .addPathSegment(identityId.toString())
                              .addPathSegments("report")
                              ;HttpUrl _httpUrl = _httpUrlBuilder.build();
                              Map<String, Object> _requestBodyProperties = new HashMap<>();
                              _requestBodyProperties.put("reason", request.getReason());
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
                                  return;
                                }
                                throw new RuntimeException();
                              }
                              catch (Exception e) {
                                throw new RuntimeException(e);
                              }
                            }

                            @Override
                            public ListFollowersResponse listFollowers(UUID identityId,
                                ListFollowersRequest request) {
                              HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                                .addPathSegments("identities")
                                .addPathSegment(identityId.toString())
                                .addPathSegments("followers")
                                ;if (request.getAnchor().isPresent()) {
                                  _httpUrlBuilder.addQueryParameter("anchor", request.getAnchor().get());
                                }
                                if (request.getLimit().isPresent()) {
                                  _httpUrlBuilder.addQueryParameter("limit", request.getLimit().get());
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
                                    return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListFollowersResponse.class);
                                  }
                                  throw new RuntimeException();
                                }
                                catch (Exception e) {
                                  throw new RuntimeException(e);
                                }
                              }

                              @Override
                              public ListFollowingResponse listFollowing(UUID identityId,
                                  ListFollowingRequest request) {
                                HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                                  .addPathSegments("identities")
                                  .addPathSegment(identityId.toString())
                                  .addPathSegments("following")
                                  ;if (request.getAnchor().isPresent()) {
                                    _httpUrlBuilder.addQueryParameter("anchor", request.getAnchor().get());
                                  }
                                  if (request.getLimit().isPresent()) {
                                    _httpUrlBuilder.addQueryParameter("limit", request.getLimit().get());
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
                                      return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListFollowingResponse.class);
                                    }
                                    throw new RuntimeException();
                                  }
                                  catch (Exception e) {
                                    throw new RuntimeException(e);
                                  }
                                }

                                @Override
                                public ListFriendsResponse listFriends(ListFriendsRequest request) {
                                  HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                                    .addPathSegments("identities")
                                    ;if (request.getAnchor().isPresent()) {
                                      _httpUrlBuilder.addQueryParameter("anchor", request.getAnchor().get());
                                    }
                                    if (request.getLimit().isPresent()) {
                                      _httpUrlBuilder.addQueryParameter("limit", request.getLimit().get());
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
                                        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListFriendsResponse.class);
                                      }
                                      throw new RuntimeException();
                                    }
                                    catch (Exception e) {
                                      throw new RuntimeException(e);
                                    }
                                  }

                                  @Override
                                  public ListMutualFriendsResponse listMutualFriends(
                                      UUID identityId, ListMutualFriendsRequest request) {
                                    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                                      .addPathSegments("identities")
                                      .addPathSegment(identityId.toString())
                                      .addPathSegments("mutual-friends")
                                      ;if (request.getAnchor().isPresent()) {
                                        _httpUrlBuilder.addQueryParameter("anchor", request.getAnchor().get());
                                      }
                                      if (request.getLimit().isPresent()) {
                                        _httpUrlBuilder.addQueryParameter("limit", request.getLimit().get());
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
                                          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListMutualFriendsResponse.class);
                                        }
                                        throw new RuntimeException();
                                      }
                                      catch (Exception e) {
                                        throw new RuntimeException(e);
                                      }
                                    }

                                    @Override
                                    public ListRecentFollowersResponse listRecentFollowers(
                                        ListRecentFollowersRequest request) {
                                      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                                        .addPathSegments("identities")
                                        ;if (request.getCount().isPresent()) {
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
                                            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListRecentFollowersResponse.class);
                                          }
                                          throw new RuntimeException();
                                        }
                                        catch (Exception e) {
                                          throw new RuntimeException(e);
                                        }
                                      }

                                      @Override
                                      public void ignoreRecentFollower(UUID identityId) {
                                        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                                          .addPathSegments("identities")
                                          .addPathSegment(identityId.toString())
                                          .addPathSegments("ignore")
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
                                      public void markDeletion() {
                                        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                                          .addPathSegments("identities")
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
                                      public void unmarkDeletion() {
                                        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL()).newBuilder()
                                          .addPathSegments("identities")
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
                                      public EventsClient events() {
                                        return this.eventsClient.get();
                                      }

                                      @Override
                                      public LinksClient links() {
                                        return this.linksClient.get();
                                      }
                                    }
