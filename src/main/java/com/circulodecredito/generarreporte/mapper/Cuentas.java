package com.circulodecredito.generarreporte.mapper;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Cuentas {
	
    private List<Cuenta> cuenta;

    @XmlElement(name ="Cuenta")
	public List<Cuenta> getCuenta() {
		return cuenta;
	}

	public void setCuenta(List<Cuenta> cuenta) {
		this.cuenta = cuenta;
	}
}
