package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
