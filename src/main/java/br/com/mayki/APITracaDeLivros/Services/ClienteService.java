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

import br.com.mayki.APITracaDeLivros.Models.Entity.Cliente;
import br.com.mayki.APITracaDeLivros.Models.Repository.ClienteRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.ClienteDto;
import br.com.mayki.APITracaDeLivros.Views.Form.ClienteForm;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ResponseEntity<Page<ClienteDto>> listar(Pageable page) {
		Page<Cliente> clientePage = clienteRepository.findByDeleteSoft(page, false);

		return ResponseEntity.ok(ClienteDto.paraPageDto(clientePage));
	}

	public ResponseEntity<Page<ClienteDto>> listar(Pageable page, String search) {
		Cliente c = new Cliente();
		c.setDeleteSoft(false);
		c.setNome(search);
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING);
		Page<Cliente> clientePage = clienteRepository.findAll(Example.of(c, matcher), page);
		return ResponseEntity.ok(ClienteDto.paraPageDto(clientePage));
	}

	public ResponseEntity<ClienteDto> buscar(Long id) throws BuscaInvalidaException {
		try {
			Cliente c = clienteRepository.findByIdAndDeleteSoft(id, false).get();
			return ResponseEntity.ok(ClienteDto.paraDto(c));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja acessar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<ClienteDto> adicionar(ClienteForm form, UriComponentsBuilder uriBuilder) {
		Cliente c = form.paraCliente(clienteRepository);
		URI uri = uriBuilder.path("/clientes/{id}").build(c.getId());
		return ResponseEntity.created(uri).body(ClienteDto.paraDto(c));
	}

	@Transactional
	public ResponseEntity<ClienteDto> editar(Long id, ClienteForm form) throws BuscaInvalidaException {
		try {
			Cliente c = clienteRepository.findByIdAndDeleteSoft(id, false).get();
			form.atualizar(c);
			return ResponseEntity.ok(ClienteDto.paraDto(c));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja atualizar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<?> deletSoft(Long id) throws BuscaInvalidaException {
		try {
			Cliente c = clienteRepository.findByIdAndDeleteSoft(id, false).get();
			c.setUpdated(LocalDate.now());
			c.setDeleteSoft(true);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja deletar é inválido ou não existe");
		}
	}

}
