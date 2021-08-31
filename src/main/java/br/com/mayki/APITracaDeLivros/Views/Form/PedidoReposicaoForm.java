package br.com.mayki.APITracaDeLivros.Views.Form;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.mayki.APITracaDeLivros.Models.Entity.Fornecedor;
import br.com.mayki.APITracaDeLivros.Models.Entity.Funcionario;
import br.com.mayki.APITracaDeLivros.Models.Entity.PedidoReposicao;
import br.com.mayki.APITracaDeLivros.Models.Repository.FornecedorRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.FuncionarioRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.PedidoReposiscaoRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;

public class PedidoReposicaoForm {

	@NotNull
	private Long fornecedorId;
	@NotBlank
	private String descricao;
	private String obs;
	@Positive
	@NotNull
	private BigDecimal valor;
	@NotNull
	private Long funcionarioId;

	public PedidoReposicaoForm(Long fornecedorId, String descricao, String obs, BigDecimal valor, Long funcionarioId) {
		this.fornecedorId = fornecedorId;
		this.descricao = descricao;
		this.obs = obs;
		this.valor = valor.setScale(2, RoundingMode.UP);
		this.funcionarioId = funcionarioId;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Long fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public PedidoReposicao paraPedidoReposicao(PedidoReposiscaoRepository pedidoReposicaoRepository,
			FornecedorRepository fornecedorRepository, FuncionarioRepository funcionarioRepository) throws BuscaInvalidaException {
		Fornecedor fornecedor = null;
		Funcionario funcionario = null;
		try {
			fornecedor = fornecedorRepository.findById(fornecedorId).get();
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("fornecedor associado a pedidos de reposicao é inválido ou não existe");
		}
		
		try {
			funcionario = funcionarioRepository.findById(funcionarioId).get();
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("funcionario associado a pedidos de reposicao é inválido ou não existe");
		}
		
		PedidoReposicao pr = new PedidoReposicao(funcionario, fornecedor, descricao, obs, valor);
		return pedidoReposicaoRepository.save(pr);
	}


}
