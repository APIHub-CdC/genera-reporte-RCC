package com.circulodecredito.generarreporte.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Respuesta")
public class Respuesta implements Serializable {

    private Personas personas;

    private static final long serialVersionUID = 1L;

	@XmlElement(name ="Personas")
    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }
}
