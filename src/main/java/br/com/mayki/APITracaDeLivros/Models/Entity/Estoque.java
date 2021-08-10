package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Integer corredor;
	@Column(nullable = false)
	private Character prateleira;
	@Column(nullable = false)
	private LocalDate created_at;
	private LocalDate updated_at;
	@Column(nullable = false)
	private Boolean delete_soft;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "estoque")
	private Produto produto;

	public Estoque() {
	}

	public Estoque(Integer corredor, Character prateleira) {
		this.corredor = corredor;
		this.prateleira = prateleira;
		this.created_at = LocalDate.now();
		this.delete_soft = false;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCorredor() {
		return corredor;
	}

	public void setCorredor(Integer corredor) {
		this.corredor = corredor;
	}

	public Character getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(Character prateleira) {
		this.prateleira = prateleira;
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
