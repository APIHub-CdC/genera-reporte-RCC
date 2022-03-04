package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Razon3 {
	
	private String razonDescripcion3;
	
    
    @XmlElement(name ="RazonDescripcion3")
    public String getRazonDescripcion3() {
        return razonDescripcion3;
    }
    
    public void setRazonDescripcion3(String razonDescripcion3) {
        this.razonDescripcion3 = razonDescripcion3;
    }


}
