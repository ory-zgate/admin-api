package io.zgate.useradmin.server.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListUtil {
    public static <S, T> List<T> convert(Collection<S> collection, Function<S, T> function) {
        return collection.stream().map(function).collect(Collectors.toList());
    }
}
