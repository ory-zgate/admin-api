package io.zgate.admin.access.client;

import io.micronaut.retry.annotation.Fallback;
import io.zgate.admin.access.client.model.CheckRequest;
import io.zgate.admin.access.client.model.CheckResponse;

@Fallback
public class KetoFallback implements KetoReadClient {
    @Override
    public CheckResponse check(CheckRequest request) {
        return CheckResponse.NOT_ALLOWED;
    }
}
