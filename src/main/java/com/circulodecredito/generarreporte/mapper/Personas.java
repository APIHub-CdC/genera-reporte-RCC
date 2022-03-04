package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Personas {

    private Persona persona;
    
    @XmlElement(name ="Persona")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
