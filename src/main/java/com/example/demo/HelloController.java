package com.example.demo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping({ "/greetings" })
public final class HelloController {

	private List<Greeting> greetings;

	public HelloController() {
		greetings = new ArrayList<>();
		greetings.add(new Greeting("Hello!"));
		greetings.add(new Greeting("Howdy!"));
		greetings.add(new Greeting("Hi!"));
	}

	@GetMapping("/{id}")
	public Greeting getGreetingById(@PathVariable("id") final int id) {
		return greetings.get(id - 1); // list index starts with 0 but we prefer to start on 1
	}

	@GetMapping
	public final List<Greeting> greetings() throws UnknownHostException {
		return greetings;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createSpanishGreeting(@RequestBody Greeting greeting) {
		greetings.add(greeting);
	}
}