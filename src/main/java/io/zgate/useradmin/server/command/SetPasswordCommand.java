package io.zgate.useradmin.server.command;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;

@Introspected
public class SetPasswordCommand {
    @NotBlank
    private final String password;

    public SetPasswordCommand(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
