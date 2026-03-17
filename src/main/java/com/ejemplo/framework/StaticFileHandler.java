package com.ejemplo.framework;

import java.io.IOException;
import java.io.InputStream;

public class StaticFileHandler {

    private static String staticFolder = "webroot";

    public static void setStaticFolder(String folder) {
        if (folder.startsWith("/")) {
            folder = folder.substring(1);
        }
        staticFolder = folder;
    }

    public static byte[] getFile(String path) throws IOException {

        if (path.equals("/")) {
            path = "/index.html";
        }

        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        InputStream is = StaticFileHandler.class
                .getClassLoader()
                .getResourceAsStream(staticFolder + "/" + path);

        if (is == null) {
            return null;
        }

        return is.readAllBytes();
    }
}