package com.circulodecredito.generarreporte.request;

import java.io.Serializable;

import com.cdc.validacionescore.response.ReporteCreditoResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objeto de request del servicio REST
 * @author lfgodinezl
 * @version 1.0
*/
@JsonIgnoreProperties
public class GenerarReporteRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//**** XML => campos para generar el Reporte de Credito
	@JsonProperty("xml")
	private String xml;
	
	
	//**** campo en comun para XML y JSON
	@JsonProperty("fechaReporte")
	private String fechaReporte;
	
	
	@JsonProperty("respuesta")
	private ReporteCreditoResponse respuesta;
	
	public String getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(String fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public String getXml() {
		return xml;
	}
	
	public void setXml(String xml) {
		this.xml = xml;
	}

	public ReporteCreditoResponse getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(ReporteCreditoResponse respuesta) {
		this.respuesta = respuesta;
	}

	
	
}
