package com.rivet.api.resources.group.invites;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.group.invites.types.ConsumeInviteResponse;
import com.rivet.api.resources.group.invites.types.CreateInviteRequest;
import com.rivet.api.resources.group.invites.types.CreateInviteResponse;
import com.rivet.api.resources.group.invites.types.GetInviteResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class InvitesClientImpl implements InvitesClient {
  private final ClientOptions clientOptions;

  public InvitesClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public GetInviteResponse getInvite(String groupInviteCode) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
      .addPathSegment(groupInviteCode)
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("GET", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
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
  public ConsumeInviteResponse consumeInvite(String groupInviteCode) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
      .addPathSegment(groupInviteCode)
      .addPathSegments("consume")
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("POST", RequestBody.create("", null))
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ConsumeInviteResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public CreateInviteResponse createInvite(UUID groupId, CreateInviteRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getgroupURL()).newBuilder()
      .addPathSegment(groupId.toString())
      .addPathSegments("invites")
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
}
