package com.circulodecredito.generarreporte.beans;

import java.io.Serializable;

/**
* Esta clase implementa el Bean para almacenar elementos de mensajes de el XML de respuesta
* cuando un Reporte de Cr�dito  sea solicitado.
* @version $Id: MessagesBean.java,v 1.1.1.1.2.2 2006/04/19 00:26:38 jcdiaz Exp $
* @author	 <a href="mailto:carlos.diaz@edgebound.com">Juan Carlos D�az Ram�rez.</a>
* @serial EB..CSREPNB
* @since 14/ENERO/2005
*/
public final class AuthenticationBeanRC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	* Variable privada de tipo String que indica el tipo de mensaje que se entrega a la solicitud
	* actual de un Reporte de Cr�dito Negativo .
	*/
	private String numeroSolicitud = null;

	/**
	* Variable privada de tipo String que indica el cuerpo del mensaje que se entrega a la solicitud
	* actual de un Reporte de Cr�dito Negativo.
	*/
	private String estatus = null;
	
	/**
	* Variable privada de tipo String que indica el numero de autenticacion
	*/
	private String numeroAutenticacion = null;

	/**
	* Constructor por default para obtener el elemento mensaje de un Xml para un Reporte de Cr�dito Negativo .
	* @return String
	*/
	public AuthenticationBeanRC() {
		super();
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}

	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

	public String getNumeroAutenticacion() {
		return numeroAutenticacion;
	}

	public void setNumeroAutenticacion(String numeroAutenticacion) {
		this.numeroAutenticacion = numeroAutenticacion;
	}

}
