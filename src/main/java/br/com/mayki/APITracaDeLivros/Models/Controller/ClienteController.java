package br.com.mayki.APITracaDeLivros.Models.Controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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

import br.com.mayki.APITracaDeLivros.Services.ClienteService;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.ClienteDto;
import br.com.mayki.APITracaDeLivros.Views.Form.ClienteForm;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService service;

	@GetMapping
	public ResponseEntity<Page<ClienteDto>> listar(
			@PageableDefault(page = 0, size = 10, direction = Direction.ASC) Pageable page,
			@RequestParam(required = false) String search) {
		if(search == null) {
			return service.listar(page);			
		}
		return service.listar(page, search);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> buscar(@PathVariable Long id) throws BuscaInvalidaException{
		return service.buscar(id);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> adicionar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
		return service.adicionar(form, uriBuilder);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> editar(@PathVariable Long id, @RequestBody @Valid ClienteForm form) throws BuscaInvalidaException{
		return service.editar(id, form);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletSoft(@PathVariable Long id) throws BuscaInvalidaException{
		return service.deletSoft(id);
	}
}
