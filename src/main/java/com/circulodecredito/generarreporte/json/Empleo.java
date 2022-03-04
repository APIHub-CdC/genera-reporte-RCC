package com.circulodecredito.generarreporte.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Empleo {

	@JsonProperty("nombreEmpresa")
	  private String nombreEmpresa = null;
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
	@JsonProperty("numeroTelefono")
	  private String numeroTelefono = null;
	@JsonProperty("extension")
	  private String extension = null;
	@JsonProperty("fax")
	  private String fax = null;
	@JsonProperty("puesto")
	  private String puesto = null;
	@JsonProperty("fechaContratacion")
	  private String fechaContratacion = null;
	@JsonProperty("claveMoneda")
	  private String claveMoneda = null;
	@JsonProperty("salarioMensual")
	  private Float salarioMensual = null;
	@JsonProperty("fechaUltimoDiaEmpleo")
	  private String fechaUltimoDiaEmpleo = null;
	@JsonProperty("fechaVerificacionEmpleo")
	  private String fechaVerificacionEmpleo = null;
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
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
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(String fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public String getClaveMoneda() {
		return claveMoneda;
	}
	public void setClaveMoneda(String claveMoneda) {
		this.claveMoneda = claveMoneda;
	}
	public Float getSalarioMensual() {
		return salarioMensual;
	}
	public void setSalarioMensual(Float salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
	public String getFechaUltimoDiaEmpleo() {
		return fechaUltimoDiaEmpleo;
	}
	public void setFechaUltimoDiaEmpleo(String fechaUltimoDiaEmpleo) {
		this.fechaUltimoDiaEmpleo = fechaUltimoDiaEmpleo;
	}
	public String getFechaVerificacionEmpleo() {
		return fechaVerificacionEmpleo;
	}
	public void setFechaVerificacionEmpleo(String fechaVerificacionEmpleo) {
		this.fechaVerificacionEmpleo = fechaVerificacionEmpleo;
	}
	  
	  
	  
}
