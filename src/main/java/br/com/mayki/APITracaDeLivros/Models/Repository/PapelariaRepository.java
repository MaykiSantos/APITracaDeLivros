package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Papelaria;

public interface PapelariaRepository extends JpaRepository<Papelaria, Long> {

}
