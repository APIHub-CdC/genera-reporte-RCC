package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class DescripcionRazones {
	
	private String razon1;
	private String razon2;
	private String razon3;
	private String razon4;
	
	private String razonDescripcion1;
	private String razonDescripcion2;
	private String razonDescripcion3;
	private String razonDescripcion4;

	@XmlElement(name ="RazonDescripcion1")
    public String getRazonDescripcion1() {
		return razonDescripcion1;
	}

	public void setRazonDescripcion1(String razonDescripcion1) {
		this.razonDescripcion1 = razonDescripcion1;
	}

	@XmlElement(name ="RazonDescripcion2")
	public String getRazonDescripcion2() {
		return razonDescripcion2;
	}

	public void setRazonDescripcion2(String razonDescripcion2) {
		this.razonDescripcion2 = razonDescripcion2;
	}

	@XmlElement(name ="RazonDescripcion3")
	public String getRazonDescripcion3() {
		return razonDescripcion3;
	}

	public void setRazonDescripcion3(String razonDescripcion3) {
		this.razonDescripcion3 = razonDescripcion3;
	}

	@XmlElement(name ="RazonDescripcion4")
	public String getRazonDescripcion4() {
		return razonDescripcion4;
	}

	public void setRazonDescripcion4(String razonDescripcion4) {
		this.razonDescripcion4 = razonDescripcion4;
	}

	@XmlElement(name ="Razon1")
    public String getRazon1() {
        return razon1;
    }
    
    public void setRazon1(String razon1) {
        this.razon1 = razon1;
    }
    
    @XmlElement(name ="Razon2")
    public String getRazon2() {
        return razon2;
    }
    
    public void setRazon2(String razon2) {
        this.razon2 = razon2;
    }
    
    @XmlElement(name ="Razon3")
    public String getRazon3() {
        return razon3;
    }
    
    public void setRazon3(String razon3) {
        this.razon3 = razon3;
    }
	
    @XmlElement(name ="Razon4")
    public String getRazon4() {
        return razon4;
    }
    
    public void setRazon4(String razon4) {
        this.razon4 = razon4;
    }
}
