package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.time.LocalDate;
import java.util.Date;
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
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfil;
	@Column(nullable = false)
	private LocalDate created_at;
	private LocalDate updated_at;
	@Column(nullable = false)
	private Boolean delete_soft;
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
	private List<PedidoReposicao> pedidoreposicao;

	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, Boolean ativo, List<Perfil> perfil) {
		this.nome = nome;
		this.cpf = cpf;
		this.ativo = ativo;
		this.perfil = perfil;
		this.created_at = LocalDate.now();
		this.delete_soft = false;
	}

	public List<PedidoReposicao> getPedidoreposicao() {
		return pedidoreposicao;
	}

	public void setPedidoreposicao(List<PedidoReposicao> pedidoreposicao) {
		this.pedidoreposicao = pedidoreposicao;
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
