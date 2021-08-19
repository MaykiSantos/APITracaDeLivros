package br.com.mayki.APITracaDeLivros.Services;

import java.net.URI;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mayki.APITracaDeLivros.Models.Entity.Chamado;
import br.com.mayki.APITracaDeLivros.Models.Repository.ChamadoRepository;
import br.com.mayki.APITracaDeLivros.Models.Repository.ClienteRepository;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.ChamadoDto;
import br.com.mayki.APITracaDeLivros.Views.Dto.ClienteDto;
import br.com.mayki.APITracaDeLivros.Views.Form.ChamadoForm;

@Service
public class ChamadoService {

	@Autowired
	ChamadoRepository chamadoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	
	
	public ResponseEntity<Page<ChamadoDto>> listar(Pageable page, UriComponentsBuilder uriBuilder) {
		Page<Chamado> chamadoPage = chamadoRepository.findByDeleteSoft(page, false);
		
		return ResponseEntity.ok(ChamadoDto.paraPageDto(chamadoPage, uriBuilder));
	}

	public ResponseEntity<ChamadoDto> buscar(Long id, UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		try {
			Chamado c = chamadoRepository.findByIdAndDeleteSoft(id, false).get();
			return ResponseEntity.ok(ChamadoDto.paraDto(c, uriBuilder));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja acessar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<ChamadoDto> adicionar(ChamadoForm form, UriComponentsBuilder uriBuilder) throws BuscaInvalidaException {
		Chamado c = form.paraChamado(chamadoRepository, clienteRepository);
		URI uri = uriBuilder.cloneBuilder().path("/chamados/{id}").build(c.getId());
		return ResponseEntity.created(uri).body(ChamadoDto.paraDto(c, uriBuilder));
	}

	@Transactional
	public ResponseEntity<ChamadoDto> editar(Long id, ChamadoForm form, UriComponentsBuilder uriBilder) throws BuscaInvalidaException {
		try {
			Chamado c = chamadoRepository.findByIdAndDeleteSoft(id, false).get();
			form.atualizar(c, clienteRepository);
			return ResponseEntity.ok(ChamadoDto.paraDto(c, uriBilder));
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja atualizar é inválido ou não existe");
		}
	}

	@Transactional
	public ResponseEntity<?> deletSoft(Long id) throws BuscaInvalidaException {
		try {
			Chamado c = chamadoRepository.findByIdAndDeleteSoft(id, false).get();
			c.setUpdated(LocalDate.now());
			c.setDeleteSoft(true);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (NoSuchElementException e) {
			throw new BuscaInvalidaException("id do recuros que deseja atualizar é inválido ou não existe");
		}
	}

}
