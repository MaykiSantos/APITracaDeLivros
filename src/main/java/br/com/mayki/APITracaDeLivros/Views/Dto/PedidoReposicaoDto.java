package br.com.mayki.APITracaDeLivros.Views.Dto;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Models.Entity.PedidoReposicao;
import br.com.mayki.APITracaDeLivros.Utils.MontaLinks;

public class PedidoReposicaoDto {

	private Long id;
	private String fornecedor;
	private String descricao;
	private BigDecimal valor;
	private String obs;
	private LocalDate dataEntraga;
	private String funcionario;
	private LocalDate created;
	private LocalDate updated;

	public PedidoReposicaoDto(Long id, String fornecedor, String descricao, BigDecimal valor, String obs,
			LocalDate dataEntraga, String funcionario, LocalDate created, LocalDate updated) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.descricao = descricao;
		this.valor = valor;
		this.obs = obs;
		this.dataEntraga = dataEntraga;
		this.funcionario = funcionario;
		this.created = created;
		this.updated = updated;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getObs() {
		return obs;
	}

	public LocalDate getDataEntraga() {
		return dataEntraga;
	}

	public LocalDate getCreated() {
		return created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public static Page<PedidoReposicaoDto> paraPageDto(Page<PedidoReposicao> prPage) {
		return prPage.map(pr ->  new PedidoReposicaoDto(pr.getId(), pr.getFornecedor().getNome(), pr.getDescricao(), pr.getValor(),
					pr.getObs(), pr.getDataEntraga(), pr.getFuncionario().getNome(), pr.getCreated(), pr.getUpdated()));
	}

	public static PedidoReposicaoDto paraDto(PedidoReposicao pr) {
		return new PedidoReposicaoDto(pr.getId(), pr.getFornecedor().getNome(), pr.getDescricao(), pr.getValor(),
				pr.getObs(), pr.getDataEntraga(), pr.getFuncionario().getNome(), pr.getCreated(), pr.getUpdated());
	}

}
