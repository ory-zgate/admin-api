package io.zgate.useradmin.server.client.model;

import io.micronaut.core.annotation.Introspected;
import io.zgate.useradmin.server.model.Identity;

@Introspected
public class CreateIdentityResp {
    private final String id;

    public CreateIdentityResp(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Identity toIdentity() {
        return new Identity(getId());
    }
}
