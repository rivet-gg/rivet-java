package com.rivet.api.resources.kv;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.kv.requests.DeleteBatchRequest;
import com.rivet.api.resources.kv.requests.DeleteOperationRequest;
import com.rivet.api.resources.kv.requests.GetBatchRequest;
import com.rivet.api.resources.kv.requests.GetOperationRequest;
import com.rivet.api.resources.kv.types.GetBatchResponse;
import com.rivet.api.resources.kv.types.GetResponse;
import com.rivet.api.resources.kv.types.PutBatchRequest;
import com.rivet.api.resources.kv.types.PutRequest;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class KvClientImpl implements KvClient {
  private final ClientOptions clientOptions;

  public KvClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public GetResponse get(GetOperationRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getkvURL()).newBuilder()
      .addPathSegments("entries")
      ;_httpUrlBuilder.addQueryParameter("key", request.getKey());
      if (request.getWatchIndex().isPresent()) {
        _httpUrlBuilder.addQueryParameter("watch_index", request.getWatchIndex().get());
      }
      if (request.getNamespaceId().isPresent()) {
        _httpUrlBuilder.addQueryParameter("namespace_id", request.getNamespaceId().get().toString());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void put(PutRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getkvURL()).newBuilder()
        .addPathSegments("entries")
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
    public void delete(DeleteOperationRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getkvURL()).newBuilder()
        .addPathSegments("entries")
        ;_httpUrlBuilder.addQueryParameter("key", request.getKey());
        if (request.getNamespaceId().isPresent()) {
          _httpUrlBuilder.addQueryParameter("namespace_id", request.getNamespaceId().get().toString());
        }
        HttpUrl _httpUrl = _httpUrlBuilder.build();
        RequestBody _requestBody = RequestBody.create("", null);
        Request.Builder _requestBuilder = new Request.Builder()
          .url(_httpUrl)
          .method("DELETE", _requestBody)
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
      public GetBatchResponse getBatch(GetBatchRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getkvURL()).newBuilder()
          .addPathSegments("entries")
          ;_httpUrlBuilder.addQueryParameter("keys", request.getKeys());
          if (request.getWatchIndex().isPresent()) {
            _httpUrlBuilder.addQueryParameter("watch_index", request.getWatchIndex().get());
          }
          if (request.getNamespaceId().isPresent()) {
            _httpUrlBuilder.addQueryParameter("namespace_id", request.getNamespaceId().get().toString());
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
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetBatchResponse.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }

        @Override
        public void putBatch(PutBatchRequest request) {
          HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getkvURL()).newBuilder()
            .addPathSegments("entries")
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
        public void deleteBatch(DeleteBatchRequest request) {
          HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getkvURL()).newBuilder()
            .addPathSegments("entries")
            ;_httpUrlBuilder.addQueryParameter("keys", request.getKeys());
            if (request.getNamespaceId().isPresent()) {
              _httpUrlBuilder.addQueryParameter("namespace_id", request.getNamespaceId().get().toString());
            }
            HttpUrl _httpUrl = _httpUrlBuilder.build();
            RequestBody _requestBody = RequestBody.create("", null);
            Request.Builder _requestBuilder = new Request.Builder()
              .url(_httpUrl)
              .method("DELETE", _requestBody)
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
        }
