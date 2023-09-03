package com.rivet.api.resources.identity.links;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.identity.links.requests.GetGameLinkRequest;
import com.rivet.api.resources.identity.links.types.GetGameLinkResponse;
import com.rivet.api.resources.identity.links.types.PrepareGameLinkResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LinksClient {
    protected final ClientOptions clientOptions;

    public LinksClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PrepareGameLinkResponse prepare() {
        return prepare(null);
    }

    public PrepareGameLinkResponse prepare(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("game-links")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PrepareGameLinkResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GetGameLinkResponse get(GetGameLinkRequest request) {
        return get(request, null);
    }

    public GetGameLinkResponse get(GetGameLinkRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getidentityURL())
                .newBuilder()
                .addPathSegments("game-links");
        _httpUrl.addQueryParameter("identity_link_token", request.getIdentityLinkToken());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetGameLinkResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
