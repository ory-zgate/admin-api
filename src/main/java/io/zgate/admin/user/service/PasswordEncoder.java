package io.zgate.admin.user.service;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import javax.inject.Singleton;

@Singleton
public class PasswordEncoder {
    private final Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();

    public String encodePassword(final String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
