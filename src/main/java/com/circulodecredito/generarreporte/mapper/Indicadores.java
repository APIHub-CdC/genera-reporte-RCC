package com.circulodecredito.generarreporte.mapper;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Indicadores {
	private List<Indicador> indicador;

	@XmlElement(name ="Indicador")
	public List<Indicador> getIndicador() {
		return indicador;
	}

	public void setIndicador(List<Indicador> indicador) {
		this.indicador = indicador;
	}
	
	
}
