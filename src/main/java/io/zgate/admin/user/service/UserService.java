package io.zgate.admin.user.service;

import io.zgate.admin.user.client.KratosAdminClient;
import io.zgate.admin.user.client.model.CreateOrUpdateIdentityResp;
import io.zgate.admin.user.client.model.GetIdentityResp;
import io.zgate.admin.user.command.CreateOrUpdateIdentityCommand;
import io.zgate.admin.user.command.SetPasswordCommand;
import io.zgate.admin.user.exception.ApiException;
import io.zgate.admin.user.exception.ErrorEnum;
import io.zgate.admin.user.model.Identity;
import io.zgate.admin.user.persistence.dao.IdentityCredentialTypesRepository;
import io.zgate.admin.user.persistence.dao.IdentityCredentialsRepository;
import io.zgate.admin.user.persistence.po.IdentityCredentialTypesPO;
import io.zgate.admin.user.persistence.po.IdentityCredentialsPO;

import javax.inject.Singleton;
import javax.transaction.Transactional;
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

    public Identity createIdentity(final CreateOrUpdateIdentityCommand command) {
        final CreateOrUpdateIdentityResp resp = adminClient.createIdentity(command.toCreateIdentityReq());
        return resp.toIdentity();
    }

    @Transactional(rollbackOn = {RuntimeException.class})
    public void setPassword(final String identityId, final SetPasswordCommand command) {
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

    private void checkIdentityExist(final String identityId) {
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

    public void deleteIdentity(final String id) {
        adminClient.deleteIdentity(id);
    }

    public void updateIdentity(final String id, final CreateOrUpdateIdentityCommand command) {
        adminClient.updateIdentity(id, command.toCreateIdentityReq());
    }
}
