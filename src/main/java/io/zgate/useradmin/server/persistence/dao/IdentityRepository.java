package io.zgate.useradmin.server.persistence.dao;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.zgate.useradmin.server.persistence.po.IdentityPO;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface IdentityRepository extends CrudRepository<IdentityPO, String>, JpaSpecificationExecutor<IdentityPO> {
}
