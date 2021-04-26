package io.zgate.useradmin.server.client.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.micronaut.core.annotation.Introspected;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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
