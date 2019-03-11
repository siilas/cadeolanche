package com.github.siilas.cadeolanche.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.siilas.cadeolanche.vo.CardapioVO;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "cardapio", url = "${cadeolanche.api.url}", path = "/cardapio", fallbackFactory = CardapioFallback.class)
public interface CardapioClient {

	@GetMapping
	CardapioVO buscarCardapio();

}

@Slf4j
@Component
class CardapioFallback implements FallbackFactory<CardapioClient> {

	@Override
	public CardapioClient create(Throwable cause) {
		log.error("Erro ao buscar cardápio", cause);
		
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
