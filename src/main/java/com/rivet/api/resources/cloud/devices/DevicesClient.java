package com.rivet.api.resources.cloud.devices;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.cloud.devices.links.LinksClient;
import java.util.function.Supplier;

public class DevicesClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<LinksClient> linksClient;

    public DevicesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.linksClient = Suppliers.memoize(() -> new LinksClient(clientOptions));
    }

    public LinksClient links() {
        return this.linksClient.get();
    }
}
