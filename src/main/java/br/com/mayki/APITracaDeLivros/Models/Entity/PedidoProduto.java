package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PedidoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Pedido pedidoDeCompra;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Produto produto;
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valorProduto;
	@Column(nullable = false)
	private LocalDate dataCompra;
	@Column(nullable = false)
	private LocalDate created;
	private LocalDate updated;
	@Column(nullable = false)
	private Boolean deleteSoft;

	public PedidoProduto() {
	}

	public PedidoProduto(Pedido pedidoDeCompra, Produto produto, BigDecimal valorProduto) {
		this.pedidoDeCompra = pedidoDeCompra;
		this.produto = produto;
		this.valorProduto = valorProduto;
		this.dataCompra = LocalDate.now();
		this.created = LocalDate.now();
		this.deleteSoft = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedidoDeCompra() {
		return pedidoDeCompra;
	}

	public void setPedidoDeCompra(Pedido pedidoDeCompra) {
		this.pedidoDeCompra = pedidoDeCompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
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
