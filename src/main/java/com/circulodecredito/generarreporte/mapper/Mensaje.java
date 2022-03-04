package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Mensaje {
	
    private String tipoMensaje;
    private String leyenda;
    private String consecutivo;

    
    @XmlElement(name ="consecutivo")
    public String getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}

	@XmlElement(name ="TipoMensaje")
    public String getTipoMensaje() {
        return tipoMensaje;
    }

    @XmlElement(name ="Leyenda")
    public String getLeyenda() {
        return leyenda;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }
}
