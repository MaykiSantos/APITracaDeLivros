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
	private LocalDate created_at;
	private LocalDate updated_at;
	@Column(nullable = false)
	private Boolean delete_soft;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedidoDeCompra")
	private List<PedidoProduto> pedidoProduto;
	
	public Pedido() {}
	
	public Pedido(Cliente cliente, Endereco endereco, Date dataCompra, BigDecimal valorTotal,
			StatusPedido status) {
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.endereco = endereco;
		this.dataCompra = dataCompra;
		this.status = status;
		this.created_at = LocalDate.now();
		this.delete_soft = false;
	}

	
	public List<PedidoProduto> getPedidoProduto() {
		return pedidoProduto;
	}

	public void setPedidoProduto(List<PedidoProduto> pedidoProduto) {
		this.pedidoProduto = pedidoProduto;
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
