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

import br.com.mayki.APITracaDeLivros.Services.FornecedorService;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.FornecedorDto;
import br.com.mayki.APITracaDeLivros.Views.Form.FornecedorForm;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController{
	
	@Autowired
	FornecedorService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<FornecedorDto>> listar(@PageableDefault(page = 0, size = 10, direction = Direction.ASC) Pageable page, @RequestParam(required = false) String search){
		if(search == null) {
			return service.listar(page);
		}
		return service.listar(page, search);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FornecedorDto> buscar(@PathVariable Long id) throws BuscaInvalidaException{
		return service.buscar(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FornecedorDto> adicionar(@RequestBody @Valid FornecedorForm form, UriComponentsBuilder uriBuilder){
		return service.adicionar(form, uriBuilder);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FornecedorDto> editar(@PathVariable Long id, @RequestBody @Valid FornecedorForm form) throws BuscaInvalidaException{
		return service.editar(id, form);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletSoft(@PathVariable Long id) throws BuscaInvalidaException{
		return service.deletSoft(id);
	}
	

}
