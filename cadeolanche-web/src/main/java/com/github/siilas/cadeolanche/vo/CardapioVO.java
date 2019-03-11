package com.github.siilas.cadeolanche.vo;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CardapioVO extends FailableVO {

	private List<LancheVO> lanches;
	private List<IngredienteVO> ingredientes;

	public List<LancheVO> getLanches() {
		if (lanches == null) {
			lanches = Collections.emptyList();
		}
		return lanches;
	}

	public List<IngredienteVO> getIngredientes() {
		if (ingredientes == null) {
			ingredientes = Collections.emptyList();
		}
		return ingredientes;
	}

}
