package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {

}
