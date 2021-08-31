package br.com.mayki.APITracaDeLivros.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Services.FuncionarioService;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.FuncionarioDto;
import br.com.mayki.APITracaDeLivros.Views.Form.FuncionarioForm;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<FuncionarioDto>> listar(
			@PageableDefault(page = 0, size = 10, direction = Direction.ASC) Pageable page,
			@RequestParam(required = false) String search) {
		if(search == null) {
			return service.listar(page);
		}
		return service.listar(page, search);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FuncionarioDto> buscar(@PathVariable Long id) throws BuscaInvalidaException {
		return service.buscar(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FuncionarioDto> adicionar(@RequestBody @Valid FuncionarioForm form,
			UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		return service.adicionar(form, uriBuilder);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FuncionarioDto> editar(@PathVariable Long id, @RequestBody FuncionarioForm form)
			throws BuscaInvalidaException {
		return service.editar(id, form);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletSoft(@PathVariable Long id) throws BuscaInvalidaException {
		return service.deletSoft(id);
	}
}
