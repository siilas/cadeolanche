package com.github.siilas.cadeolanche.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.ReciboResponse;
import com.github.siilas.cadeolanche.utils.MathUtils;

@Service
public class PromocaoMuitaCarneService implements PromocaoService {

	@Override
	public void verificarEAplicar(ReciboResponse recibo) {
		int quantidadeCarne = getQuantidadeCarne(recibo);
		if (quantidadeCarne >= 3) {
			BigDecimal desconto = getDesconto(quantidadeCarne, Ingredientes.HAMBURGUER.getValor());
			recibo.somarDesconto(desconto);
			recibo.adicionarPromocao(Promocoes.MUITA_CARNE);
		}
	}
	
	Integer getQuantidadeCarne(ReciboResponse recibo) {
		int quantidadeCarne = 0;
		for (Ingrediente ingrediente : recibo.getLanche().getIngredientes()) {
			if (Ingredientes.HAMBURGUER.getId().equals(ingrediente.getId())) {
				quantidadeCarne += 1;
			}
		}
		for (Ingrediente ingrediente : recibo.getAdicionais()) {
			if (Ingredientes.HAMBURGUER.getId().equals(ingrediente.getId())) {
				quantidadeCarne += 1;
			}
		}
		return quantidadeCarne;
	}

	BigDecimal getDesconto(int quantidadeCarne, BigDecimal valor) {
		double resultado = quantidadeCarne / 3;
		return MathUtils.multiply(resultado, valor);
	}

}
