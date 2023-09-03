package com.rivet.api.resources.chat;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.chat.identity.IdentityClient;
import com.rivet.api.resources.chat.requests.GetThreadHistoryRequest;
import com.rivet.api.resources.chat.requests.WatchThreadRequest;
import com.rivet.api.resources.chat.types.GetThreadHistoryResponse;
import com.rivet.api.resources.chat.types.GetThreadTopicResponse;
import com.rivet.api.resources.chat.types.SendMessageRequest;
import com.rivet.api.resources.chat.types.SendMessageResponse;
import com.rivet.api.resources.chat.types.SetThreadReadRequest;
import com.rivet.api.resources.chat.types.SetTypingStatusRequest;
import com.rivet.api.resources.chat.types.WatchThreadResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<IdentityClient> identityClient;

    public ChatClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.identityClient = Suppliers.memoize(() -> new IdentityClient(clientOptions));
    }

    public SendMessageResponse sendMessage(SendMessageRequest request) {
        return sendMessage(request, null);
    }

    public SendMessageResponse sendMessage(SendMessageRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getchatURL())
                .newBuilder()
                .addPathSegments("messages")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SendMessageResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetThreadHistoryResponse getThreadHistory(UUID threadId, GetThreadHistoryRequest request) {
        return getThreadHistory(threadId, request, null);
    }

    public GetThreadHistoryResponse getThreadHistory(
            UUID threadId, GetThreadHistoryRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getchatURL())
                .newBuilder()
                .addPathSegments("threads")
                .addPathSegment(threadId.toString())
                .addPathSegments("history");
        if (request.getTs().isPresent()) {
            _httpUrl.addQueryParameter("ts", request.getTs().get().toString());
        }
        _httpUrl.addQueryParameter("count", Double.toString(request.getCount()));
        if (request.getQueryDirection().isPresent()) {
            _httpUrl.addQueryParameter(
                    "query_direction", request.getQueryDirection().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetThreadHistoryResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WatchThreadResponse watchThread(UUID threadId, WatchThreadRequest request) {
        return watchThread(threadId, request, null);
    }

    public WatchThreadResponse watchThread(UUID threadId, WatchThreadRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getchatURL())
                .newBuilder()
                .addPathSegments("threads")
                .addPathSegment(threadId.toString())
                .addPathSegments("live");
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), WatchThreadResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setThreadRead(UUID threadId, SetThreadReadRequest request) {
        setThreadRead(threadId, request, null);
    }

    public void setThreadRead(UUID threadId, SetThreadReadRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getchatURL())
                .newBuilder()
                .addPathSegments("threads")
                .addPathSegment(threadId.toString())
                .addPathSegments("read")
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

    public GetThreadTopicResponse getThreadTopic(UUID threadId) {
        return getThreadTopic(threadId, null);
    }

    public GetThreadTopicResponse getThreadTopic(UUID threadId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getchatURL())
                .newBuilder()
                .addPathSegments("threads")
                .addPathSegment(threadId.toString())
                .addPathSegments("topic")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetThreadTopicResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTypingStatus(UUID threadId, SetTypingStatusRequest request) {
        setTypingStatus(threadId, request, null);
    }

    public void setTypingStatus(UUID threadId, SetTypingStatusRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getchatURL())
                .newBuilder()
                .addPathSegments("threads")
                .addPathSegment(threadId.toString())
                .addPathSegments("typing-status")
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

    public IdentityClient identity() {
        return this.identityClient.get();
    }
}
