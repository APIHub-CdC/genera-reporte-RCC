package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Razon1 {
	
	private String razonDescripcion1;
	
    
    @XmlElement(name ="RazonDescripcion1")
    public String getRazonDescripcion1() {
        return razonDescripcion1;
    }
    
    public void setRazonDescripcion1(String razonDescripcion1) {
        this.razonDescripcion1 = razonDescripcion1;
    }


}
