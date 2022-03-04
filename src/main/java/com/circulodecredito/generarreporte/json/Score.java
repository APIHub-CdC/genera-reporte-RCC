package com.circulodecredito.generarreporte.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Score {
	
	@JsonProperty("nombreScore")
  private String nombreScore = null;
	@JsonProperty("valor")
  private Integer valor = null;
	@JsonProperty("razones")
  private List<String> razones = null;
public String getNombreScore() {
	return nombreScore;
}
public void setNombreScore(String nombreScore) {
	this.nombreScore = nombreScore;
}
public Integer getValor() {
	return valor;
}
public void setValor(Integer valor) {
	this.valor = valor;
}
public List<String> getRazones() {
	return razones;
}
public void setRazones(List<String> razones) {
	this.razones = razones;
}
  
  
  
}
