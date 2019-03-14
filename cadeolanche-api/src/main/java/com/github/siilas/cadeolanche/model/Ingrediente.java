package com.github.siilas.cadeolanche.model;

import java.math.BigDecimal;

import com.github.siilas.cadeolanche.enums.Ingredientes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {

	private Integer id;
	private String nome;
	private BigDecimal valor;

	public static Ingrediente from(Ingredientes ingrediente) {
		if (ingrediente == null) {
			return null;
		}
		Ingrediente response = new Ingrediente();
		response.setId(ingrediente.getId());
		response.setNome(ingrediente.getNome());
		response.setValor(ingrediente.getValor());
		return response;
	}

}
