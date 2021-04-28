package io.zgate.admin.access.client.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class CheckRequest {
    private final String namespace;
    private final String object;
    private final String relation;
    private final String subject;

    public CheckRequest(String namespace, String object, String relation, String subject) {
        this.namespace = namespace;
        this.object = object;
        this.relation = relation;
        this.subject = subject;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getObject() {
        return object;
    }

    public String getRelation() {
        return relation;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "CheckRequest{" +
                "namespace='" + namespace + '\'' +
                ", object='" + object + '\'' +
                ", relation='" + relation + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    @Introspected
    public static final class Builder {
        private String namespace;
        private String object;
        private String relation;
        private String subject;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withNamespace(String namespace) {
            this.namespace = namespace;
            return this;
        }

        public Builder withObject(String object) {
            this.object = object;
            return this;
        }

        public Builder withRelation(String relation) {
            this.relation = relation;
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public CheckRequest build() {
            return new CheckRequest(namespace, object, relation, subject);
        }
    }
}
