package br.com.mayki.APITracaDeLivros.Views.Dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.mayki.APITracaDeLivros.Models.Entity.Cliente;

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

	public ClienteDto(Long id, Boolean ativo, String nome, String cpf, LocalDate dataNascimento, String email,
			String telefone01, String telefone02, LocalDate created, LocalDate updated) {
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

	public static Page<ClienteDto> paraPageDto(Page<Cliente> clientePage) {
		return clientePage
				.map(c -> new ClienteDto(c.getId(), c.getAtivo(), c.getNome(), c.getCpf(), c.getDataNascimento(),
						c.getEmail(), c.getTelefone_01(), c.getTelefone_02(), c.getCreated(), c.getUpdated()));
	}

	public static ClienteDto paraDto(Cliente c) {
		return new ClienteDto(c.getId(), c.getAtivo(), c.getNome(), c.getCpf(), c.getDataNascimento(),
				c.getEmail(), c.getTelefone_01(), c.getTelefone_02(), c.getCreated(), c.getUpdated());
	}

}
