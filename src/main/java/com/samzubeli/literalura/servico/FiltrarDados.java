package com.samzubeli.literalura.servico;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FiltrarDados implements IFiltrarDados {
	private ObjectMapper conversor = new ObjectMapper();

	@Override
	public <T> T obterDados(String strJson, Class<T> classe) {
		
		try {
			return conversor.readValue(strJson, classe);
		} catch (JsonMappingException e) {			
			e.printStackTrace();
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}
		return null;
	}
}