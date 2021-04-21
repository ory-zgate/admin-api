package io.zgate.useradmin.server.service;

import io.zgate.useradmin.server.client.KratosAdminClient;
import io.zgate.useradmin.server.client.model.CreateIdentityResp;
import io.zgate.useradmin.server.client.model.GetIdentityResp;
import io.zgate.useradmin.server.command.CreateIdentityCommand;
import io.zgate.useradmin.server.command.SetPasswordCommand;
import io.zgate.useradmin.server.exception.ApiException;
import io.zgate.useradmin.server.exception.ErrorEnum;
import io.zgate.useradmin.server.model.Identity;
import io.zgate.useradmin.server.persistence.dao.IdentityCredentialTypesRepository;
import io.zgate.useradmin.server.persistence.dao.IdentityCredentialsRepository;
import io.zgate.useradmin.server.persistence.po.IdentityCredentialTypesPO;
import io.zgate.useradmin.server.persistence.po.IdentityCredentialsPO;

import javax.inject.Singleton;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class UserService {
    private final KratosAdminClient adminClient;
    private final IdentityCredentialTypesRepository identityCredentialTypesRepository;
    private final IdentityCredentialsRepository identityCredentialsRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(KratosAdminClient adminClient,
                       IdentityCredentialTypesRepository identityCredentialTypesRepository,
                       IdentityCredentialsRepository identityCredentialsRepository,
                       PasswordEncoder passwordEncoder) {
        this.adminClient = adminClient;
        this.identityCredentialTypesRepository = identityCredentialTypesRepository;
        this.identityCredentialsRepository = identityCredentialsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Identity createIdentity(CreateIdentityCommand command) {
        final CreateIdentityResp resp = adminClient.createIdentity(command.toCreateIdentityReq());
        return resp.toIdentity();
    }

    public void setPassword(String identityId, SetPasswordCommand command) {
        checkIdentityExist(identityId);

        final IdentityCredentialTypesPO credentialTypes = identityCredentialTypesRepository.findByName("password");
        final Optional<IdentityCredentialsPO> identityCredentialOpt =
                identityCredentialsRepository.findByIdentityIdAndIdentityCredentialTypeId(identityId, credentialTypes.getId());
        if(identityCredentialOpt.isPresent()) {
            final IdentityCredentialsPO identityCredentials = identityCredentialOpt.get();
            identityCredentials.setConfig(buildPasswordCredentialConfig(encodePassword(command.getPassword())));
            identityCredentialsRepository.update(identityCredentials);
        }else {
            final IdentityCredentialsPO identityCredentials = new IdentityCredentialsPO();
            identityCredentials.setId(UUID.randomUUID().toString());
            identityCredentials.setConfig(buildPasswordCredentialConfig(encodePassword(command.getPassword())));
            identityCredentials.setIdentityCredentialTypeId(credentialTypes.getId());
            identityCredentials.setIdentityId(identityId);

            identityCredentialsRepository.save(identityCredentials);
        }
    }

    private void checkIdentityExist(String identityId) {
        final GetIdentityResp identityResp = adminClient.getIdentity(identityId);
        if(identityResp == null) {
            throw new ApiException(ErrorEnum.IDENTITY_NOT_FOUND);
        }
    }

    private String buildPasswordCredentialConfig(final String hashedPassword) {
        return String.format("{\"hashed_password\": \"%s\"}", hashedPassword);
    }

    private String encodePassword(final String rawPassword) {
        return passwordEncoder.encodePassword(rawPassword);
    }
}
