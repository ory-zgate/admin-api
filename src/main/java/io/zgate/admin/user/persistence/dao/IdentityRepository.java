package io.zgate.admin.user.persistence.dao;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.zgate.admin.user.persistence.po.IdentityPO;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface IdentityRepository extends CrudRepository<IdentityPO, String>, JpaSpecificationExecutor<IdentityPO> {
}
