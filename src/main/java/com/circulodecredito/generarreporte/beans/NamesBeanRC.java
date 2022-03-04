package com.circulodecredito.generarreporte.beans;

import java.io.Serializable;

/**
* Esta clase implementa el Bean para el store procedure de PERSONA el cual
* ser� almacenado cuando un Reporte de Cr�dito Especial sea solicitado.
* @version $Id: NamesBean.java,v 1.1.1.1.2.2 2006/04/19 00:26:38 jcdiaz Exp $
* @author	 <a href="mailto:carlos.diaz@edgebound.com">Juan Carlos D�az Ram�rez.</a>
* @serial EB..CSREPNB
* @since 01/MARZO/2004
*/

public final class NamesBeanRC implements Serializable {
	
	private static final String NOPROPOR = "NO PROPORCIONADO";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	* Variable privada de tipo String que indica el primer nombre de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String nombres = null;
	/**
	* Variable privada de tipo String que indica el segundo nombre de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String apellpat = null;
	/**
	* Variable privada de tipo String que indica el apellido materno de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String apellmat = null;
	/**
	* Variable privada de tipo String que indica el apellido adicional de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String apelladic = null;
	/**
	* Variable privada de tipo String que indica la fecha de nacimiento de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String fechnac = null;
	/**
	* Variable privada de tipo String que indica el rfc de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String rfc = null;
	/**
	* Variable privada de tipo String que indica el curp de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String curp = null;
	/**
	* Variable privada de tipo String que indica la nacionalidad de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String nacionalidad = null;
	/**
	* Variable privada de tipo String que indica la residencia de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String residencia = null;
	/**
	* Variable privada de tipo String que indica el estado civil de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String estadocivil = null;
	/**
	* Variable privada de tipo String que indica el sexo de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String sexo = null;
	/**
	* Variable privada de tipo String que indica la clave del IFE de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String claveife = null;
	/**
	* Variable privada de tipo String que indica el n�mero de dependientes de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String numerodependientes = null;
	/**
	* Variable privada de tipo String que indica la fecha de defunci�n de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String fechadefuncion = null;
	/**
	* Variable privada de tipo String que indica el a�o de nacimiento de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String anio = "";
	/**
	* Variable privada de tipo String que indica el mes de nacimiento de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String mes = "";
	/**
	* Variable privada de tipo String que indica el dia de nacimiento de la persona
	* actual de un Reporte de Cr�dito Especial.
	*/
	private String dia = "";

	/**
	* Constructor del Bean de PERSONA para creditos
	*/

	public NamesBeanRC() {
		super();
	}

	/**
	* En este m�todo se obtiene el APELLIDO PATERNO de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getApellpat() {
		return (this.apellpat);
	}
	/**
	* En este m�todo se almacena el APELLIDO PATERNO de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setApellpat(String apellpat) {
		this.apellpat = validarDato(apellpat);
	}

	/**
	* En este m�todo se obtiene el APELLIDO MATERNO de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getApellmat() {
		return (this.apellmat);
	}
	/**
	* En este m�todo se almacena el APELLIDO MATERNO de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setApellmat(String apellmat) {
		this.apellmat = validarDato(apellmat);
	}
	/**
	* En este m�todo se obtiene el APELLIDO ADICIONAL de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getApelladic() {
		return (this.apelladic);
	}
	/**
	* En este m�todo se almacena el APELLIDO ADICIONAL de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setApelladic(String apelladic) {
		this.apelladic = validarDato(apelladic);
	}
	/**
	* En este m�todo se obtienen los NOMBRES de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getNombres() {
		return (this.nombres);
	}
	/**
	* En este m�todo se almacenan los NOMBRES de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setNombres(String nombres) {
		this.nombres = validarDato(nombres);
	}
	/**
	* En este m�todo se obtiene la FECHA DE NACIMIENTO de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getFechnac() {
		return (this.fechnac);
	}
	/**
	* En este m�todo se almacena la FECHA DE NACIMIENTO de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setFechnac(String fechnac) {
		if (fechnac == null
			|| fechnac.equals("0001-01-01")
			|| fechnac.equals("1901-01-01")
			|| fechnac.equals(""))
			this.fechnac = "";
		else {
			this.fechnac = fechnac.toUpperCase();
			setAnio(this.fechnac);
			setMes(this.fechnac);
			setDia(this.fechnac);
		}

	}

	/**
	* En este m�todo se obtiene el RFC de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getRfc() {
		return (this.rfc);
	}
	/**
	* En este m�todo se almacena el RFC de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setRfc(String rfc) {
		this.rfc = validarDato(rfc);	
	}
	/**
	* En este m�todo se obtiene la NACIONALIDAD actual de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getNacionalidad() {
		return (this.nacionalidad);
	}
	/**
	* En este m�todo se almacena la NACIONALIDAD actual de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = validarDato(nacionalidad);
	}
	/**
	* En este m�todo se obtiene la RESIDENCIA actual de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getResidencia() {
		return (this.residencia);
	}
	/**
	* En este m�todo se almacena la RESIDENCIA actual de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setResidencia(String residencia) {
		this.residencia = validarDato(residencia);
	}

	/**
	* En este m�todo se obtiene el ESTADO CIVIL actual de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEstadocivil() {
		return (this.estadocivil);
	}
	/**
	* En este m�todo se almacena el ESTADO CIVIL actual de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEstadocivil(String estadocivil) {
		this.estadocivil = validarDato(estadocivil);
	}

	/**
	* En este m�todo se obtiene el SEXO actual de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getSexo() {
		return (this.sexo);
	}
	/**
	* En este m�todo se almacena SEXO actual de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setSexo(String sexo) {
		this.sexo = validarDato(sexo);
	}

	/**
	* En este m�todo se obtiene la CLAVE DE ELECTOR actual de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getClaveife() {
		return (this.claveife);
	}
	/**
		* En este m�todo se almacena la CLAVE DE ELECTOR actual de la persona
		* para un Reporte de Cr�dito Especial.
		* @param String
		* @return void
		*/
	public void setClaveife(String claveife) {
		this.claveife = validarDato(claveife);
	}

