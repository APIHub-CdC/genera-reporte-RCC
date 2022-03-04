package com.circulodecredito.generarreporte.xml;

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
	
//    public Can(String identiicadorCan, String prelacionOrigen, String prelacionAnual, String fechaAperturaCan,
//			String fechaCancelacionCan, String historicoCan, String fechaMRCAN, String fechaMACAN) {
//		super();
//		this.identiicadorCan = identiicadorCan;
//		this.prelacionOrigen = prelacionOrigen;
//		this.prelacionAnual = prelacionAnual;
//		this.fechaAperturaCan = fechaAperturaCan;
//		this.fechaCancelacionCan = fechaCancelacionCan;
//		this.historicoCan = historicoCan;
//		this.fechaMRCAN = fechaMRCAN;
//		this.fechaMACAN = fechaMACAN;
//	}
	
   
}
