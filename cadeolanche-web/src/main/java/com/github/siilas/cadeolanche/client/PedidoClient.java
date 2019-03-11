package com.github.siilas.cadeolanche.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.siilas.cadeolanche.vo.PedidoVO;
import com.github.siilas.cadeolanche.vo.ReciboVO;

import feign.hystrix.FallbackFactory;

@FeignClient(url = "${cadeolanche.api.url}", path = "/pedido", fallback = PedidoFallback.class)
public interface PedidoClient {

	@PostMapping
	ReciboVO enviarPedido(PedidoVO pedido);

}

@Component
class PedidoFallback implements FallbackFactory<PedidoClient> {

	@Override
	public PedidoClient create(Throwable cause) {

		return new PedidoClient() {

			@Override
			public ReciboVO enviarPedido(PedidoVO pedido) {
				ReciboVO recibo = new ReciboVO();
				recibo.error("Seu pedido não pode ser concluído, por favor entre em contato conosco para finalizá-lo.");
				return recibo;
			}

		};

	}

}
