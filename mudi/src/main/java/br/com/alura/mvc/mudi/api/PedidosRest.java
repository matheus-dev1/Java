package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

// È um controller que faz troca de informações via protocolo HTTP.
// Como ele é um Rest Controller ele não vai retornar para uma view e sim os dados(json) para ai sim uma view conseguir consumi-los.
@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/aguardando")
	public List<Pedido> getPedidosAguardandoOfertas() {
		Sort sort = Sort.by("id").descending();
		PageRequest pageRequestPaginacao = PageRequest.of(0, 10, sort);
		return pedidoRepository.findByStatusPedido(StatusPedido.AGUARDANDO, pageRequestPaginacao);
	}
	
}
