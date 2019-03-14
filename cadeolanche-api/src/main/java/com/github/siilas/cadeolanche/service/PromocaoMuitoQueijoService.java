package com.github.siilas.cadeolanche.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.ReciboResponse;
import com.github.siilas.cadeolanche.utils.MathUtils;

@Service
public class PromocaoMuitoQueijoService implements PromocaoService {

	@Override
	public void verificarEAplicar(ReciboResponse recibo) {
		int quantidadeQueijo = getQuantidadeQueijo(recibo);
		if (quantidadeQueijo >= 3) {
			BigDecimal desconto = getDesconto(quantidadeQueijo, Ingredientes.QUEIJO.getValor());
			recibo.somarDesconto(desconto);
			recibo.adicionarPromocao(Promocoes.MUITO_QUEIJO);
		}
	}

	Integer getQuantidadeQueijo(ReciboResponse recibo) {
		int quantidadeQueijo = 0;
		for (Ingrediente ingrediente : recibo.getLanche().getIngredientes()) {
			if (Ingredientes.QUEIJO.getId().equals(ingrediente.getId())) {
				quantidadeQueijo += 1;
			}
		}
		for (Ingrediente ingrediente : recibo.getAdicionais()) {
			if (Ingredientes.QUEIJO.getId().equals(ingrediente.getId())) {
				quantidadeQueijo += 1;
			}
		}
		return quantidadeQueijo;
	}

	BigDecimal getDesconto(int quantidadeQueijo, BigDecimal valor) {
		double resultado = quantidadeQueijo / 3;
		return MathUtils.multiply(resultado, valor);
	}

}
