package com.github.siilas.cadeolanche.enums;

import java.util.List;

import lombok.Getter;

@Getter
public enum Ingredientes {

	ALFACE(1, "Alface", 0.40),
	BACON(2, "Bacon", 2.00),
	HAMBURGUER(3, "Hambúrguer de carne", 3.00),
	OVO(4, "Ovo", 0.80),
	QUEIJO(5, "Queijo", 1.50);
	
	private final Integer id;
	private final String nome;
	private final Double valor;
	
	Ingredientes(Integer id, String nome, Double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	public static Ingredientes getFromId(Integer id) {
		for (Ingredientes ingrediente : values()) {
			if (ingrediente.getId().equals(id)) {
				return ingrediente;
			}
		}
		return null;
	}
	
	public static List<Ingredientes> list() {
		return List.of(values());
	}
	
}
