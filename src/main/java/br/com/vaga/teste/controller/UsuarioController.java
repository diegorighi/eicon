package br.com.vaga.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.vaga.teste.service.ClienteService;

@Controller
@RequestMapping("cliente")
public class UsuarioController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ModelAndView cliente() {
		return new ModelAndView("cliente");
	}
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(@RequestParam("email") String email, @RequestParam("nome") String nome,
			@RequestParam("sobrenome") String sobrenome, @RequestParam("dataNascimento") String dataNascimento) {
		
		//Não tinha ideia do que colocar como premissa de um cliente
		clienteService.cadastra(email, nome, sobrenome, dataNascimento);
		
		return cliente();
	}

}
