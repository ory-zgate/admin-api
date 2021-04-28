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

    public IdentityView(String id, Object traits, Date createdAt) {
        this.id = id;
        this.traits = traits;
        this.createdAt = createdAt;
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
                .build();
    }

    public static final class IdentityViewBuilder {
        private String id;
        private Object traits;
        private Date createdAt;

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

        public IdentityView build() {
            return new IdentityView(id, traits, createdAt);
        }
    }
}
