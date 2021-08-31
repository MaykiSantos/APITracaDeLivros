package br.com.mayki.APITracaDeLivros.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.mayki.APITracaDeLivros.Utils.Exceptions.BuscaInvalidaException;
import br.com.mayki.APITracaDeLivros.Utils.Exceptions.DataInvalidaException;
import br.com.mayki.APITracaDeLivros.Views.Dto.ErroSimplesDto;

@RestControllerAdvice
public class TratamentoErros {
	
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> trataMethodArgumentNotValidException(MethodArgumentNotValidException e){
		List<Map<String, String>> retorno = new ArrayList<Map<String, String>>();
		List<FieldError> fieldErros = e.getBindingResult().getFieldErrors();
		
		fieldErros.forEach(itemErro -> {
			String mensagemErro = messageSource.getMessage(itemErro, LocaleContextHolder.getLocale());
			retorno.add(Map.of(itemErro.getField(), mensagemErro));
		});
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
	}
	
	@ExceptionHandler(BuscaInvalidaException.class)
	public ResponseEntity<ErroSimplesDto> trataBuscaInvalidaException(BuscaInvalidaException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErroSimplesDto.montar(e.getMessage()));
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErroSimplesDto> trataDataIntegrityViolationException(DataIntegrityViolationException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErroSimplesDto.montar("algum atributo em conflito (duplicidade no DB). Refatorar tratamneto deste erro."));
	}
	
	@ExceptionHandler(DataInvalidaException.class)
	public ResponseEntity<ErroSimplesDto> trataDataInvalidaException(DataInvalidaException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErroSimplesDto.montar(e.getMessage()));
	}
}
