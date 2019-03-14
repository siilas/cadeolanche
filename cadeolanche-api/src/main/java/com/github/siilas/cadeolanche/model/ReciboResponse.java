package com.github.siilas.cadeolanche.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.utils.MathUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReciboResponse {

	private Lanche lanche;
	private BigDecimal valor;
	private BigDecimal desconto;
	private List<Promocao> promocoes;
	private List<Ingrediente> adicionais;
	
	public BigDecimal getValor() {
		if (valor == null) {
			valor = MathUtils.bigDecimal(0.00);
		}
		return valor;
	}
	
	public BigDecimal getDesconto() {
		if (desconto == null) {
			desconto = MathUtils.bigDecimal(0.00);
		}
		return desconto;
	}
	
	public List<Promocao> getPromocoes() {
		if (promocoes == null) {
			promocoes = new ArrayList<>();
		}
		return promocoes;
	}
	
	public List<Ingrediente> getAdicionais() {
		if (adicionais == null) {
			adicionais = new ArrayList<>();
		}
		return adicionais;
	}
	
	public BigDecimal getValorFinal() {
		return getValor().subtract(getDesconto());
	}
	
	public void somarValor(BigDecimal valor) {
		this.valor = getValor().add(valor);
	}

	public void somarDesconto(BigDecimal desconto) {
		this.desconto = getDesconto().add(desconto);
	}
	
	public void adicionarPromocao(Promocoes promocao) {
		getPromocoes().add(Promocao.from(promocao));
	}
	
}
