package br.com.mayki.APITracaDeLivros.Views.Dto;

import java.time.LocalDate;


import org.springframework.data.domain.Page;

import br.com.mayki.APITracaDeLivros.Models.Entity.Fornecedor;

public class FornecedorDto {

	private long id;
	private String nome;
	private String cnpj;
	private String inscricaoEstadual;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String cep;
	private String telefone_01;
	private String telefone_02;
	private String telefone_03;
	private String email_01;
	private String email_02;
	private String email_03;
	private LocalDate created;
	private LocalDate updated;

	public FornecedorDto(Long id, String nome, String cnpj, String inscricaoEstadual, String cidade, String bairro,
			String rua, String numero, String cep, String telefone_01, String telefone_02, String telefone_03,
			String email_01, String email_02, String email_03, LocalDate created, LocalDate updated) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.telefone_01 = telefone_01;
		this.telefone_02 = telefone_02;
		this.telefone_03 = telefone_03;
		this.email_01 = email_01;
		this.email_02 = email_02;
		this.email_03 = email_03;
		this.created = created;
		this.updated = updated;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
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

	public String getTelefone_01() {
		return telefone_01;
	}

	public String getTelefone_02() {
		return telefone_02;
	}

	public String getTelefone_03() {
		return telefone_03;
	}

	public String getEmail_01() {
		return email_01;
	}

	public String getEmail_02() {
		return email_02;
	}

	public String getEmail_03() {
		return email_03;
	}

	public LocalDate getCreated() {
		return created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public static Page<FornecedorDto> paraPageDto(Page<Fornecedor> fornecedorPage) {

		return fornecedorPage.map(f -> new FornecedorDto(f.getId(), f.getNome(), f.getCnpj(), f.getInscricaoEstadual(),
				f.getCidade(), f.getBairro(), f.getRua(), f.getNumero(), f.getCep(), f.getTelefone_01(),
				f.getTelefone_02(), f.getTelefone_03(), f.getEmail_01(), f.getEmail_02(), f.getEmail_03(),
				f.getCreated(), f.getUpdated()));
	}

	public static FornecedorDto paraDto(Fornecedor f) {
		return new FornecedorDto(f.getId(), f.getNome(), f.getCnpj(), f.getInscricaoEstadual(),
				f.getCidade(), f.getBairro(), f.getRua(), f.getNumero(), f.getCep(), f.getTelefone_01(),
				f.getTelefone_02(), f.getTelefone_03(), f.getEmail_01(), f.getEmail_02(), f.getEmail_03(),
				f.getCreated(), f.getUpdated());
	}

}
