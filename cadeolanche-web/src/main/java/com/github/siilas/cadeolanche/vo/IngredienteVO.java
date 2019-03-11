package com.github.siilas.cadeolanche.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteVO {

	private Long id;
	private String nome;
	private Double valor;
	
}
