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

import br.com.mayki.APITracaDeLivros.Models.Entity.Funcionario;
import br.com.mayki.APITracaDeLivros.Models.Repository.FuncionarioRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.PerfilRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.FuncionarioDto;
import br.com.mayki.APITracaDeLivros.Views.Form.FuncionarioForm;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	@Autowired
	PerfilRepository perfilRepository;

	public ResponseEntity<Page<FuncionarioDto>> listar(Pageable page) {
		Page<Funcionario> funcionarioPage = funcionarioRepository.findByDeleteSoft(page, false);

		return ResponseEntity.ok(FuncionarioDto.paraPageDto(funcionarioPage));
	}

	public ResponseEntity<Page<FuncionarioDto>> listar(Pageable page, String search) {

		Funcionario f = new Funcionario();
		f.setNome(search);
		f.setDeleteSoft(false);
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase(true)
				.withStringMatcher(StringMatcher.CONTAINING);
		Page<Funcionario> funcionarioPage = funcionarioRepository.findAll(Example.of(f, matcher), page);

		return ResponseEntity.ok(FuncionarioDto.paraPageDto(funcionarioPage));
	}

	public ResponseEntity<FuncionarioDto> buscar(Long id) throws BuscaInvalidaException {
		try {
			Funcionario funcionario = funcionarioRepository.findByIdAndDeleteSoft(id, false).get();
			return ResponseEntity.ok(FuncionarioDto.paraDto(funcionario));

		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja acessar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<FuncionarioDto> adicionar(FuncionarioForm form, UriComponentsBuilder uriBuilder)
			throws BuscaInvalidaException {
		Funcionario funcionario = form.paraFuncionario(funcionarioRepository, perfilRepository);
		URI uri = uriBuilder.path("/funcionarios/{id}").build(funcionario.getId());
		return ResponseEntity.created(uri).body(FuncionarioDto.paraDto(funcionario));
	}

	@Transactional
	public ResponseEntity<FuncionarioDto> editar(Long id, FuncionarioForm form) throws BuscaInvalidaException {
		try {
			Funcionario funcionario = funcionarioRepository.findById(id).get();
			form.atualizar(funcionario, perfilRepository);
			return ResponseEntity.ok(FuncionarioDto.paraDto(funcionario));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja editar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<?> deletSoft(Long id) throws BuscaInvalidaException {
		try {
			Funcionario funcionario = funcionarioRepository.findByIdAndDeleteSoft(id, false).get();
			funcionario.setUpdated(LocalDate.now());
			funcionario.setDeleteSoft(true);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja deletar é inválido ou não existe");
		}
	}

}
