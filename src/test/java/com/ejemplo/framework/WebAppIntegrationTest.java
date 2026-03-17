package com.ejemplo.framework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WebAppIntegrationTest {

    @Test
    void lambdaShouldAccessQueryParams() {

        WebApp.get("/helloTest", (req, res) ->
                "Hello " + req.getValues("name")
        );

        Route route = Router.getRoute("/helloTest");

        String result = route.handle(
                new Request("/helloTest", "name=Ana"),
                new Response()
        );

        assertEquals("Hello Ana", result);
    }
}