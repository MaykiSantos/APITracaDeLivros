package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.PedidoProduto;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {

}
