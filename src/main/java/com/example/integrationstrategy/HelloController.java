package com.example.integrationstrategy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/hello-world")
	public String getHelloWorld() {
		return "Hello World!";
	}
}

