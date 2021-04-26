package io.zgate.useradmin.server.persistence.spec;

import io.zgate.useradmin.server.model.Query;
import io.zgate.useradmin.server.persistence.po.IdentityPO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class IdentitySpec implements Specification<IdentityPO> {
    private final Query query;

    public IdentitySpec(Query query) {
        this.query = query;
    }

    @Override
    public Predicate toPredicate(Root<IdentityPO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("schemaId"), query.getSchemaId()));
        query.getFields().forEach(field -> predicates.add(parsePredicateFromQueryField(root, criteriaBuilder, field)));
        return criteriaBuilder.and(predicates.toArray(new Predicate[query.getFields().size() + 1]));
    }

    private Predicate parsePredicateFromQueryField(Root<IdentityPO> root, CriteriaBuilder criteriaBuilder, Query.Field field) {
        final String functionName = "JSON_EXTRACT";
        final String traitsAttribution = "traits";

        switch (field.getOperator()) {
            case EQ:
                if (field.getParam() instanceof String) {
                    return criteriaBuilder.equal(
                            criteriaBuilder.function(functionName, String.class, root.get(traitsAttribution),
                                    criteriaBuilder.literal("$." + field.getJsonPath())),
                            field.getParam());
                } else if (field.getParam() instanceof Integer) {
                    return criteriaBuilder.equal(
                            criteriaBuilder.function(functionName, Integer.class, root.get(traitsAttribution),
                                    criteriaBuilder.literal("$." + field.getJsonPath())),
                            field.getParam());
                } else if (field.getParam() instanceof Boolean) {
                    return criteriaBuilder.equal(
                            criteriaBuilder.function(functionName, Boolean.class, root.get(traitsAttribution),
                                    criteriaBuilder.literal("$." + field.getJsonPath())),
                            field.getParam());
                }
                break;
            case IN:
                List<?> listParam = (List<?>) field.getParam();
                if ((listParam).stream().allMatch(p -> p instanceof String)) {
                    Expression<String> jsonExtractExpress = criteriaBuilder.function(functionName,
                            String.class, root.get(traitsAttribution),
                            criteriaBuilder.literal("$." + field.getJsonPath()));
                    CriteriaBuilder.In<String> criteriaIn = criteriaBuilder.in(jsonExtractExpress);
                    listParam.forEach(p -> criteriaIn.value("\"" + p + "\""));
                    return criteriaIn;
                } else if (listParam.stream().allMatch(p -> p instanceof Integer)) {
                    // 表示范围时仅支持整形
                    Expression<Integer> jsonExtractExpress = criteriaBuilder.function(functionName,
                            Integer.class, root.get(traitsAttribution),
                            criteriaBuilder.literal("$." + field.getJsonPath()));
                    CriteriaBuilder.In<Integer> criteriaIn = criteriaBuilder.in(jsonExtractExpress);
                    listParam.forEach(p -> criteriaIn.value((Integer) p));
                    return criteriaIn;
                }
                break;
            case CONTAINS:
                if (field.getParam() instanceof String) {
                    Expression<String> jsonExtractExpress = criteriaBuilder.function(functionName,
                            String.class, root.get(traitsAttribution),
                            criteriaBuilder.literal("$." + field.getJsonPath()));
                    return criteriaBuilder.like(jsonExtractExpress, "%" + field.getParam() + "%");
                }
                break;
            default:
        }

        throw new IllegalArgumentException(String.format("operator: %s, param: %s", field.getOperator(), field.getParam()));
    }
}
