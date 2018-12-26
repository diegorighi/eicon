package br.com.vaga.teste.model;

import java.math.BigDecimal;

public interface TaxasPedido {
	
	public abstract boolean deveConterEntreUmEDezPedidosApenas(WrapperPedido pedidos);
	
	public abstract boolean numeroControleNaoExiste(Pedido pedido);
	
	public abstract void defineData(Pedido pedido);
	
	public abstract void defineQuantidade(Pedido pedido);
	
	public abstract void calcularValorTotalPedido(Pedido pedido);

}
