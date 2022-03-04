package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Autenticacion {
	private String numeroAutenticacion;
	private String numeroSolicitud;
	private String estatusAutenticacion;
	
	@XmlElement(name ="NumeroAutenticacion")
	public String getNumeroAutenticacion() {
		return numeroAutenticacion;
	}
	public void setNumeroAutenticacion(String numeroAutenticacion) {
		this.numeroAutenticacion = numeroAutenticacion;
	}
	@XmlElement(name ="NumeroSolicitu")
	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	@XmlElement(name ="EstatusAutenticacion")
	public String getEstatusAutenticacion() {
		return estatusAutenticacion;
	}
	public void setEstatusAutenticacion(String estatusAutenticacion) {
		this.estatusAutenticacion = estatusAutenticacion;
	}
	
	
}
