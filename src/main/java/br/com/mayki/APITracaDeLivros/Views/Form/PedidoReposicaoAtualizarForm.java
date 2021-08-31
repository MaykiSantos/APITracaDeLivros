package br.com.mayki.APITracaDeLivros.Views.Form;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import br.com.mayki.APITracaDeLivros.Models.Entity.PedidoReposicao;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.DataInvalidaException;

public class PedidoReposicaoAtualizarForm {

	@NotBlank
	private String descricao;
	private String obs;
	@Positive
	@NotNull
	private BigDecimal valor;
	@Pattern(regexp = "[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}")
	private String dataEntrega;

	public PedidoReposicaoAtualizarForm(String descricao, String obs, BigDecimal valor,
			String dataEntrega) {
		this.descricao = descricao;
		this.obs = obs;
		this.valor = valor;
		this.dataEntrega = dataEntrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}


	public void atualizar(PedidoReposicao pr) throws DataInvalidaException {
		try {
			pr.setUpdated(LocalDate.now());
			pr.setDataEntraga(LocalDate.parse(dataEntrega));
			pr.setDescricao(descricao);
			pr.setObs(obs);
			pr.setValor(valor);
		} catch (DateTimeException e) {
			throw new DataInvalidaException("Data inválida");
		}
	}
	
	

}
