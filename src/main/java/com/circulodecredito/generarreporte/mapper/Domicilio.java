package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Domicilio {
    private String direccion;
    private String coloniaPoblacion;
    private String delegacionMunicipio;
    private String ciudad;
    private String estado;
    private String cp;
    private String fechaResidencia;
    private String numeroTelefono;
    private String tipoDomicilio;
    private String tipoAsentamiento;
    private String fechaRegistroDomicilio;
    private String tipoAltaDomicilio;
    private String numeroOtorgantesCarga;
    private String numeroOtorgantesConsulta;
    private String idDomicilio;

    
    @XmlElement(name ="CP")
    public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@XmlElement(name ="TipoAltaDomicilio")
	public String getTipoAltaDomicilio() {
		return tipoAltaDomicilio;
	}

	public void setTipoAltaDomicilio(String tipoAltaDomicilio) {
		this.tipoAltaDomicilio = tipoAltaDomicilio;
	}

	@XmlElement(name ="NumeroOtorgantesCarga")
	public String getNumeroOtorgantesCarga() {
		return numeroOtorgantesCarga;
	}

	public void setNumeroOtorgantesCarga(String numeroOtorgantesCarga) {
		this.numeroOtorgantesCarga = numeroOtorgantesCarga;
	}

	@XmlElement(name ="NumeroOtorgantesConsulta")
	public String getNumeroOtorgantesConsulta() {
		return numeroOtorgantesConsulta;
	}

	public void setNumeroOtorgantesConsulta(String numeroOtorgantesConsulta) {
		this.numeroOtorgantesConsulta = numeroOtorgantesConsulta;
	}

	@XmlElement(name ="IdDomicilio")
	public String getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(String idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	@XmlElement(name ="Direccion")
    public String getDireccion() {
        return direccion;
    }

    @XmlElement(name ="ColoniaPoblacion")
    public String getColoniaPoblacion() {
        return coloniaPoblacion;
    }

    @XmlElement(name ="DelegacionMunicipio")
    public String getDelegacionMunicipio() {
        return delegacionMunicipio;
    }

    @XmlElement(name ="Ciudad")
    public String getCiudad() {
        return ciudad;
    }

    @XmlElement(name ="Estado")
    public String getEstado() {
        return estado;
    }

    @XmlElement(name ="FechaResidencia")
    public String getFechaResidencia() {
        return fechaResidencia;
    }

    @XmlElement(name ="NumeroTelefono")
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    @XmlElement(name ="TipoDomicilio")
    public String getTipoDomicilio() {
        return tipoDomicilio;
    }

    @XmlElement(name ="TipoAsentamiento")
    public String getTipoAsentamiento() {
        return tipoAsentamiento;
    }

    @XmlElement(name ="FechaRegistroDomicilio")
    public String getFechaRegistroDomicilio() {
        return fechaRegistroDomicilio;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setColoniaPoblacion(String coloniaPoblacion) {
        this.coloniaPoblacion = coloniaPoblacion;
    }

    public void setDelegacionMunicipio(String delegacionMunicipio) {
        this.delegacionMunicipio = delegacionMunicipio;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaResidencia(String fechaResidencia) {
        this.fechaResidencia = fechaResidencia;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setTipoDomicilio(String tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }

    public void setTipoAsentamiento(String tipoAsentamiento) {
        this.tipoAsentamiento = tipoAsentamiento;
    }

    public void setFechaRegistroDomicilio(String fechaRegistroDomicilio) {
        this.fechaRegistroDomicilio = fechaRegistroDomicilio;
    }
}
