package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Grafica {
	
	private String tipoA;
	private String valorA;
	private String tipoB;
	private String valorB;
	
	//Grafica 1
	private String porcentajeAA;
	private String porcentajeAB;
	//Grafica 2
	private String porcentajeBA;
	private String porcentajeBB;
	
	private String montoMayorAprobado;
	private String fechasMasAntiguo;
	private String abiertosPresente;
	
	@Override
	public String toString(){
		return "Grafica Objeto: tipoA->"+tipoA+", valorA->"+valorA+", tipoB->"+tipoB+", valorB->"+valorB+",porcentajeAA->"+porcentajeAA+
				",porcentajeAB->"+porcentajeAB+",porcentajeBA->"+porcentajeBA+",porcentajeBB->"+porcentajeBB+",montoMayorAprobado->"+montoMayorAprobado+
				",fechasMasAntiguo->"+fechasMasAntiguo+",abiertosPresente->"+abiertosPresente;
	}
	
	@XmlElement(name ="TipoA")
	public String getTipoA() {
		return tipoA;
	}
	
	public void setTipoA(String tipoA) {
		this.tipoA = tipoA;
	}
	
	@XmlElement(name ="ValorA")
	public String getValorA() {
		return valorA;
	}
	
	public void setValorA(String valorA) {
		this.valorA = valorA;
	}
	
	@XmlElement(name ="TipoB")
	public String getTipoB() {
		return tipoB;
	}
	
	public void setTipoB(String tipoB) {
		this.tipoB = tipoB;
	}
	
	@XmlElement(name ="ValorB")
	public String getValorB() {
		return valorB;
	}
	
	public void setValorB(String valorB) {
		this.valorB = valorB;
	}
	
	@XmlElement(name ="PorcentajeAA")
	public String getPorcentajeAA() {
		return porcentajeAA;
	}
	
	public void setPorcentajeAA(String porcentajeAA) {
		this.porcentajeAA = porcentajeAA;
	}
	
	@XmlElement(name ="PorcentajeAB")
	public String getPorcentajeAB() {
		return porcentajeAB;
	}
	
	public void setPorcentajeAB(String porcentajeAB) {
		this.porcentajeAB = porcentajeAB;
	}
	
	@XmlElement(name ="PorcentajeBA")
	public String getPorcentajeBA() {
		return porcentajeBA;
	}
	
	public void setPorcentajeBA(String porcentajeBA) {
		this.porcentajeBA = porcentajeBA;
	}
	
	@XmlElement(name ="PorcentajeBB")
	public String getPorcentajeBB() {
		return porcentajeBB;
	}
	
	public void setPorcentajeBB(String porcentajeBB) {
		this.porcentajeBB = porcentajeBB;
	}
	
	@XmlElement(name ="MontoMayorAprobado")
	public String getMontoMayorAprobado() {
		return montoMayorAprobado;
	}
	
	public void setMontoMayorAprobado(String montoMayorAprobado) {
		this.montoMayorAprobado = montoMayorAprobado;
	}
	
	@XmlElement(name ="FechasMasAntiguo")
	public String getFechasMasAntiguo() {
		return fechasMasAntiguo;
	}
	
	public void setFechasMasAntiguo(String fechasMasAntiguo) {
		this.fechasMasAntiguo = fechasMasAntiguo;
	}
	
	@XmlElement(name ="AbiertosPresente")
	public String getAbiertosPresente() {
		return abiertosPresente;
	}
	
	public void setAbiertosPresente(String abiertosPresente) {
		this.abiertosPresente = abiertosPresente;
	}

}
