package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "LIVRO")
public class Livro extends Produto {

	private BigDecimal altura; // centimetros: 10.3cm
	private String autor;
	@Enumerated(EnumType.STRING)
	private TipoAcabamento acabamento;
	private String idioma;
	@Column(precision = 5, scale = 2)
	private BigDecimal largura; // centimetros: 5.3cm
	private Integer numeroPaginas;
	private String pais;
	@Column(precision = 5, scale = 2)
	private Integer peso; // gramas: 340g
	@Column(precision = 5, scale = 2)
	private BigDecimal profundidade; // centimetros: 12.3cm

	public Livro() {}


	public Livro(String nome, String descricao, BigDecimal valor, BigDecimal porcentagemDesconto,
			List<Categoria> categoria, Fornecedor fornecedor, Funcionario funcionario, Estoque estoque,
			Boolean disponivel, BigDecimal altura, String autor, TipoAcabamento acabamento, String idioma,
			BigDecimal largura, Integer numeroPaginas, String pais, Integer peso, BigDecimal profundidade) {
		super(nome, descricao, valor, porcentagemDesconto, categoria, fornecedor, funcionario, estoque, disponivel);
		this.altura = altura;
		this.autor = autor;
		this.acabamento = acabamento;
		this.idioma = idioma;
		this.largura = largura;
		this.numeroPaginas = numeroPaginas;
		this.pais = pais;
		this.peso = peso;
		this.profundidade = profundidade;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public TipoAcabamento getAcabamento() {
		return acabamento;
	}

	public void setAcabamento(TipoAcabamento acabamento) {
		this.acabamento = acabamento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public BigDecimal getLargura() {
		return largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public BigDecimal getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(BigDecimal profundidade) {
		this.profundidade = profundidade;
	}

}
