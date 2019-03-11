package com.github.siilas.cadeolanche.model;

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
	private Double valor;
	
	public static Ingrediente from(Ingredientes ingrediente) {
		Ingrediente response = new Ingrediente();
		response.setId(ingrediente.getId());
		response.setNome(ingrediente.getNome());
		response.setValor(ingrediente.getValor());
		return response;
	}

}
