package br.com.dolarhoje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.dolarhoje.model.ValueModel;
import br.com.dolarhoje.service.DolarService;

@RestController
public class DolarController {
    
    @Autowired
    private DolarService dolarService;

    @CrossOrigin(origins = "*")
    @GetMapping("/dolarHoje/{data}")
    public ResponseEntity<Object> DolarHojegGet(@PathVariable("data") String data) {
        try {
            ValueModel valueModel = this.dolarService.DolarGet(data);
            return ResponseEntity.ok(valueModel);
        } catch(Exception exception) {
            return ResponseEntity.ok("Erro ao chamar a API. Tente novamente mais tarde.");
        }
    }

}
