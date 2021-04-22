package io.zgate.useradmin.server.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.zgate.useradmin.server.command.CreateIdentityCommand;
import io.zgate.useradmin.server.command.SetPasswordCommand;
import io.zgate.useradmin.server.dto.IdentityView;
import io.zgate.useradmin.server.model.Identity;
import io.zgate.useradmin.server.service.UserService;
import io.zgate.useradmin.server.utils.ListUtil;

import java.util.List;

@Controller("/identity")
public class UserAdminController {
    private final UserService userService;

    public UserAdminController(UserService userService) {
        this.userService = userService;
    }

    @Post
    public Identity createIdentity(@Body final CreateIdentityCommand command) {
        return userService.createIdentity(command);
    }

    @Put("{id}/password")
    public void setPassword(@PathVariable("id") final String id,
                            @Body final SetPasswordCommand command) {
        userService.setPassword(id, command);
    }

    @Get
    public List<IdentityView> listIdentities() {
        List<Identity> identities = userService.listIdentities();
        return ListUtil.convert(identities, IdentityView::fromIdentity);
    }



}
