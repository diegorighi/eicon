package br.com.vaga.teste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vaga.teste.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
