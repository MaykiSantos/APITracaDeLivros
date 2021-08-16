package br.com.mayki.APITracaDeLivros.Views.Form;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.mayki.APITracaDeLivros.Models.Entity.Funcionario;
import br.com.mayki.APITracaDeLivros.Models.Entity.Perfil;
import br.com.mayki.APITracaDeLivros.Models.Repository.FuncionarioRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.PerfilRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;

public class FuncionarioForm {

	@NotBlank
	private String nome;
	@Pattern(regexp = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}")
	private String cpf;
	@NotNull
	private Boolean ativo;
	@NotNull
	private List<String> perfil;
	
	public FuncionarioForm(String nome, String cpf, Boolean ativo, List<String> perfil) {
		this.nome = nome;
		this.cpf = cpf;
		this.ativo = ativo;
		this.perfil = perfil;
	}
	

	public List<String> getPerfil() {
		return perfil;
	}


	public void setPerfil(List<String> perfil) {
		this.perfil = perfil;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Funcionario paraFuncionario(FuncionarioRepository repository, PerfilRepository perfilRepository) throws BuscaInvalidaException {
		try {
			List<Perfil> pl = this.perfil.stream().map(item -> perfilRepository.findBynome(item).get()).collect(Collectors.toList());
			
			Funcionario funcionario = new Funcionario(nome, cpf, ativo, pl);
			return repository.save(funcionario);
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("valores recebidos no atributo perfil são inválidos");
		}
	}
	
	
}
