package com.circulodecredito.generarreporte.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mensaje {

	@JsonProperty("tipoMensaje")
  private Integer tipoMensaje = null;
	@JsonProperty("leyenda")
  private String leyenda = null;
public Integer getTipoMensaje() {
	return tipoMensaje;
}
public void setTipoMensaje(Integer tipoMensaje) {
	this.tipoMensaje = tipoMensaje;
}
public String getLeyenda() {
	return leyenda;
}
public void setLeyenda(String leyenda) {
	this.leyenda = leyenda;
}	
  
  
  
}
