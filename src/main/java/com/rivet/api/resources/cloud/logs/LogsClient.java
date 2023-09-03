package com.rivet.api.resources.cloud.logs;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.cloud.logs.types.GetRayPerfLogsResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class LogsClient {
    protected final ClientOptions clientOptions;

    public LogsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public GetRayPerfLogsResponse getRayPerfLogs(UUID rayId) {
        return getRayPerfLogs(rayId, null);
    }

    public GetRayPerfLogsResponse getRayPerfLogs(UUID rayId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL())
                .newBuilder()
                .addPathSegments("rays")
                .addPathSegment(rayId.toString())
                .addPathSegments("perf")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetRayPerfLogsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
