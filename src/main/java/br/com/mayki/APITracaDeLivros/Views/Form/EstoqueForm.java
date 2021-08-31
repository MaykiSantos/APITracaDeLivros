package br.com.mayki.APITracaDeLivros.Views.Form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.mayki.APITracaDeLivros.Models.Entity.Estoque;
import br.com.mayki.APITracaDeLivros.Models.Repository.EstoqueRepository;

public class EstoqueForm {

	@NotNull
	private Integer corredor;
	@NotBlank @Pattern(regexp = "[a-zA-Z]{1}")
	private String prateleira;

	public EstoqueForm(Integer corredor, String prateleira) {
		super();
		this.corredor = corredor;
		this.prateleira = prateleira;
	}

	public Integer getCorredor() {
		return corredor;
	}

	public void setCorredor(Integer corredor) {
		this.corredor = corredor;
	}

	public String getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}

	public Estoque paraEstoque(EstoqueRepository estoqueRepository) {
		Estoque es = new Estoque(corredor, Character.toUpperCase(prateleira.charAt(0)));
		return estoqueRepository.save(es);
	}

}
