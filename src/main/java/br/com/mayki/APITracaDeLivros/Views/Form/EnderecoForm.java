package br.com.mayki.APITracaDeLivros.Views.Form;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.mayki.APITracaDeLivros.Models.Entity.Cliente;
import br.com.mayki.APITracaDeLivros.Models.Entity.Endereco;
import br.com.mayki.APITracaDeLivros.Models.Repository.ClienteRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.EnderecoRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;

public class EnderecoForm {

	@NotBlank
	private String cidade;
	@NotBlank
	private String bairro;
	@NotBlank
	private String rua;
	@NotBlank
	private String numero;
	@Pattern(regexp = "[0-9]{5}\\-[0-9]{3}")
	private String cep;
	@NotNull
	private Long cliente;

	public EnderecoForm(String cidade, String bairro, String rua, String numero, String cep, Long cliente) {
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cliente = cliente;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Endereco paraEndereco(EnderecoRepository enderecoRepository, ClienteRepository clienteRepository) throws BuscaInvalidaException {
		try {
			Cliente cliente = clienteRepository.findByIdAndDeleteSoft(this.cliente, false).get();
			Endereco en = new Endereco(this.rua, this.bairro, this.cidade, this.cep, this.numero, cliente);
			
			return enderecoRepository.save(en);
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("cliente associado ao endereço é inválido ou não existe");
		}
	}

	public void atualizar(Endereco en, ClienteRepository clienteRepository) throws BuscaInvalidaException {
		try {
			Cliente cliente = clienteRepository.findByIdAndDeleteSoft(this.cliente, false).get();
			en.setCidade(cidade);
			en.setBairro(bairro);
			en.setRua(rua);
			en.setNumero(numero);
			en.setCep(cep);
			en.setUpdated(LocalDate.now());
			en.setCliente(cliente);
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("cliente associado ao endereço é inválido ou não existe");
		}
	}

}
