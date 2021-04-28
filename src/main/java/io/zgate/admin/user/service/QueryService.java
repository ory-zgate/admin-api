package io.zgate.admin.user.service;

import io.micronaut.transaction.annotation.ReadOnly;
import io.zgate.admin.user.command.QueryIdentityCommand;
import io.zgate.admin.user.dto.IdentityView;
import io.zgate.admin.user.persistence.dao.IdentityRepository;
import io.zgate.admin.user.persistence.po.IdentityPO;
import io.zgate.admin.user.persistence.spec.IdentitySpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Singleton
public class QueryService {
    private final IdentityRepository identityRepository;

    public QueryService(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    @ReadOnly
    public Page<IdentityView> queryIdentities(QueryIdentityCommand command) {
        IdentitySpec identitySpec = new IdentitySpec(command.getQuery());
        final Page<IdentityPO> page = identityRepository.findAll(identitySpec, PageRequest.of(command.getPage() - 1, command.getLimit()));
        return page.map(IdentityView::fromIdentityPO);
    }

    @ReadOnly
    public List<IdentityView> listAll() {
        return StreamSupport.stream(identityRepository.findAll().spliterator(), false)
                            .map(IdentityView::fromIdentityPO)
                            .collect(Collectors.toList());
    }
}
