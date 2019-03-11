package com.github.siilas.cadeolanche.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.model.PedidoRequest;
import com.github.siilas.cadeolanche.model.ReciboResponse;

import reactor.core.publisher.Mono;

@Service
public class PedidoService {

	@Autowired
	private PromocaoSelectorService promocaoService;
	
	public Mono<ReciboResponse> fazerPedido(PedidoRequest pedido) {
		return Mono.just(new ReciboResponse())
			.map(r -> {
				r.somarValor(pedido.getLanche().getValor());
				pedido.getAdicionais().forEach(i -> r.somarValor(i.getValor()));
				return r;
			})
			.map(r -> {
				promocaoService.get(Promocoes.MUITA_CARNE).verificarEAplicar(pedido, r);
				promocaoService.get(Promocoes.MUITO_QUEIJO).verificarEAplicar(pedido, r);
				promocaoService.get(Promocoes.LIGHT).verificarEAplicar(pedido, r);
				return r;
			});
	}

}
