package com.rivet.api.resources.cloud.games.cdn;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.resources.cloud.games.cdn.types.CreateGameCdnSiteRequest;
import com.rivet.api.resources.cloud.games.cdn.types.CreateGameCdnSiteResponse;
import com.rivet.api.resources.cloud.games.cdn.types.ListGameCdnSitesResponse;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CdnClient {
    protected final ClientOptions clientOptions;

    public CdnClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ListGameCdnSitesResponse listGameCdnSites(UUID gameId) {
        return listGameCdnSites(gameId, null);
    }

    public ListGameCdnSitesResponse listGameCdnSites(UUID gameId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("cdn/sites")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ListGameCdnSitesResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CreateGameCdnSiteResponse createGameCdnSite(UUID gameId, CreateGameCdnSiteRequest request) {
        return createGameCdnSite(gameId, request, null);
    }

    public CreateGameCdnSiteResponse createGameCdnSite(
            UUID gameId, CreateGameCdnSiteRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud/games")
                .addPathSegment(gameId.toString())
                .addPathSegments("cdn/sites")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreateGameCdnSiteResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
