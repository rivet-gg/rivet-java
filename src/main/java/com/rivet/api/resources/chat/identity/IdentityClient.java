package com.rivet.api.resources.chat.identity;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.chat.identity.types.GetDirectThreadResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class IdentityClient {
    protected final ClientOptions clientOptions;

    public IdentityClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public GetDirectThreadResponse getDirectThread(UUID identityId) {
        return getDirectThread(identityId, null);
    }

    public GetDirectThreadResponse getDirectThread(UUID identityId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getchatURL())
                .newBuilder()
                .addPathSegments("identities")
                .addPathSegment(identityId.toString())
                .addPathSegments("thread")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetDirectThreadResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
