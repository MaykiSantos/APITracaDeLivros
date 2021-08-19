package br.com.mayki.APITracaDeLivros.Models.Controller;

import javax.validation.Valid;

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

import br.com.mayki.APITracaDeLivros.Services.ChamadoService;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.ChamadoDto;
import br.com.mayki.APITracaDeLivros.Views.Form.ChamadoForm;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

	@Autowired
	ChamadoService service;

	@GetMapping
	public ResponseEntity<Page<ChamadoDto>> listar(
			@PageableDefault(page = 0, size = 10, direction = Direction.ASC) Pageable page,
			UriComponentsBuilder uriBuilder) {
		return service.listar(page, uriBuilder);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ChamadoDto> buscar(@PathVariable Long id, UriComponentsBuilder uriBuilder)
			throws BuscaInvalidaException {
		return service.buscar(id, uriBuilder);
	}

	@PostMapping
	public ResponseEntity<ChamadoDto> adicionar(@RequestBody @Valid ChamadoForm form, UriComponentsBuilder uriBuilder)
			throws BuscaInvalidaException {
		return service.adicionar(form, uriBuilder);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ChamadoDto> editar(@PathVariable Long id, @RequestBody @Valid ChamadoForm form,
			UriComponentsBuilder uriBilder) throws BuscaInvalidaException {
		return service.editar(id, form, uriBilder);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletSoft(@PathVariable Long id) throws BuscaInvalidaException{
		return service.deletSoft(id);
	}
	
	
}
