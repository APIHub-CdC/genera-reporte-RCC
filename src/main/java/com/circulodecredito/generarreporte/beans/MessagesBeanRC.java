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
public final class MessagesBeanRC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	* Variable privada de tipo String que indica el tipo de mensaje que se entrega a la solicitud
	* actual de un Reporte de Cr�dito Negativo .
	*/
	private String tipomensaje = null;

	/**
	* Variable privada de tipo String que indica el cuerpo del mensaje que se entrega a la solicitud
	* actual de un Reporte de Cr�dito Negativo.
	*/
	private String cuerpomensaje = null;

	/**
	* Constructor por default para obtener el elemento mensaje de un Xml para un Reporte de Cr�dito Negativo .
	* @return String
	*/
	public MessagesBeanRC() {
		super();
	}

	/**
	* En este m�todo se obtiene el tipo de mensaje que se entrega a la solicitud
	* de un Reporte de Cr�dito Negativo .
	* @return String
	*/
	public String getTipomensaje() {
		return (this.tipomensaje);
	}

	/**
	* En este m�todo se almacena el tipo de mensaje que se entrega a la solicitud
	* de  un Reporte de Cr�dito Negativo.
	* @param String
	* @return void
	*/
	public void setTipomensaje(String tipomensaje) {
		if (tipomensaje == null)
			this.tipomensaje = "";
		else {
			this.tipomensaje = tipomensaje;
			if (tipomensaje.equals("ND"))
				this.tipomensaje = "";
			if (tipomensaje.equals("NO PROPORCIONADO"))
				this.tipomensaje = "";
		}
	}

	/**
	* En este m�todo se obtiene el cuerpo del mensaje que se entrega a la solicitud
	* actual de un Reporte de Cr�dito Negativo.
	* @return String
	*/
	public String getCuerpomensaje() {
		return (this.cuerpomensaje);
	}

	/**
	* En este m�todo se almacena el cuerpo del mensaje que se entrega a la solicitud
	* actual de un Reporte de Cr�dito Negativo.
	* @param String
	* @return void
	*/
	public void setCuerpomensaje(String cuerpomensaje) {
		if (cuerpomensaje == null)
			this.cuerpomensaje = "";
		else {
			this.cuerpomensaje = cuerpomensaje;
			if (cuerpomensaje.equals("NO PROPORCIONADO"))
				this.cuerpomensaje = "";
		}
	}

}
