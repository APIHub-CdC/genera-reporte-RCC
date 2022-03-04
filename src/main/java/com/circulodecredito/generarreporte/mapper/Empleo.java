package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Empleo {
	private String nombreEmpresa;
	private String direccion;
	private String coloniaPoblacion;
	private String delegacionMunicipio;
	private String ciudad;
	private String estado;
	private String cp;
	private String numeroTelefono;
	private String extension;
	private String fax;
	private String puesto;
	private String fechaContratacion;
	private String claveMoneda;
	private String salarioMensual;
	private String fechaUltimoDiaEmpleo;
	private String fechaVerificacionEmpleo;
	
	@XmlElement(name ="NombreEmpresa")
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	@XmlElement(name ="Direccion")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@XmlElement(name ="ColoniaPoblacion")
	public String getColoniaPoblacion() {
		return coloniaPoblacion;
	}
	public void setColoniaPoblacion(String coloniaPoblacion) {
		this.coloniaPoblacion = coloniaPoblacion;
	}
	@XmlElement(name ="DelegacionMunicipio")
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}
	@XmlElement(name ="Ciudad")
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@XmlElement(name ="Estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@XmlElement(name ="CP")
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	@XmlElement(name ="NumeroTelefono")
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	@XmlElement(name ="Extension")
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	@XmlElement(name ="Fax")
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	@XmlElement(name ="Puesto")
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	@XmlElement(name ="FechaContratacion")
	public String getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(String fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	@XmlElement(name ="ClaveMoneda")
	public String getClaveMoneda() {
		return claveMoneda;
	}
	public void setClaveMoneda(String claveMoneda) {
		this.claveMoneda = claveMoneda;
	}
	@XmlElement(name ="SalarioMensual")
	public String getSalarioMensual() {
		return salarioMensual;
	}
	public void setSalarioMensual(String salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
	@XmlElement(name ="FechaUltimoDiaEmpleo")
	public String getFechaUltimoDiaEmpleo() {
		return fechaUltimoDiaEmpleo;
	}
	public void setFechaUltimoDiaEmpleo(String fechaUltimoDiaEmpleo) {
		this.fechaUltimoDiaEmpleo = fechaUltimoDiaEmpleo;
	}
	@XmlElement(name ="FechaVerificacionEmpleo")
	public String getFechaVerificacionEmpleo() {
		return fechaVerificacionEmpleo;
	}
	public void setFechaVerificacionEmpleo(String fechaVerificacionEmpleo) {
		this.fechaVerificacionEmpleo = fechaVerificacionEmpleo;
	}
	
	
}
