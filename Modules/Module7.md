# Object Oriented Programming With Java (ITA5004) - Notes

## Module - 7 : RMI and Servlets

- [x] ~~Remote Method Invocation~~
- [x] ~~Servlets~~

## RMI - Remote Method Invocation

- RMI is an API that provides a mechanism to create distributed application in java.
- It allows an object to invoke methods on an object running in another JVM.
- It provides remote communication between the applications using two objects stub and skeleton.
- RMI uses stub and skeleton object for communication with the remote object.
- A remote object is an object whose method can be invoked from another JVM.

### Stub

- Object that acts as a gateway at client side.
- All outgoing requests go through it.
- When a method is called on stub, following happens:
  1. Make connection with the remote JVM
  2. Write and Transmit the parameters to the remote object.
  3. Wait for result
  4. Read the return value
  5. Return value to the caller.

### Skeleton

- Resides at server side.
- All incoming requests go through it.
- When a request is received, following happens:
  1. Read the parameter
  2. Invoke method on actual object
  3. Write and transmit data to the caller.

### Servlets

- Servlet technology is used to create a web application
- Resides at server side and generates a dynamic web page.
- Servlet technology is robust and scalable.
- There are many interfaces and classes in the Servlet API such as Servlet, GenericServlet, HttpServlet, ServletRequest, ServletResponse, etc.

### Servlet Advantages

- Better performance: because it creates a thread for each request, not process.
- Portability: because it uses Java language.
- Robust: JVM
- manages Servlets, so we don't need to worry about the memory leak, garbage collection, etc.
- Secure: because it uses java language.

### Web Application

- A web application is an application accessible from the web.
- A web application is composed of web components like Servlet, JSP, Filter, etc.
- The web components typically execute in Web Server and respond to the HTTP request.
- A web application is an application accessible from the web.
- A web application is composed of web components like Servlet, JSP, Filter, etc. and other elements such as HTML, CSS, and JavaScript.
- The web components typically execute in Web Server and respond to the HTTP request.

## CGI (Common Gateway Interface)

- CGI technology enables the web server to call an external program and pass HTTP request information to the external program to process the request.
- For each request, it starts a new process.

### Disadvantages

- If the number of clients increases, it takes more time for sending the response.
- For each request, it starts a process, and the web server is limited to start processes.
- It uses platform dependent language e.g. C, C++, , perl.

## Servlet Life Cycle

- The web container maintains the life cycle of a servlet instance.
- Let's see the life cycle of the servlet:
  1. Servlet class is loaded.
  2. Servlet instance is created.
  3. init method is invoked.
  4. service method is invoked.
  5. destroy method is invoked.
- There are three states of a servlet: new, ready and end.
- The servlet is in new state if servlet instance is created.
- After invoking the init() method, Servlet comes in the ready state.
- In the ready state, servlet performs all the tasks.
- When the web container invokes the destroy() method, it shifts to the end state.

### 1. Classloader

- The classloader is responsible to load the servlet class.
- The servlet class is loaded when the first request for the servlet is received.
- The web container creates the instance of a servlet after loading the servlet class.
- The servlet instance is created only once in the servlet life cycle.

### 2. init() method

- The web container calls the init method only once after creating the servlet instance.
- The init method is used to initialize the servlet.
- It is the life cycle method of the `javax.servlet.Servlet` interface.

```java
public void init(ServletConfig config) throws ServletException {
  ...
}
```

### 3. service() method

- Container calls the service method each time request is received. 
- If servlet is not initialized, it follows the first three steps as described above then calls the service method. 
- If servlet is initialized, it calls the service method. 
- Notice that servlet is initialized only once. 

```java
public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
  ...
} 
```

### 4. destroy() method

- Container calls the destroy method before removing the servlet instance from the service. 
- It gives the servlet an opportunity to clean up any resource for example memory, thread etc.

```java
public void destroy() {
  ...
}
```