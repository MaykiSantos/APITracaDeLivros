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

import br.com.mayki.APITracaDeLivros.Models.Entity.Chamado;
import br.com.mayki.APITracaDeLivros.Models.Entity.Cliente;
import br.com.mayki.APITracaDeLivros.Models.Entity.Endereco;
import br.com.mayki.APITracaDeLivros.Models.Repository.ChamadoRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.ClienteRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.EnderecoRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.ChamadoDto;
import br.com.mayki.APITracaDeLivros.Views.Dto.ClienteDto;
import br.com.mayki.APITracaDeLivros.Views.Dto.EnderecoDto;
import br.com.mayki.APITracaDeLivros.Views.Form.ClienteForm;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	ChamadoRepository chamadoRepository;
	

	public ResponseEntity<Page<ClienteDto>> listar(Pageable page, UriComponentsBuilder uriBuilder) {
		Page<Cliente> clientePage = clienteRepository.findByDeleteSoft(page, false);

		return ResponseEntity.ok(ClienteDto.paraPageDto(clientePage, uriBuilder));
	}

	public ResponseEntity<Page<ClienteDto>> listar(Pageable page, String search, UriComponentsBuilder uriBuilder) {
		Cliente c = new Cliente();
		c.setDeleteSoft(false);
		c.setNome(search);
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING);
		Page<Cliente> clientePage = clienteRepository.findAll(Example.of(c, matcher), page);
		return ResponseEntity.ok(ClienteDto.paraPageDto(clientePage, uriBuilder));
	}

	public ResponseEntity<ClienteDto> buscar(Long id, UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		try {
			Cliente c = clienteRepository.findByIdAndDeleteSoft(id, false).get();
			return ResponseEntity.ok(ClienteDto.paraDto(c, uriBuilder));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja acessar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<ClienteDto> adicionar(ClienteForm form, UriComponentsBuilder uriBuilder) {
		Cliente c = form.paraCliente(clienteRepository);
		URI uri = uriBuilder.path("/clientes/{id}").build(c.getId());
		return ResponseEntity.created(uri).body(ClienteDto.paraDto(c, uriBuilder));
	}

	@Transactional
	public ResponseEntity<ClienteDto> editar(Long id, ClienteForm form, UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		try {
			Cliente c = clienteRepository.findByIdAndDeleteSoft(id, false).get();
			form.atualizar(c);
			return ResponseEntity.ok(ClienteDto.paraDto(c, uriBuilder));
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

	public ResponseEntity<Page<EnderecoDto>> buscarPorEnderecos(Pageable page, Long id, UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		if(clienteRepository.existsByIdAndDeleteSoft(id, false)) {
			Page<Endereco> enderecoPage = enderecoRepository.findByDeleteSoftAndCliente_id(page, false, id);
			return ResponseEntity.ok(EnderecoDto.paraPageDto(enderecoPage, uriBuilder));			
		}
		throw new BuscaInvalidaException("o recuros que deseja acessar é inválido ou não existe");
	}

	public ResponseEntity<Page<ChamadoDto>> buscarPorChamados(Pageable page, Long id, UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		if(chamadoRepository.existsByIdAndDeleteSoft(id, false)) {
			Page<Chamado> enderecoPage = chamadoRepository.findByDeleteSoftAndCliente_id(page, false, id);
			return ResponseEntity.ok(ChamadoDto.paraPageDto(enderecoPage, uriBuilder));			
		}
		throw new BuscaInvalidaException("o recuros que deseja acessar é inválido ou não existe");
	}

}
