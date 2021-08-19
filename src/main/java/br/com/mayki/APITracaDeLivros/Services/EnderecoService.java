package br.com.mayki.APITracaDeLivros.Services;

import java.net.URI;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Models.Entity.Endereco;
import br.com.mayki.APITracaDeLivros.Models.Repository.ClienteRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.EnderecoRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.EnderecoDto;
import br.com.mayki.APITracaDeLivros.Views.Form.EnderecoForm;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	

	public ResponseEntity<Page<EnderecoDto>> listar(Pageable page, UriComponentsBuilder uriBuilder) {
		Page<Endereco> enderecoPage = enderecoRepository.findByDeleteSoft(page, false);

		return ResponseEntity.ok(EnderecoDto.paraPageDto(enderecoPage, uriBuilder));
	}

	public ResponseEntity<Page<EnderecoDto>> listar(Pageable page, String search, UriComponentsBuilder uriBuilder) {
		Endereco en = new Endereco();
		en.setDeleteSoft(false);
		en.setCidade(search);
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING);
		Page<Endereco> enderecoPage = enderecoRepository.findAll(Example.of(en, matcher), page);

		return ResponseEntity.ok(EnderecoDto.paraPageDto(enderecoPage, uriBuilder));
	}

	public ResponseEntity<EnderecoDto> buscar(Long id, UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		try {
			Endereco en = enderecoRepository.findByIdAndDeleteSoft(id, false).get();
			return ResponseEntity.ok(EnderecoDto.paraDto(en, uriBuilder));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja acessar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<EnderecoDto> adicionar( EnderecoForm form, UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		Endereco en = form.paraEndereco(enderecoRepository, clienteRepository);
		URI uri = uriBuilder.cloneBuilder().path("/enderecos/{id}").build(en.getId());
		return ResponseEntity.created(uri).body(EnderecoDto.paraDto(en, uriBuilder));
	}

	@Transactional
	public ResponseEntity<EnderecoDto> editar(Long id, @Valid EnderecoForm form, UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		try {
			Endereco en = enderecoRepository.findByIdAndDeleteSoft(id, false).get();
			form.atualizar(en, clienteRepository);
			
			return ResponseEntity.ok(EnderecoDto.paraDto(en, uriBuilder));
		} catch (BuscaInvalidaException e) {
			throw new BuscaInvalidaException("id do recuros que deseja atualizar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<?> deletSoft(Long id) throws BuscaInvalidaException {
		try {
			Endereco en = enderecoRepository.findByIdAndDeleteSoft(id, false).get();
			en.setUpdated(LocalDate.now());
			en.setDeleteSoft(true);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja deletar é inválido ou não existe");
		}
	}

}
