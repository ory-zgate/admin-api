package io.zgate.useradmin.server.service;

import io.micronaut.transaction.annotation.ReadOnly;
import io.zgate.useradmin.server.command.QueryIdentityCommand;
import io.zgate.useradmin.server.dto.IdentityView;
import io.zgate.useradmin.server.persistence.dao.IdentityRepository;
import io.zgate.useradmin.server.persistence.po.IdentityPO;
import io.zgate.useradmin.server.persistence.spec.IdentitySpec;
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
