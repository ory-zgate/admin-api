package io.zgate.useradmin.server.client.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class CreateIdentityReq {
    private final String schemaId;
    private final Object traits;

    public CreateIdentityReq(String schemaId, Object traits) {
        this.schemaId = schemaId;
        this.traits = traits;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public Object getTraits() {
        return traits;
    }
}
