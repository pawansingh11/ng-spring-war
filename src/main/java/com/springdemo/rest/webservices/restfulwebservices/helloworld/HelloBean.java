package com.springdemo.rest.webservices.restfulwebservices.helloworld;

public class HelloBean {
	String messages;
	public HelloBean(String messagee){
		this.messages = messagee;
	}
	public String getMessage() {
		return messages;
	}
	public void setMessage(String message) {
		this.messages = message;
	}
	
	@Override
	public String toString() {
		return "HelloBean [messagess=" + messages + "]";
	}
	
	
}
