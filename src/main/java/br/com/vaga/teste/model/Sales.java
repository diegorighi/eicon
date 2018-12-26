package br.com.vaga.teste.model;

import java.math.BigDecimal;

public interface Sales {

	public abstract BigDecimal darDesconto(Pedido pedido);
	
}
