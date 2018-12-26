package br.com.vaga.teste.model;

import java.math.BigDecimal;

public class Desconto5 implements Sales{

	@Override
	public BigDecimal darDesconto(Pedido pedido) {
		return pedido.getValorPedido().subtract(new BigDecimal(0.05));
	}
}
