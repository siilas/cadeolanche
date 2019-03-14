package com.github.siilas.cadeolanche.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Lanches;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.Lanche;
import com.github.siilas.cadeolanche.model.ReciboResponse;
import com.github.siilas.cadeolanche.utils.MathUtils;

public class PromocaoLightServiceTest {

	private PromocaoLightService service = new PromocaoLightService();

	@Test
	public void deveValidarOAlfaceAdicionalNaPromocaoLight() {
		ReciboResponse recibo = new ReciboResponse();
		recibo.setLanche(Lanche.from(Lanches.X_BURGER));
		recibo.getAdicionais().add(Ingrediente.from(Ingredientes.ALFACE));

		Assert.assertTrue(service.isPromocaoLight(recibo));
	}

	@Test
	public void deveValidarOXBaconForaDaPromocaoLight() {
		ReciboResponse recibo = new ReciboResponse();
		recibo.setLanche(Lanche.from(Lanches.X_BACON));

		Assert.assertFalse(service.isPromocaoLight(recibo));
	}

	@Test
	public void deveValidarODesconto() {
		ReciboResponse recibo = new ReciboResponse();
		recibo.setValor(BigDecimal.TEN);
		BigDecimal desconto = service.getDesconto(recibo);

		Assert.assertEquals(MathUtils.setScale(BigDecimal.ONE), desconto);
	}

}
