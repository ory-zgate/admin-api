package io.zgate.admin.access.client;

import io.micronaut.retry.annotation.Fallback;
import io.zgate.admin.access.client.model.CheckRequest;
import io.zgate.admin.access.client.model.CheckResponse;
import io.zgate.admin.access.client.model.QueryResponse;

@Fallback
public class KetoFallback implements KetoReadClient {
    @Override
    public CheckResponse check(CheckRequest request) {
        return CheckResponse.NOT_ALLOWED;
    }

    @Override
    public QueryResponse query(String namespace) {
        return null;
    }
}
