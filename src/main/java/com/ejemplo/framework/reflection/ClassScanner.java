package com.ejemplo.framework.reflection;

import com.ejemplo.framework.annotations.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassScanner {

    public static List<Class<?>> findControllers(String basePackage) {

        List<Class<?>> controllers = new ArrayList<>();

        try {
            // Ej: com.ejemplo → com/ejemplo
            String packagePath = basePackage.replace(".", "/");

            // Ruta física en Maven
            String baseDir = "target/classes/" + packagePath;

            File directory = new File(baseDir);

            if (!directory.exists()) {
                System.out.println("⚠ Directory not found: " + directory.getAbsolutePath());
                return controllers;
            }

            scanDirectory(directory, basePackage, controllers);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return controllers;
    }

    private static void scanDirectory(File directory, String packageName, List<Class<?>> controllers) {

        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {

            if (file.isDirectory()) {
                scanDirectory(file, packageName + "." + file.getName(), controllers);

            } else if (file.getName().endsWith(".class")) {

                String className = packageName + "." + file.getName().replace(".class", "");

                try {
                    Class<?> clazz = Class.forName(className);

                    if (clazz.isAnnotationPresent(RestController.class)) {
                        controllers.add(clazz);
                        System.out.println("Found controller: " + className);
                    }

                } catch (Throwable e) {
                }
            }
        }
    }
}