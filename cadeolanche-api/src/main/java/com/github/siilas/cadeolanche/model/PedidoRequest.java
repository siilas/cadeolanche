package com.github.siilas.cadeolanche.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {

	@NotNull
	private Lanche lanche;
	private List<Ingrediente> adicionais;
	
	public List<Ingrediente> getAdicionais() {
		if (adicionais == null) {
			adicionais = new ArrayList<>();
		}
		return adicionais;
	}
	
}
