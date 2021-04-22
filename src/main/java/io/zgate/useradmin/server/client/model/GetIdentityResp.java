package io.zgate.useradmin.server.client.model;

import io.micronaut.core.annotation.Introspected;
import io.zgate.useradmin.server.model.Identity;

@Introspected
public class GetIdentityResp {
    private final String id;
    private final Object traits;

    public GetIdentityResp(String id, Object traits) {
        this.id = id;
        this.traits = traits;
    }

    public String getId() {
        return id;
    }

    public Object getTraits() {
        return traits;
    }

    public Identity toIdentity() {
        return new Identity(getId(), getTraits());
    }
}
