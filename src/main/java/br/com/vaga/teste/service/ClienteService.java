package br.com.vaga.teste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vaga.teste.model.Cliente;
import br.com.vaga.teste.model.WrapperCliente;
import br.com.vaga.teste.repository.ClienteRepositoy;
import br.com.vaga.teste.utils.Utils;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositoy clienteRepository;
	
	@Autowired
	private Utils utils;
	
	public void cadastra(String email, String nome, String sobrenome, String dataNascimento) {
		if(!buscarPorEmail(email).isPresent())
			clienteRepository.save(new Cliente(email, nome, sobrenome, utils.stringToLocalDate(dataNascimento)));
	}
	
	public void insertCliente(WrapperCliente clientes) {
		clientes.getClientes().stream().forEach( cliente -> {
			if(!buscarPorEmail(cliente.getEmail()).isPresent() ) {
				clienteRepository.save(cliente);
			}
		});
	}
	
	public Iterable<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> buscarPorEmail(String email) {
		return clienteRepository.findById(email);
	}
}
