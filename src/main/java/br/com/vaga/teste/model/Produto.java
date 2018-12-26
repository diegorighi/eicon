package br.com.vaga.teste.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "Produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idProduto;
	
	@ManyToOne
	@JoinColumn(name = "idPedido")
	public Pedido pedido;

	public LocalDate dataCadastro;

	@NotNull
	public String nomeProduto;

	@NotNull
	public BigDecimal valor;

	public Integer quantidade;
	
	public Produto() {}
	
	public Produto(Pedido pedido, LocalDate dataCadastro, @NotNull String nomeProduto, @NotNull BigDecimal valor,
			Integer quantidade) {
		this.pedido = pedido;
		this.dataCadastro = dataCadastro;
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.quantidade = quantidade;
	}



	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
