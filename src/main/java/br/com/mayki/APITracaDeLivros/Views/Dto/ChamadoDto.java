package br.com.mayki.APITracaDeLivros.Views.Dto;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Models.Entity.Chamado;
import br.com.mayki.APITracaDeLivros.Utils.MontaLinks;

public class ChamadoDto {

	private Long id;
	private Boolean atendido;
	private String titulo;
	private String descricao;
	private Long cliente;
	private LocalDate created;
	private LocalDate updated;
	private Map<String, URI> links;

	public ChamadoDto(Long id, Boolean atendido, String titulo, String descricao, Long cliente, LocalDate updated,
			LocalDate created, Map<String, URI> links) {
		this.id = id;
		this.atendido = atendido;
		this.titulo = titulo;
		this.descricao = descricao;
		this.cliente = cliente;
		this.updated = updated;
		this.created = created;
		this.links = links;
	}

	public Long getId() {
		return id;
	}

	public Boolean getAtendido() {
		return atendido;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getCliente() {
		return cliente;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public LocalDate getCreated() {
		return created;
	}

	public Map<String, URI> getLinks() {
		return links;
	}

	public static Page<ChamadoDto> paraPageDto(Page<Chamado> chamadoPage, UriComponentsBuilder uriBuilder) {
		return chamadoPage.map(c ->{
			Map<String, URI> ll = new HashMap<String, URI>();
			ll.putAll(MontaLinks.executar(uriBuilder, "cliente", "/clientes/{id}", c.getCliente().getId()));
			return new ChamadoDto(c.getId(), c.getAtendido(), c.getTitulo(), c.getDescricao(), c.getCliente().getId(),
					c.getUpdated(), c.getCreated(), ll);
		});
	}

	public static ChamadoDto paraDto(Chamado c, UriComponentsBuilder uriBuilder) {
		Map<String, URI> ll = new HashMap<String, URI>();
		ll.putAll(MontaLinks.executar(uriBuilder, "cliente", "/clientes/{id}", c.getCliente().getId()));
		return new ChamadoDto(c.getId(), c.getAtendido(), c.getTitulo(), c.getDescricao(), c.getCliente().getId(),
				c.getUpdated(), c.getCreated(), ll);
	}

}
