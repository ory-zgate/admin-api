package io.zgate.admin.user.model;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotNull;
import java.util.List;

@Introspected
public class Query {
    @Introspected
    public enum Operator {
        EQ, IN, CONTAINS
    }

    private String schemaId = "default";

    private List<Field> fields;

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Introspected
    public static class Field {
        @NotNull
        private String jsonPath;
        @NotNull
        private Operator operator;
        @NotNull
        private Object param;

        public String getJsonPath() {
            return jsonPath;
        }

        public void setJsonPath(String jsonPath) {
            this.jsonPath = jsonPath;
        }

        public Operator getOperator() {
            return operator;
        }

        public void setOperator(Operator operator) {
            this.operator = operator;
        }

        public Object getParam() {
            return param;
        }

        public void setParam(Object param) {
            this.param = param;
        }
    }
}
