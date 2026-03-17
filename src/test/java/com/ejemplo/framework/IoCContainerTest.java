package com.ejemplo.framework;

import com.ejemplo.framework.ioc.IoCContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IoCContainerTest {

    @Test
    void shouldLoadControllerAndRegisterRoute() throws Exception {
        IoCContainer.loadController("com.ejemplo.app.GreetingController");

        Route route = Router.getRoute("/greeting");

        assertNotNull(route, "Route /greeting should be registered");
    }
}
