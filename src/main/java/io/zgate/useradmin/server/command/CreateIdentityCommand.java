package io.zgate.useradmin.server.command;

import io.micronaut.core.annotation.Introspected;
import io.zgate.useradmin.server.client.model.CreateIdentityReq;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Introspected
public class CreateIdentityCommand {
    @NotBlank
    private final String schemaId;
    @NotNull
    private final Object traits;

    public CreateIdentityCommand(String schemaId, Object traits) {
        this.schemaId = schemaId;
        this.traits = traits;
    }

    public CreateIdentityReq toCreateIdentityReq() {
        return new CreateIdentityReq(schemaId, traits);
    }
}
