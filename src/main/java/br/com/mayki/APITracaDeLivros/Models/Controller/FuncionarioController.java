package br.com.mayki.APITracaDeLivros.Models.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mayki.APITracaDeLivros.Services.FuncionarioService;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.FuncionarioDto;
import br.com.mayki.APITracaDeLivros.Views.Form.FuncionarioForm;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService service;
	
	@GetMapping()
	public ResponseEntity<Page<FuncionarioDto>> listar(@PageableDefault(page = 0, size = 10, direction = Direction.ASC) Pageable page){
		return service.listar(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioDto> buscar(@PathVariable Long id) throws BuscaInvalidaException{
		return service.buscar(id);
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDto> adicionar(@RequestBody @Valid FuncionarioForm form) throws BuscaInvalidaException{
		return service.adicionar(form);
	}
}
