package com.circulodecredito.generarreporte.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Respuesta {

	@JsonProperty("folioConsulta")
  private String folioConsulta = null;
	@JsonProperty("folioConsultaOtorgante")
  private String folioConsultaOtorgante = null;
	@JsonProperty("claveOtorgante")
  private String claveOtorgante = null;
	@JsonProperty("declaracionesConsumidor")
  private String declaracionesConsumidor = null;
	@JsonProperty("persona")
  private PersonaRespuesta persona = null;
	@JsonProperty("consultas")
  private List<Consulta> consultas = null;
	@JsonProperty("creditos")
  private List<Credito> creditos = null;
	@JsonProperty("domicilios")
  private List<DomicilioRespuesta> domicilios = null;
	@JsonProperty("empleos")
  private List<Empleo> empleos = null;
	@JsonProperty("scores")
  private List<Score> scores = null;
	@JsonProperty("mensajes")
  private List<Mensaje> mensajes = null;
  
public String getFolioConsulta() {
	return folioConsulta;
}
public void setFolioConsulta(String folioConsulta) {
	this.folioConsulta = folioConsulta;
}
public String getFolioConsultaOtorgante() {
	return folioConsultaOtorgante;
}
public void setFolioConsultaOtorgante(String folioConsultaOtorgante) {
	this.folioConsultaOtorgante = folioConsultaOtorgante;
}
public String getClaveOtorgante() {
	return claveOtorgante;
}
public void setClaveOtorgante(String claveOtorgante) {
	this.claveOtorgante = claveOtorgante;
}
public String getDeclaracionesConsumidor() {
	return declaracionesConsumidor;
}
public void setDeclaracionesConsumidor(String declaracionesConsumidor) {
	this.declaracionesConsumidor = declaracionesConsumidor;
}
public PersonaRespuesta getPersona() {
	return persona;
}
public void setPersona(PersonaRespuesta persona) {
	this.persona = persona;
}
public List<Consulta> getConsultas() {
	return consultas;
}
public void setConsultas(List<Consulta> consultas) {
	this.consultas = consultas;
}
public List<Credito> getCreditos() {
	return creditos;
}
public void setCreditos(List<Credito> creditos) {
	this.creditos = creditos;
}
public List<DomicilioRespuesta> getDomicilios() {
	return domicilios;
}
public void setDomicilios(List<DomicilioRespuesta> domicilios) {
	this.domicilios = domicilios;
}
public List<Empleo> getEmpleos() {
	return empleos;
}
public void setEmpleos(List<Empleo> empleos) {
	this.empleos = empleos;
}
public List<Score> getScores() {
	return scores;
}
public void setScores(List<Score> scores) {
	this.scores = scores;
}
public List<Mensaje> getMensajes() {
	return mensajes;
}
public void setMensajes(List<Mensaje> mensajes) {
	this.mensajes = mensajes;
}
  
  
}
