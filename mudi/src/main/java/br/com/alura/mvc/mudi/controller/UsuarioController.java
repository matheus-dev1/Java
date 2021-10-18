package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/pedido")
	public ModelAndView Home(Principal principal) {
		
		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		
		ModelAndView modelAndView = new ModelAndView("/usuario/home");
		modelAndView.addObject("pedidos", pedidos);
		
		return modelAndView;
	}
	
	@GetMapping("/pedido/{statusDoPedido}")
	public ModelAndView statusDoPedido(@PathVariable("statusDoPedido") String statusDoPedido, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findByStatusPedidoEUsuario(StatusPedido.valueOf(statusDoPedido.toUpperCase()), principal.getName());
		ModelAndView modelAndView = new ModelAndView("/usuario/home");
		modelAndView.addObject("pedidos", pedidos);
		modelAndView.addObject("statusDoPedido", statusDoPedido);
		return modelAndView;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onErro() {
		return "redirect:/usuario/home";
	}
	
}
