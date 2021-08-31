package br.com.mayki.APITracaDeLivros.Services;

import java.net.URI;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Models.Entity.Estoque;
import br.com.mayki.APITracaDeLivros.Models.Repository.EstoqueRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.EstoqueDto;
import br.com.mayki.APITracaDeLivros.Views.Form.EstoqueForm;

@Service
public class EstoqueService {

	@Autowired
	EstoqueRepository estoqueRepository;
	
	public ResponseEntity<Page<EstoqueDto>> listar(Pageable page) {
		Page<Estoque> estoquePage = estoqueRepository.findByDeleteSoft(page, false);
		return ResponseEntity.ok(EstoqueDto.paraPageDto(estoquePage));
	}

	public ResponseEntity<EstoqueDto> buscar(Long id) throws BuscaInvalidaException {
		try {
			Estoque e = estoqueRepository.findByIdAndDeleteSoft(id, false).get();
			return ResponseEntity.ok(EstoqueDto.paraDto(e));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja acessar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<EstoqueDto> adicionar(EstoqueForm form, UriComponentsBuilder uriBuilder) {
		Estoque es = form.paraEstoque(estoqueRepository);
		URI uri = uriBuilder.path("estoques/{id}").build(es.getId());
		return ResponseEntity.created(uri).body(EstoqueDto.paraDto(es));
	}

	@Transactional
	public ResponseEntity<?> deletSoft(Long id) throws BuscaInvalidaException {
		try {
			Estoque es = estoqueRepository.findByIdAndDeleteSoft(id, false).get();
			es.setUpdated(LocalDate.now());
			es.setDeleteSoft(true);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja deletar é inválido ou não existe");
		}
	}

}
