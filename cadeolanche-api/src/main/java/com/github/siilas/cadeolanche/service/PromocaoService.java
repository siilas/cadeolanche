package com.github.siilas.cadeolanche.service;

import com.github.siilas.cadeolanche.model.PedidoRequest;
import com.github.siilas.cadeolanche.model.ReciboResponse;

public interface PromocaoService {

	void verificarEAplicar(PedidoRequest pedido, ReciboResponse recibo);

}
