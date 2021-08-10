package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private LocalDate dataNascimento;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String telefone_01;
	private String telefone_02;
	@Column(nullable = false)
	private Boolean ativo;
	@Column(nullable = false)
	private LocalDate created_at;
	private LocalDate updated_at;
	@Column(nullable = false)
	private Boolean delete_soft;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Endereco> endereco;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Chamado> chamado;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Pedido> pedidoDeCompra;

	public Cliente() {
	}

	public Cliente(String nome, LocalDate dataNascimento, String email, String senha, String cpf, String telefone_01,
			String telefone_02, Boolean ativo) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone_01 = telefone_01;
		this.telefone_02 = telefone_02;
		this.ativo = ativo;
		this.created_at = LocalDate.now();
		this.delete_soft = false;
	}

	public List<Pedido> getPedidoDeCompra() {
		return pedidoDeCompra;
	}

	public void setPedidoDeCompra(List<Pedido> pedidoDeCompra) {
		this.pedidoDeCompra = pedidoDeCompra;
	}

	public List<Chamado> getChamado() {
		return chamado;
	}

	public void setChamado(List<Chamado> chamado) {
		this.chamado = chamado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone_01() {
		return telefone_01;
	}

	public void setTelefone_01(String telefone_01) {
		this.telefone_01 = telefone_01;
	}

	public String getTelefone_02() {
		return telefone_02;
	}

	public void setTelefone_02(String telefone_02) {
		this.telefone_02 = telefone_02;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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
