package com.circulodecredito.generarreporte.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class Domicilios {

	private List<Domicilio> domicilio;

    @XmlElement(name ="Domicilio")
	public List<Domicilio> getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(List<Domicilio> domicilio) {
		this.domicilio = domicilio;
	}
    
}
