package br.com.mayki.APITracaDeLivros.Views.Dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.mayki.APITracaDeLivros.Models.Entity.Funcionario;

public class FuncionarioDto {

	private Long id;
	private String nome;
	private String cpf;
	private Boolean ativo;
	private LocalDate dataCriacao;
	private LocalDate dataAtualização;

	public FuncionarioDto(Long id, String nome, String cpf, Boolean ativo, LocalDate dataCriacao,
			LocalDate dataAtualização) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataAtualização = dataAtualização;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public LocalDate getDataAtualização() {
		return dataAtualização;
	}

	public static Page<FuncionarioDto> paraPageDto(Page<Funcionario> funcionarioPage) {
		return funcionarioPage.map(f ->
			new FuncionarioDto(f.getId(), f.getNome(), f.getCpf(), f.getAtivo(), f.getCreated_at(), f.getUpdated_at())
		);
	}

	public static FuncionarioDto paraDto(Funcionario f) {
		return new FuncionarioDto(f.getId(), f.getNome(), f.getCpf(), f.getAtivo(), f.getCreated_at(), f.getUpdated_at());
	}

}
