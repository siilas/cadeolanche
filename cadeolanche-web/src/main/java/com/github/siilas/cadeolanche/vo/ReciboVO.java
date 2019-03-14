package com.github.siilas.cadeolanche.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReciboVO extends FailableVO {

	private LancheVO lanche;
	private BigDecimal valor;
	private BigDecimal desconto;
	private List<PromocaoVO> promocoes;
	private List<IngredienteVO> adicionais;

	public BigDecimal getValor() {
		if (valor == null) {
			valor = BigDecimal.ZERO;
		}
		return valor;
	}

	public BigDecimal getDesconto() {
		if (desconto == null) {
			desconto = BigDecimal.ZERO;
		}
		return desconto;
	}

	public List<PromocaoVO> getPromocoes() {
		if (promocoes == null) {
			promocoes = new ArrayList<>();
		}
		return promocoes;
	}

	public List<IngredienteVO> getAdicionais() {
		if (adicionais == null) {
			adicionais = new ArrayList<>();
		}
		return adicionais;
	}

	public BigDecimal getValorFinal() {
		return getValor().subtract(getDesconto());
	}

}
