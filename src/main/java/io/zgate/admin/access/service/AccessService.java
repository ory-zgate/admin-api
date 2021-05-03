package io.zgate.admin.access.service;

import io.zgate.admin.access.client.KetoReadClient;
import io.zgate.admin.access.client.model.CheckRequest;
import io.zgate.admin.access.client.model.CheckResponse;
import io.zgate.admin.access.client.model.QueryResponse;

import javax.inject.Singleton;

@Singleton
public class AccessService {
    private final KetoReadClient readClient;

    public AccessService(KetoReadClient readClient) {
        this.readClient = readClient;
    }

    public boolean check(CheckRequest checkRequest) {
        final CheckResponse response = readClient.check(checkRequest);
        return response.getAllowed();
    }

    public QueryResponse query(String namespace) {
        return readClient.query(namespace);
    }
}
