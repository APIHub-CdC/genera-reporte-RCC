package com.circulodecredito.generarreporte.mapper;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class RespuestaCore implements Serializable {

    private Respuesta respuesta;

    private static final long serialVersionUID = 1L;

    @XmlElement(name ="Respuesta")
    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }
}
