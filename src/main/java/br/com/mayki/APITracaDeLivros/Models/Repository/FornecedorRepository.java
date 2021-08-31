package br.com.mayki.APITracaDeLivros.Models.Repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	Page<Fornecedor> findByDeleteSoft(Pageable page, boolean b);

	Optional<Fornecedor> findByIdAndDeleteSoft(Long id, boolean b);

	Fornecedor findByNome(String search);

	Fornecedor findByDeleteSoftAndNomeLike(boolean b, String string);



}
