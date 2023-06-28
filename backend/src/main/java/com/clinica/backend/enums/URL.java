package com.clinica.backend.enums;

public enum URL {
	CONSULTA("http://localhost:8080/consulta/");
	
	private String url;
	
	private URL(String url) {this.url = url;}
	
	public String getUrl() {
		return this.url;
	}
}
