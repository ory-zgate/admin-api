package io.zgate.admin.user.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.zgate.admin.user.command.CreateOrUpdateIdentityCommand;
import io.zgate.admin.user.command.QueryIdentityCommand;
import io.zgate.admin.user.command.SetPasswordCommand;
import io.zgate.admin.user.dto.IdentityView;
import io.zgate.admin.user.model.Identity;
import io.zgate.admin.user.service.QueryService;
import io.zgate.admin.user.service.UserService;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller("/identity")
public class UserAdminController {
    private final UserService userService;
    private final QueryService queryService;

    public UserAdminController(UserService userService, QueryService queryService) {
        this.userService = userService;
        this.queryService = queryService;
    }

    @Post
    public Identity createIdentity(@Valid @Body final CreateOrUpdateIdentityCommand command) {
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

    @Get
    public List<IdentityView> list() {
        return queryService.listAll();
    }

    @Delete("{id}")
    public void deleteIdentity(@NotBlank @PathVariable("id") final String id) {
        userService.deleteIdentity(id);
    }

    @Put("{id}")
    public void updateIdentity(@NotBlank @PathVariable("id") final String id,
                               @Valid @Body CreateOrUpdateIdentityCommand command) {
        userService.updateIdentity(id, command);
    }

}
