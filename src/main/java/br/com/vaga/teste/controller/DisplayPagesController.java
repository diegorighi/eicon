package br.com.vaga.teste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DisplayPagesController {

	//Aqui é uma classe que escrevi para facilitar a criação das Entities
	
	@GetMapping
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
}
