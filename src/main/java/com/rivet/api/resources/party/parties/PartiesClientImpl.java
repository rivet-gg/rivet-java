package com.rivet.api.resources.party.parties;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.party.parties.requests.GetInviteRequest;
import com.rivet.api.resources.party.parties.requests.GetProfileRequest;
import com.rivet.api.resources.party.parties.requests.GetSelfProfileRequest;
import com.rivet.api.resources.party.parties.requests.GetSelfSummaryRequest;
import com.rivet.api.resources.party.parties.requests.GetSummaryRequest;
import com.rivet.api.resources.party.parties.types.CreateInviteRequest;
import com.rivet.api.resources.party.parties.types.CreateInviteResponse;
import com.rivet.api.resources.party.parties.types.CreateRequest;
import com.rivet.api.resources.party.parties.types.CreateResponse;
import com.rivet.api.resources.party.parties.types.GetInviteResponse;
import com.rivet.api.resources.party.parties.types.GetProfileResponse;
import com.rivet.api.resources.party.parties.types.GetSelfProfileResponse;
import com.rivet.api.resources.party.parties.types.GetSelfSummaryResponse;
import com.rivet.api.resources.party.parties.types.GetSummaryResponse;
import com.rivet.api.resources.party.parties.types.JoinRequest;
import com.rivet.api.resources.party.parties.types.JoinResponse;
import com.rivet.api.resources.party.parties.types.SetPublicityRequest;
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

public final class PartiesClientImpl implements PartiesClient {
  private final ClientOptions clientOptions;

  public PartiesClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public GetInviteResponse getFromInvite(GetInviteRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
      ;if (request.getToken().isPresent()) {
        _httpUrlBuilder.addQueryParameter("token", request.getToken().get());
      }
      if (request.getAlias().isPresent()) {
        _httpUrlBuilder.addQueryParameter("alias", request.getAlias().get());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetInviteResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public CreateResponse create(CreateRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
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
    public JoinResponse join(JoinRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), JoinResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public CreateInviteResponse createInvite(CreateInviteRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateInviteResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void revokeInvite(UUID inviteId) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
        .addPathSegment(inviteId.toString())
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
    public void leave() {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
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
    public void kickMember(UUID identityId) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
        .addPathSegment(identityId.toString())
        .addPathSegments("kick")
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
    public void transferOwnership(UUID identityId) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
        .addPathSegment(identityId.toString())
        .addPathSegments("transfer-ownership")
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
    public GetSelfProfileResponse getSelfProfile(GetSelfProfileRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
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
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetSelfProfileResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public void setPublicity(SetPublicityRequest request) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
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
      public GetSelfSummaryResponse getSelfSummary(GetSelfSummaryRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
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
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetSelfSummaryResponse.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }

        @Override
        public void sendJoinRequest(UUID partyId) {
          HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
            .addPathSegment(partyId.toString())
            .addPathSegments("join-request/send")
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
        public GetProfileResponse getProfile(UUID partyId, GetProfileRequest request) {
          HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
            .addPathSegment(partyId.toString())
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
          public GetSummaryResponse getSummary(UUID partyId, GetSummaryRequest request) {
            HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
              .addPathSegment(partyId.toString())
              .addPathSegments("summary")
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
                  return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetSummaryResponse.class);
                }
                throw new RuntimeException();
              }
              catch (Exception e) {
                throw new RuntimeException(e);
              }
            }
          }
