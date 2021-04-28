package io.zgate.admin.access.dto;

import io.micronaut.core.annotation.Introspected;
import io.zgate.admin.access.client.model.CheckRequest;

@Introspected
public class CheckPayload {
    private final String namespace;
    private final String subject;
    private final String resource;

    public CheckPayload(String namespace, String subject, String resource) {
        this.namespace = namespace;
        this.subject = subject;
        this.resource = resource;
    }

    public CheckRequest toCheckRequest() {
        return CheckRequest.Builder
                .builder()
                .withNamespace(namespace)
                .withSubject(subject)
                .withObject(resource)
                //https://github.com/ory/oathkeeper/pull/676
                .withRelation("mock")
                .build();
    }
}
