package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Can {
	
	//pertenecen al XML
    private String identiicadorCan;
    private String prelacionOrigen;
    private String prelacionAnual;
    private String fechaAperturaCan;
    private String fechaCancelacionCan;
    private String historicoCan;
    private String fechaMRCAN;
    private String fechaMACAN;
    //Extras de jasper
    private Integer noCredito;
    private String productoResponsabiliad;
    private String credito;
    private String otorgante;
    

    @XmlElement(name ="IdentificadorCAN")
    public String getIdentiicadorCan() { return identiicadorCan; }
    public void setIdentiicadorCan(String identiicadorCan) { this.identiicadorCan = identiicadorCan; }

    @XmlElement(name ="PrelacionOrigen")
    public String getPrelacionOrigen() { return prelacionOrigen; }
    public void setPrelacionOrigen(String prelacionOrigen) { this.prelacionOrigen = prelacionOrigen; }

    @XmlElement(name ="PrelacionActual")
    public String getPrelacionAnual() { return prelacionAnual; }
    public void setPrelacionAnual(String prelacionAnual) { this.prelacionAnual = prelacionAnual; }

    @XmlElement(name ="FechaAperturaCAN")
    public String getFechaAperturaCan() { return fechaAperturaCan; }
    public void setFechaAperturaCan(String fechaAperturaCan) { this.fechaAperturaCan = fechaAperturaCan; }

    @XmlElement(name ="FechaCancelacionCAN")
    public String getFechaCancelacionCan() { return fechaCancelacionCan; }
    public void setFechaCancelacionCan(String fechaCancelacionCan) { this.fechaCancelacionCan = fechaCancelacionCan; }

    @XmlElement(name ="HistoricoCAN")
    public String getHistoricoCan() { return historicoCan; }
    public void setHistoricoCan(String historicoCan) { this.historicoCan = historicoCan; }

    @XmlElement(name ="FechaMRCAN")
    public String getFechaMRCAN() { return fechaMRCAN; }
    public void setFechaMRCAN(String fechaMRCAN) { this.fechaMRCAN = fechaMRCAN; }

    @XmlElement(name ="FechaMACAN")
    public String getFechaMACAN() { return fechaMACAN; }
    public void setFechaMACAN(String fechaMACAN) { this.fechaMACAN = fechaMACAN; }
	
   
    
    
	public Integer getNoCredito() {
		return noCredito;
	}
	public void setNoCredito(Integer noCredito) {
		this.noCredito = noCredito;
	}
	public String getProductoResponsabiliad() {
		return productoResponsabiliad;
	}
	public void setProductoResponsabiliad(String productoResponsabiliad) {
		this.productoResponsabiliad = productoResponsabiliad;
	}
	public String getCredito() {
		return credito;
	}
	public void setCredito(String credito) {
		this.credito = credito;
	}
	public String getOtorgante() {
		return otorgante;
	}
	public void setOtorgante(String otorgante) {
		this.otorgante = otorgante;
	}
    
    
}
