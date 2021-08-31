package br.com.mayki.APITracaDeLivros.Utils;

public final class Formata {
	
	public static String cpf(String cpf) {
		if(cpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}")) {
			return cpf.replace(".", "").replace("-", "");
		}
		return cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9)+"-"+cpf.substring(9, 11);
	}
	
	public static String cnpj(String cnpj) {
		if(cnpj.matches("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")) {
			return cnpj.replace(".", "").replace("/", "").replace("-", "");
		}
		return cnpj.substring(0, 2)+"."+cnpj.substring(2, 5)+"."+cnpj.substring(5, 8)+"/"+cnpj.substring(8, 12)+"-"+cnpj.substring(12, 14);
	}
	
	public static String inscricaoEstadual(String ie) {
		if(ie.matches("([0-9]{3}\\.){3}[0-9]{3}")) {
			return ie.replace(".", "");
		}
		return ie.substring(0, 3)+"."+ie.substring(3, 6)+"."+ie.substring(6, 9)+"."+ie.substring(9, 12);
	}
	
	public static String cep(String cep) {
		if(cep.matches("[0-9]{5}\\-[0-9]{3}")) {
			return cep.replace("-", "");
		}
		return cep.substring(0, 5)+"-"+cep.substring(5, 8);
	}

}
