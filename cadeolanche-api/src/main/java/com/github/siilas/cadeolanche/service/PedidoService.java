package com.github.siilas.cadeolanche.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Lanches;
import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.Lanche;
import com.github.siilas.cadeolanche.model.PedidoRequest;
import com.github.siilas.cadeolanche.model.ReciboResponse;

import reactor.core.publisher.Mono;

@Service
public class PedidoService {

	@Autowired
	private PromocaoSelectorService promocaoService;
	
	public Mono<ReciboResponse> fazerPedido(PedidoRequest pedido) {
		return Mono.just(new ReciboResponse())
			.map(recibo -> {
				Lanches lanche = Lanches.getFromId(pedido.getLanche().getId());
				recibo.setLanche(Lanche.from(lanche));
				pedido.getAdicionais().removeIf(Objects::isNull);
				pedido.getAdicionais().forEach(i -> {
					Ingredientes ingrediente = Ingredientes.getFromId(i.getId());
					recibo.getAdicionais().add(Ingrediente.from(ingrediente));
				});
				return recibo;
			})
			.map(recibo -> {
				recibo.somarValor(recibo.getLanche().getValor());
				recibo.getAdicionais().forEach(i -> recibo.somarValor(i.getValor()));
				return recibo;
			})
			.map(recibo -> {
				promocaoService.get(Promocoes.MUITA_CARNE).verificarEAplicar(recibo);
				promocaoService.get(Promocoes.MUITO_QUEIJO).verificarEAplicar(recibo);
				promocaoService.get(Promocoes.LIGHT).verificarEAplicar(recibo);
				return recibo;
			});
	}

}
