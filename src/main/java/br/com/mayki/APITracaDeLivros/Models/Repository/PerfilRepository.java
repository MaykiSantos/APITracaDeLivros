package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
