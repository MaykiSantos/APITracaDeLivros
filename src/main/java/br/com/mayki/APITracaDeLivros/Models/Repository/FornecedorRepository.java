package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
