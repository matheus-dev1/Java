package br.com.matheus.spring.learning.matheuslearningjava18spring3.service.mvnavegacao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class MsNavegacaoSegmento {

    private Environment environment;
    private ObjectMapper objectMapper;

    public MsNavegacaoSegmento(Environment environment, ObjectMapper objectMapper){
        this.environment = environment;
        this.objectMapper = objectMapper;
    }

    //no ms terei um metodo pra retornar o segmento em vez de passar como param
    public String getGrupoSegmento(String segmento) throws IOException {
        String enviromentPath = "";
        String segmentoGrupo = "";

        for(String enviroment : environment.getActiveProfiles()){
            enviromentPath = enviroment;
        }
        String pathSegmentos = "src/main/resources/" + enviromentPath + "/segmentos.json";

        JsonNode rootNode = objectMapper.readTree(new File(pathSegmentos));
        JsonNode segmentosNode = rootNode.path("segmentos");

        for (JsonNode segmentoNode : segmentosNode) {
            String segmentoNodeValue = segmentoNode.path("segmento").asText();
            if(segmentoNodeValue.equals(segmento)){
                segmentoGrupo = segmentoNode.path("grupo").asText();
            }
        }

        return segmentoGrupo;
    }
}
