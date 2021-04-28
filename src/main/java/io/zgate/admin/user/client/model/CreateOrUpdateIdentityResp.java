package io.zgate.admin.user.client.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.micronaut.core.annotation.Introspected;
import io.zgate.admin.user.model.Identity;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Introspected
public class CreateOrUpdateIdentityResp {
    private final String id;
    private final Object traits;

    public CreateOrUpdateIdentityResp(String id, Object traits) {
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
