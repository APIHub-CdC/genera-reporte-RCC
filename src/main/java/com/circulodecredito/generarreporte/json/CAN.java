package com.circulodecredito.generarreporte.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CAN {
	@JsonProperty("identificadorCAN")
  private String identificadorCAN = null;
	@JsonProperty("prelacionOrigen")
  private Integer prelacionOrigen = null;
	@JsonProperty("prelacionActual")
  private Integer prelacionActual = null;
	@JsonProperty("fechaAperturaCAN")
  private String fechaAperturaCAN = null;
	@JsonProperty("fechaCancelacionCAN")
  private String fechaCancelacionCAN = null;
	@JsonProperty("historicoCAN")
  private String historicoCAN = null;
	@JsonProperty("fechaMRCAN")
  private String fechaMRCAN = null;
	@JsonProperty("fechaMACAN")
  private String fechaMACAN = null;
public String getIdentificadorCAN() {
	return identificadorCAN;
}
public void setIdentificadorCAN(String identificadorCAN) {
	this.identificadorCAN = identificadorCAN;
}
public Integer getPrelacionOrigen() {
	return prelacionOrigen;
}
public void setPrelacionOrigen(Integer prelacionOrigen) {
	this.prelacionOrigen = prelacionOrigen;
}
public Integer getPrelacionActual() {
	return prelacionActual;
}
public void setPrelacionActual(Integer prelacionActual) {
	this.prelacionActual = prelacionActual;
}
public String getFechaAperturaCAN() {
	return fechaAperturaCAN;
}
public void setFechaAperturaCAN(String fechaAperturaCAN) {
	this.fechaAperturaCAN = fechaAperturaCAN;
}
public String getFechaCancelacionCAN() {
	return fechaCancelacionCAN;
}
public void setFechaCancelacionCAN(String fechaCancelacionCAN) {
	this.fechaCancelacionCAN = fechaCancelacionCAN;
}
public String getHistoricoCAN() {
	return historicoCAN;
}
public void setHistoricoCAN(String historicoCAN) {
	this.historicoCAN = historicoCAN;
}
public String getFechaMRCAN() {
	return fechaMRCAN;
}
public void setFechaMRCAN(String fechaMRCAN) {
	this.fechaMRCAN = fechaMRCAN;
}
public String getFechaMACAN() {
	return fechaMACAN;
}
public void setFechaMACAN(String fechaMACAN) {
	this.fechaMACAN = fechaMACAN;
}
  
  
  
  
}
