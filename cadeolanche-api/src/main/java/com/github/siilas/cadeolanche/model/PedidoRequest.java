package com.github.siilas.cadeolanche.model;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {

	private Lanche lanche;
	private List<Ingrediente> adicionais;
	
	public List<Ingrediente> getAdicionais() {
		if (adicionais == null) {
			adicionais = Collections.emptyList();
		}
		return adicionais;
	}
	
}
