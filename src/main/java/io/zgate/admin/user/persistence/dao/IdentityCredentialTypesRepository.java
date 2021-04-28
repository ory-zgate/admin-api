package io.zgate.admin.user.persistence.dao;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.zgate.admin.user.persistence.po.IdentityCredentialTypesPO;

@Repository
public interface IdentityCredentialTypesRepository extends CrudRepository<IdentityCredentialTypesPO, String> {
    IdentityCredentialTypesPO findByName(final String name);

}
