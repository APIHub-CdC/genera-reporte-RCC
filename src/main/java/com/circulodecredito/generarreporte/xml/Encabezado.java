package com.circulodecredito.generarreporte.xml;

import javax.xml.bind.annotation.XmlElement;

public class Encabezado {
	
	private String folioConsultaOtorgante;
    private String claveOtorgante;
    private String expedienteEncontrado;
    private String folioConsulta;

    @XmlElement(name ="FolioConsultaOtorgante")
    public String getFolioConsultaOtorgante() {
        return folioConsultaOtorgante;
    }

    @XmlElement(name ="ClaveOtorgante")
    public String getClaveOtorgante() {
        return claveOtorgante;
    }

    @XmlElement(name ="ExpedienteEncontrado")
    public String getExpedienteEncontrado() {
        return expedienteEncontrado;
    }

    @XmlElement(name ="FolioConsulta")
    public String getFolioConsulta() {
        return folioConsulta;
    }
    
    public void setFolioConsultaOtorgante(String folioConsultaOtorgante) {
        this.folioConsultaOtorgante = folioConsultaOtorgante;
    }

    public void setClaveOtorgante(String claveOtorgante) {
        this.claveOtorgante = claveOtorgante;
    }

    public void setExpedienteEncontrado(String expedienteEncontrado) {
        this.expedienteEncontrado = expedienteEncontrado;
    }

    public void setFolioConsulta(String folioConsulta) {
        this.folioConsulta = folioConsulta;
    }
}
