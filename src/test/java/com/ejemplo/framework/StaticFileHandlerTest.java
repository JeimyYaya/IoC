package com.ejemplo.framework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StaticFileHandlerTest {

    @Test
    void shouldLoadIndexFile() throws Exception {

        StaticFileHandler.setStaticFolder("webroot");

        byte[] data = StaticFileHandler.getFile("/index.html");

        assertNotNull(data);
        assertTrue(data.length > 0);
    }

    @Test
    void shouldReturnNullForMissingFile() throws Exception {

        StaticFileHandler.setStaticFolder("webroot");

        byte[] data = StaticFileHandler.getFile("/nofile.html");

        assertNull(data);
    }
}