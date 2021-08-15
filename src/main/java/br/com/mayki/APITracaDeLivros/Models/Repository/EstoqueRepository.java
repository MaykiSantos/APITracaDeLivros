package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
