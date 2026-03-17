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
## Deployment on AWS EC2

The application was successfully deployed on an AWS EC2 instance.

### Deployment Steps

1. The project was compiled locally using Maven:

```bash
mvn clean package
```

2. The compiled classes (`target/classes`) were compressed into a ZIP file:

```bash
Compress-Archive -Path target/classes -DestinationPath classes.zip
```

3. The ZIP file was uploaded to the EC2 instance using SCP:

```bash
scp -i AppServerKey.pem classes.zip ec2-user@ec2-3-232-134-133.compute-1.amazonaws.com:/home/ec2-user
```

4. The file was extracted on the server:

```bash
unzip classes.zip
```

5. The application was executed using the Java classpath:

```bash
java -cp classes com.ejemplo.framework.MicroSpringBoot
```

---

### Accessing the Application

Once deployed, the application was accessed through the browser:

```text
http://ec2-3-232-134-133.compute-1.amazonaws.com:8080/greeting?name=Jeimy
```

---

### Evidence

#### 1️⃣ Server running on AWS

<img width="729" height="110" alt="image" src="https://github.com/user-attachments/assets/f835d401-eb00-4967-bbc7-3dc4dfaddd55" />


#### 2️⃣ Successful HTTP response

<img width="1077" height="167" alt="image" src="https://github.com/user-attachments/assets/54297be6-8daf-4d8d-8062-dee4dd42d06a" />

---

### Notes

* Port **8080** was enabled in the EC2 Security Group.
* The application runs using compiled `.class` files without requiring a JAR.
* The ClassScanner dynamically detects the classpath, ensuring compatibility between local and cloud environments.

---

## Result

The deployment demonstrates that the framework:

* Works correctly in a cloud environment
* Handles HTTP requests externally
* Maintains portability across different execution environments
  
---

## Conclusion

This project demonstrates how modern web frameworks work internally by implementing:
- HTTP server
- Routing system
- IoC container
- Annotation processing
- Reflection-based class loading
