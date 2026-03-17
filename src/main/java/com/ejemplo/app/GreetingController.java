package com.ejemplo.app;

import com.ejemplo.framework.annotations.*;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(value = "name", defaultValue = "World") String name
    ) {
        return "Hola " + name;
    }
}
