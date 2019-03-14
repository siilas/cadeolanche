package com.github.siilas.cadeolanche.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.siilas.cadeolanche.model.PedidoRequest;
import com.github.siilas.cadeolanche.model.ReciboResponse;
import com.github.siilas.cadeolanche.service.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@Api
@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	@ApiOperation("Serviço que faz os pedidos")
	public Mono<ReciboResponse> fazerPedido(@Valid @RequestBody PedidoRequest pedido) {
		return pedidoService.fazerPedido(pedido);
	}
	
}
