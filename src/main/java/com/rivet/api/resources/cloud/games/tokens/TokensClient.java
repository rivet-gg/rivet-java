package com.rivet.api.resources.cloud.games.tokens;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.cloud.games.tokens.types.CreateCloudTokenResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TokensClient {
    protected final ClientOptions clientOptions;

    public TokensClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public CreateCloudTokenResponse createCloudToken(UUID gameId) {
        return createCloudToken(gameId, null);
    }

    public CreateCloudTokenResponse createCloudToken(UUID gameId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL())
                .newBuilder()
                .addPathSegments("games")
                .addPathSegment(gameId.toString())
                .addPathSegments("tokens/cloud")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateCloudTokenResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
