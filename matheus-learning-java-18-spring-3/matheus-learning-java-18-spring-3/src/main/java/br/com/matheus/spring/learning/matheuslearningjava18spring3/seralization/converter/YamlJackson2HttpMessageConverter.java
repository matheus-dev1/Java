package br.com.matheus.spring.learning.matheuslearningjava18spring3.seralization.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

// Converter objecto java para objeto yaml
// AbstractJackson2HttpMessageConverter
// Classe Spring usada para converter automaticamente objetos para formatos como JSON ou YAML na resposta HTTP
public class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

    public YamlJackson2HttpMessageConverter() {
        // Content-Type: application/x-yaml
        super(getPersonalizedMapperToYaml(), MediaType.parseMediaType("application/x-yaml"));
    }

    private static ObjectMapper getPersonalizedMapperToYaml() {
        // Com YAMLMapper, conseguimos desserializar objetos Java em YAML
        // Configuracao para nao serializar objetos nulos
        return new YAMLMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

}
