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

public class PromocaoMuitoQueijoServiceTest {

	private PromocaoMuitoQueijoService service = new PromocaoMuitoQueijoService();
	
	@Test
	public void deveValidarQuantidade() {
		ReciboResponse recibo = new ReciboResponse();
		recibo.setLanche(Lanche.from(Lanches.X_BURGER));
		recibo.getAdicionais().add(Ingrediente.from(Ingredientes.QUEIJO));
		
		Assert.assertEquals(Integer.valueOf(2), service.getQuantidadeQueijo(recibo));
	}
	
	@Test
	public void deveValidarDescontoComNumeroPar() {
		BigDecimal desconto = service.getDesconto(6, MathUtils.bigDecimal(1.00));
		
		Assert.assertEquals(MathUtils.bigDecimal(2.00), desconto);
	}
	
	@Test
	public void deveValidarDescontoComNumeroImpar() {
		BigDecimal desconto = service.getDesconto(7, MathUtils.bigDecimal(1.00));
		
		Assert.assertEquals(MathUtils.bigDecimal(2.00), desconto);
	}
	
}
