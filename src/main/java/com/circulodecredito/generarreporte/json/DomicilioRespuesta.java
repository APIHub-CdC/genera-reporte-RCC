package com.circulodecredito.generarreporte.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DomicilioRespuesta {

	@JsonProperty("direccion")
  private String direccion = null;
	@JsonProperty("coloniaPoblacion")
  private String coloniaPoblacion = null;
	@JsonProperty("delegacionMunicipio")
  private String delegacionMunicipio = null;
	@JsonProperty("ciudad")
  private String ciudad = null;
	@JsonProperty("estado")
  private String estado = null;
	@JsonProperty("CP")
  private String CP = null;
	@JsonProperty("fechaResidencia")
  private String fechaResidencia = null;
	@JsonProperty("numeroTelefono")
  private String numeroTelefono = null;
	@JsonProperty("tipoDomicilio")
  private String tipoDomicilio = null;
	@JsonProperty("tipoAsentamiento")
  private String tipoAsentamiento = null;
	@JsonProperty("fechaRegistroDomicilio")
  private String fechaRegistroDomicilio = null;
	@JsonProperty("tipoAltaDomicilio")
  private Integer tipoAltaDomicilio = null;
	@JsonProperty("numeroOtorgantesCarga")
  private Integer numeroOtorgantesCarga = null;
	@JsonProperty("numeroOtorgantesConsulta")
  private Integer numeroOtorgantesConsulta = null;
	@JsonProperty("idDomicilio")
  private String idDomicilio = null;
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getColoniaPoblacion() {
	return coloniaPoblacion;
}
public void setColoniaPoblacion(String coloniaPoblacion) {
	this.coloniaPoblacion = coloniaPoblacion;
}
public String getDelegacionMunicipio() {
	return delegacionMunicipio;
}
public void setDelegacionMunicipio(String delegacionMunicipio) {
	this.delegacionMunicipio = delegacionMunicipio;
}
public String getCiudad() {
	return ciudad;
}
public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public String getCP() {
	return CP;
}
public void setCP(String cP) {
	CP = cP;
}
public String getFechaResidencia() {
	return fechaResidencia;
}
public void setFechaResidencia(String fechaResidencia) {
	this.fechaResidencia = fechaResidencia;
}
public String getNumeroTelefono() {
	return numeroTelefono;
}
public void setNumeroTelefono(String numeroTelefono) {
	this.numeroTelefono = numeroTelefono;
}
public String getTipoDomicilio() {
	return tipoDomicilio;
}
public void setTipoDomicilio(String tipoDomicilio) {
	this.tipoDomicilio = tipoDomicilio;
}
public String getTipoAsentamiento() {
	return tipoAsentamiento;
}
public void setTipoAsentamiento(String tipoAsentamiento) {
	this.tipoAsentamiento = tipoAsentamiento;
}
public String getFechaRegistroDomicilio() {
	return fechaRegistroDomicilio;
}
public void setFechaRegistroDomicilio(String fechaRegistroDomicilio) {
	this.fechaRegistroDomicilio = fechaRegistroDomicilio;
}
public Integer getTipoAltaDomicilio() {
	return tipoAltaDomicilio;
}
public void setTipoAltaDomicilio(Integer tipoAltaDomicilio) {
	this.tipoAltaDomicilio = tipoAltaDomicilio;
}
public Integer getNumeroOtorgantesCarga() {
	return numeroOtorgantesCarga;
}
public void setNumeroOtorgantesCarga(Integer numeroOtorgantesCarga) {
	this.numeroOtorgantesCarga = numeroOtorgantesCarga;
}
public Integer getNumeroOtorgantesConsulta() {
	return numeroOtorgantesConsulta;
}
public void setNumeroOtorgantesConsulta(Integer numeroOtorgantesConsulta) {
	this.numeroOtorgantesConsulta = numeroOtorgantesConsulta;
}
public String getIdDomicilio() {
	return idDomicilio;
}
public void setIdDomicilio(String idDomicilio) {
	this.idDomicilio = idDomicilio;
}
  
  
  
  
}
