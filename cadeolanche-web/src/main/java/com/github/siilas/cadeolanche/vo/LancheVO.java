package com.github.siilas.cadeolanche.vo;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancheVO {

	private Long id;
	private String nome;
	private List<IngredienteVO> ingredientes;

	public List<IngredienteVO> getIngredientes() {
		if (ingredientes == null) {
			ingredientes = Collections.emptyList();
		}
		return ingredientes;
	}
	
	public Double getValor() {
		Double valor = 0.0;
		for (IngredienteVO ingrediente : getIngredientes()) {
			valor = valor + ingrediente.getValor();
		}
		return valor;
	}
	
}
