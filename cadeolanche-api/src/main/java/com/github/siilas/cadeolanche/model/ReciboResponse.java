package com.github.siilas.cadeolanche.model;

import java.util.ArrayList;
import java.util.List;

import com.github.siilas.cadeolanche.enums.Promocoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReciboResponse {

	private Double valor;
	private List<Promocao> promocoes;
	
	public Double getValor() {
		if (valor == null) {
			valor = 0.0;
		}
		return valor;
	}
	
	public List<Promocao> getPromocoes() {
		if (promocoes == null) {
			promocoes = new ArrayList<>();
		}
		return promocoes;
	}
	
	public void somarValor(Double valor) {
		this.valor = getValor() + valor;
	}

	public void subtrairValor(Double desconto) {
		this.valor = getValor() - desconto;
	}
	
	public void adicionarPromocao(Promocoes promocao) {
		getPromocoes().add(Promocao.from(promocao));
	}
	
}
