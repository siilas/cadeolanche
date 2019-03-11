package com.github.siilas.cadeolanche.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class FailableVO {

	private boolean error;
	private String mensagem;
	
	public void error(String mensagem) {
		this.error = true;
		this.mensagem = mensagem;
	}
	
}
