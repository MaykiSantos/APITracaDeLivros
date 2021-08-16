package br.com.mayki.APITracaDeLivros.Views.Dto;

import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;

public class ErroSimplesDto {

	private String descricao;

	public ErroSimplesDto(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static ErroSimplesDto montar(String e) {
		return new ErroSimplesDto(e);
	}
	
	
	
	
}
