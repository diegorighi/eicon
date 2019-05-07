package br.com.vaga.teste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vaga.teste.model.Cliente;

@Repository
public interface ClienteRepositoy extends CrudRepository<Cliente, String> {
	//Olha a bruxaria do SpringData :)
}
