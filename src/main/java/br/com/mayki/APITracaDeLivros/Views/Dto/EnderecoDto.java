package br.com.mayki.APITracaDeLivros.Views.Dto;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Models.Entity.Endereco;
import br.com.mayki.APITracaDeLivros.Utils.MontaLinks;

public class EnderecoDto {

	private Long id;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String cep;
	private Long cliente;
	private LocalDate created;
	private LocalDate updated;
	private Map<String, URI> links;

	public EnderecoDto(Long id, String cidade, String bairro, String rua, String numero, String cep, Long cliente,
			LocalDate created, LocalDate updated, Map<String, URI> links) {
		this.id = id;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cliente = cliente;
		this.created = created;
		this.updated = updated;
		this.links = links;
	}

	public Map<String, URI> getLinks() {
		return links;
	}

	public Long getId() {
		return id;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	public Long getCliente() {
		return cliente;
	}

	public LocalDate getCreated() {
		return created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public static Page<EnderecoDto> paraPageDto(Page<Endereco> enderecoPage, UriComponentsBuilder uriBuilder) {

		Page<EnderecoDto> pageEnderecoDto = enderecoPage.map(e -> {
			Map<String, URI> linksUteis = MontaLinks.executar(uriBuilder, "cliente", "/clientes/{id}", e.getCliente().getId());
					//Map.of("cliente", uriBuilder.cloneBuilder().path("/clientes/{id}").build(e.getCliente().getId()));
			return new EnderecoDto(e.getId(), e.getCidade(), e.getBairro(), e.getRua(), e.getNumero(), e.getCep(), e.getCliente().getId(), e.getCreated(), e.getUpdated(), linksUteis);
		});
		
		return pageEnderecoDto;
	}

	public static EnderecoDto paraDto(Endereco e, UriComponentsBuilder uriBuilder) {
		
		Map<String, URI> linksUteis = MontaLinks.executar(uriBuilder, "cliente", "/clientes/{id}", e.getCliente().getId());
		return new EnderecoDto(e.getId(), e.getCidade(), e.getBairro(), e.getRua(), e.getNumero(), e.getCep(), e.getCliente().getId(), e.getCreated(), e.getUpdated(), linksUteis);
	}

}
