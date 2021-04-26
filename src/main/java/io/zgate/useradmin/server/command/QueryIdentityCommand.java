package io.zgate.useradmin.server.command;

import io.micronaut.core.annotation.Introspected;
import io.zgate.useradmin.server.model.Query;

import javax.validation.constraints.NotNull;

@Introspected
public class QueryIdentityCommand {
    @NotNull
    private final Integer page;
    @NotNull
    private final Integer limit;
    private final Query query;

    public QueryIdentityCommand(Integer page, Integer limit, Query query) {
        this.page = page;
        this.limit = limit;
        this.query = query;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getLimit() {
        return limit;
    }

    public Query getQuery() {
        return query;
    }
}