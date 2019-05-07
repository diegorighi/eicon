package br.com.vaga.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vaga.teste.model.Cliente;
import br.com.vaga.teste.model.Pedido;
import br.com.vaga.teste.model.WrapperCliente;
import br.com.vaga.teste.model.WrapperPedido;
import br.com.vaga.teste.service.ClienteService;
import br.com.vaga.teste.service.PedidoService;

@RestController
@RequestMapping("webservice")
public class ExposedEndPointsForIntegration {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(path = "clientes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody Iterable<Cliente> getAllClientes(){
		return clienteService.buscarTodos();
	}
	
	@PostMapping(path = "clientes/cadastrar", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastraCliente(@RequestBody WrapperCliente clientes) {
		clienteService.insertCliente(clientes);
	}
	
	@GetMapping(path = "pedidos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody Iterable<Pedido> getAllPedidos(){
		return pedidoService.buscarTodos();
	}
	
	@PostMapping(path = "pedidos/cadastrar", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrarPedido(@RequestBody WrapperPedido pedidos) throws Exception {
		pedidoService.inserePedidos(pedidos);
	}

}
