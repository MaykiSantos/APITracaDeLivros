package br.com.mayki.APITracaDeLivros.Models.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import br.com.mayki.APITracaDeLivros.Models.Entity.Cliente;
import br.com.mayki.APITracaDeLivros.Views.Dto.ClienteDto;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByIdAndDeleteSoft(Long cliente, boolean b);

	Page<Cliente> findByDeleteSoft(Pageable page, boolean b);

}
