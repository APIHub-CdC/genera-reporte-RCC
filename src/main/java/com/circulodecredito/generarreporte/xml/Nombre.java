package com.circulodecredito.generarreporte.xml;

import javax.xml.bind.annotation.XmlElement;

public class Nombre {
	 private String apellidoPaterno;
	    private String apellidoMaterno;
	    private String apellidoAdicional;
	    private String nombres;
	    private String fechaNacimiento;
	    private String rfc;
	    private String curp;
	    private String nacionalidad;
	    private String residencia;
	    private String estadoCivil;
	    private String sexo;
	    private String claveElectorIFE;
	    private String numeroDependientes;
	    private String fechaDefuncion;

	    @XmlElement(name ="ApellidoPaterno")
	    public String getApellidoPaterno() {
	        return apellidoPaterno;
	    }

	    @XmlElement(name ="ApellidoMaterno")
	    public String getApellidoMaterno() {
	        return apellidoMaterno;
	    }

	    @XmlElement(name ="ApellidoAdicional")
	    public String getApellidoAdicional() {
	        return apellidoAdicional;
	    }

	    @XmlElement(name ="Nombres")
	    public String getNombres() {
	        return nombres;
	    }
	    
	    @XmlElement(name ="FechaNacimiento")
	    public String getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    @XmlElement(name ="RFC")
	    public String getRfc() {
	        return rfc;
	    }

	    @XmlElement(name ="CURP")
	    public String getCurp() {
	        return curp;
	    }
	    
	    @XmlElement(name ="Nacionalidad")
	    public String getNacionalidad() {
	        return nacionalidad;
	    }

	    @XmlElement(name ="Residencia")
	    public String getResidencia() {
	        return residencia;
	    }

	    @XmlElement(name ="EstadoCivil")
	    public String getEstadoCivil() {
	        return estadoCivil;
	    }

	    @XmlElement(name ="Sexo")
	    public String getSexo() {
	        return sexo;
	    }

	    @XmlElement(name ="ClaveElectorIFE")
	    public String getClaveElectorIFE() {
	        return claveElectorIFE;
	    }

	    @XmlElement(name ="ClaveElectorIFE")
	    public String getNumeroDependientes() {
	        return numeroDependientes;
	    }

	    @XmlElement(name ="FechaDefuncion")
	    public String getFechaDefuncion() {
	        return fechaDefuncion;
	    }

	    public void setApellidoPaterno(String apellidoPaterno) {
	        this.apellidoPaterno = apellidoPaterno;
	    }

	    public void setApellidoMaterno(String apellidoMaterno) {
	        this.apellidoMaterno = apellidoMaterno;
	    }

	    public void setApellidoAdicional(String apellidoAdicional) {
	        this.apellidoAdicional = apellidoAdicional;
	    }

	    public void setNombres(String nombres) {
	        this.nombres = nombres;
	    }

	    public void setFechaNacimiento(String fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }

	    public void setRfc(String rfc) {
	        this.rfc = rfc;
	    }

	    public void setCurp(String curp) {
	        this.curp = curp;
	    }

	    public void setNacionalidad(String nacionalidad) {
	        this.nacionalidad = nacionalidad;
	    }

	    public void setResidencia(String residencia) {
	        this.residencia = residencia;
	    }

	    public void setEstadoCivil(String estadoCivil) {
	        this.estadoCivil = estadoCivil;
	    }

	    public void setSexo(String sexo) {
	        this.sexo = sexo;
	    }

	    public void setClaveElectorIFE(String claveElectorIFE) {
	        this.claveElectorIFE = claveElectorIFE;
	    }

	    public void setNumeroDependientes(String numeroDependientes) {
	        this.numeroDependientes = numeroDependientes;
	    }

	    public void setFechaDefuncion(String fechaDefuncion) {
	        this.fechaDefuncion = fechaDefuncion;
	    }

}
