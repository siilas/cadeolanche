package com.github.siilas.cadeolanche.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CardapioResponse {

	private List<Lanche> lanches;
	private List<Ingrediente> ingredientes;
	private List<Promocao> promocoes;
	
	public List<Lanche> getLanches() {
		if (lanches == null ) {
			lanches = new ArrayList<>();
		}
		return lanches;
	}

	public List<Ingrediente> getIngredientes() {
		if (ingredientes == null ) {
			ingredientes = new ArrayList<>();
		}
		return ingredientes;
	}
	
	public List<Promocao> getPromocoes() {
		if (promocoes == null ) {
			promocoes = new ArrayList<>();
		}
		return promocoes;
	}

}
