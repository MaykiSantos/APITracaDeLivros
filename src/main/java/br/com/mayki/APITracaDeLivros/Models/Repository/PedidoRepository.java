package br.com.mayki.APITracaDeLivros.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayki.APITracaDeLivros.Models.Entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
