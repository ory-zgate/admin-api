package io.zgate.admin.user.persistence.dao;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.zgate.admin.user.persistence.po.IdentityCredentialsPO;

import java.util.Optional;

@Repository
public interface IdentityCredentialsRepository extends CrudRepository<IdentityCredentialsPO, String> {
    Optional<IdentityCredentialsPO> findByIdentityIdAndIdentityCredentialTypeId(final String identityId, final String identityCredentialTypeId);

}
