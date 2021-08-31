package br.com.mayki.APITracaDeLivros.Models.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import br.com.mayki.APITracaDeLivros.Models.Entity.Chamado;
import br.com.mayki.APITracaDeLivros.Views.Dto.ChamadoDto;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

	Page<Chamado> findByDeleteSoft(Pageable page, boolean b);

	Optional<Chamado> findByIdAndDeleteSoft(Long id, boolean b);

	boolean existsByIdAndDeleteSoft(Long id, boolean b);

	Page<Chamado> findByDeleteSoftAndCliente_id(Pageable page, boolean b, Long id);

}
