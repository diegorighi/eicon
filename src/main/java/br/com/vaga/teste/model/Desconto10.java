package br.com.vaga.teste.model;

import java.math.BigDecimal;

public class Desconto10 implements Sales{

	@Override
	public BigDecimal darDesconto(Pedido pedido) {
		return pedido.getValorPedido().subtract(new BigDecimal(0.10));
	}
}
