package br.com.mayki.APITracaDeLivros.Views.Form;

import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.mayki.APITracaDeLivros.Models.Entity.Cliente;
import br.com.mayki.APITracaDeLivros.Models.Repository.ClienteRepository;

public class ClienteForm {

	@NotNull
	private Boolean ativo;
	@NotBlank
	private String nome;
	@Pattern(regexp = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}")
	private String cpf;
	@Temporal(TemporalType.DATE)
	private LocalDate dataNascimento;
	@Pattern(regexp = "[0-9a-z]+\\@[0-9a-z]+\\.com\\.br")
	private String email;
	@NotBlank
	private String senha;
	@NotBlank
	private String telefone01;
	private String telefone02;

	public ClienteForm(Boolean ativo, String nome, String cpf, LocalDate dataNascimento, String email, String senha,
			String telefone01, String telefone02) {
		this.ativo = ativo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.telefone01 = telefone01;
		this.telefone02 = telefone02;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone01() {
		return telefone01;
	}

	public void setTelefone01(String telefone01) {
		this.telefone01 = telefone01;
	}

	public String getTelefone02() {
		return telefone02;
	}

	public void setTelefone02(String telefone02) {
		this.telefone02 = telefone02;
	}

	public Cliente paraCliente(ClienteRepository clienteRepository) {
		Cliente c = new Cliente(this.nome, this.dataNascimento, this.email, this.senha, this.cpf, this.telefone01,
				this.telefone02, this.ativo);
		return clienteRepository.save(c);
	}

	public void atualizar(Cliente c) {
		c.setAtivo(ativo);
		c.setNome(nome);
		c.setCpf(cpf);
		c.setDataNascimento(dataNascimento);
		c.setEmail(email);
		c.setSenha(senha);
		c.setTelefone_01(telefone01);
		c.setTelefone_02(telefone02);
		c.setUpdated(LocalDate.now());
	}

}
