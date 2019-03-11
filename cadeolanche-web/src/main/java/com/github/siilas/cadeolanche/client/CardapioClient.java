package com.github.siilas.cadeolanche.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.siilas.cadeolanche.vo.CardapioVO;

import feign.hystrix.FallbackFactory;

@FeignClient(url = "${cadeolanche.api.url}", path = "/cardapio", fallback = CardapioFallback.class)
public interface CardapioClient {

	@GetMapping
	CardapioVO buscarCardapio();

}

@Component
class CardapioFallback implements FallbackFactory<CardapioClient> {

	@Override
	public CardapioClient create(Throwable cause) {

		return new CardapioClient() {

			@Override
			public CardapioVO buscarCardapio() {
				CardapioVO cardapio = new CardapioVO();
				cardapio.error("Não conseguimos buscar o cardápio, por favor entre em contato conosco para recebê-lo.");
				return cardapio;
			}

		};

	}

}
