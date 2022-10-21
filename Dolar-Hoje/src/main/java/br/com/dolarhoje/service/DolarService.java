package br.com.dolarhoje.service;

import org.springframework.stereotype.Service;
import com.google.gson.*;

import br.com.dolarhoje.model.ValueModel;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

@Service
public class DolarService {

    // Usando o HttpRequest do Java, nos temos duas maneiras de começar, instanciando uma URI no construtor
    // do Builder do HttpRequest, ou criando o builder com o contrutor vazio e usar o metodo .uri

    // HttpRequest.newBuilder(new URI("https://postman-echo.com/get"))

    // HttpRequest.newBuilder()
    //   .uri(new URI("https://postman-echo.com/get"))
	
	private static final String BASE_DOLAR_URL = "https://olinda.bcb.gov.br";
	private static final String BARRA = "/";
	private static final String OLINDA = "olinda";
	private static final String SERVICO = "servico";
	private static final String PTAX = "PTAX";
	private static final String VERSAO = "versao";
	private static final String V1 = "v1";
	private static final String ODATA = "odata";
	private static final String COTACAO_DOLAR_DIA = "CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao=";
	private static final String VINTE_SETE = "%27";
	private static final String MAIS_PARAMETRO = "&";
	private static final String FORMATO = "$format=";
	private static final String JSON = "json";

    public ValueModel DolarGet(String data) throws Exception {    	
    	// Instanciando o cliente.
    	HttpClient httpClient = HttpClient.newHttpClient();
    	
    	String URL = BASE_DOLAR_URL + 
                		BARRA + 
                		OLINDA + 
                		BARRA + 
                		SERVICO + 
                		BARRA + 
                		PTAX + 
                		BARRA + 
                		VERSAO + 
                		BARRA + 
                		V1 + 
                		BARRA + 
                		ODATA + 
                		BARRA + 
                		COTACAO_DOLAR_DIA + 
                		VINTE_SETE + 
                		data + 
                		VINTE_SETE + 
                		MAIS_PARAMETRO + 
                		FORMATO + 
                		JSON;
    	
    	// Aqui eu estou montando a requisição
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(URL))
                // .version(HttpClient.Version.HTTP_2) - Nos podemos configurar a verção do HTTP que vamos usars
                // .header("key1", "value1") - Podemos adicionar um Header.
                // .timeout(Duration.of(10, SECONDS)) - Timeout da resposta.
                .GET()
                .build();
        
        // Aqui eu estou enviando e pegando o retorno da requisição.
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        
        // Instancando o objeto Gson e fazendo um parse para JSON baseado no classe de modelo ValueModel
        ValueModel valueModel = new Gson().fromJson(httpResponse.body(), ValueModel.class);

        // Aqui eu estou printando a resuisição.
        System.out.println(valueModel.getValue());
        
        return valueModel;
    }

}
