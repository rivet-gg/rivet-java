package com.rivet.api.resources.party.activity.matchmaker;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.party.activity.matchmaker.types.FindMatchmakerLobbyForPartyRequest;
import com.rivet.api.resources.party.activity.matchmaker.types.JoinMatchmakerLobbyForPartyRequest;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class MatchmakerClientImpl implements MatchmakerClient {
  private final ClientOptions clientOptions;

  public MatchmakerClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public void findLobbyForParty(FindMatchmakerLobbyForPartyRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
      .addPathSegments("parties/self")
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
  public void joinLobbyForParty(JoinMatchmakerLobbyForPartyRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
      .addPathSegments("parties/self")
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
  public void requestPlayer() {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
      .addPathSegments("parties/self")
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
}
