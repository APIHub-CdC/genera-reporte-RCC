package com.circulodecredito.generarreporte.mapper;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Graficas {
	
	private List<Grafica> grafica;
	
    @XmlElement(name ="Grafica")
    public List<Grafica> getGrafica() {
        return grafica;
    }

    public void setGrafica(List<Grafica> grafica) {
        this.grafica = grafica;
    }
}
