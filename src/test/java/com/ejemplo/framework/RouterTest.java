package com.ejemplo.framework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RouterTest {

    @Test
    void shouldRegisterAndRetrieveRoute() {

        Router.get("/test", (req, res) -> "ok");

        Route route = Router.getRoute("/test");

        assertNotNull(route);
        assertEquals("ok", route.handle(
                new Request("/test", null),
                new Response()
        ));
    }
}