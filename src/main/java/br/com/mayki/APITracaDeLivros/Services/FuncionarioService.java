package br.com.mayki.APITracaDeLivros.Services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mayki.APITracaDeLivros.Models.Entity.Funcionario;
import br.com.mayki.APITracaDeLivros.Models.Repository.FuncionarioRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.PerfilRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.FuncionarioDto;
import br.com.mayki.APITracaDeLivros.Views.Form.FuncionarioForm;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	@Autowired
	PerfilRepository perfilRepository;
	

	public ResponseEntity<Page<FuncionarioDto>> listar(Pageable page) {
		Page<Funcionario> funcionarioPage = funcionarioRepository.findAll(page);
		
		return ResponseEntity.ok(FuncionarioDto.paraPageDto(funcionarioPage));
	}

	public ResponseEntity<FuncionarioDto> buscar(Long id) throws BuscaInvalidaException {
		try {
			Funcionario funcionario = funcionarioRepository.findById(id).get();
			return ResponseEntity.ok(FuncionarioDto.paraDto(funcionario));
			
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja acessar é inválido"); 
		}
	}

	public ResponseEntity<FuncionarioDto> adicionar(FuncionarioForm form) throws BuscaInvalidaException {
		Funcionario funcionario = form.paraFuncionario(funcionarioRepository, perfilRepository);
		
		return ResponseEntity.ok(FuncionarioDto.paraDto(funcionario));
	}
	
	

}
