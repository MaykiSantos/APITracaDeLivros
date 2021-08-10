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
	@Column(nullable = false, length = 14, unique = true)
	private String cnpj;
	@Column(nullable = false, length = 60)
	private String nome;
	@Column(nullable = false, length = 60)
	private String rua;
	@Column(nullable = false, length = 60)
	private String bairro;
	@Column(nullable = false, length = 60)
	private String cidade;
	@Column(nullable = false, length = 8)
	private String cep;
	@Column(nullable = false)
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
	private LocalDate created_at;
	private LocalDate updated_at;
	@Column(nullable = false)
	private Boolean delete_soft;
	@OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
	private List<Produto> produto;
	@OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
	private List<PedidoReposicao> peidoReposicao;

	public Fornecedor() {
	}

	public Fornecedor(String cnpj, String nome, String rua, String bairro, String cidade, String cep, String numero,
			String telefone_01, String telefone_02, String telefone_03, String email_01, String email_02,
			String email_03) {
		this.cnpj = cnpj;
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
		this.created_at = LocalDate.now();
		this.delete_soft = false;
	}

	public List<PedidoReposicao> getPeidoRposicao() {
		return peidoReposicao;
	}

	public void setPeidoRposicao(List<PedidoReposicao> peidoRposicao) {
		this.peidoReposicao = peidoRposicao;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
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
