package com.circulodecredito.generarreporte.beans;

import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;

import com.circulodecredito.generarreporte.util.FechaFormatRC;

/**
* Esta clase implementa el Bean para la consultas realizadas por otros otorgantes a una  persona el cual
* ser� almacenado cuando un Reporte de Cr�dito Especial sea solicitado.
* @version $Id: ConsultsBean.java,v 1.2 2005/08/30 17:09:58 jcdiaz Exp $
* @author	 <a href="mailto:carlos.diaz@edgebound.com">Juan Carlos D�az Ram�rez.</a>
* @serial EB..CSREPNB
* @since 03/MARZO/2003
*/

public final class ConsultsBeanRC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String NOPROPOR = "NO PROPORCIONADO";
	/**
	* Constructor del Bean de Consultas Realizadas por otros otorgantes para el Reporte de Cr�dito Especial
	*/
	public ConsultsBeanRC() {
		super();
	}
	
	
	private  String  descripcionMoneda = "";
	public void setDescripcionMoneda ( String pStr ) {
		pStr = (( pStr == null) ? "" : pStr.trim());
		this.descripcionMoneda = pStr;
	}
	public String getDescripcionMoneda () {
		return this.descripcionMoneda;
	}
	/**
	* Variable privada de tipo String que indica la fecha en que el otorgante consulto a la persona.
	*/
	private String fechacons = null;
	/**
	* Variable privada de tipo String que indica la clave del otorgante que consulto a la persona.
	*/
	private String claveotorgante = null;
	/**
	* Variable privada de tipo String que indica el nombre del otorgante que consulto a la persona.
	*/
	private String nomotor = null;
	/**
	* Variable privada de tipo String que indica el tipo de cr�dito que el otorgante
	*  a otorgar a la persona.
	*/
	private String tipcred = null;
	/**
	* Variable privada de tipo String que indica la clave de la unidad monetaria del cr�dito que se
	*  otorgo a la persona.
	*/
	private String clavemoneda = null;
	/**
	* Variable privada de tipo String que indica el importe del cr�dito que se
	*   otorgo a la persona.
	*/
	private String importecredito = null;
	/**
	* Variable privada de tipo String que indica el tipo de responsabilidad del cr�dito que se
	*   otorgo a la persona.
	*/
	private String tiporesponsabilidad = null;
	/**
	* Variable privada de tipo String que indica la descripci�n del tipo de cuenta del cr�dito que se
	*   otorgo a la persona.
	*/
	private String descripciontipocuenta = null;
	/**
	* Variable privada de tipo String que indica el tipo de otorgante que
	*   otorgo un cr�dito a la persona.
	*/
	private String tipootorgante = null;
	/**
	* Variable privada de tipo String que indica la direcci�n del otorgante que consulto a la persona.
	*/
	private String dir = null;
	/**
	* Variable privada de tipo String que indica el telefono del otorgante que consulto a la  persona.
	*/
	private String tel = null;

	/**
	* En este m�todo se obtiene la FECHA DE CONSULTA referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @return String
	*/
	public String getFechacons() {
		return (this.fechacons);
	}
	/**
	* En este m�todo se almacena la FECHA DE CONSULTA referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @param String
	* @return void
	*/
	public void setFechacons(String fechacons) {
		Date temp = null;
		if (fechacons == null || fechacons.equals("") || fechacons.equals("0001-01-01")) {
			this.fechacons = "";
		} else {
			temp = Date.valueOf(fechacons);
			this.fechacons = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.fechacons = temporal.init_fecha(this.fechacons);
		}
	}
	/**
	* 
	* En este m�todo se obtiene la CLAVE DEL OTORGANTE referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @return String
	*/
	public String getClaveotorgante() {
		return (this.claveotorgante);
	}
	/**
	* En este m�todo se almacena la CLAVE DEL OTORGANTE referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @param String
	* @return void
	*/
	public void setClaveotorgante(String claveotorgante) {
		this.claveotorgante = claveotorgante;
		if (claveotorgante == null || claveotorgante.equals(""))
			this.claveotorgante = "";
		else {
			if (claveotorgante.equals("ND"))
				this.claveotorgante = "";
			if (claveotorgante.equals(NOPROPOR))
				this.claveotorgante = "";
		}
	}
	/**
	* En este m�todo se obtiene el NOMBRE CORTO referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @return String
	*/
	public String getNomotor() {
		return (this.nomotor);
	}

	/**
	* En este m�todo se almacena el NOMBRE CORTO referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @param String
	* @return void
	*/
	public void setNomotor(String nomotor) {
		this.nomotor = nomotor;
		if (nomotor == null || nomotor.equals(""))
			this.nomotor = "";
		else {
			if (nomotor.equals("ND"))
				this.nomotor = "";
			if (nomotor.equals(NOPROPOR))
				this.nomotor = "";
		}
	}
	/**
	* En este m�todo se obtiene la DESCRIPCION DEL TIPO DE CREDITO referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona
	* @return String
	*/
	public String getTipcred() {
		return (this.tipcred);
	}
	/** 
	* En este m�todo se almacena la DESCRIPCION DEL TIPO DE CREDITO referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @param String
	* @return void
	*/
	public void setTipcred(String tipcred) {
		this.tipcred = tipcred;
		if (tipcred == null || tipcred.equals(""))
			this.tipcred = "";
		else {
			if (tipcred.equals("ND"))
				this.tipcred = "";
			if (tipcred.equals(NOPROPOR))
				this.tipcred = "";
		}
	}

	/**
	* En este m�todo se obtiene la CLAVE DE MONEDA del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona
	* @return String
	*/
	public String getClavemoneda() {
		return (this.clavemoneda);
	}
	/**
	* En este m�todo se obtiene la CLAVE DE MONEDA del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @param String
	* @return void
	*/
	public void setClavemoneda(String clavemoneda) {
		this.clavemoneda = clavemoneda;
		if (clavemoneda == null || clavemoneda.equals(""))
			this.clavemoneda = "";
		else {
			if (clavemoneda.equals("ND"))
				this.clavemoneda = "";
			if (clavemoneda.equals(NOPROPOR))
				this.clavemoneda = "";
		}
	}
	/**
	* En este m�todo se obtiene el IMPORTE del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona
	* @return String
	*/
	public String getImportecredito() {
		return (this.importecredito);
	}
	/**
	* En este m�todo se almacena el IMPORTE del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @param String
	* @return void
	*/
	public void setImportecredito(String importecredito) {
		if (importecredito == null || importecredito.equals(""))
			this.importecredito = "";
		else {
			NumberFormat forma;
			forma = NumberFormat.getInstance();
			this.importecredito = forma.format(Long.parseLong(importecredito));
		}
		if (this.importecredito.equals("ND"))
			this.importecredito = "";
		if (this.importecredito.equals(NOPROPOR))
			this.importecredito = "";
	}

	/**
	* En este m�todo se obtiene el IMPORTE del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona
	* @return String
	*/
	public String getTiporesponsabilidad() {
		return (this.tiporesponsabilidad);
	}
	/**
	* En este m�todo se almacena el IMPORTE del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @param String
	* @return void
	*/
	public void setTiporesponsabilidad(String tiporesponsabilidad) {
		this.tiporesponsabilidad = tiporesponsabilidad;
		if (tiporesponsabilidad == null || tiporesponsabilidad.equals(""))
			this.tiporesponsabilidad = "";
		else {
			if (tiporesponsabilidad.equals("ND"))
				this.tiporesponsabilidad = "";
			if (tiporesponsabilidad.equals(NOPROPOR))
				this.tiporesponsabilidad = "";
		}
	}
	/**
	 * En este m�todo se obtiene la DESCRIPCION DEL TIPO DE CUENTA del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona
	 * @return String
	 */
	public String getDescripciontipocuenta() {
		return (this.descripciontipocuenta);
	}
	/**
	* En este m�todo se almacena la DESCRIPCION DEL TIPO DE CUENTA del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @param String
	* @return void
	*/
	public void setDescripciontipocuenta(String descripciontipocuenta) {
		if (descripciontipocuenta == null)
			this.descripciontipocuenta = "";
		else {
			this.descripciontipocuenta = descripciontipocuenta;
			if (descripciontipocuenta.equals("ND"))
				this.descripciontipocuenta = "";
			if (descripciontipocuenta.equals(NOPROPOR))
				this.descripciontipocuenta = "";
		}
	}
	/**
	 *  En este m�todo se obtiene la DESCRIPCION DEL TIPO DE CUENTA del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona
	 * @return String
	 */
	public String getTipootorgante() {
		return (this.tipootorgante);
	}
	/**
	* En este m�todo se almacena la DESCRIPCION DEL TIPO DE CUENTA del cr�dito a otorgar referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito Especial de la Persona.
	* @param String
	* @return void
	*/
	public void setTipootorgante(String tipootorgante) {
		if (tipootorgante == null)
			this.tipootorgante = "";
		else {
			this.tipootorgante = tipootorgante;
			if (tipootorgante.equals("ND"))
				this.tipootorgante = "";
			if (tipootorgante.equals(NOPROPOR))
				this.tipootorgante = "";
		}
	}
	/**
	* En este m�todo se obtiene la DIRECCION referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito de la Persona
	* @return String
	*/
	public String getDir() {
		return (this.dir);
	}

	/**
	* En este m�todo se almacena la DIRECCION referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito de la Persona
	* @param String
	* @return void
	*/
	public void setDir(String dir) {
		if (dir == null || dir.equals(""))
			this.dir = "";
		else {
			this.dir = dir;
			if (dir.equals("ND"))
				this.dir = "";
			if (dir.equals(NOPROPOR))
				this.dir = "";
		}

	}
	/**
	* En este m�todo se obtiene el NUMERO TELEFONICO referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito de la Persona
	* @return String
	*/
	public String getTel() {
		return (this.tel);
	}

	/**
	* En este m�todo se almacena el NUMERO TELEFONICO referente al otorgante que ha solicitado anteriormente un Reporte de Cr�dito de la Persona
	* @param String
	* @return void
	*/
	public void setTel(String tel) {
		if (tel == null || tel.equals(""))
			this.tel = "";
		else {
			this.tel = tel;
			if (tel.equals("ND"))
				this.tel = "";
			if (tel.equals(NOPROPOR))
				this.tel = "";
		}
	}

}
