package com.ejemplo.framework;

import com.ejemplo.framework.ioc.IoCContainer;

public class MicroSpringBoot {

    public static void main(String[] args) throws Exception {

        System.out.println("Starting MicroSpringBoot...");

        IoCContainer.loadAllControllers("com.ejemplo");

        WebApp.staticfiles("webroot");

        WebApp.start(8080);
    }
}