package br.com.mayki.APITracaDeLivros.Controller;

import java.util.List;

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

import br.com.mayki.APITracaDeLivros.Services.PedidoReposicaoService;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.DataInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.PedidoReposicaoDto;
import br.com.mayki.APITracaDeLivros.Views.Dto.TesteDto;
import br.com.mayki.APITracaDeLivros.Views.Form.PedidoReposicaoAtualizarForm;
import br.com.mayki.APITracaDeLivros.Views.Form.PedidoReposicaoForm;

@RestController
@RequestMapping("pedidos_reposicao")
public class PedidoReposicaoController {

	@Autowired
	PedidoReposicaoService service;

	@GetMapping
	public ResponseEntity<Page<PedidoReposicaoDto>> listar(
			@PageableDefault(page = 0, size = 10, direction = Direction.ASC) Pageable page,
			@RequestParam(required = false) String search) {
		if (search == null) {
			return service.listar(page);
		}
		return service.listar(page, search);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoReposicaoDto> buscar(@PathVariable Long id) throws BuscaInvalidaException {
		return service.buscar(id);
	}

	@PostMapping
	public ResponseEntity<PedidoReposicaoDto> adicionar(@Valid @RequestBody PedidoReposicaoForm form,
			UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		return service.adicionar(form, uriBuilder);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PedidoReposicaoDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid PedidoReposicaoAtualizarForm form) throws DataInvalidaException, BuscaInvalidaException {
		return service.atualizar(id, form);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletSoft(@PathVariable Long id) throws BuscaInvalidaException{
		return service.deletSoft(id);
	}

}
