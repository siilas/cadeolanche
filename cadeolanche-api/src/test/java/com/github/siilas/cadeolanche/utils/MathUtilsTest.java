package com.github.siilas.cadeolanche.utils;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTest {

	@Test
	public void deveValidarACriacaoDeNovoBigDecimal() {
		BigDecimal result = MathUtils.bigDecimal(2.00);

		Assert.assertEquals(new BigDecimal("2.00"), result);
	}

	@Test
	public void deveValidarAsCasaDEcimais() {
		BigDecimal result = MathUtils.setScale(new BigDecimal(2));

		Assert.assertEquals(new BigDecimal("2.00"), result);
	}

	@Test
	public void deveValidarAMultiplicacao() {
		BigDecimal result = MathUtils.multiply(new BigDecimal("2"), new BigDecimal("2"));

		Assert.assertEquals(new BigDecimal("4.00"), result);
	}

	@Test
	public void deveValidarOValorInteiro() {
		BigDecimal result = MathUtils.intValue(2.95);

		Assert.assertEquals(new BigDecimal("2"), result);
	}

}
