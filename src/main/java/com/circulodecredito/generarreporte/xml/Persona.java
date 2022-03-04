package com.circulodecredito.generarreporte.xml;

import javax.xml.bind.annotation.XmlElement;

public class Persona {

	
	private Encabezado encabezado;
    private Nombre nombre;
    private Domicilios domicilios;
    private Empleos empleos;
    private Mensajes mensajes;
    private Cuentas cuentas;
    //private TendenciasFinancieras tendenciasFinancieras;
    //private EstadisticasFinancieras estadisticasFinancieras;
    //private ResumenCuentas resumenCuentas;
    private ConsultasEfectuadas consultasEfectuadas;
    private String declaracionesConsumidor;
    //private Autenticacion autenticacion;
    private Scores scores;
    
    @XmlElement(name ="Encabezado")
	public Encabezado getEncabezado() {
		return encabezado;
	}
	public void setEncabezado(Encabezado encabezado) {
		this.encabezado = encabezado;
	}
	@XmlElement(name ="Nombre")
	public Nombre getNombre() {
		return nombre;
	}
	public void setNombre(Nombre nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name ="Domicilios")
	public Domicilios getDomicilios() {
		return domicilios;
	}
	public void setDomicilios(Domicilios domicilios) {
		this.domicilios = domicilios;
	}
	@XmlElement(name ="Empleos")
	public Empleos getEmpleos() {
		return empleos;
	}
	public void setEmpleos(Empleos empleos) {
		this.empleos = empleos;
	}
	@XmlElement(name ="Mensajes")
	public Mensajes getMensajes() {
		return mensajes;
	}
	public void setMensajes(Mensajes mensajes) {
		this.mensajes = mensajes;
	}
	@XmlElement(name ="Cuentas")
	public Cuentas getCuentas() {
		return cuentas;
	}
	public void setCuentas(Cuentas cuentas) {
		this.cuentas = cuentas;
	}
	@XmlElement(name ="ConsultasEfectuadas")
	public ConsultasEfectuadas getConsultasEfectuadas() {
		return consultasEfectuadas;
	}
	public void setConsultasEfectuadas(ConsultasEfectuadas consultasEfectuadas) {
		this.consultasEfectuadas = consultasEfectuadas;
	}
	@XmlElement(name ="DeclaracionesConsumidor")
	public String getDeclaracionesConsumidor() {
		return declaracionesConsumidor;
	}
	public void setDeclaracionesConsumidor(String declaracionesConsumidor) {
		this.declaracionesConsumidor = declaracionesConsumidor;
	}
	@XmlElement(name ="Scores")
	public Scores getScores() {
		return scores;
	}
	public void setScores(Scores scores) {
		this.scores = scores;
	}
    
    
    
    
}
