package com.example.demo;

public class Greeting {

	private String message;

	// Required for JSON deserialization
	public Greeting() {
	}

	public Greeting(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
