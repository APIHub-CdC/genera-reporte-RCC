package com.circulodecredito.generarreporte.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class ConsultasEfectuadas {
    private List<ConsultaEfectuada> consultaEfectuada;

    @XmlElement(name ="ConsultaEfectuada")
	public List<ConsultaEfectuada> getConsultaEfectuada() {
		return consultaEfectuada;
	}

	public void setConsultaEfectuada(List<ConsultaEfectuada> consultaEfectuada) {
		this.consultaEfectuada = consultaEfectuada;
	}
}
