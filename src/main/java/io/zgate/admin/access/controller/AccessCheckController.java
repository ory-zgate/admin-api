package io.zgate.admin.access.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.zgate.admin.access.dto.CheckPayload;
import io.zgate.admin.access.service.AccessCheckService;

import javax.validation.constraints.NotNull;

@Controller("/access")
public class AccessCheckController {
    private final AccessCheckService accessCheckService;

    public AccessCheckController(AccessCheckService accessCheckService) {
        this.accessCheckService = accessCheckService;
    }

    @Post("/check")
    public HttpResponse<Void> check(@Body @NotNull CheckPayload payload) {
        boolean allowed = accessCheckService.check(payload.toCheckRequest());
        return allowed ? HttpResponse.accepted() : HttpResponse.unauthorized();
    }
}
