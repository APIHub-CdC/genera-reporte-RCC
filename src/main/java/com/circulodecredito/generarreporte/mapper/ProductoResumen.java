package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class ProductoResumen {
	
	private String tipoCredito;
	private String status;
	private String cantidad;
	private String limite;
	private String aprobado;
	private String actual;
	private String vencido;
	private String semanal;
	private String quincenal;
	private String mensual;
	private String totalCantidad;
	private String limiteTotal;
	private String aprobadoTotal;
	private String actualTotal;
	private String vencidoTotal;
	private String semanalTotal;
	private String quincenalTotal;
	private String mensualTotal;

	@XmlElement(name ="TipoCredito")
	public String getTipoCredito() {
		return tipoCredito;
	}
	
	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}
	
	@XmlElement(name ="Status")
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@XmlElement(name ="Cantidad")
	public String getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	@XmlElement(name ="Limite")
	public String getLimite() {
		return limite;
	}
	
	public void setLimite(String limite) {
		this.limite = limite;
	}
	
	@XmlElement(name ="Aprobado")
	public String getAprobado() {
		return aprobado;
	}
	
	public void setAprobado(String aprobado) {
		this.aprobado = aprobado;
	}
	
	@XmlElement(name ="Actual")
	public String getActual() {
		return actual;
	}
	
	public void setActual(String actual) {
		this.actual = actual;
	}
	
	@XmlElement(name ="Vencido")
	public String getVencido() {
		return vencido;
	}
	
	public void setVencido(String vencido) {
		this.vencido = vencido;
	}
	
	@XmlElement(name ="Semanal")
	public String getSemanal() {
		return semanal;
	}
	
	public void setSemanal(String semanal) {
		this.semanal = semanal;
	}
	
	@XmlElement(name ="Quincenal")
	public String getQuincenal() {
		return quincenal;
	}
	
	public void setQuincenal(String quincenal) {
		this.quincenal = quincenal;
	}
	
	@XmlElement(name ="Mensual")
	public String getMensual() {
		return mensual;
	}
	
	public void setMensual(String mensual) {
		this.mensual = mensual;
	}
	
	@XmlElement(name ="TotalCantidad")
	public String getTotalCantidad() {
		return totalCantidad;
	}
	
	public void setTotalCantidad(String totalCantidad) {
		this.totalCantidad = totalCantidad;
	}
	
	@XmlElement(name ="LimiteTotal")
	public String getLimiteTotal() {
		return limiteTotal;
	}
	
	public void setLimiteTotal(String limiteTotal) {
		this.limiteTotal = limiteTotal;
	}
	
	@XmlElement(name ="AprobadoTotal")
	public String getAprobadoTotal() {
		return aprobadoTotal;
	}
	
	public void setAprobadoTotal(String aprobadoTotal) {
		this.aprobadoTotal = aprobadoTotal;
	}
	
	@XmlElement(name ="ActualTotal")
	public String getActualTotal() {
		return actualTotal;
	}
	
	public void setActualTotal(String actualTotal) {
		this.actualTotal = actualTotal;
	}
	
	@XmlElement(name ="VencidoTotal")
	public String getVencidoTotal() {
		return vencidoTotal;
	}
	
	public void setVencidoTotal(String vencidoTotal) {
		this.vencidoTotal = vencidoTotal;
	}
	
	@XmlElement(name ="SemanaTotal")
	public String getSemanalTotal() {
		return semanalTotal;
	}
	
	public void setSemanalTotal(String semanalTotal) {
		this.semanalTotal = semanalTotal;
	}
	
	@XmlElement(name ="QuincenaTotal")
	public String getQuincenalTotal() {
		return quincenalTotal;
	}
	
	public void setQuincenalTotal(String quincenalTotal) {
		this.quincenalTotal = quincenalTotal;
	}
	
	@XmlElement(name ="MensualTotal")
	public String getMensualTotal() {
		return mensualTotal;
	}
	
	public void setMensualTotal(String mensualTotal) {
		this.mensualTotal = mensualTotal;
	}	
	
}
