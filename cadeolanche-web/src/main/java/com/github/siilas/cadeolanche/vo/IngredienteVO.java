package com.github.siilas.cadeolanche.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.siilas.cadeolanche.deserializer.MonetaryDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteVO {

	private Long id;
	private String nome;
	@JsonDeserialize(using = MonetaryDeserializer.class)
	private BigDecimal valor;
	
}
