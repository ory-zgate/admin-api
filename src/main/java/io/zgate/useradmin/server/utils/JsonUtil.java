package io.zgate.useradmin.server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static Object toJsonObject(final String src) {
        try {
            return objectMapper.readValue(src, Object.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("", e);
        }
    }
}
