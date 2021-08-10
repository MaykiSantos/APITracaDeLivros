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
	private LocalDate created_at;
	private LocalDate updated_at;
	@Column(nullable = false)
	private Boolean delete_soft;

	public PedidoProduto() {}

	public PedidoProduto(Pedido pedidoDeCompra, Produto produto, BigDecimal valorProduto) {
		this.pedidoDeCompra = pedidoDeCompra;
		this.produto = produto;
		this.valorProduto = valorProduto;
		this.dataCompra = LocalDate.now();
		this.created_at = LocalDate.now();
		this.delete_soft = false;
	}

	
	public Pedido getPedidoDeCompra() {
		return pedidoDeCompra;
	}

	public void setPedidoDeCompra(Pedido pedidoDeCompra) {
		this.pedidoDeCompra = pedidoDeCompra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
