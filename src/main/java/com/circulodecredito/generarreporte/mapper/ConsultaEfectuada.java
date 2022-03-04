package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class ConsultaEfectuada {
    private String fechaConsulta;
    private String claveOtorgante;
    private String nombreOtorgante;
    private String direccionOtorgante;
    private String telefonoOtorgante;
    private String tipoCredito;
    private String importeCredito;
    private String claveUnidadMonetaria;
    private String tipoResponsabilidad;
    private String idDomicilio;
    private String servicios;

    @XmlElement(name ="DireccionOtorgante")
    public String getDireccionOtorgante() {
		return direccionOtorgante;
	}

	public void setDireccionOtorgante(String direccionOtorgante) {
		this.direccionOtorgante = direccionOtorgante;
	}

	@XmlElement(name ="TelefonoOtorgante")
	public String getTelefonoOtorgante() {
		return telefonoOtorgante;
	}

	public void setTelefonoOtorgante(String telefonoOtorgante) {
		this.telefonoOtorgante = telefonoOtorgante;
	}

	@XmlElement(name ="IdDomicilio")
	public String getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(String idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	@XmlElement(name ="Servicios")
	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	@XmlElement(name ="FechaConsulta")
    public String getFechaConsulta() {
        return fechaConsulta;
    }

    @XmlElement(name ="ClaveOtorgante")
    public String getClaveOtorgante() {
        return claveOtorgante;
    }

    @XmlElement(name ="NombreOtorgante")
    public String getNombreOtorgante() {
        return nombreOtorgante;
    }

    @XmlElement(name ="TipoCredito")
    public String getTipoCredito() {
        return tipoCredito;
    }

    @XmlElement(name ="ClaveUnidadMonetaria")
    public String getClaveUnidadMonetaria() {
        return claveUnidadMonetaria;
    }

    @XmlElement(name ="ImporteCredito")
    public String getImporteCredito() {
        return importeCredito;
    }

    @XmlElement(name ="TipoResponsabilidad")
    public String getTipoResponsabilidad() {
        return tipoResponsabilidad;
    }

    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public void setClaveOtorgante(String claveOtorgante) {
        this.claveOtorgante = claveOtorgante;
    }

    public void setNombreOtorgante(String nombreOtorgante) {
        this.nombreOtorgante = nombreOtorgante;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public void setClaveUnidadMonetaria(String claveUnidadMonetaria) {
        this.claveUnidadMonetaria = claveUnidadMonetaria;
    }

    public void setImporteCredito(String importeCredito) {
        this.importeCredito = importeCredito;
    }

    public void setTipoResponsabilidad(String tipoResponsabilidad) {
        this.tipoResponsabilidad = tipoResponsabilidad;
    }
}
