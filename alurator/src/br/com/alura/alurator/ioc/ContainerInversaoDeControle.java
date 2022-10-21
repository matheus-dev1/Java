package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

// Explica��o com base na classe ProdutoControler que tem a classe como depdencia ProdutoDaoMock
// A Invers�o de controle/Inje��o de Dependencia, � feita nos construtores das classes.
public class ContainerInversaoDeControle {
	// Este tipoFonte, vai guardar por exemplo produtoDao(interface) e o tipoDestino, vai guardar por exemplo
	// a implementa��o desta interface, no caso o ProdutoDaoMock(class)
	private Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();
	// Aqui � a classe que tem as dependencias, n�o as "classes dependencias" em si. Exemplo ProdutoController e n�o ProdutoDaoMock
	public Object getInstancia(Class<?> classe) {
		Class<?> tipoFonte = classe;
		// Se o tipoDestino for diferente de null - ou seja, se j� tivermos vinculado algum tipo de
		// destino ao tipo fonte - vamos criar uma inst�ncia do tipoDestino que j� foi criado.
		Class<?> tipoDestino = mapaDeTipos.get(tipoFonte);
		if(tipoDestino != null) {
			/* Quando eu pegar o a interface e passar ela como parametro para getInstancia,
			 * no momento que eu estou verificando os parametros do construtor da ProdutoControler,
			 * eu vou executar novamente getInstancia e vou passar como parametro a interface 
			 * ProdutoDao, e quando eu vou verificar no meu mapaDeTipos, a correspondencia de
			 * ProdutoDao � ProdutoDaoMock, e ent�o eu entro no if passando como parametro para
			 * getInstancia ProdutoDaoMock, e ai sim fazendo a inje��o de dependencia que implementa
			 * a interface.
			 * 
			 * PARTE QUE EXECUTA @IMPORTANTE
			 */
			return getInstancia(tipoDestino);
		}
		// Pegando todos os contrutores da classes ProdutoController.
		Constructor<?>[] construtores = classe.getDeclaredConstructors();
		// Colocando nossos construtores em uma Stream.
        Stream<Constructor<?>> construtoresStream = Stream.of(construtores);
        // Vai me retornar um novo Stream de Construtores que tenham true no filter
        // neste caso, se o construtor tiver 0 parametros ent�o, ele sera retornado.
        Stream<Constructor<?>> construtoresSemParametrosStream = construtoresStream.filter(construtor -> construtor.getParameterCount() == 0);
        // Vou pegar o primeiro construtor sem parametro da classe.
        // Obs: O Optional � semelhate ao Stream, � um clase utilitaria para ajudar com certos fluxos.
        Optional<Constructor<?>> primeiroConstrutorDaClasseOptional = construtoresSemParametrosStream.findFirst();
        
        try {
        	// O metodo isPresent() da classe Optional, verifica se seu construtor padr�o realmente existe, porque pode ter o caso de voc� n�o ter
        	// declarado nenhum construtor padr�o, ou seja, sem parametros.
            if(primeiroConstrutorDaClasseOptional.isPresent()) {
            	// Pega o construtor em si, sem o Optional para fazer valida��es.
            	Constructor<?> construtorPadrao = primeiroConstrutorDaClasseOptional.get();
            	// Criando um instancia da minha classe ProdutoController, atraves de seu construtor padr�o. 
                Object instancia = construtorPadrao.newInstance();
                // retorno a instancia da classe;
                return instancia;
            } else {
            	// Pegando o primeiro construtor de todos os construtores da classe ProdutoControler, caso, eu n�o encontre nenhum construtor padr�o.
                Constructor<?> primeiroConstrutor = classe.getDeclaredConstructors()[0];

                // Criando uma lista vazia para representar os paramtros do construtor.
                List<Object> parametros = new ArrayList<>();
                
                // Ent�o, eu vou pegar o meu primeiro constutor e fazer um for each por cada parametro que ele tem.
                for (Parameter parametro : primeiroConstrutor.getParameters()) {
                	// Pega o tipo do parametro, ent�o pegando o exemplo do ProdutoController, vai ter um construtor
                	// com um parametro do tipo ProdutoDaoMock
                    Class<?> tipoDoParametro = parametro.getType();
                    // Instanciando o parametro com ESSA PROPRIA CLASSE KKKK.
                    // PARTE QUE PASSA A INTERFACE "PRODUTODAO" @IMPORTANTE
                    Object object = getInstancia(tipoDoParametro);
                    // Aqui eu vou adicionar o Objeto de retorno da instancia do nosso parametro, sendo que 
                    // Se o nosso parametro tamb�m n�o tiver construtor padr�o, ele entra aqui novamente.
                    parametros.add(object);
                }
                // Pegando de exemplo, o nosso ProdutoController
                // Se a gente entrar no la�o do construtor com parametro, aqui ele vai instanciar a 
                // ProdutoControler passando como parametro as instancias do seus parametros.
                return primeiroConstrutor.newInstance(parametros.toArray());
            }
        } catch (InstantiationException 
        		| IllegalAccessException
                | IllegalArgumentException 
                | InvocationTargetException e) { 
            		throw new RuntimeException(e);
        }
    }
	
	// No "<>", o ?, quer dizer qualquer coisa.
	// Depois de public, eu posso definir regras para os meus generics. Exemplo: <T, K extends T>
	// Neste caso eu estou dizendo que K(TipoDestino) tem que extender de T(tipoFonte), se n�o ele j� da erro em tempo de compila��o.
	// Obs: N�o pode usar ? para a cria��o destes tipos de regras.
	public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
		/*boolean compativel = verificaCompatibilidade2(tipoFonte, tipoDestino);

	    if (!compativel) 
	    	throw new ClassCastException("N�o � poss�vel resolver " + tipoFonte + " para " + tipoDestino);
	    else*/
	    
		mapaDeTipos.put(tipoFonte, tipoDestino);
	}
	
	// A ideia de compatibilidade � que o tipoFonte seja uma interace, ou seja, um contrato para o tipoDestino que � a implemena��o desta interface/contrato.
	private boolean verificaCompatibilidade(Class<?> tipoFonte, Class<?> tipoDestino) {
		boolean compatibilidade;
		// Verifico se tipoFonte � uma interfae
		if(tipoFonte.isInterface()) {
			// Retorno todas a interfaces que o tipoDestino implementa.
			Stream<Class<?>> interfacesDoTipoDestino = Stream.of(tipoDestino.getInterfaces());
			// Estou verificando se alguma interface que a classe do tipoDestino implementa � igual a que foi recebida no tipoFonte.
			compatibilidade = interfacesDoTipoDestino.anyMatch(interfaceImplementada ->interfaceImplementada.equals(tipoFonte));
		} else {
			// Se o tipoFnte n�o for uma interface ent�o ele � um classe.
			// Nesse cen�rio, ou ele � igual ao tipoDestino ou o tipoDestino precisa estender(extends)/herdar dele.
			compatibilidade = tipoDestino.getSuperclass().equals(tipoFonte) || tipoDestino.equals(tipoFonte);
		}
		return compatibilidade;
	}
	
	private boolean verificaCompatibilidade2(Class<?> tipoFonte, Class<?> tipoDestino) {
		// Esse m�todo tentar� converter o par�metro tipoDestino para o tipoFonte. Em caso positivo,
		// ele retornar� true, o que significa que eles s�o compat�veis; e se n�o conseguir, retornar� false
		return tipoFonte.isAssignableFrom(tipoDestino);
	}
}
