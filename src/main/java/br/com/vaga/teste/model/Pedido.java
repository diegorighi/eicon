package br.com.vaga.teste.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name = "Pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	private Long idPedido;
	
	@OneToMany(mappedBy="idProduto")
	private List<Produto> listaProdutos;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	@NotNull
	private BigDecimal valorPedido = BigDecimal.ZERO;
	
	public Pedido() {}
	
	public Pedido(Long idPedido, List<Produto> listaProdutos, Cliente cliente, BigDecimal valorPedido) {
		this.idPedido = idPedido;
		this.listaProdutos = listaProdutos;
		this.cliente = cliente;
		this.valorPedido = valorPedido;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}
	
	
	
}
