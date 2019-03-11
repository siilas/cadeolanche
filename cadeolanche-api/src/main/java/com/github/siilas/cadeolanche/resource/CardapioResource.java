package com.github.siilas.cadeolanche.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.siilas.cadeolanche.model.CardapioResponse;
import com.github.siilas.cadeolanche.service.CardapioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@Api
@RestController
@RequestMapping("/cardapio")
public class CardapioResource {

	@Autowired
	private CardapioService cardapioService;
	
	@GetMapping
	@ApiOperation("Serviço que busca o cardápio")
	public Mono<CardapioResponse> buscarCardapio() {
		return cardapioService.buscarCardapio();
	}
	
}