	/**
	* En este m�todo se obtiene el NUMERO DE DEPENDIENTES de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getNumerodependientes() {
		return (this.numerodependientes);
	}
	/**
		* En este m�todo se almacena el PRIMER NOMBRE de la persona
		* para un Reporte de Cr�dito Especial.
		* @param String
		* @return void
		*/
	public void setNumerodependientes(String numerodependientes) {
		this.numerodependientes = validarDato(numerodependientes);
	}
	/**
	* En este m�todo se obtiene la FECHA DE DEFUNCION de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getFechadefuncion() {
		return (this.fechadefuncion);
	}
	/**
	* En este m�todo se almacena el NUMERO DE EXPEDIENTE de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setFechadefuncion(String fechadefuncion) {
		this.fechadefuncion = validarDato(fechadefuncion);
	}
	/**
	* En este m�todo se obtiene el CURP de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getCurp() {
		return (this.curp);
	}
	/**
	* En este m�todo se almacena el CURP de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setCurp(String curp) {
		this.curp = validarDato(curp);
	}
	/**
	* En este m�todo se obtiene el A�O DE NACIMIENTO de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getAnio() {

		return (this.anio);
	}
	/**
	* En este m�todo se almacena el A�O DE NACIMIENTO de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setAnio(String fechnac) {
		if (fechnac == null)
			this.anio = "";
		else
			this.anio = "/" + fechnac.substring(2, 4);
	}
	/**
	* En este m�todo se obtiene el MES DE NACIMIENTO de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getMes() {

		return (this.mes);
	}
	/**
	* En este m�todo se almacena el MES DE NACIMIENTO de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setMes(String fechnac) {
		if (fechnac == null)
			this.mes = "";
		else {
			this.mes = fechnac.substring(5, 7);
			if (this.mes.equals("01")) {
				this.mes = "ENE";
			}
			if (this.mes.equals("02")) {
				this.mes = "FEB";
			}
			if (this.mes.equals("03")) {
				this.mes = "MAR";
			}
			if (this.mes.equals("04")) {
				this.mes = "ABR";
			}
			if (this.mes.equals("05")) {
				this.mes = "MAY";
			}
			setMesCont(fechnac);
		}
	}
	public void setMesCont (String fechnac) {
		if (this.mes.equals("06")) {
			this.mes = "JUN";
		}
		if (this.mes.equals("07")) {
			this.mes = "JUL";
		}
		if (this.mes.equals("08")) {
			this.mes = "AGO";
		}
		if (this.mes.equals("09")) {
			this.mes = "SEP";
		}
		if (this.mes.equals("10")) {
			this.mes = "OCT";
		}
		if (this.mes.equals("11")) {
			this.mes = "NOV";
		}
		if (this.mes.equals("12")) {
			this.mes = "DIC";
		}
	}
	/**
	* En este m�todo se obtiene el DIA DE NACIMIENTO de la persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getDia() {
		return (this.dia);
	}
	/**
	* En este m�todo se almacena el DIA DE NACIMIENTO de la persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setDia(String fechnac) {
		if (fechnac == null)
			this.dia = "";
		else
			this.dia = fechnac.substring(8, 10) + "/";
	}

	public String validarDato(String universalStg) {
		if (universalStg == null || universalStg.equals("ND") || universalStg.equals(NOPROPOR)) {
			universalStg = "";
		}
		return universalStg;
	}
}
