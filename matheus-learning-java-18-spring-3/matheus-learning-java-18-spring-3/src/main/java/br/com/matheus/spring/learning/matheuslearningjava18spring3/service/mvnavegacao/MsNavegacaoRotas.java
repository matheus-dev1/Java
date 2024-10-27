package br.com.matheus.spring.learning.matheuslearningjava18spring3.service.mvnavegacao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class MsNavegacaoRotas {

    private Environment environment;
    private ObjectMapper objectMapper;

    public MsNavegacaoRotas(Environment environment, ObjectMapper objectMapper){
        this.environment = environment;
        this.objectMapper = objectMapper;
    }

    public JsonNode getRotasPorGrupoSegmento(String grupoSegmento) throws IOException {
        String enviromentPath = "";
        JsonNode segmentoGrupo = null;

        for(String enviroment : environment.getActiveProfiles()){
            enviromentPath = enviroment;
        }
        String pathSegmentos = "src/main/resources/" + enviromentPath + "/metadata.json";

        JsonNode rootNode = objectMapper.readTree(new File(pathSegmentos));
        JsonNode segmentosNode = rootNode.path("segmentos");

        for (JsonNode segmentoNode : segmentosNode) {
            if(!segmentoNode.path(grupoSegmento).isEmpty()){
                segmentoGrupo = segmentoNode.path(grupoSegmento);
            }
        }

        return segmentoGrupo;
    }
}
