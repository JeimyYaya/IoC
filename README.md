# MicroSpringBoot - Java Web Framework
- Jeimy Alejandra Yaya Martinez

## Overview

This project implements a lightweight Java web framework inspired by Spring Boot.  
It was built from scratch using Java sockets, reflection, and a simple IoC container.

The framework supports:

- REST services using annotations
- Automatic component scanning
- Query parameter extraction
- Static file serving
- Dynamic route registration

---

## Architecture

### Core Components

- **HttpServer**: Handles HTTP requests using sockets
- **Router**: Stores and resolves REST routes
- **Request / Response**: Encapsulate HTTP data
- **StaticFileHandler**: Serves static files

### IoC & Reflection

- **@RestController**: Marks classes as web components
- **@GetMapping**: Maps methods to HTTP endpoints
- **@RequestParam**: Extracts query parameters
- **IoCContainer**: Loads and processes controllers
- **ClassScanner**: Scans classpath for annotated classes

---

## How to Run

### 1. Compile

```bash
mvn clean package
```

### 2. Run

```bash
java -cp target/classes com.ejemplo.framework.MicroSpringBoot
```

Server starts at:

http://localhost:8080

---

## Example Endpoint
http://localhost:8080/greeting?name=Jeimy

Response:

Hola Jeimy

<img width="554" height="189" alt="image" src="https://github.com/user-attachments/assets/aa5de622-f088-4506-96ae-6e3616b47b42" />

---

##  Testing

Run all tests:

```bash
mvn test
```

Tests include:
- IoC container loading
- Query parameter extraction
- Classpath scanning

---

##  Maven Structure
```
src/
 ├── main/
 │   ├── java/com/ejemplo/
 │   │
 │   │   ├── app/
 │   │   │   └── GreetingController.java 
 │   │
 │   │   └──  framework/
 │   │       ├── HttpServer.java
 │   │       ├── Request.java
 │   │       ├── Response.java
 │   │       ├── Route.java
 │   │       ├── Router.java
 │   │       ├── StaticFileHandler.java
 │   │       ├── WebApp.java
 │   │       ├── MicroSpringBoot.java  
 │   │    
 │   │       ├── annotations/           
 │   │       │   ├── RestController.java
 │   │       │   ├── GetMapping.java
 │   │       │   └── RequestParam.java
 │   │       │
 │   │       ├── ioc/                     
 │   │       │   └── IoCContainer.java
 │   │       │
 │   │       └── reflection/             
 │   │          └── ClassScanner.java
 │   │
 │   │
 │   └── resources/webroot/
 │       └── index.html
 │
 └── test/
 ```
---

##  Design Decisions

- Uses reflection to dynamically load controllers
- Implements a simple IoC container
- Uses filesystem-based class scanning (target/classes)
- Focuses on simplicity and educational value

---

## Limitations

- Only supports GET requests
- Only supports String responses
- ClassScanner works only in compiled environments (not JAR)

--- 

## Conclusion

This project demonstrates how modern web frameworks work internally by implementing:
- HTTP server
- Routing system
- IoC container
- Annotation processing
- Reflection-based class loading
