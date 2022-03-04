package com.circulodecredito.generarreporte.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaRespuesta {
  @JsonProperty("apellidoPaterno")
  private String apellidoPaterno = null;
  @JsonProperty("apellidoMaterno")
  private String apellidoMaterno = null;
  @JsonProperty("apellidoAdicional")
  private String apellidoAdicional = null;
  @JsonProperty("nombres")
  private String nombres = null;
  @JsonProperty("fechaNacimiento")
  private String fechaNacimiento = null;
  @JsonProperty("RFC")
  private String RFC = null;
  @JsonProperty("CURP")
  private String CURP = null;
  @JsonProperty("numeroSeguridadSocial")
  private String numeroSeguridadSocial = null;
  @JsonProperty("nacionalidad")
  private String nacionalidad = null;
  @JsonProperty("residencia")
  private Integer residencia = null;
  @JsonProperty("estadoCivil")
  private String estadoCivil = null;
  @JsonProperty("sexo")
  private String sexo = null;
  @JsonProperty("claveElectorIFE")
  private String claveElectorIFE = null;
  @JsonProperty("numeroDependientes")
  private Integer numeroDependientes = null;
  @JsonProperty("fechaDefuncion")
  private String fechaDefuncion = null;
  
public String getApellidoPaterno() {
	return apellidoPaterno;
}
public void setApellidoPaterno(String apellidoPaterno) {
	this.apellidoPaterno = apellidoPaterno;
}
public String getApellidoMaterno() {
	return apellidoMaterno;
}
public void setApellidoMaterno(String apellidoMaterno) {
	this.apellidoMaterno = apellidoMaterno;
}
public String getApellidoAdicional() {
	return apellidoAdicional;
}
public void setApellidoAdicional(String apellidoAdicional) {
	this.apellidoAdicional = apellidoAdicional;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getFechaNacimiento() {
	return fechaNacimiento;
}
public void setFechaNacimiento(String fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}
public String getRFC() {
	return RFC;
}
public void setRFC(String rFC) {
	RFC = rFC;
}
public String getCURP() {
	return CURP;
}
public void setCURP(String cURP) {
	CURP = cURP;
}
public String getNumeroSeguridadSocial() {
	return numeroSeguridadSocial;
}
public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
	this.numeroSeguridadSocial = numeroSeguridadSocial;
}
public String getNacionalidad() {
	return nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}
public Integer getResidencia() {
	return residencia;
}
public void setResidencia(Integer residencia) {
	this.residencia = residencia;
}
public String getEstadoCivil() {
	return estadoCivil;
}
public void setEstadoCivil(String estadoCivil) {
	this.estadoCivil = estadoCivil;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getClaveElectorIFE() {
	return claveElectorIFE;
}
public void setClaveElectorIFE(String claveElectorIFE) {
	this.claveElectorIFE = claveElectorIFE;
}
public Integer getNumeroDependientes() {
	return numeroDependientes;
}
public void setNumeroDependientes(Integer numeroDependientes) {
	this.numeroDependientes = numeroDependientes;
}
public String getFechaDefuncion() {
	return fechaDefuncion;
}
public void setFechaDefuncion(String fechaDefuncion) {
	this.fechaDefuncion = fechaDefuncion;
}
  
  
  
}
