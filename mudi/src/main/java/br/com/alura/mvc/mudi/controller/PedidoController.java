package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedidoDTO;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;

@Controller
// Aqui eu estou definindo o endpoint "/pedido" aceita qualquer verbo HTPP, GET, POST, DELETE e etc...
@RequestMapping("pedido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;

	// @GetMapping("formulario")
	// Podemos definir o metodo em que este endpoint aceita e seu mapeamento.
	@RequestMapping(method = RequestMethod.GET, value="formulario")
	// Pelo fato de estar associando o objeto RequisicaoNovoPedidoDTO para vaidações no fomulario.html, está action que chama o
	// formulario precisa receber este objeto também.
	public String formulario(RequisicaoNovoPedidoDTO requisicaoNovoPedidoDTO) {
		return "pedido/formulario";
	}
	
	// @PostMapping("novoPedido")
	@RequestMapping(method = RequestMethod.POST, value="novoPedido")
	// Eu posso passa anotações por parametro também.
	// Obs: A anoação @Valid nos retorna um valor booleano se a verificação foi true ou false em um objeto chamado BindingResult.
	public String novoPedido(@Valid RequisicaoNovoPedidoDTO requisicaoNovoPedidoDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "pedido/formulario";
		}
		
		// Usuario autenticado.
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User userAndPassword = userRepository.findByUsername(username);
		
		// Converter os dados da criação de um novo pedido para um objeto do tipo Pedido genuinamente.
		Pedido pedido = requisicaoNovoPedidoDTO.toPedido();
		new User().setUsername(username);;
		pedido.setUser(userAndPassword);
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}
