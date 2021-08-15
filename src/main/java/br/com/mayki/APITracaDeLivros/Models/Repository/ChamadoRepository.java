package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
