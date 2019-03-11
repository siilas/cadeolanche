package com.github.siilas.cadeolanche.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.siilas.cadeolanche.enums.Promocoes;
import com.github.siilas.cadeolanche.exception.ServiceException;

@Service
public class PromocaoSelectorService {

	@Autowired
	private PromocaoLightService promocaoLightService;
	
	@Autowired
	private PromocaoMuitaCarneService promocaoMuitaCarneService;
	
	@Autowired
	private PromocaoMuitoQueijoService promocaoMuitoQueijoService;
	
	public PromocaoService get(Promocoes promocao) {
		switch (promocao) {
			case LIGHT:
				return promocaoLightService;
			case MUITA_CARNE:
				return promocaoMuitaCarneService;
			case MUITO_QUEIJO:
				return promocaoMuitoQueijoService;
			default:
			    throw new ServiceException("Promoção não encontrada");
		}
	}
	
}
