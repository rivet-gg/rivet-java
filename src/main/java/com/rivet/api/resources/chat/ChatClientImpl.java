package com.rivet.api.resources.chat;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.chat.identity.IdentityClient;
import com.rivet.api.resources.chat.identity.IdentityClientImpl;
import com.rivet.api.resources.chat.requests.GetThreadHistoryRequest;
import com.rivet.api.resources.chat.requests.WatchThreadRequest;
import com.rivet.api.resources.chat.types.GetThreadHistoryResponse;
import com.rivet.api.resources.chat.types.GetThreadTopicResponse;
import com.rivet.api.resources.chat.types.SendMessageRequest;
import com.rivet.api.resources.chat.types.SendMessageResponse;
import com.rivet.api.resources.chat.types.SetThreadReadRequest;
import com.rivet.api.resources.chat.types.SetTypingStatusRequest;
import com.rivet.api.resources.chat.types.WatchThreadResponse;
import java.lang.Double;
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

public final class ChatClientImpl implements ChatClient {
  private final ClientOptions clientOptions;

  private final Supplier<IdentityClient> identityClient;

  public ChatClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.identityClient = Suppliers.memoize(() -> new IdentityClientImpl(clientOptions));
  }

  @Override
  public SendMessageResponse sendMessage(SendMessageRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getchatURL()).newBuilder()
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
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SendMessageResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public GetThreadHistoryResponse getThreadHistory(UUID threadId, GetThreadHistoryRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getchatURL()).newBuilder()
      .addPathSegment(threadId.toString())
      .addPathSegments("history")
      ;if (request.getTs().isPresent()) {
        _httpUrlBuilder.addQueryParameter("ts", request.getTs().get());
      }
      _httpUrlBuilder.addQueryParameter("count", Double.toString(request.getCount()));
      if (request.getQueryDirection().isPresent()) {
        _httpUrlBuilder.addQueryParameter("query_direction", request.getQueryDirection().get().toString());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetThreadHistoryResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public WatchThreadResponse watchThread(UUID threadId, WatchThreadRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getchatURL()).newBuilder()
        .addPathSegment(threadId.toString())
        .addPathSegments("live")
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
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), WatchThreadResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public void setThreadRead(UUID threadId, SetThreadReadRequest request) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getchatURL()).newBuilder()
          .addPathSegment(threadId.toString())
          .addPathSegments("read")
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
      public GetThreadTopicResponse getThreadTopic(UUID threadId) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getchatURL()).newBuilder()
          .addPathSegment(threadId.toString())
          .addPathSegments("topic")
          .build();Request _request = new Request.Builder()
          .url(_httpUrl)
          .method("GET", RequestBody.create("", null))
          .headers(Headers.of(clientOptions.headers()))
          .build();
        try {
          Response _response = clientOptions.httpClient().newCall(_request).execute();
          if (_response.isSuccessful()) {
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetThreadTopicResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public void setTypingStatus(UUID threadId, SetTypingStatusRequest request) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getchatURL()).newBuilder()
          .addPathSegment(threadId.toString())
          .addPathSegments("typing-status")
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
      public IdentityClient identity() {
        return this.identityClient.get();
      }
    }
