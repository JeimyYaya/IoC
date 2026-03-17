package com.ejemplo.framework;

public class WebApp {

    public static void get(String path, Route route) {
        Router.get(path, route);
    }

    public static void staticfiles(String folder) {
        StaticFileHandler.setStaticFolder(folder);
    }

    public static void start(int port) throws Exception {
        HttpServer.start(port);
    }
}