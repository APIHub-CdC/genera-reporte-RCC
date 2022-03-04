package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Razon2 {
	
	private String razonDescripcion2;
	
    
    @XmlElement(name ="RazonDescripcion2")
    public String getRazonDescripcion2() {
        return razonDescripcion2;
    }
    
    public void setRazonDescripcion2(String razonDescripcion2) {
        this.razonDescripcion2 = razonDescripcion2;
    }


}
