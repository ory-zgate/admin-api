package io.zgate.useradmin.server.persistence.dao;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.zgate.useradmin.server.persistence.po.IdentityCredentialsPO;

import java.util.Optional;

@Repository
public interface IdentityCredentialsRepository extends CrudRepository<IdentityCredentialsPO, String> {
    Optional<IdentityCredentialsPO> findByIdentityIdAndIdentityCredentialTypeId(final String identityId, final String identityCredentialTypeId);

}
