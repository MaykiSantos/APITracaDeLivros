package br.com.mayki.APITracaDeLivros.Models.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import br.com.mayki.APITracaDeLivros.Models.Entity.Estoque;
import br.com.mayki.APITracaDeLivros.Views.Dto.EstoqueDto;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

	Page<Estoque> findByDeleteSoft(Pageable page, boolean b);

	Optional<Estoque> findByIdAndDeleteSoft(Long id, boolean b);

}
