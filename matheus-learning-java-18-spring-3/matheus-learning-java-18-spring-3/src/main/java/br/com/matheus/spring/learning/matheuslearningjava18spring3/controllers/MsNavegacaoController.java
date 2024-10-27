package br.com.matheus.spring.learning.matheuslearningjava18spring3.controllers;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.service.mvnavegacao.MsNavegacaoRotas;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.service.mvnavegacao.MsNavegacaoSegmento;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/navegacao/v1")
public class MsNavegacaoController {

    private MsNavegacaoSegmento msNavegacaoSegmento;
    private MsNavegacaoRotas msNavegacaoRotas;

    @Autowired
    public MsNavegacaoController(MsNavegacaoSegmento msNavegacaoSegmento, MsNavegacaoRotas msNavegacaoRotas) {
        this.msNavegacaoSegmento = msNavegacaoSegmento;
        this.msNavegacaoRotas = msNavegacaoRotas;
    }

    @GetMapping("/getAll/{segmento}")
    public ResponseEntity<JsonNode> getAllMetadados(
            @PathVariable String segmento
    ) throws IOException {
        String segmentoGrupo = msNavegacaoSegmento.getGrupoSegmento(segmento);
        JsonNode segmentoGroup = msNavegacaoRotas.getRotasPorGrupoSegmento(segmentoGrupo);
        return ResponseEntity.ok(segmentoGroup);
    }
}
