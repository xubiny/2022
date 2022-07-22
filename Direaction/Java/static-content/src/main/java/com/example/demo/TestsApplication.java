package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class TestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsApplication.class, args);
	}
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
}
