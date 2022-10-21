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

// Explicação com base na classe ProdutoControler que tem a classe como depdencia ProdutoDaoMock
// A Inversão de controle/Injeção de Dependencia, é feita nos construtores das classes.
public class ContainerInversaoDeControle {
	// Este tipoFonte, vai guardar por exemplo produtoDao(interface) e o tipoDestino, vai guardar por exemplo
	// a implementação desta interface, no caso o ProdutoDaoMock(class)
	private Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();
	// Aqui é a classe que tem as dependencias, não as "classes dependencias" em si. Exemplo ProdutoController e não ProdutoDaoMock
	public Object getInstancia(Class<?> classe) {
		Class<?> tipoFonte = classe;
		// Se o tipoDestino for diferente de null - ou seja, se já tivermos vinculado algum tipo de
		// destino ao tipo fonte - vamos criar uma instância do tipoDestino que já foi criado.
		Class<?> tipoDestino = mapaDeTipos.get(tipoFonte);
		if(tipoDestino != null) {
			/* Quando eu pegar o a interface e passar ela como parametro para getInstancia,
			 * no momento que eu estou verificando os parametros do construtor da ProdutoControler,
			 * eu vou executar novamente getInstancia e vou passar como parametro a interface 
			 * ProdutoDao, e quando eu vou verificar no meu mapaDeTipos, a correspondencia de
			 * ProdutoDao é ProdutoDaoMock, e então eu entro no if passando como parametro para
			 * getInstancia ProdutoDaoMock, e ai sim fazendo a injeção de dependencia que implementa
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
        // neste caso, se o construtor tiver 0 parametros então, ele sera retornado.
        Stream<Constructor<?>> construtoresSemParametrosStream = construtoresStream.filter(construtor -> construtor.getParameterCount() == 0);
        // Vou pegar o primeiro construtor sem parametro da classe.
        // Obs: O Optional é semelhate ao Stream, é um clase utilitaria para ajudar com certos fluxos.
        Optional<Constructor<?>> primeiroConstrutorDaClasseOptional = construtoresSemParametrosStream.findFirst();
        
        try {
        	// O metodo isPresent() da classe Optional, verifica se seu construtor padrão realmente existe, porque pode ter o caso de vocÊ não ter
        	// declarado nenhum construtor padrão, ou seja, sem parametros.
            if(primeiroConstrutorDaClasseOptional.isPresent()) {
            	// Pega o construtor em si, sem o Optional para fazer validações.
            	Constructor<?> construtorPadrao = primeiroConstrutorDaClasseOptional.get();
            	// Criando um instancia da minha classe ProdutoController, atraves de seu construtor padrão. 
                Object instancia = construtorPadrao.newInstance();
                // retorno a instancia da classe;
                return instancia;
            } else {
            	// Pegando o primeiro construtor de todos os construtores da classe ProdutoControler, caso, eu não encontre nenhum construtor padrão.
                Constructor<?> primeiroConstrutor = classe.getDeclaredConstructors()[0];

                // Criando uma lista vazia para representar os paramtros do construtor.
                List<Object> parametros = new ArrayList<>();
                
                // Então, eu vou pegar o meu primeiro constutor e fazer um for each por cada parametro que ele tem.
                for (Parameter parametro : primeiroConstrutor.getParameters()) {
                	// Pega o tipo do parametro, então pegando o exemplo do ProdutoController, vai ter um construtor
                	// com um parametro do tipo ProdutoDaoMock
                    Class<?> tipoDoParametro = parametro.getType();
                    // Instanciando o parametro com ESSA PROPRIA CLASSE KKKK.
                    // PARTE QUE PASSA A INTERFACE "PRODUTODAO" @IMPORTANTE
                    Object object = getInstancia(tipoDoParametro);
                    // Aqui eu vou adicionar o Objeto de retorno da instancia do nosso parametro, sendo que 
                    // Se o nosso parametro também não tiver construtor padrão, ele entra aqui novamente.
                    parametros.add(object);
                }
                // Pegando de exemplo, o nosso ProdutoController
                // Se a gente entrar no laço do construtor com parametro, aqui ele vai instanciar a 
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
	// Neste caso eu estou dizendo que K(TipoDestino) tem que extender de T(tipoFonte), se não ele já da erro em tempo de compilação.
	// Obs: Não pode usar ? para a criação destes tipos de regras.
	public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
		/*boolean compativel = verificaCompatibilidade2(tipoFonte, tipoDestino);

	    if (!compativel) 
	    	throw new ClassCastException("Não é possível resolver " + tipoFonte + " para " + tipoDestino);
	    else*/
	    
		mapaDeTipos.put(tipoFonte, tipoDestino);
	}
	
	// A ideia de compatibilidade é que o tipoFonte seja uma interace, ou seja, um contrato para o tipoDestino que é a implemenação desta interface/contrato.
	private boolean verificaCompatibilidade(Class<?> tipoFonte, Class<?> tipoDestino) {
		boolean compatibilidade;
		// Verifico se tipoFonte é uma interfae
		if(tipoFonte.isInterface()) {
			// Retorno todas a interfaces que o tipoDestino implementa.
			Stream<Class<?>> interfacesDoTipoDestino = Stream.of(tipoDestino.getInterfaces());
			// Estou verificando se alguma interface que a classe do tipoDestino implementa é igual a que foi recebida no tipoFonte.
			compatibilidade = interfacesDoTipoDestino.anyMatch(interfaceImplementada ->interfaceImplementada.equals(tipoFonte));
		} else {
			// Se o tipoFnte não for uma interface então ele é um classe.
			// Nesse cenário, ou ele é igual ao tipoDestino ou o tipoDestino precisa estender(extends)/herdar dele.
			compatibilidade = tipoDestino.getSuperclass().equals(tipoFonte) || tipoDestino.equals(tipoFonte);
		}
		return compatibilidade;
	}
	
	private boolean verificaCompatibilidade2(Class<?> tipoFonte, Class<?> tipoDestino) {
		// Esse método tentará converter o parâmetro tipoDestino para o tipoFonte. Em caso positivo,
		// ele retornará true, o que significa que eles são compatíveis; e se não conseguir, retornará false
		return tipoFonte.isAssignableFrom(tipoDestino);
	}
}
