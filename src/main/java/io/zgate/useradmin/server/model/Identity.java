package io.zgate.useradmin.server.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Identity {
    private final String id;
    private final Object traits;

    public Identity(String id, Object traits) {
        this.id = id;
        this.traits = traits;
    }

    public String getId() {
        return id;
    }

    public Object getTraits() {
        return traits;
    }
}
