package io.zgate.useradmin.server.client.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class GetIdentityResp {
    private final String id;

    public GetIdentityResp(String id) {
        this.id = id;
    }
}
