package io.zgate.admin.user.command;

import io.micronaut.core.annotation.Introspected;
import io.zgate.admin.user.client.model.CreateOrUpdateIdentityReq;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Introspected
public class CreateOrUpdateIdentityCommand {
    @NotBlank
    private final String schemaId;
    @NotNull
    private final Object traits;

    public CreateOrUpdateIdentityCommand(String schemaId, Object traits) {
        this.schemaId = schemaId;
        this.traits = traits;
    }

    public CreateOrUpdateIdentityReq toCreateIdentityReq() {
        return new CreateOrUpdateIdentityReq(schemaId, traits);
    }
}
