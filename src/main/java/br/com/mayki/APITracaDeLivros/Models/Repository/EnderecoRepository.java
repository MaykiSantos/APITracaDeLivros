package br.com.mayki.APITracaDeLivros.Models.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import br.com.mayki.APITracaDeLivros.Models.Entity.Endereco;
import br.com.mayki.APITracaDeLivros.Views.Dto.EnderecoDto;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Page<Endereco> findByDeleteSoft(Pageable page, boolean b);

	Optional<Endereco> findByIdAndDeleteSoft(Long id, boolean b);

	Page<Endereco> findByDeleteSoftAndCliente_id(Pageable page, boolean b, Long id);

}
