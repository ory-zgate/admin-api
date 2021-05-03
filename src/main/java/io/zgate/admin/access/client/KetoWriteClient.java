package io.zgate.admin.access.client;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.zgate.admin.access.client.model.RelationTupleRequest;

import javax.annotation.Nullable;

/**
 * This is just a client wrapper for keto write api.
 * Please visit https://www.ory.sh/keto/docs/reference/api for more details.
 */
@Client("${keto.endpoint.write}")
public interface KetoWriteClient {
    @Put("/relation-tuples")
    void create(@Body final RelationTupleRequest request);

    @Delete("/relation-tuples")
    void delete(@QueryValue final String namespace,
                @QueryValue final String object,
                @QueryValue final String relation,
                @Nullable @QueryValue final String subject);
}
