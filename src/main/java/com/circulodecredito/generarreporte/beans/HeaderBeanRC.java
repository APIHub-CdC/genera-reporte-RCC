package com.circulodecredito.generarreporte.beans;

import java.io.Serializable;

/**
* Esta clase implementa el Bean para almacenar elementos cabecera de el XML de respuesta
* cuando un Reporte de Cr�dito  sea solicitado.
* @version $Id: HeaderBean.java,v 1.1.1.1.2.2 2006/04/19 00:26:37 jcdiaz Exp $
* @author	 <a href="mailto:carlos.diaz@edgebound.com">Juan Carlos D�az Ram�rez.</a>
* @serial EB..CSREPNB
* @since 04/MARZO/2004
*/
public final class HeaderBeanRC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	* Variable privada de tipo String que indica el folio de consulta del otorgante que consulto a la persona
	* actual de un Reporte de Cr�dito .
	*/
	private String folioconsultaotorgante = null;

	/**
	* Variable privada de tipo String que indica clave del otorgante que consulto a la persona
	* actual de un Reporte de Cr�dito .
	*/
	private String claveotorgante = null;

	/**
	* Variable privada de tipo String que indica el n�mero de expedientes encontrados de la persona
	* actual de un Reporte de Cr�dito .
	*/
	private String expedienteencontrado = null;

	/**
	* Variable privada de tipo String que indica el folio de la consulta de la persona
	* actual de un Reporte de Cr�dito .
	*/
	private String folioconsulta = null;

	/**
	* Variable privada de tipo String que indica el grupo del otorgante que busco a la persona
	* actual de un Reporte de Cr�dito.
	*/
	private String grupootorgante = null;

	/**
	* Variable privada de tipo String que indica el grupo subgrupo del reporte *en caso de ser un reporte de cr�dito negativo.
	*/
	private String subproducto = null;

	/**
	* Constructor por default para obtener el elemento cabecera de un Xml para un Reporte de Cr�dito .
	* @return String
	*/
	public HeaderBeanRC() {
		super();
	}

	/**
	* En este m�todo se obtiene el FOLIO DE CONSULTA DEL OTORGANTE que consulto a la persona
	* para un Reporte de Cr�dito .
	* @return String
	*/
	public String getFolioconsultaotorgante() {
		return (this.folioconsultaotorgante);
	}

	/**
	* En este m�todo se almacena el FOLIO DE CONSULTA DEL OTORGANTE que consulto a la persona
	* para un Reporte de Cr�dito .
	* @param String
	* @return void
	*/
	public void setFolioconsultaotorgante(String folioconsultaotorgante) {
		if (folioconsultaotorgante == null)
			this.folioconsultaotorgante = "";
		else {
			this.folioconsultaotorgante = folioconsultaotorgante;
			if (folioconsultaotorgante.equals("ND"))
				this.folioconsultaotorgante = "";
			if (folioconsultaotorgante.equals("NO PROPORCIONADO"))
				this.folioconsultaotorgante = "";
		}
	}

	/**
	* En este m�todo se obtiene la CLAVE DEL OTORGANTE que consulto a la persona
	* para un Reporte de Cr�dito .
	* @return String
	*/
	public String getClaveotorgante() {
		return (this.claveotorgante);
	}

	/**
	* En este m�todo se almacena la CLAVE DEL OTORGANTE que consulto a la persona
	* para un Reporte de Cr�dito .
	* @param String
	* @return void
	*/
	public void setClaveotorgante(String claveotorgante) {
		if (claveotorgante == null)
			this.claveotorgante = "";
		else {
			this.claveotorgante = claveotorgante;
			if (claveotorgante.equals("NO PROPORCIONADO"))
				this.claveotorgante = "";
		}
	}

	/**
	* En este m�todo se obtiene el NUMERO DE EXPEDIENTES encontrados de la persona
	* para un Reporte de Cr�dito .
	* @return String
	*/
	public String getExpedienteencontrado() {
		return (this.expedienteencontrado);
	}

	/**
	* En este m�todo se almacena el NUMERO DE EXPEDIENTES encontrados de la persona
	* para un Reporte de Cr�dito .
	* @param String
	* @return void
	*/
	public void setExpedienteencontrado(String expedienteencontrado) {
		if (expedienteencontrado == null)
			this.expedienteencontrado = "";
		else {
			this.expedienteencontrado = expedienteencontrado;
			if (expedienteencontrado.equals("ND"))
				this.expedienteencontrado = "";
			if (expedienteencontrado.equals("NO PROPORCIONADO"))
				this.expedienteencontrado = "";
		}
	}

	/**
	* En este m�todo se obtiene el FOLIO DE CONSULTA de la persona
	* para un Reporte de Cr�dito .
	* @return String
	*/
	public String getFolioconsulta() {
		return (this.folioconsulta);
	}

	/**
	* En este m�todo se almacena FOLIO DE CONSULTA de la persona
	* para un Reporte de Cr�dito .
	* @param String
	* @return void
	*/
	public void setFolioconsulta(String folioconsulta) {
		if (folioconsulta == null)
			this.folioconsulta = "";
		else {
			this.folioconsulta = folioconsulta;
			if (folioconsulta.equals("ND"))
				this.folioconsulta = "";
			if (folioconsulta.equals("NO PROPORCIONADO"))
				this.folioconsulta = "";
		}
	}

	/**
	* En este m�todo se obtiene el GRUPO DEL OTORGANTE que consulto a la persona
	* para un Reporte de Cr�dito .
	* @return String
	*/
	public String getGrupootorgante() {
		return (this.grupootorgante);
	}

	/**
	* En este m�todo se almacena el GRUPO DEL OTORGANTE que consulto a la persona
	* para un Reporte de Cr�dito .
	* @param String
	* @return void
	*/
	public void setGrupootorgante(String grupootorgante) {
		if (grupootorgante == null)
			this.grupootorgante = "";
		else
			this.grupootorgante = grupootorgante.toUpperCase();
	}

	/**
	* En este m�todo se obtiene el GRUPO DEL OTORGANTE que consulto a la persona
	* para un Reporte de Cr�dito Negativo
	* @return String
	*/
	public String getSubproducto() {
		return (this.subproducto);
	}

	/**
	* En este m�todo se almacena el SUBGRUPO
	* para un Reporte de Cr�dito Negativo .
	* @param String
	* @return void
	*/
	public void setSubproducto(String subproducto) {
		if (subproducto == null)
			this.subproducto = "";
		else
			this.subproducto = subproducto.toUpperCase();
	}

}
