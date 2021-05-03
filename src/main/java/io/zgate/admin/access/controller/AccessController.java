package io.zgate.admin.access.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.zgate.admin.access.client.model.QueryResponse;
import io.zgate.admin.access.dto.CheckPayload;
import io.zgate.admin.access.service.AccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;

@Controller("/access")
public class AccessController {
    private static final Logger logger = LoggerFactory.getLogger(AccessController.class);
    private final AccessService accessService;

    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @Post("/check")
    public HttpResponse<Void> check(@Body @NotNull CheckPayload payload) {
        logger.info("receiving payload: {}", payload);
        boolean allowed = accessService.check(payload.toCheckRequest());
        return allowed ? HttpResponse.ok() : HttpResponse.status(HttpStatus.FORBIDDEN);
    }

    @Get("/query")
    public QueryResponse query(@QueryValue final String namespace) {
        return accessService.query(namespace);
    }
}
