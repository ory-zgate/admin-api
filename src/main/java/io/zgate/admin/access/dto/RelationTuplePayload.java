package io.zgate.admin.access.dto;

import io.micronaut.core.annotation.Introspected;
import io.zgate.admin.access.client.model.RelationTupleRequest;

@Introspected
public class RelationTuplePayload {
    private final String namespace;
    private final String subject;
    private final String object;
    private final String relation;

    public RelationTuplePayload(String namespace, String subject, String object, String relation) {
        this.namespace = namespace;
        this.subject = subject;
        this.object = object;
        this.relation = relation;
    }

    public RelationTupleRequest toRequest() {
        return RelationTupleRequest.Builder
                .builder()
                .withNamespace(namespace)
                .withSubject(subject)
                .withObject(object)
                //https://github.com/ory/oathkeeper/pull/676
                .withRelation("mock")
                .build();
    }

    @Override
    public String toString() {
        return "RelationTuplePayload{" +
                "namespace='" + namespace + '\'' +
                ", subject='" + subject + '\'' +
                ", object='" + object + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }
}
