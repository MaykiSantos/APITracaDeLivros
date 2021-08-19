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
	private LocalDate created;
	private LocalDate updated;
	@Column(nullable = false)
	private Boolean deleteSoft;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estoque")
	private List<Produto> produto;

	public Estoque() {
	}

	public Estoque(Integer corredor, Character prateleira) {
		this.corredor = corredor;
		this.prateleira = prateleira;
		this.created = LocalDate.now();
		this.deleteSoft = false;
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

}
