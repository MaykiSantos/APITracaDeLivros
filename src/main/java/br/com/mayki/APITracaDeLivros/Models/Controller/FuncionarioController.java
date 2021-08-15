package br.com.mayki.APITracaDeLivros.Models.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mayki.APITracaDeLivros.Services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService service;
}
