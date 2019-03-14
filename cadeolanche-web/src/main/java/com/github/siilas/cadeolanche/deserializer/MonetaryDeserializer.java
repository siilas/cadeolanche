package com.github.siilas.cadeolanche.deserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MonetaryDeserializer extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		return getValor(parser.getDoubleValue());
	}

	BigDecimal getValor(Double number) {
		BigDecimal valor = new BigDecimal(number);
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
