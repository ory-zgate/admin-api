package io.zgate.admin.access.client.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class CheckResponse {
    private final Boolean allowed;

    public static final CheckResponse NOT_ALLOWED = new CheckResponse(false);

    public CheckResponse(Boolean allowed) {
        this.allowed = allowed;
    }

    public Boolean getAllowed() {
        return allowed;
    }
}
