package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PAPELARIA")
public class Papelaria extends Produto{

	public Papelaria() {}

	public Papelaria(String nome, String descricao, BigDecimal valor, BigDecimal porcentagemDesconto,
			List<Categoria> categoria, Fornecedor fornecedor, Funcionario funcionario, Estoque estoque, Boolean disponivel) {
		super(nome, descricao, valor, porcentagemDesconto, categoria, fornecedor, funcionario, estoque, disponivel);
	}
	
	
}
