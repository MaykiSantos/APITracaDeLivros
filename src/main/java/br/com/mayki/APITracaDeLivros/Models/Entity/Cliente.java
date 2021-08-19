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
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false)
	private String telefone_01;
	private String telefone_02;
	@Column(nullable = false)
	private Boolean ativo;
	@Column(nullable = false)
	private LocalDate created;
	private LocalDate updated;
	@Column(nullable = false)
	private Boolean deleteSoft;
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

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public List<Chamado> getChamado() {
		return chamado;
	}

	public void setChamado(List<Chamado> chamado) {
		this.chamado = chamado;
	}

	public List<Pedido> getPedidoDeCompra() {
		return pedidoDeCompra;
	}

	public void setPedidoDeCompra(List<Pedido> pedidoDeCompra) {
		this.pedidoDeCompra = pedidoDeCompra;
	}

}
