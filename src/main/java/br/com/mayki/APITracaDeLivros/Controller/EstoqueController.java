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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Services.EstoqueService;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.EstoqueDto;
import br.com.mayki.APITracaDeLivros.Views.Form.EstoqueForm;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

	@Autowired
	EstoqueService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<EstoqueDto>> listar(@PageableDefault(page = 0, size = 10, direction = Direction.ASC) Pageable page){
		return service.listar(page);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstoqueDto> buscar(@PathVariable Long id) throws BuscaInvalidaException{
		return service.buscar(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstoqueDto> adicionar(@RequestBody @Valid EstoqueForm form, UriComponentsBuilder uriBuilder){
		return service.adicionar(form, uriBuilder);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletsoft(@PathVariable Long id) throws BuscaInvalidaException{
		return service.deletSoft(id);
	}
	
}
