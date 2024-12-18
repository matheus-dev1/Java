package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOfertaDTO;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	// Este parametro vai vir do corpo da requisição
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOfertaDTO requisicaoNovaOferta) {
		
		// O ojbeto pode vir ou não a ser null!
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicaoNovaOferta.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		Pedido pedido = pedidoBuscado.get();
		
		Oferta novaOferta = requisicaoNovaOferta.toOferta();
		novaOferta.setPedido(pedido);
		pedido.getOfertas().add(novaOferta);
		pedidoRepository.save(pedido);
		
		return novaOferta;
	}
}
