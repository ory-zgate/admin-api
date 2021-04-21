package io.zgate.useradmin.server.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Identity {
    private final String id;

    public Identity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
