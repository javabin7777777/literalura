package com.samzubeli.literalura.servico;

public interface IFiltrarDados {
	<T> T obterDados(String strJson, Class<T> classe);	
}