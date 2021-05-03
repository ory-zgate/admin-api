package io.zgate.admin.access.service;

import io.zgate.admin.access.client.KetoReadClient;
import io.zgate.admin.access.client.KetoWriteClient;
import io.zgate.admin.access.client.model.RelationTupleRequest;
import io.zgate.admin.access.client.model.CheckResponse;
import io.zgate.admin.access.client.model.QueryResponse;
import io.zgate.admin.access.dto.RelationTuplePayload;

import javax.inject.Singleton;

@Singleton
public class AccessService {
    private final KetoReadClient readClient;
    private final KetoWriteClient writeClient;

    public AccessService(KetoReadClient readClient, KetoWriteClient writeClient) {
        this.readClient = readClient;
        this.writeClient = writeClient;
    }

    public boolean check(RelationTupleRequest relationTupleRequest) {
        final CheckResponse response = readClient.check(relationTupleRequest);
        return response.getAllowed();
    }

    public QueryResponse query(String namespace) {
        return readClient.query(namespace);
    }

    public void create(RelationTuplePayload payload) {
        writeClient.create(payload.toRequest());
    }

    public void delete(String namespace, String object, String relation, String subject) {
        writeClient.delete(namespace, object, relation, subject);
    }
}
