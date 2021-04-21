package io.zgate.useradmin.server.command;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class SetPasswordCommand {
    private final String password;

    public SetPasswordCommand(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
