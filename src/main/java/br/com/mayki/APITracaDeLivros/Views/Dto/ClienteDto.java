package br.com.mayki.APITracaDeLivros.Views.Dto;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Models.Entity.Cliente;
import br.com.mayki.APITracaDeLivros.Utils.MontaLinks;

public class ClienteDto {

	private Long id;
	private Boolean ativo;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String email;
	private String telefone01;
	private String telefone02;
	private LocalDate created;
	private LocalDate updated;
	private Map<String, URI> links;

	public ClienteDto(Long id, Boolean ativo, String nome, String cpf, LocalDate dataNascimento, String email,
			String telefone01, String telefone02, LocalDate created, LocalDate updated, Map<String, URI> links) {
		this.id = id;
		this.ativo = ativo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone01 = telefone01;
		this.telefone02 = telefone02;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone01() {
		return telefone01;
	}

	public String getTelefone02() {
		return telefone02;
	}

	public LocalDate getCreated() {
		return created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public static Page<ClienteDto> paraPageDto(Page<Cliente> clientePage, UriComponentsBuilder uriBuilder) {
		return clientePage.map(c -> {
			Map<String, URI> ll = new HashMap<String, URI>();
			ll.putAll(MontaLinks.executar(uriBuilder, "enderecos", "/clientes/{id}/enderecos", c.getId()));
			ll.putAll(MontaLinks.executar(uriBuilder, "chamados", "/clientes/{id}/chamados", c.getId()));

			return new ClienteDto(c.getId(), c.getAtivo(), c.getNome(), c.getCpf(), c.getDataNascimento(), c.getEmail(),
					c.getTelefone_01(), c.getTelefone_02(), c.getCreated(), c.getUpdated(), ll);
		});
	}

	public static ClienteDto paraDto(Cliente c, UriComponentsBuilder uriBuilder) {
		Map<String, URI> ll = new HashMap<String, URI>();
		ll.putAll(MontaLinks.executar(uriBuilder, "enderecos", "/clientes/{id}/enderecos", c.getId()));
		ll.putAll(MontaLinks.executar(uriBuilder, "chamados", "/clientes/{id}/chamados", c.getId()));

		return new ClienteDto(c.getId(), c.getAtivo(), c.getNome(), c.getCpf(), c.getDataNascimento(), c.getEmail(),
				c.getTelefone_01(), c.getTelefone_02(), c.getCreated(), c.getUpdated(), ll);
	}

}
