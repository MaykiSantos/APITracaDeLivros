package br.com.mayki.APITracaDeLivros.Models.Entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CAT-PAPELARIA")
public class CategoriaPapelaria extends Categoria {

	public CategoriaPapelaria() {}

	public CategoriaPapelaria(String nome) {
		super(nome);
	}

}
