package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(precision = 6, scale = 2, nullable = false)
	private BigDecimal valorTotal;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cliente cliente;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Endereco endereco;
	@Column(nullable = false)
	private Date dataCompra;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusPedido status;
	@Column(nullable = false)
	private LocalDate created;
	private LocalDate updated;
	@Column(nullable = false)
	private Boolean deleteSoft;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedidoDeCompra")
	private List<PedidoProduto> pedidoProduto;

	public Pedido() {
	}

	public Pedido(Cliente cliente, Endereco endereco, Date dataCompra, BigDecimal valorTotal, StatusPedido status) {
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.endereco = endereco;
		this.dataCompra = dataCompra;
		this.status = status;
		this.created = LocalDate.now();
		this.deleteSoft = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
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

	public List<PedidoProduto> getPedidoProduto() {
		return pedidoProduto;
	}

	public void setPedidoProduto(List<PedidoProduto> pedidoProduto) {
		this.pedidoProduto = pedidoProduto;
	}

}
