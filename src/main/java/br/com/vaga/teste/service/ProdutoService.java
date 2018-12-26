package br.com.vaga.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vaga.teste.model.Produto;
import br.com.vaga.teste.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void cadastrar(Produto produto) {
		produtoRepository.save(produto);
	}
}
