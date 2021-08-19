package br.com.mayki.APITracaDeLivros.Utils;

import java.net.URI;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;

public class MontaLinks {
	
	public static Map<String, URI> executar(UriComponentsBuilder uriBuilder, String descricao, String path, Long identificador){
		
		return Map.of(descricao, uriBuilder.cloneBuilder().path("/" + path + "/{id}").build(identificador));
	}

}
