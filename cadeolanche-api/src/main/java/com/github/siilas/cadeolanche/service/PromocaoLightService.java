package com.github.siilas.cadeolanche.service;

import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.PedidoRequest;
import com.github.siilas.cadeolanche.model.ReciboResponse;

@Service
public class PromocaoLightService implements PromocaoService {

	@Override
	public void verificarEAplicar(PedidoRequest pedido, ReciboResponse recibo) {
		if (isPromocaoLight(pedido)) {
			Double desconto = getDesconto(recibo);
			recibo.subtrairValor(desconto);
			recibo.adicionarPromocao(Promocoes.LIGHT);
		}
	}

	boolean isPromocaoLight(PedidoRequest pedido) {
		boolean temAlface = false;
		boolean temBacon = false;
		for (Ingrediente ingrediente : pedido.getLanche().getIngredientes()) {
			if (Ingredientes.ALFACE.getId().equals(ingrediente.getId())) {
				temAlface = true;
			} else if (Ingredientes.BACON.getId().equals(ingrediente.getId())) {
				temBacon = true;
			}
		}
		for (Ingrediente ingrediente : pedido.getAdicionais()) {
			if (Ingredientes.ALFACE.getId().equals(ingrediente.getId())) {
				temAlface = true;
			} else if (Ingredientes.BACON.getId().equals(ingrediente.getId())) {
				temBacon = true;
			}
		}
		return temAlface && !temBacon;
	}

	Double getDesconto(ReciboResponse recibo) {
		return recibo.getValor() * 0.10;
	}

}
