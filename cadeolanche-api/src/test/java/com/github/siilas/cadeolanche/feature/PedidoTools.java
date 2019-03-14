package com.github.siilas.cadeolanche.feature;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.github.siilas.cadeolanche.model.PedidoRequest;
import com.github.siilas.cadeolanche.model.ReciboResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public abstract class PedidoTools {

	@Autowired
    private RestTemplate restTemplate;
	
	protected ReciboResponse fazerPedido(PedidoRequest pedido) {
		return restTemplate.postForObject("http://localhost:8082/pedidos", pedido, ReciboResponse.class);
	}
	
}
