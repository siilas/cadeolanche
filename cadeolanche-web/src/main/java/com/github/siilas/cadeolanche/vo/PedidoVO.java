package com.github.siilas.cadeolanche.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoVO {

	private LancheVO lanche;
	private List<IngredienteVO> adicionais;

}
