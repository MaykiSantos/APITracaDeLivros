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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Categoria {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private LocalDate created_at;
	private LocalDate updated_at;
	@Column(nullable = false)
	private Boolean delete_soft;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	private List<Produto> produto;

	public Categoria() {}
	
	public Categoria(String nome) {
		this.nome = nome;
		this.created_at = LocalDate.now();
		this.delete_soft = false;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
