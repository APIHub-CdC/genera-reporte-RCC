package com.circulodecredito.generarreporte.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class Empleos {
	private List<Empleo> lstEmpleo;

	
	@XmlElement(name ="Empleo")
	public List<Empleo> getLstEmpleo() {
		return lstEmpleo;
	}

	public void setLstEmpleo(List<Empleo> lstEmpleo) {
		this.lstEmpleo = lstEmpleo;
	}

}
