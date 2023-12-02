package com.rivet.api.resources.cloud;

import com.rivet.api.core.ApiError;
import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.core.RequestOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.cloud.auth.AuthClient;
import com.rivet.api.resources.cloud.devices.DevicesClient;
import com.rivet.api.resources.cloud.games.GamesClient;
import com.rivet.api.resources.cloud.groups.GroupsClient;
import com.rivet.api.resources.cloud.logs.LogsClient;
import com.rivet.api.resources.cloud.tiers.TiersClient;
import com.rivet.api.resources.cloud.types.BootstrapResponse;
import com.rivet.api.resources.cloud.uploads.UploadsClient;
import java.io.IOException;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class CloudClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<GamesClient> gamesClient;

    protected final Supplier<AuthClient> authClient;

    protected final Supplier<DevicesClient> devicesClient;

    protected final Supplier<GroupsClient> groupsClient;

    protected final Supplier<LogsClient> logsClient;

    protected final Supplier<TiersClient> tiersClient;

    protected final Supplier<UploadsClient> uploadsClient;

    public CloudClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.gamesClient = Suppliers.memoize(() -> new GamesClient(clientOptions));
        this.authClient = Suppliers.memoize(() -> new AuthClient(clientOptions));
        this.devicesClient = Suppliers.memoize(() -> new DevicesClient(clientOptions));
        this.groupsClient = Suppliers.memoize(() -> new GroupsClient(clientOptions));
        this.logsClient = Suppliers.memoize(() -> new LogsClient(clientOptions));
        this.tiersClient = Suppliers.memoize(() -> new TiersClient(clientOptions));
        this.uploadsClient = Suppliers.memoize(() -> new UploadsClient(clientOptions));
    }

    public BootstrapResponse bootstrap() {
        return bootstrap(null);
    }

    public BootstrapResponse bootstrap(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("cloud")
                .addPathSegments("bootstrap")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), BootstrapResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GamesClient games() {
        return this.gamesClient.get();
    }

    public AuthClient auth() {
        return this.authClient.get();
    }

    public DevicesClient devices() {
        return this.devicesClient.get();
    }

    public GroupsClient groups() {
        return this.groupsClient.get();
    }

    public LogsClient logs() {
        return this.logsClient.get();
    }

    public TiersClient tiers() {
        return this.tiersClient.get();
    }

    public UploadsClient uploads() {
        return this.uploadsClient.get();
    }
}
