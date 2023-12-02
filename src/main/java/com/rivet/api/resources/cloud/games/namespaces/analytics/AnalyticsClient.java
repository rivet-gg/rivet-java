package com.rivet.api.resources.cloud.games.namespaces.analytics;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.cloud.games.namespaces.analytics.types.GetAnalyticsMatchmakerLiveResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class AnalyticsClient {
    protected final ClientOptions clientOptions;

    public AnalyticsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public GetAnalyticsMatchmakerLiveResponse getAnalyticsMatchmakerLive(UUID gameId, UUID namespaceId) {
        return getAnalyticsMatchmakerLive(gameId, namespaceId, null);
    }

    public GetAnalyticsMatchmakerLiveResponse getAnalyticsMatchmakerLive(
            UUID gameId, UUID namespaceId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("namespaces")
                .addPathSegment(namespaceId.toString())
                .addPathSegments("analytics")
                .addPathSegments("matchmaker/live")
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), GetAnalyticsMatchmakerLiveResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
