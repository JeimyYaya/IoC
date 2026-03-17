package com.ejemplo.framework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestParamTest {

    @Test
    void shouldExtractQueryParam() {
        Request req = new Request("/greeting?", "name=Jeimy");

        String value = req.getValues("name");

        assertEquals("Jeimy", value);
    }
}