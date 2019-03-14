package com.github.siilas.cadeolanche.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.ReciboResponse;
import com.github.siilas.cadeolanche.utils.MathUtils;

@Service
public class PromocaoLightService implements PromocaoService {

	private static final BigDecimal DESCONTO = new BigDecimal(0.10);
	
	@Override
	public void verificarEAplicar(ReciboResponse recibo) {
		if (isPromocaoLight(recibo)) {
			BigDecimal desconto = getDesconto(recibo);
			recibo.somarDesconto(desconto);
			recibo.adicionarPromocao(Promocoes.LIGHT);
		}
	}

	boolean isPromocaoLight(ReciboResponse recibo) {
		boolean temAlface = false;
		boolean temBacon = false;
		for (Ingrediente ingrediente : recibo.getLanche().getIngredientes()) {
			if (Ingredientes.ALFACE.getId().equals(ingrediente.getId())) {
				temAlface = true;
			} else if (Ingredientes.BACON.getId().equals(ingrediente.getId())) {
				temBacon = true;
			}
		}
		for (Ingrediente ingrediente : recibo.getAdicionais()) {
			if (Ingredientes.ALFACE.getId().equals(ingrediente.getId())) {
				temAlface = true;
			} else if (Ingredientes.BACON.getId().equals(ingrediente.getId())) {
				temBacon = true;
			}
		}
		return temAlface && !temBacon;
	}

	BigDecimal getDesconto(ReciboResponse recibo) {
		return MathUtils.multiply(recibo.getValor(), DESCONTO);
	}

}
