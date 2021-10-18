package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

// Dependencia de Controller
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Dependencias de Negocios
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	// Para o Spring insanciar/importar um outro objeto do seu projeto.
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	// A classe Principal, nos conseguimos pegar informações do usuario logado.
	public ModelAndView Home(Principal principal) { // Model model - Parameters
		/*
		Pedido pedido = new Pedido("Celular 1",
		// Passando um BigDecimal como parametro e arredondando para ter apenas 2 casa decimais.
		new BigDecimal(200.99).setScale(2, RoundingMode.HALF_EVEN),
		// LocalDate
		LocalDate.now(),
		"https://www.magazineluiza.com.br/celular-samsung-galaxy-a-02-s-32gb-dual-sm-a025mzkvzto/p/fcdk87d0f7/te/tcsp/",
		"https://www.havan.com.br/media/catalog/product/cache/73a52df140c4d19dbec2b6c485ea6a50/c/e/celular-smartphone-galaxy-a11-64gb-6-4-samsung_327904_1.jpg",
		"celular daora mesmo meu chapa");
		*/
		
		// Me retornar um lista deste modelo. Exemplo: Aqui eu vou retornar uma lista de pedidos.
		// Obs: Para adicionar mais pedidos a está lista, apenas coloque mais parametro de pedidos.
		// List<Pedido> pedidos = Arrays.asList(pedido, pedido, pedido);
		
		// Query query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);
		// List<Pedido> pedidosList = query.getResultList();
		
		// List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		
		// Ordenando pela tavela Hora da entrega que esta local kkkk, pela ordem decrecente.
		Sort sort = Sort.by("localDaEntrega").descending();
		
		// Paginação e ordenação de pedidos.
		PageRequest pageRequestPaginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.ENTREGUE, pageRequestPaginacao);
		
		// pedidosList.forEach(pedidoLambda -> System.out.println(pedidoLambda.getDescricao()));
		// System.out.println(pedidosList);
		// model.addAttribute("pedidos", pedidos);
		
		// Aqui eu defino o meu mmodelo, desvinculando a class Model da minha action e deixando apenas pro ModelAndView fazer isso.
		// Obs: Se esta minha pagina estiver dentro de uma pasta exemplo /usuario/home
		ModelAndView modelAndView = new ModelAndView("home");
		// Estou adicionando os dados da lista "pedidos" a pagina.
		modelAndView.addObject("pedidos", pedidos);
		
		// return "home";
		// E retornando um modelAndView
		return modelAndView;
	}
	
	/*
	// Isso é uma variavel em uma string, ou seja, quando o usuario digitar /home/batata, bate aqui por que não tem um nome definido, porém nos conseguimos resgatar
	// este valor e trabalhar em cima dele.
	@GetMapping("/{statusDoPedido}")
	// Aqui eu vou armazenar a variavel do path na variavel statusPedido
	public ModelAndView statusDoPedido(@PathVariable("statusDoPedido") String statusDoPedido) {
		// Ele vai transformar a string em um valor igual, porém enum da classe StatusPedido
		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.valueOf(statusDoPedido.toUpperCase()));
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("pedidos", pedidos);
		// Podemos adicionar mais de um atributo.
		modelAndView.addObject("statusDoPedido", statusDoPedido);
		return modelAndView;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onErro() {
		return "redirect:/home";
		// Nesse caso(com forward), o fluxo volta apenas para o Front-Controller do Spring MVC e ele chama a nova action. Enquanto o redirecionamento 
		// client-side causa uma nova requisição, o server-side continua dentro da mesma requisição HTTP.
		// Nesse exemplo, o melhor seria usar redirect, pois estamos trabalhando com uma requisição POST, seguindo a regra: "always redirect after post".
		// return "forward:/home" - Este prefixo faz um redirecionamento pelo lado do servidor.
	}
	*/
}
