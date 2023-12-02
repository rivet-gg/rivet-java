package com.rivet.api;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.admin.AdminClient;
import com.rivet.api.resources.cloud.CloudClient;
import com.rivet.api.resources.group.GroupClient;
import com.rivet.api.resources.identity.IdentityClient;
import com.rivet.api.resources.kv.KvClient;
import com.rivet.api.resources.matchmaker.MatchmakerClient;
import com.rivet.api.resources.module.ModuleClient;
import java.util.function.Supplier;

public class RivetApiClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AdminClient> adminClient;

    protected final Supplier<CloudClient> cloudClient;

    protected final Supplier<GroupClient> groupClient;

    protected final Supplier<IdentityClient> identityClient;

    protected final Supplier<KvClient> kvClient;

    protected final Supplier<ModuleClient> moduleClient;

    protected final Supplier<MatchmakerClient> matchmakerClient;

    public RivetApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.adminClient = Suppliers.memoize(() -> new AdminClient(clientOptions));
        this.cloudClient = Suppliers.memoize(() -> new CloudClient(clientOptions));
        this.groupClient = Suppliers.memoize(() -> new GroupClient(clientOptions));
        this.identityClient = Suppliers.memoize(() -> new IdentityClient(clientOptions));
        this.kvClient = Suppliers.memoize(() -> new KvClient(clientOptions));
        this.moduleClient = Suppliers.memoize(() -> new ModuleClient(clientOptions));
        this.matchmakerClient = Suppliers.memoize(() -> new MatchmakerClient(clientOptions));
    }

    public AdminClient admin() {
        return this.adminClient.get();
    }

    public CloudClient cloud() {
        return this.cloudClient.get();
    }

    public GroupClient group() {
        return this.groupClient.get();
    }

    public IdentityClient identity() {
        return this.identityClient.get();
    }

    public KvClient kv() {
        return this.kvClient.get();
    }

    public ModuleClient module() {
        return this.moduleClient.get();
    }

    public MatchmakerClient matchmaker() {
        return this.matchmakerClient.get();
    }

    public static RivetApiClientBuilder builder() {
        return new RivetApiClientBuilder();
    }
}
