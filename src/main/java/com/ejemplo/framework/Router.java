package com.ejemplo.framework;

import java.util.HashMap;
import java.util.Map;

public class Router {

    private static Map<String, Route> getRoutes = new HashMap<>();

    public static void get(String path, Route route) {
        getRoutes.put(path, route);
    }

    public static Route getRoute(String path) {
        return getRoutes.get(path);
    }
}