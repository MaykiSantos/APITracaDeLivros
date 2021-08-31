package br.com.mayki.APITracaDeLivros.Models.Repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.mayki.APITracaDeLivros.Models.Entity.PedidoReposicao;
import br.com.mayki.APITracaDeLivros.Views.Dto.PedidoReposicaoDto;
import br.com.mayki.APITracaDeLivros.Views.Dto.TesteDto;

public interface PedidoReposiscaoRepository extends JpaRepository<PedidoReposicao, Long> {

	@Query(value = "SELECT new br.com.mayki.APITracaDeLivros.Views.Dto.TesteDto(pr.id) FROM PedidoReposicao pr WHERE pr.id =1")
	TesteDto tatatte();
	
	@Query(value = "SELECT rp FROM PedidoReposicao rp JOIN FETCH rp.funcionario WHERE rp IN :pedidoReposicao")
	List<PedidoReposicao> carregaFuncionario(List<PedidoReposicao> pedidoReposicao);
	
	@Query(value = "SELECT rp FROM PedidoReposicao rp JOIN FETCH rp.fornecedor WHERE rp IN :pedidoReposicao")
	List<PedidoReposicao> carregaFornecedor(List<PedidoReposicao> pedidoReposicao);

	Page<PedidoReposicao> findByDeleteSoft(Pageable page, boolean b);

	Page<PedidoReposicao> findByDeleteSoftAndFornecedor_NomeLike(Pageable page, boolean b, String search);


}
