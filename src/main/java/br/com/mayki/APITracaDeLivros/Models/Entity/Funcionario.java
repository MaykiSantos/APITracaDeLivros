package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 14, unique = true)
	private String cpf;
	@Column(nullable = false)
	private Boolean ativo;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Perfil> perfil;
	@Column(nullable = false)
	private LocalDate created;
	private LocalDate updated;
	@Column(nullable = false)
	private Boolean deleteSoft;
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
	private List<PedidoReposicao> pedidoreposicao;

	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, Boolean ativo, List<Perfil> perfil) {
		this.nome = nome;
		this.cpf = cpf;
		this.ativo = ativo;
		this.perfil = perfil;
		this.created = LocalDate.now();
		this.deleteSoft = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfil(List<Perfil> perfil) {
		this.perfil = perfil;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDate updated) {
		this.updated = updated;
	}

	public Boolean getDeleteSoft() {
		return deleteSoft;
	}

	public void setDeleteSoft(Boolean deleteSoft) {
		this.deleteSoft = deleteSoft;
	}

	public List<PedidoReposicao> getPedidoreposicao() {
		return pedidoreposicao;
	}

	public void setPedidoreposicao(List<PedidoReposicao> pedidoreposicao) {
		this.pedidoreposicao = pedidoreposicao;
	}

}
