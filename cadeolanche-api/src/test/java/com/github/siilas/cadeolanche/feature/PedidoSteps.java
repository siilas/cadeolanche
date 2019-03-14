package com.github.siilas.cadeolanche.feature;

import org.junit.Assert;

import com.github.siilas.cadeolanche.enums.Ingredientes;
import com.github.siilas.cadeolanche.enums.Lanches;
import com.github.siilas.cadeolanche.model.Ingrediente;
import com.github.siilas.cadeolanche.model.Lanche;
import com.github.siilas.cadeolanche.model.PedidoRequest;
import com.github.siilas.cadeolanche.model.ReciboResponse;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;

public class PedidoSteps extends PedidoTools {

	private PedidoRequest pedido = new PedidoRequest();

	@Dado("que o usuário peça o lanche {string}")
	public void dadoQueOUsuarioPecaOLanche(String valor) {
		Lanches lanche = Lanches.valueOf(valor);
		Assert.assertNotNull(lanche);
		pedido.setLanche(Lanche.from(lanche));
	}

	@E("adicione o ingrediente {string}")
	public void eAdicioneOIngrediente(String valor) {
		Ingredientes ingrediente = Ingredientes.valueOf(valor);
		Assert.assertNotNull(ingrediente);
		pedido.getAdicionais().add(Ingrediente.from(ingrediente));
	}

	@Então("o recibo deve vir sem promoções")
	public void entaoOReciboDeveVirSemPromocoes() {
		ReciboResponse recibo = fazerPedido(pedido);
		Assert.assertTrue(recibo.getPromocoes().isEmpty());
	}

	@Então("o recibo deve vir com a promoção {string}")
	public void entaoOReciboDeveVirComAPromocao(String nome) {
		ReciboResponse recibo = fazerPedido(pedido);
		Assert.assertEquals(nome, recibo.getPromocoes().get(0).getNome());
	}

}
