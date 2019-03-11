package com.github.siilas.cadeolanche.enums;

import java.util.List;

import lombok.Getter;

@Getter
public enum Promocoes {

	LIGHT(1, "Light", "Se o lanche tem alface e não tem bacon, ganha 10% de desconto."),
	MUITA_CARNE(2, "Muita carne", "A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, "
	        + "o cliente pagará 4. Assim por diante..."),
	MUITO_QUEIJO(3, "Muito queijo", "A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, "
	        + "o cliente pagará 4. Assim por diante...");
	
	private Integer id;
	private String nome;
	private String descricao;

	Promocoes(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public static List<Promocoes> list() {
		return List.of(values());
	}
	
}
