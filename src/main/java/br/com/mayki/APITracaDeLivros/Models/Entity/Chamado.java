package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String titulo;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private Boolean atendido;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cliente cliente;
	@Column(nullable = false)
	private LocalDate created;
	private LocalDate updated;
	@Column(nullable = false)
	private Boolean deleteSoft;

	public Chamado() {
	}

	public Chamado(String titulo, String descricao, Boolean atendido, Cliente cliente) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.atendido = atendido;
		this.cliente = cliente;
		this.created = LocalDate.now();
		this.deleteSoft = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtendido() {
		return atendido;
	}

	public void setAtendido(Boolean atendido) {
		this.atendido = atendido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

}
