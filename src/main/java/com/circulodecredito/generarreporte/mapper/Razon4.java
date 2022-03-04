package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Razon4 {
	
	private String razonDescripcion4;
	
    
    @XmlElement(name ="RazonDescripcion4")
    public String getRazonDescripcion4() {
        return razonDescripcion4;
    }
    
    public void setRazonDescripcion4(String razonDescripcion4) {
        this.razonDescripcion4 = razonDescripcion4;
    }


}
