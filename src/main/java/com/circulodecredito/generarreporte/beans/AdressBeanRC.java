package com.circulodecredito.generarreporte.beans;

import java.io.Serializable;
import java.sql.Date;

import com.circulodecredito.generarreporte.util.FechaFormatRC;
import com.circulodecredito.generarreporte.util.TokenappliesRC;

//import java.util.Enumeration;
//import java.util.Hashtable;

//import java.sql.Time;
//import java.math.BigDecimal;

/**
* Esta clase implementa el Bean para el store procedure de domicilio de una  persona el cual
* ser� almacenado cuando un Reporte de Cr�dito Especial sea solicitado.
* @version $Id: AdressBean.java,v 1.1.1.1.2.2 2006/04/19 00:26:38 jcdiaz Exp $
* @author	 <a href="mailto:carlos.diaz@edgebound.com">Juan Carlos D�az Ram�rez.</a>
* @serial EB..CSREPNB
* @since 02/Marzo/2003
*/
public final class AdressBeanRC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	* Constructor del Bean de Domicilios Registrados
	*/
	public AdressBeanRC() {
		super();
	}

	// step 1 attributes
	/**
	* Variable privada de tipo String que indica la calle del domicilio registrado de la persona.
	*/
	private String direccion = "";
	/**
	* Variable privada de tipo String que indica la colonia del domicilio registrado de la persona.
	*/
	private String colonia = "";
	/**
	* Variable privada de tipo String que indica la delegaci�n �
	* el municipio del domicilio registrado de la persona.
	*/
	private String delmun = "";
	/**
	* Variable privada de tipo String que indica la ciudad del domicilio registrado de la persona.
	*/
	private String ciudad = "";
	/**
	* Variable privada de tipo String que indica el estado del domicilio registrado de la persona.
	*/
	private String estado = "";
	/**
	* Variable privada de tipo String que indica el c�digo postal del domicilio registrado de la persona.
	*/
	private String cp = "";
	/**
	* Variable privada de tipo Date que indica la fecha de residencia en el domicilio registrado de la persona.
	*/
	private String fecharesidencia = null;
	/**
	* Variable privada de tipo String que indica el tel�fono del domicilio registrado de la persona.
	*/
	private String tel = "";
	/**
	* Variable privada de tipo String que indica el tel�fono del domicilio registrado de la persona.
	*/
	private String tipodomicilio = "";
	/**
	* Variable privada de tipo String que indica el tipo de asentamiento del domicilio registrado de la persona.
	*/
	private String tipoasentamiento = "";
	/**
	* Variable privada de tipo String que indica la fecha de registro del domicilio registrado de la persona.
	*/
	private String fecharegistro = "";
	/**
	* Variable privada de tipo String que corta los elementos despues de 12 caracteres para aplicar en cadenas largas.
	*/
	private TokenappliesRC myToken = new TokenappliesRC();
	/**
	* En este m�todo se obtiene la CALLE del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getDireccion() {
		return (this.direccion);
	}
	/**
	* En este m�todo se almacena la CALLE del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setDireccion(String direccion) {
		if (direccion == null)
			this.direccion = "";
		else {
			this.direccion = direccion;
			if (direccion.equals("ND"))
				this.direccion = "";
			if (direccion.equals("NO PROPORCIONADO"))
				this.direccion = "";
		}
	}

	/**
	* En este m�todo se obtiene la COLONIA del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getColonia() {
		return (this.colonia);
	}
	/**
	* En este m�todo se almacena la COLONIA del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setColonia(String colonia) {
		if (colonia == null)
			this.colonia = "";
		else {
			this.colonia = myToken.CutToken(colonia);
			if (colonia.equals("ND"))
				this.colonia = "";
			if (colonia.equals("NO PROPORCIONADO"))
				this.colonia = "";
		}
	}
	/**
	* En este m�todo se obtiene la DELEGACION � MUNICIPIO del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getDelmun() {
		return (this.delmun);
	}
	/**
	* En este m�todo se almacena la DELEGACION � MUNICIPIO del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setDelmun(String delmun) {
		if (delmun == null)
			this.delmun = "";
		else {
			this.delmun = myToken.CutToken(delmun);
			if (delmun.equals("ND"))
				this.delmun = "";
			if (delmun.equals("NO PROPORCIONADO"))
				this.delmun = "";
		}
	}
	/**
	* En este m�todo se obtiene la CIUDAD del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getCiudad() {
		return (this.ciudad);
	}
	/**
	* En este m�todo se almacena la CIUDAD del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setCiudad(String ciudad) {
		if (ciudad == null)
			this.ciudad = "";
		else {
			this.ciudad = myToken.CutToken(ciudad);
			if (ciudad.equals("ND"))
				this.ciudad = "";
			if (ciudad.equals("NO PROPORCIONADO"))
				this.ciudad = "";
		}
	}

	/**
	* En este m�todo se obtiene el ESTADO del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEstado() {
		return (this.estado);
	}
	/**
	* En este m�todo se almacena el ESTADO del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEstado(String estado) {
		if (estado == null)
			this.estado = "";
		else {
			this.estado = estado;
			if (estado.equals("ND"))
				this.estado = "";
			if (estado.equals("NO PROPORCIONADO"))
				this.estado = "";
		}
	}
	/**
	* En este m�todo se obtiene el CODIGO POSTAL del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getCp() {
		return (this.cp);
	}
	/**
	* En este m�todo se almacena el CODIGO POSTAL del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setCp(String cp) {
		if (cp == null)
			this.cp = "";
		else {
			this.cp = cp;
			if (cp.equals("ND"))
				this.cp = "";
			if (cp.equals("NO PROPORCIONADO"))
				this.cp = "";
		}
	}
	/**
	* En este m�todo se obtiene la FECHA DE RESIDENCIA en el domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @return Date
	*/
	public String getFecharesidencia() {
		return (this.fecharesidencia);
	}
	/**
	* En este m�todo se almacena la FECHA DE RESIDENCIA en el domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setFecharesidencia(String fecharesidencia) {
		Date temp = null;
		if (fecharesidencia == null)
			fecharesidencia = "";
		else if (fecharesidencia.equals(""))
			fecharesidencia = "";
		else if (fecharesidencia.equals("0001-01-01"))
			this.fecharesidencia = "";
		else if (fecharesidencia != null) {
			temp = Date.valueOf(fecharesidencia);
			this.fecharesidencia = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.fecharesidencia = temporal.init_fecha(this.fecharesidencia);
		}
	}

	/**
	* En este m�todo se obtiene el TELEFONO del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getTel() {
		return (this.tel);
	}
	/**
	* En este m�todo se almacena el TELEFONO del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setTel(String tel) {
		if (tel == null)
			this.tel = "";
		else {
			this.tel = myToken.CutTokenNumbers(tel);
			if (tel.equals("ND"))
				this.tel = "";
			if (tel.equals("NO PROPORCIONADO"))
				this.tel = "";
		}
	}
	/**
	* En este m�todo se obtiene el TIPO DE DOMICILIO de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getTipodomicilio() {
		return (this.tipodomicilio);
	}
	/**
	* En este m�todo se almacena el TIPO DE DOMICILIO de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setTipodomicilio(String tipodomicilio) {
		if (tipodomicilio == null)
			this.tipodomicilio = "";
		else {
			this.tipodomicilio = tipodomicilio;
			if (tipodomicilio.equals("ND"))
				this.tipodomicilio = "";
			if (tipodomicilio.equals("NO PROPORCIONADO"))
				this.tipodomicilio = "";
		}
	}
	/**
	* En este m�todo se obtiene el TIPO DE ASENTAMIENTO del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getTipoasentamiento() {
		return (this.tipoasentamiento);
	}
	/**
	* En este m�todo se almacena el TIPO DE ASENTAMIENTO del domicilio de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setTipoasentamiento(String tipoasentamiento) {
		if (tipoasentamiento == null)
			this.tipoasentamiento = "";
		else {
			this.tipoasentamiento = tipoasentamiento;
			if (tipoasentamiento.equals("ND"))
				this.tipoasentamiento = "";
			if (tipoasentamiento.equals("NO PROPORCIONADO"))
				this.tipoasentamiento = "";
		}
	}
	/**
	* En este m�todo se obtiene la FECHA DE REGISTRO de la direcci�n de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getFecharegistro() {
		return (this.fecharegistro);
	}
	/**
	* En este m�todo se almacena la FECHA DE REGISTRO de la direcci�n de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setFecharegistro(String fecharegistro) {
		Date temp = null;
		if (fecharegistro == null)
			fecharegistro = "";
		else if (fecharegistro.equals(""))
			fecharegistro = "";
		else if (fecharegistro.equals("0001-01-01"))
			this.fecharegistro = "";
		else if (fecharegistro != null) {
			temp = Date.valueOf(fecharegistro);
			this.fecharegistro = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.fecharegistro = temporal.init_fecha(this.fecharegistro);
		}
	}

}
