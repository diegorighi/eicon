package br.com.vaga.teste.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vaga.teste.model.Desconto10;
import br.com.vaga.teste.model.Desconto5;
import br.com.vaga.teste.model.Pedido;
import br.com.vaga.teste.model.TaxasPedido;
import br.com.vaga.teste.model.WrapperPedido;
import br.com.vaga.teste.repository.PedidoRepository;

@Service
public class PedidoService implements TaxasPedido{
	
	public boolean isOK = false;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Iterable<Pedido> buscarTodos(){
		return pedidoRepository.findAll();
	}

	public void inserePedidos(WrapperPedido pedidos) throws Exception {
		if(deveConterEntreUmEDezPedidosApenas(pedidos)) {
			pedidos.getPedidos().stream().forEach( pedido -> {
				if(numeroControleNaoExiste(pedido)) {
					//REGRAS 
					defineData(pedido);
					defineQuantidade(pedido);
					calcularValorTotalPedido(pedido);
					pedidoRepository.save(pedido);
				}
			});
		}else
			throw new Exception("Seu request não atende às especificações");
		//Ta certo, poderia ter feito uma exception melhor, mas o código ficaria
		//complexo demais para um teste
	}

	@Override
	public boolean deveConterEntreUmEDezPedidosApenas(WrapperPedido pedidos) {
		//Confesso que a mão coçou para usar reference methods
		if(pedidos.getPedidos().size() > 0 && pedidos.getPedidos().size() <= 10)
			setOK(true);
		return isOK();
	}

	@Override
	public boolean numeroControleNaoExiste(Pedido pedido) {
		if(!pedidoRepository.findById(pedido.getIdPedido()).isPresent()) 
			setOK(true);
		return isOK();
	}

	@Override
	public void defineData(Pedido pedido) {
		pedido.getListaProdutos().stream().forEach( produto -> {
			if(produto.getDataCadastro().equals(null))
				produto.setDataCadastro(LocalDate.now());
		});
	}

	@Override
	public void defineQuantidade(Pedido pedido) {
		//Assumindo que é um cliente por pedido, eles nunca se repetem
		pedido.getListaProdutos().stream().forEach( produto -> {
			
			/*
			 * Aqui o código tende a crescer. Utilizaria um Strategy para isto, mas como
			 * é apenas a título de exemplo para chamar no Postman vou deixar assim rs
			 */
			
			if(produto.getQuantidade() == 0 || produto.getQuantidade().equals(null))
				produto.setQuantidade(1);
			else if(produto.getQuantidade() > 5 && produto.getQuantidade() < 10) {
				pedido.setValorPedido(new Desconto5().darDesconto(pedido));
			}else if(produto.getQuantidade() >= 10) {
				pedido.setValorPedido(new Desconto10().darDesconto(pedido));
			}
			
		});
	}

	@Override
	public void calcularValorTotalPedido(Pedido pedido) {
		//Uso muito stream para não "sujar" a lista original
		pedido.getListaProdutos().stream().forEach( produto -> {
			pedido.setValorPedido(pedido.getValorPedido().add(produto.getValor()));
		});
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}
	
	
	
}
