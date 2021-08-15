package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
