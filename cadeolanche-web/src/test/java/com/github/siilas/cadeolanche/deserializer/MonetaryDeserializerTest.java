package com.github.siilas.cadeolanche.deserializer;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class MonetaryDeserializerTest {

	@Test
	public void deveValidarDeserializer() {
		BigDecimal valor = new MonetaryDeserializer().getValor(2.5);
		Assert.assertEquals("2.50", valor.toString());
	}

}
