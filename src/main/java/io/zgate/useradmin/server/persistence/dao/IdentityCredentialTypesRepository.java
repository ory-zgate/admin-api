package io.zgate.useradmin.server.persistence.dao;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.zgate.useradmin.server.persistence.po.IdentityCredentialTypesPO;

@Repository
public interface IdentityCredentialTypesRepository extends CrudRepository<IdentityCredentialTypesPO, String> {
    IdentityCredentialTypesPO findByName(final String name);

}
