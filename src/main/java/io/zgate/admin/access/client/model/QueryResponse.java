package io.zgate.admin.access.client.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.micronaut.core.annotation.Introspected;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Introspected
public class QueryResponse {
    private final String nextPageToken;
    private final List<RelationTuples> relationTuples;

    public QueryResponse(String nextPageToken, List<RelationTuples> relationTuples) {
        this.nextPageToken = nextPageToken;
        this.relationTuples = relationTuples;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public List<RelationTuples> getRelationTuples() {
        return relationTuples;
    }
}
