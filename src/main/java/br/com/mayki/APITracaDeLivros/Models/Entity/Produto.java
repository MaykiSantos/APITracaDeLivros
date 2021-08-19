package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 150, nullable = false)
	private String nome;
	@Column(nullable = false, length = 600)
	private String descricao;
	@Column(nullable = false, precision = 2, scale = 2)
	private BigDecimal porcentagemDesconto;
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valor;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Categoria> categoria;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Fornecedor fornecedor;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Funcionario funcionario;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Estoque estoque;
	@Column(nullable = false)
	private Boolean disponivel;
	@Column(nullable = false)
	private LocalDate created;
	private LocalDate updated;
	@Column(nullable = false)
	private Boolean deleteSoft;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private List<Imagem> imagem;

	public Produto() {
	}

	public Produto(String nome, String descricao, BigDecimal valor, BigDecimal porcentagemDesconto,
			List<Categoria> categoria, Fornecedor fornecedor, Funcionario funcionario, Estoque estoque,
			Boolean disponivel) {
		this.nome = nome;
		this.descricao = descricao;
		this.porcentagemDesconto = porcentagemDesconto;
		this.valor = valor;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
		this.funcionario = funcionario;
		this.estoque = estoque;
		this.disponivel = disponivel;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(BigDecimal porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
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

	public List<Imagem> getImagem() {
		return imagem;
	}

	public void setImagem(List<Imagem> imagem) {
		this.imagem = imagem;
	}

}
