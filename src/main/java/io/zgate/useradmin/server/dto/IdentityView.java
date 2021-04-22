package io.zgate.useradmin.server.dto;

import io.micronaut.core.annotation.Introspected;
import io.zgate.useradmin.server.model.Identity;

@Introspected
public class IdentityView {
    private final String id;
    private final Object traits;

    public IdentityView(String id, Object traits) {
        this.id = id;
        this.traits = traits;
    }

    public String getId() {
        return id;
    }

    public Object getTraits() {
        return traits;
    }

    public static IdentityView fromIdentity(Identity identity) {
        return new IdentityView(identity.getId(), identity.getTraits());
    }
}
