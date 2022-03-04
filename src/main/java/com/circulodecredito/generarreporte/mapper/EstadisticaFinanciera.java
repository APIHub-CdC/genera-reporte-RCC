package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class EstadisticaFinanciera {
	
	private String fechaMontoPagarMaximo;
	private String montoPagarMaximo;
	private String montoPagarPromedio;
	private String fechaSaldoMaximo;
	private String saldoMaximo;
	private String saldoPromedio;
	private String fechaSaldoVencidoMaximo;
	private String saldoVencidoMaximo;
	private String saldoVencidoPromedio;
	
	@XmlElement(name ="FechaMontoPagarMaximo")
	public String getFechaMontoPagarMaximo() {
		return fechaMontoPagarMaximo;
	}
	public void setFechaMontoPagarMaximo(String fechaMontoPagarMaximo) {
		this.fechaMontoPagarMaximo = fechaMontoPagarMaximo;
	}
	@XmlElement(name ="MontoPagarMaximo")
	public String getMontoPagarMaximo() {
		return montoPagarMaximo;
	}
	public void setMontoPagarMaximo(String montoPagarMaximo) {
		this.montoPagarMaximo = montoPagarMaximo;
	}
	@XmlElement(name ="MontoPagarPromedio")
	public String getMontoPagarPromedio() {
		return montoPagarPromedio;
	}
	public void setMontoPagarPromedio(String montoPagarPromedio) {
		this.montoPagarPromedio = montoPagarPromedio;
	}
	@XmlElement(name ="FechaSaldoMaximo")
	public String getFechaSaldoMaximo() {
		return fechaSaldoMaximo;
	}
	public void setFechaSaldoMaximo(String fechaSaldoMaximo) {
		this.fechaSaldoMaximo = fechaSaldoMaximo;
	}
	@XmlElement(name ="SaldoMaximo")
	public String getSaldoMaximo() {
		return saldoMaximo;
	}
	public void setSaldoMaximo(String saldoMaximo) {
		this.saldoMaximo = saldoMaximo;
	}
	@XmlElement(name ="SaldoPromedio")
	public String getSaldoPromedio() {
		return saldoPromedio;
	}
	public void setSaldoPromedio(String saldoPromedio) {
		this.saldoPromedio = saldoPromedio;
	}
	@XmlElement(name ="FechaSaldoVencidoMaximo")
	public String getFechaSaldoVencidoMaximo() {
		return fechaSaldoVencidoMaximo;
	}
	public void setFechaSaldoVencidoMaximo(String fechaSaldoVencidoMaximo) {
		this.fechaSaldoVencidoMaximo = fechaSaldoVencidoMaximo;
	}
	@XmlElement(name ="SaldoVencidoMaximo")
	public String getSaldoVencidoMaximo() {
		return saldoVencidoMaximo;
	}
	public void setSaldoVencidoMaximo(String saldoVencidoMaximo) {
		this.saldoVencidoMaximo = saldoVencidoMaximo;
	}
	@XmlElement(name ="SaldoVencidoPromedio")
	public String getSaldoVencidoPromedio() {
		return saldoVencidoPromedio;
	}
	public void setSaldoVencidoPromedio(String saldoVencidoPromedio) {
		this.saldoVencidoPromedio = saldoVencidoPromedio;
	}
	
	
}
