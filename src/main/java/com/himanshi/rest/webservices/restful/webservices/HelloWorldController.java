package com.himanshi.rest.webservices.restful.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/hello-world")
    public String helloWorld() {
    	return "Hello World";
    }
	
	@GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
    	return new HelloWorldBean("Hello World Bean");
    }
	
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
    	return new HelloWorldBean(String.format("Hello World Bean, %s", name));
    }
}
