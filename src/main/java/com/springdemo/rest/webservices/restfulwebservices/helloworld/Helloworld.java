package com.springdemo.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
//to anotation to indicate this as controller
@RestController
public class Helloworld {
//	@RequestMapping anotation requires method and path
//	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	
//	intead of @RequestMapping we are using @GetMapping as we dont need to specify request type
	@GetMapping(path = "/api/hello")
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping(path = "/api/hello-bean")
	public HelloBean helloBean(){
		return new HelloBean("hello bean");
	}
}
