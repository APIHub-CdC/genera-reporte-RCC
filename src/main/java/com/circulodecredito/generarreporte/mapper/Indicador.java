package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Indicador {
	private String descripcionInd;
	private String valorInd;
	
	@XmlElement(name ="DescripcionInd")
	public String getDescripcionInd() {
		return descripcionInd;
	}
	public void setDescripcionInd(String descripcionInd) {
		this.descripcionInd = descripcionInd;
	}
	@XmlElement(name ="ValorInd")
	public String getValorInd() {
		return valorInd;
	}
	public void setValorInd(String valorInd) {
		this.valorInd = valorInd;
	}
	
	
}
