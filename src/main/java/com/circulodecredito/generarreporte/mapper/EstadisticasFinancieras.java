package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class EstadisticasFinancieras {
	
	private EstadisticaFinanciera estadisticaFinanciera;

	@XmlElement(name ="EstadisticaFinanciera")
	public EstadisticaFinanciera getEstadisticaFinanciera() {
		return estadisticaFinanciera;
	}

	public void setEstadisticaFinanciera(EstadisticaFinanciera estadisticaFinanciera) {
		this.estadisticaFinanciera = estadisticaFinanciera;
	}
	
	
}
