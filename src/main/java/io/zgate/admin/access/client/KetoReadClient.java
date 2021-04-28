package io.zgate.admin.access.client;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.zgate.admin.access.client.model.CheckRequest;
import io.zgate.admin.access.client.model.CheckResponse;

/**
 * This is just a client wrapper for keto admin api.
 * Please visit https://www.ory.sh/keto/docs/reference/api for more details.
 */
@Client("${keto.endpoint.read}")
public interface KetoReadClient {
    @Post("/check")
    CheckResponse check(@Body CheckRequest request);
}
