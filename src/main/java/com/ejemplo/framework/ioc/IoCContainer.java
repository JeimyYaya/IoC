package com.ejemplo.framework.ioc;

import com.ejemplo.framework.annotations.*;
import com.ejemplo.framework.reflection.ClassScanner;
import com.ejemplo.framework.Router;

import java.lang.reflect.*;

public class IoCContainer {

    public static void loadController(String className) throws Exception {

        Class<?> clazz = Class.forName(className);

        if (!clazz.isAnnotationPresent(RestController.class)) {
            return;
        }

        Object instance = clazz.getDeclaredConstructor().newInstance();

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(GetMapping.class)) {

                String path = method.getAnnotation(GetMapping.class).value();

                Router.get(path, (req, res) -> {

                    try {

                        Parameter[] params = method.getParameters();
                        Object[] args = new Object[params.length];

                        for (int i = 0; i < params.length; i++) {

                            if (params[i].isAnnotationPresent(RequestParam.class)) {

                                RequestParam rp = params[i].getAnnotation(RequestParam.class);

                                String value = req.getValues(rp.value());

                                if (value == null || value.isEmpty()) {
                                    value = rp.defaultValue();
                                }

                                args[i] = value;
                            }
                        }

                        Object result = method.invoke(instance, args);

                        return result.toString();

                    } catch (Exception e) {
                        e.printStackTrace();
                        return "Error executing method";
                    }
                });
            }
        }
    }

    public static void loadAllControllers(String basePackage) throws Exception {

        var controllers = ClassScanner.findControllers(basePackage);

        for (Class<?> clazz : controllers) {
            System.out.println("Loading: " + clazz.getName());
            loadController(clazz.getName());
        }
    }
}
