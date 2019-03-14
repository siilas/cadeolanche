package com.github.siilas.cadeolanche.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.github.siilas.cadeolanche.enums.Lanches;
import com.github.siilas.cadeolanche.utils.MathUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lanche {

	private Integer id;
	private String nome;
	private List<Ingrediente> ingredientes;

	public List<Ingrediente> getIngredientes() {
		if (ingredientes == null) {
			ingredientes = new ArrayList<>();
		}
		return ingredientes;
	}

	public BigDecimal getValor() {
		BigDecimal valor = MathUtils.bigDecimal(0.00);
		for (Ingrediente ingrediente : getIngredientes()) {
			valor = valor.add(ingrediente.getValor());
		}
		return valor;
	}

	public static Lanche from(Lanches lanche) {
		Lanche response = new Lanche();
		response.setId(lanche.getId());
		response.setNome(lanche.getNome());
		lanche.getIngredientes().forEach(i -> {
			response.getIngredientes().add(Ingrediente.from(i));
		});
		return response;
	}

}
