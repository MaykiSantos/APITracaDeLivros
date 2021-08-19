package br.com.mayki.APITracaDeLivros.Services;

import java.net.URI;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Models.Entity.Fornecedor;
import br.com.mayki.APITracaDeLivros.Models.Repository.FornecedorRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.FornecedorDto;
import br.com.mayki.APITracaDeLivros.Views.Dto.FuncionarioDto;
import br.com.mayki.APITracaDeLivros.Views.Form.FornecedorForm;

@Service
public class FornecedorService {

	@Autowired
	FornecedorRepository fornecedorRepository;
	
	public ResponseEntity<Page<FornecedorDto>> listar(Pageable page) {
		Page<Fornecedor> fornecedorPage = fornecedorRepository.findByDeleteSoft(page, false);
		return ResponseEntity.ok(FornecedorDto.paraPageDto(fornecedorPage));
	}

	public ResponseEntity<Page<FornecedorDto>> listar(Pageable page, String search) {
		Fornecedor f = new Fornecedor();
		f.setNome(search);
		f.setDeleteSoft(false);
		
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING);
		
		Page<Fornecedor> fornecedorPage = fornecedorRepository.findAll(Example.of(f, matcher), page);
		return ResponseEntity.ok(FornecedorDto.paraPageDto(fornecedorPage));
	}

	public ResponseEntity<FornecedorDto> buscar(Long id) throws BuscaInvalidaException {
		try {
			Fornecedor f = fornecedorRepository.findByIdAndDeleteSoft(id, false).get();
			return ResponseEntity.ok(FornecedorDto.paraDto(f));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja acessar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<FornecedorDto> adicionar(FornecedorForm form, UriComponentsBuilder uriBuilder) {
		Fornecedor fornecedor = form.parafornecedor(fornecedorRepository);
		URI uri = uriBuilder.path("fornecedores/{id}").build(fornecedor.getId());
		return ResponseEntity.created(uri).body(FornecedorDto.paraDto(fornecedor));
	}

	@Transactional
	public ResponseEntity<FornecedorDto> editar(Long id, FornecedorForm form) throws BuscaInvalidaException {
		try {
			Fornecedor f = fornecedorRepository.findByIdAndDeleteSoft(id, false).get();
			form.atualizar(f);
			return ResponseEntity.ok(FornecedorDto.paraDto(f));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja atualizar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<?> deletSoft(Long id) throws BuscaInvalidaException {
		try {
			Fornecedor fornecedor = fornecedorRepository.findByIdAndDeleteSoft(id, false).get();
			fornecedor.setUpdated(LocalDate.now());
			fornecedor.setDeleteSoft(true);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja deletar é inválido ou não existe");
		}
	}

}
