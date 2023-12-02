package com.rivet.api.resources.module;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.module.requests.FindLobbyRequest;
import com.rivet.api.resources.module.types.CallResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ModuleClient {
    protected final ClientOptions clientOptions;

    public ModuleClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public CallResponse call(String module, String script, FindLobbyRequest request) {
        return call(module, script, request, null);
    }

    public CallResponse call(String module, String script, FindLobbyRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("module/modules")
                .addPathSegment(module)
                .addPathSegments("scripts")
                .addPathSegment(script)
                .addPathSegments("call")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getNamespaceId().isPresent()) {
            _requestBodyProperties.put("namespace_id", request.getNamespaceId());
        }
        _requestBodyProperties.put("data", request.getData());
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getOrigin().isPresent()) {
            _requestBuilder.addHeader("origin", request.getOrigin().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CallResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
