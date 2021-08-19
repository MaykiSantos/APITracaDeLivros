package br.com.mayki.APITracaDeLivros.Models.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Page<Funcionario> findByDeleteSoft(Pageable page, boolean b);

	Optional<Funcionario> findByIdAndDeleteSoft(Long id, boolean b);

}
