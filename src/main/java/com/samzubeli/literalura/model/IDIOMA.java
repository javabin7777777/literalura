package com.samzubeli.literalura.model;

public enum IDIOMA {
	pt("PORTUGUÊS"),
	en("INGLÊS"),
	fr("FRANCÊS"),
	n("N/A");

	private String idioma;

	private IDIOMA(String idioma) {
		this.idioma = idioma;
	}
	
	public static String fromString(String textoEntrada) {
		for(IDIOMA idioma: IDIOMA.values()) {		
			if(idioma.name().equalsIgnoreCase(textoEntrada)) return idioma.idioma ;							
		}	
	IDIOMA[] idioma =IDIOMA.values();	
	return idioma[idioma.length-1].idioma;
	}	
}
