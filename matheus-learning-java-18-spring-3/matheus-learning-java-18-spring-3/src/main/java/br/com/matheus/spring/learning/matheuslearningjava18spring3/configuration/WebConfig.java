package br.com.matheus.spring.learning.matheuslearningjava18spring3.configuration;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.seralization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

// Como configuration eh executado quando o contexto do spring tambem eh inicializado
// para debugar vc precisar colocar um debug e startar a aplicacao
@Configuration
public class WebConfig implements WebMvcConfigurer {

    public final MediaType MEDIA_TYPE_APPLICATION_YAML = MediaType.valueOf("application/x-yaml");

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .favorParameter(false) // Define se a preferência pode ser passada como parâmetro na URL
                // .parameterName("mediaType") // Define o nome do parâmetro de URL que pode ser usado para especificar o tipo de mídia (como JSON ou XML)
                .ignoreAcceptHeader(false) // Permite ou não ignorar o cabeçalho Accept
                // Define se o Spring deve ou não considerar apenas as extensões de mídia que foram registradas explicitamente
                // Quando true apenas usara mídia que foram registradas explicitamente
                // Quando false o Spring tentará resolver a extensão usando a lista completa de tipos de mídia suportados
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON) // Formato padrão
                .mediaType("json", MediaType.APPLICATION_JSON) // MediaType Json
                .mediaType("xml", MediaType.APPLICATION_XML) // MediaType XML
                .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YAML); // Custom MediaType Yaml
    }

    // Adicionar ou modificar conversores de mensagens HTTP
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter());
    }
}