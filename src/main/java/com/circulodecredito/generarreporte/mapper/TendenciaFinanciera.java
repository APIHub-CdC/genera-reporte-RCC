package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class TendenciaFinanciera {
	
	private String idTendencia;
	private String montoPagar;
	private String saldoActual;
	private String saldoVencido;
	
	
	@XmlElement(name ="IdTendencia")
	public String getIdTendencia() {
		return idTendencia;
	}
	public void setIdTendencia(String idTendencia) {
		this.idTendencia = idTendencia;
	}
	@XmlElement(name ="MontoPagar")
	public String getMontoPagar() {
		return montoPagar;
	}
	public void setMontoPagar(String montoPagar) {
		this.montoPagar = montoPagar;
	}
	@XmlElement(name ="SaldoActual")
	public String getSaldoActual() {
		return saldoActual;
	}
	public void setSaldoActual(String saldoActual) {
		this.saldoActual = saldoActual;
	}
	@XmlElement(name ="SaldoVencido")
	public String getSaldoVencido() {
		return saldoVencido;
	}
	public void setSaldoVencido(String saldoVencido) {
		this.saldoVencido = saldoVencido;
	}
}
