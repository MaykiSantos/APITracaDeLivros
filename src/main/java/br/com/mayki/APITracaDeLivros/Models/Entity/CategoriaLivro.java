package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "LIVRO")
public class CategoriaLivro extends Categoria {

	public CategoriaLivro() {}

	public CategoriaLivro(String nome) {
		super(nome);
	}

}
