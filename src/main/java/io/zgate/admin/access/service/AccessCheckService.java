package io.zgate.admin.access.service;

import io.zgate.admin.access.client.KetoReadClient;
import io.zgate.admin.access.client.model.CheckRequest;
import io.zgate.admin.access.client.model.CheckResponse;

import javax.inject.Singleton;

@Singleton
public class AccessCheckService {
    private final KetoReadClient adminClient;

    public AccessCheckService(KetoReadClient adminClient) {
        this.adminClient = adminClient;
    }

    public boolean check(CheckRequest checkRequest) {
        final CheckResponse response = adminClient.check(checkRequest);
        return response.getAllowed();
    }
}