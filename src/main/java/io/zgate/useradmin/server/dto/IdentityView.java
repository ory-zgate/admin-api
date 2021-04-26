package io.zgate.useradmin.server.dto;

import io.micronaut.core.annotation.Introspected;
import io.zgate.useradmin.server.model.Identity;
import io.zgate.useradmin.server.persistence.po.IdentityPO;
import io.zgate.useradmin.server.utils.JsonUtil;

@Introspected
public class IdentityView {
    private final String id;
    private final Object traits;

    public IdentityView(String id, Object traits) {
        this.id = id;
        this.traits = traits;
    }

    public String getId() {
        return id;
    }

    public Object getTraits() {
        return traits;
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
                .build();
    }

    public static final class IdentityViewBuilder {
        private String id;
        private Object traits;

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

        public IdentityView build() {
            return new IdentityView(id, traits);
        }
    }
}
