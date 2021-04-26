package io.zgate.useradmin.server.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.zgate.useradmin.server.command.CreateIdentityCommand;
import io.zgate.useradmin.server.command.QueryIdentityCommand;
import io.zgate.useradmin.server.command.SetPasswordCommand;
import io.zgate.useradmin.server.dto.IdentityView;
import io.zgate.useradmin.server.model.Identity;
import io.zgate.useradmin.server.service.QueryService;
import io.zgate.useradmin.server.service.UserService;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Controller("/identity")
public class UserAdminController {
    private final UserService userService;
    private final QueryService queryService;

    public UserAdminController(UserService userService, QueryService queryService) {
        this.userService = userService;
        this.queryService = queryService;
    }

    @Post
    public Identity createIdentity(@Valid @Body final CreateIdentityCommand command) {
        return userService.createIdentity(command);
    }

    @Put("{id}/password")
    public void setPassword(@NotBlank @PathVariable("id") final String id,
                            @Valid @Body final SetPasswordCommand command) {
        userService.setPassword(id, command);
    }

    @Post("/filter")
    public Page<IdentityView> filterIdentities(@Valid QueryIdentityCommand command) {
        return queryService.queryIdentities(command);
    }


}
