package com.ejemplo.framework;

import com.ejemplo.framework.reflection.ClassScanner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClassScannerTest {

    @Test
    void shouldFindControllers() {
        var controllers = ClassScanner.findControllers("com.ejemplo");

        assertFalse(controllers.isEmpty(), "Should find at least one controller");
    }
}