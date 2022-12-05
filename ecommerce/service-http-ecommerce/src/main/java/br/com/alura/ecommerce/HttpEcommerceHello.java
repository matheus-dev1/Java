package br.com.alura.ecommerce;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpEcommerceHello {

    @GetMapping("/hello")
    public ResponseEntity<String> helloGet() {
            return ResponseEntity.ok("Testando...");
    }
}
