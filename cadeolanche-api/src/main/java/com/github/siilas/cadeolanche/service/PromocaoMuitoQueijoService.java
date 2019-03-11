package com.github.siilas.cadeolanche.service;

import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.PedidoRequest;
import com.github.siilas.cadeolanche.model.ReciboResponse;

@Service
public class PromocaoMuitoQueijoService implements PromocaoService {

	@Override
	public void verificarEAplicar(PedidoRequest pedido, ReciboResponse recibo) {
		int quantidadeQueijo = getQuantidadeQueijo(pedido);
		if (quantidadeQueijo >= 3) {
			Double desconto = getDesconto(quantidadeQueijo);
			recibo.subtrairValor(desconto);
			recibo.adicionarPromocao(Promocoes.MUITO_QUEIJO);
		}
	}

	int getQuantidadeQueijo(PedidoRequest pedido) {
		int quantidadeQueijo = 0;
		for (Ingrediente ingrediente : pedido.getLanche().getIngredientes()) {
			if (Ingredientes.QUEIJO.getId().equals(ingrediente.getId())) {
				quantidadeQueijo += 1;
			}
		}
		for (Ingrediente ingrediente : pedido.getAdicionais()) {
			if (Ingredientes.QUEIJO.getId().equals(ingrediente.getId())) {
				quantidadeQueijo += 1;
			}
		}
		return quantidadeQueijo;
	}

	Double getDesconto(int quantidadeQueijo) {
		double resultado = quantidadeQueijo / 3;
		return Double.valueOf(resultado).intValue() * Ingredientes.QUEIJO.getValor();
	}

}
