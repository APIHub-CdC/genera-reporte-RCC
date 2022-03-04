package com.circulodecredito.generarreporte.beans;

import java.util.HashMap;

public class CatalogosDTO {
	private HashMap<String, String> catalogoProducto;// = new HashMap<String, String>();
	private HashMap<String, Float> catalogoCambio;// = new HashMap<String, Float>();
	private HashMap<String, String> catalogoResponsabilidad;// = new HashMap<String, String>();
	private HashMap<String, String> catalogoCveObs;// = new HashMap<String, String>();
	private HashMap<String, String> catalogoCuenta;// = new HashMap<String, String>();
	private HashMap<String, String> catalogoCodigoScore;// = new HashMap<String, String>();
	
	public CatalogosDTO() {
		this.catalogoProducto = new HashMap<String, String>();
		this.catalogoCambio = new HashMap<String, Float>();
		this.catalogoResponsabilidad = new HashMap<String, String>();
		this.catalogoCveObs = new HashMap<String, String>();
		this.catalogoCuenta = new HashMap<String, String>();
		this.catalogoCodigoScore = new HashMap<String, String>();
	}

	public HashMap<String, String> getCatalogoProducto() {
		return catalogoProducto;
	}

	public void setCatalogoProducto(HashMap<String, String> catalogoProducto) {
		this.catalogoProducto = catalogoProducto;
	}

	public HashMap<String, Float> getCatalogoCambio() {
		return catalogoCambio;
	}

	public void setCatalogoCambio(HashMap<String, Float> catalogoCambio) {
		this.catalogoCambio = catalogoCambio;
	}

	public HashMap<String, String> getCatalogoResponsabilidad() {
		return catalogoResponsabilidad;
	}

	public void setCatalogoResponsabilidad(HashMap<String, String> catalogoResponsabilidad) {
		this.catalogoResponsabilidad = catalogoResponsabilidad;
	}

	public HashMap<String, String> getCatalogoCveObs() {
		return catalogoCveObs;
	}

	public void setCatalogoCveObs(HashMap<String, String> catalogoCveObs) {
		this.catalogoCveObs = catalogoCveObs;
	}

	public HashMap<String, String> getCatalogoCuenta() {
		return catalogoCuenta;
	}

	public void setCatalogoCuenta(HashMap<String, String> catalogoCuenta) {
		this.catalogoCuenta = catalogoCuenta;
	}

	public HashMap<String, String> getCatalogoCodigoScore() {
		return catalogoCodigoScore;
	}

	public void setCatalogoCodigoScore(HashMap<String, String> catalogoCodigoScore) {
		this.catalogoCodigoScore = catalogoCodigoScore;
	}
	
	
	
}
