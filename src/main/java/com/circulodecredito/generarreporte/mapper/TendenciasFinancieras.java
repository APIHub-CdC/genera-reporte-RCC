package com.circulodecredito.generarreporte.mapper;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class TendenciasFinancieras {
	private String tipoTendencia;
	private String ultimaActualizacion;
	private String anioUltimaActualizacion;
	private List<TendenciaFinanciera> tendenciaFinanciera;
	
	@XmlElement(name ="TipoTendencia")
	public String getTipoTendencia() {
		return tipoTendencia;
	}
	public void setTipoTendencia(String tipoTendencia) {
		this.tipoTendencia = tipoTendencia;
	}
	@XmlElement(name ="UltimaActualizacion")
	public String getUltimaActualizacion() {
		return ultimaActualizacion;
	}
	public void setUltimaActualizacion(String ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}
	@XmlElement(name ="AñoUltimaActualizacion")
	public String getAnioUltimaActualizacion() {
		return anioUltimaActualizacion;
	}
	public void setAnioUltimaActualizacion(String anioUltimaActualizacion) {
		this.anioUltimaActualizacion = anioUltimaActualizacion;
	}
	@XmlElement(name ="TendenciaFinanciera")
	public List<TendenciaFinanciera> getTendenciaFinanciera() {
		return tendenciaFinanciera;
	}
	public void setTendenciaFinanciera(List<TendenciaFinanciera> tendenciaFinanciera) {
		this.tendenciaFinanciera = tendenciaFinanciera;
	}
	
	
}
