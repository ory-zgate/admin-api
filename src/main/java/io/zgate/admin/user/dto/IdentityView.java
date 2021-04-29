package io.zgate.admin.user.dto;

import io.micronaut.core.annotation.Introspected;
import io.zgate.admin.user.model.Identity;
import io.zgate.admin.user.persistence.po.IdentityPO;
import io.zgate.admin.utils.JsonUtil;

import java.util.Date;

@Introspected
public class IdentityView {
    private final String id;
    private final Object traits;
    private final Date createdAt;
    private final String schemaId;

    public IdentityView(String id, Object traits, Date createdAt, String schemaId) {
        this.id = id;
        this.traits = traits;
        this.createdAt = createdAt;
        this.schemaId = schemaId;
    }

    public String getId() {
        return id;
    }

    public Object getTraits() {
        return traits;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public static IdentityView fromIdentity(Identity identity) {
        return IdentityViewBuilder
                .builder()
                .withId(identity.getId())
                .withTraits(identity.getTraits())
                .build();
    }

    public static IdentityView fromIdentityPO(IdentityPO identity) {
        return IdentityViewBuilder
                .builder()
                .withId(identity.getId())
                .withTraits(JsonUtil.toJsonObject(identity.getTraits()))
                .withCreatedAt(identity.getCreatedAt())
                .withSchemaId(identity.getSchemaId())
                .build();
    }

    public static final class IdentityViewBuilder {
        private String id;
        private Object traits;
        private Date createdAt;
        private String schemaId;

        private IdentityViewBuilder() {
        }

        public static IdentityViewBuilder builder() {
            return new IdentityViewBuilder();
        }

        public IdentityViewBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public IdentityViewBuilder withTraits(Object traits) {
            this.traits = traits;
            return this;
        }

        public IdentityViewBuilder withCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public IdentityViewBuilder withSchemaId(String schemaId) {
            this.schemaId = schemaId;
            return this;
        }

        public IdentityView build() {
            return new IdentityView(id, traits, createdAt, schemaId);
        }
    }
}
