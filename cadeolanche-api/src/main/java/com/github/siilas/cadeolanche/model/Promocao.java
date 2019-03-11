package com.github.siilas.cadeolanche.model;

import com.github.siilas.cadeolanche.enums.Promocoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promocao {
	
	private String nome;
	private String descricao;
	
	public static Promocao from(Promocoes promocao) {
		Promocao response = new Promocao();
		response.setNome(promocao.getNome());
		response.setDescricao(promocao.getDescricao());
		return response;
	}

}
