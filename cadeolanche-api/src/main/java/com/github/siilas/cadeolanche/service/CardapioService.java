package com.github.siilas.cadeolanche.service;

import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Lanches;
import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.model.CardapioResponse;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.Lanche;
import com.github.siilas.cadeolanche.model.Promocao;

import reactor.core.publisher.Mono;

@Service
public class CardapioService {

	public Mono<CardapioResponse> buscarCardapio() {
		return Mono.just(new CardapioResponse())
			.map(r -> {
				Lanches.list().forEach(l -> {
					r.getLanches().add(Lanche.from(l));
				});
				return r;
			})
			.map(r -> {
				Ingredientes.list().forEach(i -> {
					r.getIngredientes().add(Ingrediente.from(i));
				});
				return r;
			})
			.map(r -> {
				Promocoes.list().forEach(p -> {
					r.getPromocoes().add(Promocao.from(p));
				});
				return r;
			});
	}

}
