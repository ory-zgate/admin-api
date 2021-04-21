package io.zgate.useradmin.server.exception;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {ApiException.class, ExceptionHandler.class})
public class ApiExceptionHandler implements ExceptionHandler<ApiException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, ApiException exception) {
        return HttpResponse.badRequest();
    }
}
