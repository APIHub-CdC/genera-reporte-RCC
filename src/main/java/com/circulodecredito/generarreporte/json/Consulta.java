package com.circulodecredito.generarreporte.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Consulta {

	@JsonProperty("fechaConsulta")
	  private String fechaConsulta = null;
	@JsonProperty("claveOtorgante")
	  private String claveOtorgante = null;
	@JsonProperty("nombreOtorgante")
	  private String nombreOtorgante = null;
	@JsonProperty("direccionOtorgante")
	  private String direccionOtorgante = null;
	@JsonProperty("telefonoOtorgante")
	  private String telefonoOtorgante = null;
	@JsonProperty("tipoCredito")
	  private String tipoCredito = null;
	@JsonProperty("claveUnidadMonetaria")
	  private String claveUnidadMonetaria = null;
	@JsonProperty("importeCredito")
	  private Float importeCredito = null;
	@JsonProperty("tipoResponsabilidad")
	  private String tipoResponsabilidad = null;
	@JsonProperty("idDomicilio")
	  private String idDomicilio = null;
	public String getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public String getClaveOtorgante() {
		return claveOtorgante;
	}
	public void setClaveOtorgante(String claveOtorgante) {
		this.claveOtorgante = claveOtorgante;
	}
	public String getNombreOtorgante() {
		return nombreOtorgante;
	}
	public void setNombreOtorgante(String nombreOtorgante) {
		this.nombreOtorgante = nombreOtorgante;
	}
	public String getDireccionOtorgante() {
		return direccionOtorgante;
	}
	public void setDireccionOtorgante(String direccionOtorgante) {
		this.direccionOtorgante = direccionOtorgante;
	}
	public String getTelefonoOtorgante() {
		return telefonoOtorgante;
	}
	public void setTelefonoOtorgante(String telefonoOtorgante) {
		this.telefonoOtorgante = telefonoOtorgante;
	}
	public String getTipoCredito() {
		return tipoCredito;
	}
	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}
	public String getClaveUnidadMonetaria() {
		return claveUnidadMonetaria;
	}
	public void setClaveUnidadMonetaria(String claveUnidadMonetaria) {
		this.claveUnidadMonetaria = claveUnidadMonetaria;
	}
	public Float getImporteCredito() {
		return importeCredito;
	}
	public void setImporteCredito(Float importeCredito) {
		this.importeCredito = importeCredito;
	}
	public String getTipoResponsabilidad() {
		return tipoResponsabilidad;
	}
	public void setTipoResponsabilidad(String tipoResponsabilidad) {
		this.tipoResponsabilidad = tipoResponsabilidad;
	}
	public String getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(String idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	  
	  
}
