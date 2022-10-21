package br.com.alura.mvc.mudi.mapper;

import br.com.alura.mvc.mudi.dto.PedidoDTO;
import br.com.alura.mvc.mudi.model.Pedido;

public class PedidosMapper {
	public static PedidoDTO pedidoListToPedidoListDTO(Pedido pedido) {
		PedidoDTO pedidoDTO = new PedidoDTO();
		
		pedidoDTO.setId(pedido.getId());
		pedidoDTO.setNomeDoProduto(pedido.getNomeDoProduto());
		pedidoDTO.setValorNegociado(pedido.getValorNegociado());
		pedidoDTO.setLocalDaEntrega(pedido.getLocalDaEntrega());
		pedidoDTO.setUrlProduto(pedido.getUrlProduto());
		pedidoDTO.setUrlImagem(pedido.getUrlImagem());
		pedidoDTO.setDescricao(pedido.getDescricao());
		pedidoDTO.setStatusPedido(pedido.getStatusPedido());
		pedidoDTO.setUser(pedido.getUser());
		pedidoDTO.setOfertas(pedido.getOfertas());
		
		return pedidoDTO;
	}
}
