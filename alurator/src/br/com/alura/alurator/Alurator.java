package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.conversor.ConversorXML;
import br.com.alura.alurator.ioc.ContainerInversaoDeControle;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.ManipuladorMetodo;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {
	
	private String pacote;
	private ContainerInversaoDeControle containerInversaoDeControle;
	
	public Alurator(String pacote) {
		this.pacote = pacote;
		this.containerInversaoDeControle = new ContainerInversaoDeControle();
	}
	
	public Object executa(String url) throws 
		NoSuchMethodException, SecurityException {		
			/*System.out.println(url);
			
			String[] urlDividia = url
					.replaceFirst("/", "")
					.split("/");
			
			System.out.println(urlDividia[0]);
			System.out.println(urlDividia[1]);
			
			String FQNController = pacoteBase + urlDividia[0];*/
			
			Request request = new Request(url);
			// System.out.println("Nome do metodo: " + request.getNomeMetodo());
			String FQNController = pacote + request.getPacoteCompleto();
			// System.out.println(pacote + " Pacotão");
			String nomeMetodo = request.getNomeMetodo();
			Map<String, Object> parametrosMap = request.getParametros();
			
			/* Padrão Builder, aonde a gente faz um amontuado de metodos.
			 A ideia de fazer assim é que os metodos compostos dessa forma sejam usads assim mesmo. */
			/*Object classeInstanciada = new Reflexao()
				.refleteClasse(pacote) // Class<?> classeController = Class.forName(pacote);
				.getConstrutorPadrao() // Constructor<?> classeControllerConstructorInstancia = classeController.getDeclaredConstructor();
				.invoca(); // Object classeControllerInstancia = classeControllerConstructorInstancia.newInstance();
				*/
			
			// Antiga forma de pegar o pacote, instanciar a classe, pegar o metodo e exeuta-los.
			/*Object retornoMetodo = new Reflexao()
				.refleteClasse(pacote)
				.criandoInstancia()
				.getMetodo(nomeMetodo, parametrosMap)
				.comTratamentoDeExcecao()
				.invoca();*/
			
			/*Class<?> classeController = Class.forName(pacote);
			 Classe Construtor
			 Constructor<?> classeControllerConstructorInstancia = classeController.getDeclaredConstructor();
			 try {
				 Object classeControllerInstancia = classeControllerConstructorInstancia.newInstance();
				 System.out.println(classeControllerInstancia);
			 } catch (IllegalArgumentException e) {
				 e.printStackTrace();
			 }*/
			
			// get Classe retorna uma classe a partir de um FQN
			Class<?> classeController = new Reflexao().getClasse(FQNController);
			// Instancia uma classe e suas dependencias.
			Object instanciaController = containerInversaoDeControle.getInstancia(classeController);
			// Pega a classe instanciada e executa os metodos a partir do valor que o usuario digitou.
			Object retornoMetodo = new ManipuladorMetodo(classeController, instanciaController)
				.getMetodo(nomeMetodo, parametrosMap)
				.invoca();
			
			ConversorXML conversorXML = new ConversorXML();
			retornoMetodo = conversorXML.converte(retornoMetodo);
			
			return retornoMetodo;
		}

	//Estou verificando se os tipoDestino é compativel com o tipoFonte
	public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
		containerInversaoDeControle.registra(tipoFonte, tipoDestino);
	}
}
