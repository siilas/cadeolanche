package com.github.siilas.cadeolanche.vo;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
	
	
	public BigDecimal getValor() {
		BigDecimal valor = BigDecimal.ZERO;
		for (IngredienteVO ingrediente : getIngredientes()) {
			valor = valor.add(ingrediente.getValor());
		}
		return valor;
	}
	
	public String getNomesIngredientes() {
		return ingredientes.stream().map(IngredienteVO::getNome).collect(Collectors.joining(", "));
	}
	
}
