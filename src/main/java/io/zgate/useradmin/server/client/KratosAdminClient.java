package io.zgate.useradmin.server.client;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import io.zgate.useradmin.server.client.model.CreateOrUpdateIdentityReq;
import io.zgate.useradmin.server.client.model.CreateOrUpdateIdentityResp;
import io.zgate.useradmin.server.client.model.GetIdentityResp;

import java.util.List;

/**
 * This is just a client wrapper for kratos admin api.
 * Please visit https://www.ory.sh/kratos/docs/reference/api for more details.
 */
@Client("${kratos.endpoint.admin}")
public interface KratosAdminClient {
    @Post("/identities")
    CreateOrUpdateIdentityResp createIdentity(@Body final CreateOrUpdateIdentityReq req);

    @Get("/identities/{id}")
    GetIdentityResp getIdentity(@PathVariable("id") final String id);

    @Get("/identities")
    List<GetIdentityResp> getIdentities();

    @Delete("/identities/{id}")
    void deleteIdentity(@PathVariable("id") final String id);

    @Put("/identities/{id}")
    CreateOrUpdateIdentityResp updateIdentity(@PathVariable("id") final String id, @Body final CreateOrUpdateIdentityReq req);
}
