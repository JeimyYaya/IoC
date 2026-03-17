package com.ejemplo.framework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RequestTest {

    @Test
    void shouldExtractQueryParameters() {

        Request req = new Request("/hello", "name=Pedro&age=21");

        assertEquals("Pedro", req.getValues("name"));
        assertEquals("21", req.getValues("age"));
    }

    @Test
    void shouldReturnNullForMissingParam() {

        Request req = new Request("/hello", "name=Pedro");

        assertNull(req.getValues("age"));
    }
}