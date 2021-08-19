package br.com.mayki.APITracaDeLivros.Views.Form;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mayki.APITracaDeLivros.Models.Entity.Chamado;
import br.com.mayki.APITracaDeLivros.Models.Entity.Cliente;
import br.com.mayki.APITracaDeLivros.Models.Repository.ChamadoRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.ClienteRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;

public class ChamadoForm {

	@NotNull
	private Boolean atendido;
	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	@NotNull
	private Long cliente;

	public ChamadoForm(Boolean atendido, String titulo, String descricao, Long cliente) {
		this.atendido = atendido;
		this.titulo = titulo;
		this.descricao = descricao;
		this.cliente = cliente;
	}

	public Boolean getAtendido() {
		return atendido;
	}

	public void setAtendido(Boolean atendido) {
		this.atendido = atendido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Chamado paraChamado(ChamadoRepository chamadoRepository, ClienteRepository clienteRepository) throws BuscaInvalidaException {
		try {
			Cliente cliente = clienteRepository.findByIdAndDeleteSoft(this.cliente, false).get();
			
			Chamado c = new Chamado(this.titulo, this.descricao, this.atendido, cliente);
			return chamadoRepository.save(c);
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("cliente associado ao chamado é inválido ou não existe");
		}
	}

	public void atualizar(Chamado c, ClienteRepository clienteRepository) throws BuscaInvalidaException {
		try {
			Cliente cliente = clienteRepository.findByIdAndDeleteSoft(this.cliente, false).get();
			
			c.setAtendido(atendido);
			c.setDescricao(descricao);
			c.setTitulo(titulo);
			c.setCliente(cliente);
			c.setUpdated(LocalDate.now());
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("cliente associado ao chamado é inválido ou não existe");
		}
		
	}

}
