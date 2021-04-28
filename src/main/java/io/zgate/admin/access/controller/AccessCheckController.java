package io.zgate.admin.access.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.zgate.admin.access.dto.CheckPayload;
import io.zgate.admin.access.service.AccessCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;

@Controller("/access")
public class AccessCheckController {
    private static final Logger logger = LoggerFactory.getLogger(AccessCheckController.class);
    private final AccessCheckService accessCheckService;

    public AccessCheckController(AccessCheckService accessCheckService) {
        this.accessCheckService = accessCheckService;
    }

    @Post("/check")
    public HttpResponse<Void> check(@Body @NotNull CheckPayload payload) {
        logger.info("receiving payload: {}", payload);
        boolean allowed = accessCheckService.check(payload.toCheckRequest());
        return allowed ? HttpResponse.accepted() : HttpResponse.status(HttpStatus.FORBIDDEN);
    }
}
