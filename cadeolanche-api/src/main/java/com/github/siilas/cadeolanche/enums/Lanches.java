package com.github.siilas.cadeolanche.enums;

import static com.github.siilas.cadeolanche.enums.Ingredientes.BACON;
import static com.github.siilas.cadeolanche.enums.Ingredientes.HAMBURGUER;
import static com.github.siilas.cadeolanche.enums.Ingredientes.OVO;
import static com.github.siilas.cadeolanche.enums.Ingredientes.QUEIJO;

import java.util.List;

import lombok.Getter;

@Getter
public enum Lanches {

	X_BACON(1, "X-Bacon", List.of(BACON, HAMBURGUER, QUEIJO)),
	X_BURGUER(2, "X-Burger", List.of(HAMBURGUER, QUEIJO)),
	X_EGG(3, "X-Egg", List.of(OVO, HAMBURGUER, QUEIJO)),
	X_EGG_BACON(4, "X-Egg Bacon", List.of(OVO, BACON, HAMBURGUER, QUEIJO));

	private final Integer id;
	private final String nome;
	private final List<Ingredientes> ingredientes;
	
	Lanches(Integer id, String nome, List<Ingredientes> ingredientes) {
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
	}
	
	public static Lanches getFromId(Integer id) {
		for (Lanches lanche : values()) {
			if (lanche.getId().equals(id)) {
				return lanche;
			}
		}
		return null;
	}
	
	public static List<Lanches> list() {
		return List.of(values());
	}
	
}
