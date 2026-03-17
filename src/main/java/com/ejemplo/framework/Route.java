package com.ejemplo.framework;

@FunctionalInterface
public interface Route {
    String handle(Request req, Response res);
}