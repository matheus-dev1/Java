package br.com.alura.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class HelloWorldController {

	@GetMapping
	// O retorno desta action vai ser no corpo da requisição.
	// Obs: A biblioteca Jackson Json que faz essa conversão de objeto java para JSON.
	// @ResponseBody
	// Porém se você usar o @RestController, você não precisa da anotação ResponseBody.
	public String helloWorld() {
		return "Hello World!";
	}
}
