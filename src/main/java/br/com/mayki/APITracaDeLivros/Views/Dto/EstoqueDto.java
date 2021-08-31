package br.com.mayki.APITracaDeLivros.Views.Dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.mayki.APITracaDeLivros.Models.Entity.Estoque;

public class EstoqueDto {

	private Long id;
	private Integer corredor;
	private Character prateleira;
	private LocalDate created;
	private LocalDate updated;

	public EstoqueDto(Long id, Integer corredor, Character prateleira, LocalDate created, LocalDate updated) {
		this.id = id;
		this.corredor = corredor;
		this.prateleira = prateleira;
		this.created = created;
		this.updated = updated;
	}

	public Long getId() {
		return id;
	}

	public Integer getCorredor() {
		return corredor;
	}

	public Character getPrateleira() {
		return prateleira;
	}

	public LocalDate getCreated() {
		return created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public static Page<EstoqueDto> paraPageDto(Page<Estoque> eP) {
		return eP.map(e -> new EstoqueDto(e.getId(), e.getCorredor(), e.getPrateleira(), e.getCreated(), e.getUpdated()));
	}

	public static EstoqueDto paraDto(Estoque e) {
		return new EstoqueDto(e.getId(), e.getCorredor(), e.getPrateleira(), e.getCreated(), e.getUpdated());
	}

}
