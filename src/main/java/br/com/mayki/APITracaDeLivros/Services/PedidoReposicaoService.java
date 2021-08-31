package br.com.mayki.APITracaDeLivros.Services;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

import br.com.mayki.APITracaDeLivros.Models.Entity.PedidoReposicao;
import br.com.mayki.APITracaDeLivros.Models.Repository.FornecedorRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.FuncionarioRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.PedidoReposiscaoRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.DataInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.PedidoReposicaoDto;
import br.com.mayki.APITracaDeLivros.Views.Dto.TesteDto;
import br.com.mayki.APITracaDeLivros.Views.Form.PedidoReposicaoAtualizarForm;
import br.com.mayki.APITracaDeLivros.Views.Form.PedidoReposicaoForm;

@Service
public class PedidoReposicaoService {

	@Autowired
	PedidoReposiscaoRepository pedidoReposicaoRepository;
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	
	public ResponseEntity<Page<PedidoReposicaoDto>> listar(Pageable page) {
		Page<PedidoReposicao> prPage = pedidoReposicaoRepository.findByDeleteSoft(page, false);
		pedidoReposicaoRepository.carregaFuncionario(prPage.stream().collect(Collectors.toList()));
		pedidoReposicaoRepository.carregaFornecedor(prPage.stream().collect(Collectors.toList()));
		
		return ResponseEntity.ok(PedidoReposicaoDto.paraPageDto(prPage));
	}

	public ResponseEntity<Page<PedidoReposicaoDto>> listar(Pageable page, String search) {		
		Page<PedidoReposicao> pedidoReposicaoFiltrado = pedidoReposicaoRepository.findByDeleteSoftAndFornecedor_NomeLike(page, false, "%"+search+"%");
		pedidoReposicaoRepository.carregaFuncionario(pedidoReposicaoFiltrado.stream().collect(Collectors.toList()));
		pedidoReposicaoRepository.carregaFornecedor(pedidoReposicaoFiltrado.stream().collect(Collectors.toList()));
		
		return ResponseEntity.ok(PedidoReposicaoDto.paraPageDto(pedidoReposicaoFiltrado));
	}

	public ResponseEntity<PedidoReposicaoDto> buscar(Long id) throws BuscaInvalidaException {
		try {
			PedidoReposicao pr = pedidoReposicaoRepository.findById(id).get();
			return ResponseEntity.ok(PedidoReposicaoDto.paraDto(pr));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja acessar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<PedidoReposicaoDto> adicionar(PedidoReposicaoForm form,
			UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		PedidoReposicao rp = form.paraPedidoReposicao(pedidoReposicaoRepository, fornecedorRepository, funcionarioRepository);
		URI uri = uriBuilder.path("/pedidos_reposicao/{id}").build(rp.getId()); 
		return ResponseEntity.created(uri).body(PedidoReposicaoDto.paraDto(rp));
	}


	@Transactional
	public ResponseEntity<PedidoReposicaoDto> atualizar(Long id,  PedidoReposicaoAtualizarForm form) throws DataInvalidaException, BuscaInvalidaException {
		try {
			PedidoReposicao pr = pedidoReposicaoRepository.findById(id).get();
			form.atualizar(pr);
			return ResponseEntity.ok(PedidoReposicaoDto.paraDto(pr));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja atualizar é inválido ou não existe");
		}
	}

	public ResponseEntity<?> deletSoft(Long id) throws BuscaInvalidaException {
		try {
			PedidoReposicao pr = pedidoReposicaoRepository.findById(id).get();
			pr.setDeleteSoft(true);
			pr.setUpdated(LocalDate.now());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja deletar é inválido ou não existe");
		}
	}

}
