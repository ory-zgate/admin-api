package io.zgate.useradmin.server.command;

import io.micronaut.core.annotation.Introspected;
import io.zgate.useradmin.server.client.model.CreateIdentityReq;

@Introspected
public class CreateIdentityCommand {
    private final String schemaId;
    private final Object traits;

    public CreateIdentityCommand(String schemaId, Object traits) {
        this.schemaId = schemaId;
        this.traits = traits;
    }

    public CreateIdentityReq toCreateIdentityReq() {
        return new CreateIdentityReq(schemaId, traits);
    }
}
