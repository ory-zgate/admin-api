package io.zgate.admin.access.client.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class RelationTuples {
    private final String namespace;
    private final String object;
    private final String relation;
    private final String subject;

    public RelationTuples(String namespace, String object, String relation, String subject) {
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
}
