package com.example.integrationstrategy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.integrationstrategy.model.HellWorld;

@RestController
public class HelloController {
  @GetMapping("/hello-world")
	@ResponseBody
	public HellWorld getHelloWorld() {
		return new HellWorld();
	}
}

