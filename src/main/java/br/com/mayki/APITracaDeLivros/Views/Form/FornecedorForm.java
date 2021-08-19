package br.com.mayki.APITracaDeLivros.Views.Form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.mayki.APITracaDeLivros.Models.Entity.Fornecedor;
import br.com.mayki.APITracaDeLivros.Models.Repository.FornecedorRepository;

public class FornecedorForm {

	@NotBlank
	private String nome;
	@Pattern(regexp = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")
	private String cnpj;
	@Pattern(regexp = "([0-9]{3}\\.){3}[0-9]{3}")
	private String inscricaoEstadual;
	@NotBlank
	private String cidade;
	@NotBlank
	private String bairro;
	@NotBlank
	private String rua;
	@NotBlank
	private String numero;
	@Pattern(regexp = "[0-9]{5}\\-[0-9]{3}")
	private String cep;
	@NotBlank
	private String telefone_01;
	private String telefone_02;
	private String telefone_03;
	@Pattern(regexp = "[0-9a-z]+\\@[0-9a-z]+\\.com\\.br")
	private String email_01;
	@Pattern(regexp = "([0-9a-z]+\\@[0-9a-z]+\\.com\\.br)?")
	private String email_02;
	@Pattern(regexp = "([0-9a-z]+\\@[0-9a-z]+\\.com\\.br)?")
	private String email_03;

	public FornecedorForm(String nome, String cnpj, String inscricaoEstadual, String cidade, String bairro, String rua,
			String numero, String cep, String telefone_01, String telefone_02, String telefone_03, String email_01,
			String email_02, String email_03) {
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
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone_01() {
		return telefone_01;
	}

	public void setTelefone_01(String telefone_01) {
		this.telefone_01 = telefone_01;
	}

	public String getTelefone_02() {
		return telefone_02;
	}

	public void setTelefone_02(String telefone_02) {
		this.telefone_02 = telefone_02;
	}

	public String getTelefone_03() {
		return telefone_03;
	}

	public void setTelefone_03(String telefone_03) {
		this.telefone_03 = telefone_03;
	}

	public String getEmail_01() {
		return email_01;
	}

	public void setEmail_01(String email_01) {
		this.email_01 = email_01;
	}

	public String getEmail_02() {
		return email_02;
	}

	public void setEmail_02(String email_02) {
		this.email_02 = email_02;
	}

	public String getEmail_03() {
		return email_03;
	}

	public void setEmail_03(String email_03) {
		this.email_03 = email_03;
	}

	public Fornecedor parafornecedor(FornecedorRepository fornecedorRepository) {

		Fornecedor f = new Fornecedor(cnpj, inscricaoEstadual, nome, rua, bairro, cidade, cep, numero, telefone_01,
				telefone_02, telefone_03, email_01, email_02, email_03);
		return fornecedorRepository.save(f);
	}

	public void atualizar(Fornecedor f) {
		f.setCnpj(this.cnpj);
		f.setInscricaoEstadual(this.inscricaoEstadual);
		f.setNome(this.nome);
		f.setRua(this.rua);
		f.setBairro(this.bairro);
		f.setCidade(this.cidade);
		f.setCep(this.cep);
		f.setNumero(this.numero);
		f.setTelefone_01(this.telefone_01);
		f.setTelefone_02(this.telefone_02);
		f.setTelefone_03(this.telefone_03);
		f.setEmail_01(this.email_01);
		f.setEmail_02(this.email_02);
		f.setEmail_03(this.email_03);
		f.setUpdated(LocalDate.now());
		
	}

}
