package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.CategoriaLivro;

public interface CategoriaLivroRepository extends JpaRepository<CategoriaLivro, Long> {

}
