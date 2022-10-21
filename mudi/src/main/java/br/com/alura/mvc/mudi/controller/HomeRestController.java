package br.com.alura.mvc.mudi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

    @GetMapping("/oi")
    // A classe ResponseEntity é um builder para definir o corpo (body) da resposta, status e os cabeçalhos. 
    public ResponseEntity<String> hello() {
    	// Isso não faz nada mais do que devolver o texto no corpo da resposta junto ao status 200.
        return ResponseEntity.ok().body("Oi Mundo!");
    }
}  
