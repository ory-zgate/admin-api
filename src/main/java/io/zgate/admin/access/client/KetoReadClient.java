package io.zgate.admin.access.client;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.zgate.admin.access.client.model.RelationTupleRequest;
import io.zgate.admin.access.client.model.CheckResponse;
import io.zgate.admin.access.client.model.QueryResponse;

/**
 * This is just a client wrapper for keto read api.
 * Please visit https://www.ory.sh/keto/docs/reference/api for more details.
 */
@Client("${keto.endpoint.read}")
public interface KetoReadClient {
    @Post("/check")
    CheckResponse check(@Body final RelationTupleRequest request);

    @Get("/relation-tuples")
    QueryResponse query(@QueryValue final String namespace);
}
