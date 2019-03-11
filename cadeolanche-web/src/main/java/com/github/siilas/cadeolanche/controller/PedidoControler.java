package com.github.siilas.cadeolanche.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.siilas.cadeolanche.client.CardapioClient;
import com.github.siilas.cadeolanche.client.PedidoClient;
import com.github.siilas.cadeolanche.vo.PedidoVO;

@Controller
@RequestMapping("/pedido")
public class PedidoControler {

	@Autowired
	private PedidoClient pedidoClient;

	@Autowired
	private CardapioClient cardapioClient;

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("pedido/form");
		modelAndView.addObject("pedido", new PedidoVO());
		modelAndView.addObject("cardapio", cardapioClient.buscarCardapio());
		return modelAndView;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid PedidoVO pedido) {
		ModelAndView modelAndView = new ModelAndView("pedido/info");
		modelAndView.addObject("pedido", pedido);
		modelAndView.addObject("info", pedidoClient.enviarPedido(pedido));
		return modelAndView;
	}

}
