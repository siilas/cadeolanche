package com.github.siilas.cadeolanche.service;

import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.PedidoRequest;
import com.github.siilas.cadeolanche.model.ReciboResponse;

@Service
public class PromocaoMuitaCarneService implements PromocaoService {

	@Override
	public void verificarEAplicar(PedidoRequest pedido, ReciboResponse recibo) {
		int quantidadeCarne = getQuantidadeCarne(pedido);
		if (quantidadeCarne >= 3) {
			Double desconto = getDesconto(quantidadeCarne);
			recibo.subtrairValor(desconto);
			recibo.adicionarPromocao(Promocoes.MUITA_CARNE);
		}
	}
	
	int getQuantidadeCarne(PedidoRequest pedido) {
		int quantidadeCarne = 0;
		for (Ingrediente ingrediente : pedido.getLanche().getIngredientes()) {
			if (Ingredientes.HAMBURGUER.getId().equals(ingrediente.getId())) {
				quantidadeCarne += 1;
			}
		}
		for (Ingrediente ingrediente : pedido.getAdicionais()) {
			if (Ingredientes.HAMBURGUER.getId().equals(ingrediente.getId())) {
				quantidadeCarne += 1;
			}
		}
		return quantidadeCarne;
	}

	Double getDesconto(int quantidadeCarne) {
		double resultado = quantidadeCarne / 3;
		return Double.valueOf(resultado).intValue() * Ingredientes.HAMBURGUER.getValor();
	}

}
