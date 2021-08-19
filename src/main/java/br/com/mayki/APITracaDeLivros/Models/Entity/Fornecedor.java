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
import javax.persistence.OneToMany;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 18, unique = true)
	private String cnpj;
	@Column(nullable = false, length = 15, unique = true)
	private String inscricaoEstadual;
	@Column(nullable = false, length = 60)
	private String nome;
	@Column(nullable = false, length = 60)
	private String rua;
	@Column(nullable = false, length = 60)
	private String bairro;
	@Column(nullable = false, length = 60)
	private String cidade;
	@Column(nullable = false, length = 9)
	private String cep;
	@Column(nullable = false, length = 10)
	private String numero;
	@Column(nullable = false, length = 20)
	private String telefone_01;
	@Column(length = 20)
	private String telefone_02;
	@Column(length = 20)
	private String telefone_03;
	@Column(nullable = false, length = 60)
	private String email_01;
	@Column(length = 60)
	private String email_02;
	@Column(length = 60)
	private String email_03;
	@Column(nullable = false)
	private LocalDate created;
	private LocalDate updated;
	@Column(nullable = false)
	private Boolean deleteSoft;
	@OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
	private List<Produto> produto;
	@OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
	private List<PedidoReposicao> peidoReposicao;

	public Fornecedor() {
	}

	public Fornecedor(String cnpj, String inscricaoEstadual ,String nome, String rua, String bairro, String cidade, String cep, String numero,
			String telefone_01, String telefone_02, String telefone_03, String email_01, String email_02,
			String email_03) {
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.numero = numero;
		this.telefone_01 = telefone_01;
		this.telefone_02 = telefone_02;
		this.telefone_03 = telefone_03;
		this.email_01 = email_01;
		this.email_02 = email_02;
		this.email_03 = email_03;
		this.created = LocalDate.now();
		this.deleteSoft = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getTelefone_03() {
		return telefone_03;
	}

	public void setTelefone_03(String telefone_03) {
		this.telefone_03 = telefone_03;
	}

	public String getEmail_01() {
		return email_01;
	}

	public void setEmail_01(String email_01) {
		this.email_01 = email_01;
	}

	public String getEmail_02() {
		return email_02;
	}

	public void setEmail_02(String email_02) {
		this.email_02 = email_02;
	}

	public String getEmail_03() {
		return email_03;
	}

	public void setEmail_03(String email_03) {
		this.email_03 = email_03;
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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public List<PedidoReposicao> getPeidoReposicao() {
		return peidoReposicao;
	}

	public void setPeidoReposicao(List<PedidoReposicao> peidoReposicao) {
		this.peidoReposicao = peidoReposicao;
	}

}
