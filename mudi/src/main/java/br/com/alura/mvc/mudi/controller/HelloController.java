package br.com.alura.mvc.mudi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Está anotação Spring faz com que está classe seja um controller e seja monitorada pelo Speing, fazendo com que ele mapeie cada
// action(metodo) para identificar qual metodo pertence a determinada requisição.
@Controller
//Controller - Que faz a parte logica.
public class HelloController {
	
	// Definindo o mapeamento(endpoint. Exemplo: localhost:8080/hello) que chama esta action.
	@GetMapping("/hello")
	// Actions - Proessa uma requisição do usuario que redireciona ALGO para uma view.
	public String hello(HttpServletRequest request, HttpServletResponse response) {
		// Thymeleaf + Spring Boot + Spring MVC - Nos temos que colocar as nossas view(paginas) em src/main/resouces/templates.
		// Por padrão no thymeleaf as nossas paginas são em html puro.
		
		// Aqui eu estou enviando para a pagina hello.html na requisição do endpoint localhost:8080/hello o valor mundo na variavel 
		// nome
		request.setAttribute("nome", "mundo");
		return "hello";
	}
	
	@GetMapping("/hello1")
	// O model faz a mesma coisa que o HttpServletRequest, porém em uma camada mais alto nivel.
	public String hello1(Model model) {
		model.addAttribute("nome", "mundo");
		return "hello1";
	}
}
