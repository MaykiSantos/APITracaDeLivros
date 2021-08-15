package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PedidoReposicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Funcionario funcionario;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Fornecedor fornecedor;
	@Column(nullable = false, length = 2000)
	private String descricao;
	private Date dataEntraga;
	@Column(length = 1000)
	private String obs;
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal valor;
	@Column(nullable = false)
	private LocalDate created_at;
	private LocalDate updated_at;
	@Column(nullable = false)
	private Boolean delete_soft;

	public PedidoReposicao() {
	}

	public PedidoReposicao(Funcionario funcionario, Fornecedor fornecedor, String descricao, String obs, BigDecimal valor) {
		this.funcionario = funcionario;
		this.fornecedor = fornecedor;
		this.descricao = descricao;
		this.obs = obs;
		this.valor = valor;
		this.created_at = LocalDate.now();
		this.delete_soft = false;
	}
	
	

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEntraga() {
		return dataEntraga;
	}

	public void setDataEntraga(Date dataEntraga) {
		this.dataEntraga = dataEntraga;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	public LocalDate getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDate updated_at) {
		this.updated_at = updated_at;
	}

	public Boolean getDelete_soft() {
		return delete_soft;
	}

	public void setDelete_soft(Boolean delete_soft) {
		this.delete_soft = delete_soft;
	}

}
