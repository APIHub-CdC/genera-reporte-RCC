package com.circulodecredito.generarreporte.beans;
import java.io.Serializable;
import java.sql.Date;

import com.circulodecredito.generarreporte.util.FechaFormatRC;
import com.circulodecredito.generarreporte.util.TokenappliesRC;

//import java.sql.Time;
//import java.math.BigDecimal;

/**
* Esta clase implementa el Bean para el store procedure de empleos registrados de una  persona el cual
* ser� almacenado cuando un Reporte de Cr�dito Especial sea solicitado.
* @version $Id: JobBean.java,v 1.1.1.1.2.2 2006/04/19 00:26:38 jcdiaz Exp $
* @author	 <a href="mailto:carlos.diaz@edgebound.com">Juan Carlos D�az Ram�rez.</a>
* @serial EB..CSREPNB
* @since 02/MARZO/2003
*/
public final class JobBeanRC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	* Constructor del Bean de Empleos Registrados
	*/
	public JobBeanRC() {
		super();
	}

	/**
	* Variable privada de tipo String que indica el nombre de la compa��a
	* del empleo registrado de la persona.
	*/
	private String empcomp = "";
	/**
	* Variable privada de tipo String que indica la calle de la compa��a
	* del empleo registrado de la persona.
	*/
	private String empdireccion = "";
	/**
	* Variable privada de tipo String que indica la colonia de la compa��a
	* del empleo registrado de la persona.
	*/
	private String empcolonia = "";
	/**
	* Variable privada de tipo String que indica la delegaci�n � municipio de la compa��a
	* del empleo registrado de la persona.
	*/
	private String empdelmun = "";
	/**
	* Variable privada de tipo String que indica la ciudad registrado del empleo.
	*/
	private String empciudad = "";
	/**
	* Variable privada de tipo String que indica el estado registrado del empleo.
	*/
	private String empestado = "";
	/**
	* Variable privada de tipo String que indica el c�digo postal registrado del empleo.
	*/
	private String empcp = ""; //DEBERIA SER INT
	/**
	* Variable privada de tipo String que indica el telefono registrado del empleo.
	*/
	private String emptel = "";
	/**
	* Variable privada de tipo String que indica la extensi�n del telefono registrado del empleo.
	*/
	private String empextension = "";
	/**
	* Variable privada de tipo String que indica el n�mero de fax registrado del empleo.
	*/
	private String empfax = "";
	/**
	* Variable privada de tipo String que indica el puesto en la compa��a
	* del empleo registrado de la persona.
	*/
	private String emppuesto = "";
	/**
	* Variable privada de tipo String que indica la fecha de contrataci�n en la compa��a
	* del empleo registrado de la persona.
	*/
	private String fechacontratacion = "";
	/**
	* Variable privada de tipo String que indica la clave monetaria del salario
	* del empleo registrado de la persona.
	*/
	private String empclavemoneda = "";
	/**
	* Variable privada de tipo String que indica el salario
	* del empleo registrado de la persona.
	*/
	private String empsalario = "";
	/**
	* Variable privada de tipo String que indica la fecha del �ltimo d�a
	* del empleo registrado de la persona.
	*/
	private String fechaultimodiaempleo = "";
	/**
	* Variable privada de tipo String que indica la fecha de verificaci�n
	*  del empleo registrado de la persona.
	*/
	private String fechaverificacionempleo = "";
	/**
	* Variable privada de tipo String que corta los elementos despues de 12 caracteres para aplicar en cadenas largas.
	*/
	private TokenappliesRC myToken = new TokenappliesRC();

	/**
	* En este m�todo se obtiene el NOMBRE DE LA EMPRESA del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpcomp() {
		return (this.empcomp);
	}
	/**
	* En este m�todo se almacena el NOMBRE DE LA EMPRESA del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpcomp(String empcomp) {
		if (empcomp == null)
			this.empcomp = "";
		else {
			this.empcomp = empcomp;
			if (empcomp.equals("ND"))
				this.empcomp = "";
			if (empcomp.equals("NO PROPORCIONADO"))
				this.empcomp = "";
		}
	}
	/**
	* En este m�todo se obtiene la CALLE del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpdireccion() {
		return (this.empdireccion);
	}
	/**
	* En este m�todo se almacena la CALLE del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpdireccion(String empdireccion) {
		if (empdireccion == null)
			this.empdireccion = "";
		else {
			this.empdireccion = empdireccion;
			if (empdireccion.equals("ND"))
				this.empdireccion = "";
			if (empdireccion.equals("NO PROPORCIONADO"))
				this.empdireccion = "";
		}
	}
	/**
	* En este m�todo se obtiene la COLONIA del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpcolonia() {
		return (this.empcolonia);
	}
	/**
	* En este m�todo se almacena la COLONIA del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpcolonia(String empcolonia) {
		if (empcolonia == null)
			this.empcolonia = "";
		else {
			this.empcolonia = myToken.CutToken(empcolonia);
			if (empcolonia.equals("ND"))
				this.empcolonia = "";
			if (empcolonia.equals("NO PROPORCIONADO"))
				this.empcolonia = "";
		}
	}
	/**
	* En este m�todo se obtiene la DELEGACION � MUNICIPIO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpdelmun() {
		return (this.empdelmun);
	}
	/**
	* En este m�todo se almacena la DELEGACION � MUNICIPIO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpdelmun(String empdelmun) {
		if (empdelmun == null)
			this.empdelmun = "";
		else {
			this.empdelmun = myToken.CutToken(empdelmun);
			if (empdelmun.equals("ND"))
				this.empdelmun = "";
			if (empdelmun.equals("NO PROPORCIONADO"))
				this.empdelmun = "";
		}
	}
	/**
	* En este m�todo se obtiene la CIUDAD del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpciudad() {
		return (this.empciudad);
	}
	/**
	* En este m�todo se almacena la CIUDAD del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpciudad(String empciudad) {
		if (empciudad == null)
			this.empciudad = "";
		else {
			this.empciudad = myToken.CutToken(empciudad);
			if (empciudad.equals("ND"))
				this.empciudad = "";
			if (empciudad.equals("NO PROPORCIONADO"))
				this.empciudad = "";
		}
	}
	/**
	* En este m�todo se obtiene el ESTADO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpestado() {
		return (this.empestado);
	}
	/**
	* En este m�todo se almacena el ESTADO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpestado(String empestado) {
		if (empestado == null)
			this.empestado = "";
		else {
			this.empestado = empestado;
			if (empestado.equals("ND"))
				this.empestado = "";
			if (empestado.equals("NO PROPORCIONADO"))
				this.empestado = "";
		}
	}
	/**
	* En este m�todo se obtiene el CODIGO POSTAL del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpcp() {
		return (this.empcp);
	}
	/**
	* En este m�todo se almacena el CODIGO POSTAL del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpcp(String empcp) {
		if (empcp == null)
			this.empcp = "";
		else {
			this.empcp = empcp;
			if (empcp.equals("ND"))
				this.empcp = "";
			if (empcp.equals("NO PROPORCIONADO"))
				this.empcp = "";
		}
	}
	/**
	* En este m�todo se obtiene el NUMERO TELEFONICO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmptel() {
		return (this.emptel);
	}
	/**
	* En este m�todo se almacena el NUMERO TELEFONICO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmptel(String emptel) {
		if (emptel == null)
			this.emptel = "";
		else {
			this.emptel = myToken.CutToken(emptel);
			if (emptel.equals("ND"))
				this.emptel = "";
			if (emptel.equals("NO PROPORCIONADO"))
				this.emptel = "";
		}
	}
	/**
	* En este m�todo se obtiene el NUMERO DE EXTENSION del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpextension() {
		return (this.empextension);
	}
	/**
	* En este m�todo se almacena el NUMERO DE EXTENSION del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpextension(String empextension) {
		if (empextension == null)
			this.empextension = "";
		else {
			this.empextension = empextension;
			if (empextension.equals("ND"))
				this.empextension = "";
			if (empextension.equals("NO PROPORCIONADO"))
				this.empextension = "";
		}
	}
	/**
	* En este m�todo se obtiene el NUMERO DE FAX del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpfax() {
		return (this.empfax);
	}
	/**
	* En este m�todo se almacena el NUMERO DE FAX del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpfax(String empfax) {
		if (empfax == null)
			this.empfax = "";
		else {
			this.empfax = empfax;
			if (empfax.equals("ND"))
				this.empfax = "";
			if (empfax.equals("NO PROPORCIONADO"))
				this.empfax = "";
		}
	}
	/**
	* En este m�todo se obtiene el PUESTO DEL EMPLEO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmppuesto() {
		return (this.emppuesto);
	}
	/**
	* En este m�todo se almacena el PUESTO DEL EMPLEO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmppuesto(String emppuesto) {
		if (emppuesto == null)
			this.emppuesto = "";
		else {
			this.emppuesto = emppuesto;
			if (emppuesto.equals("ND"))
				this.emppuesto = "";
			if (emppuesto.equals("NO PROPORCIONADO"))
				this.emppuesto = "";
		}
	}
	/**
	* En este m�todo se obtiene la FECHA DE CONTRTACION del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getFechacontratacion() {
		return (this.fechacontratacion);
	}
	/**
	* En este m�todo se almacena la FECHA DE CONTRTACION del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setFechacontratacion(String fechacontratacion) {
		Date temp = null;
		if (fechacontratacion == null)
			fechacontratacion = "";
		else if (fechacontratacion.equals(""))
			fechacontratacion = "";
		else if (fechacontratacion.equals("0001-01-01"))
			this.fechacontratacion = "";
		else if (fechacontratacion != null) {
			temp = Date.valueOf(fechacontratacion);
			this.fechacontratacion = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.fechacontratacion = temporal.init_fecha(this.fechacontratacion);
		}
	}
	/**
	* En este m�todo se obtiene la CLAVE MONETARIA del salario del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpclavemoneda() {
		return (this.empclavemoneda);
	}
	/**
	* En este m�todo se almacena la CLAVE MONETARIA del salario del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpclavemoneda(String empclavemoneda) {
		if (empclavemoneda == null)
			this.empclavemoneda = "";
		else {
			this.empclavemoneda = empclavemoneda;
			if (empclavemoneda.equals("ND"))
				this.empclavemoneda = "";
			if (empclavemoneda.equals("NO PROPORCIONADO"))
				this.empclavemoneda = "";
		}
	}
	/**
	* En este m�todo se obtiene el SALARIO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getEmpsalario() {
		return (this.empsalario);
	}
	/**
	* En este m�todo se almacena el SALARIO del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setEmpsalario(String empsalario) {
		if (empsalario == null)
			this.empsalario = "";
		else {
			this.empsalario = empsalario;
			if (empsalario.equals("ND"))
				this.empsalario = "";
			if (empsalario.equals("NO PROPORCIONADO"))
				this.empsalario = "";
		}
	}
	/**
	* En este m�todo se obtiene la FECHA DEL ULTIMO DIA del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getFechaultimodiaempleo() {
		return (this.fechaultimodiaempleo);
	}
	/**
	* En este m�todo se almacena la FECHA DEL ULTIMO DIA del empleo registrado de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setFechaultimodiaempleo(String fechaultimodiaempleo) {
		Date temp = null;
		if (fechaultimodiaempleo == null)
			fechaultimodiaempleo = "";
		else if (fechaultimodiaempleo.equals(""))
			fechaultimodiaempleo = "";
		else if (fechaultimodiaempleo.equals("0001-01-01"))
			this.fechaultimodiaempleo = "";
		else if (fechaultimodiaempleo != null) {
			temp = Date.valueOf(fechaultimodiaempleo);
			this.fechaultimodiaempleo = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.fechaultimodiaempleo = temporal.init_fecha(this.fechaultimodiaempleo);
		}
	}
	/**
	* En este m�todo se obtiene la FECHA DE VERIFICACION del empleo  de una persona
	* para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getFechaverificacionempleo() {
		return (this.fechaverificacionempleo);
	}
	/**
	* En este m�todo se almacena la FECHA DE VERIFICACION del empleo  de una persona
	* para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setFechaverificacionempleo(String fechaverificacionempleo) {
		Date temp = null;
		if (fechaverificacionempleo == null)
			fechaverificacionempleo = "";
		else if (fechaverificacionempleo.equals(""))
			fechaverificacionempleo = "";
		else if (fechaverificacionempleo.equals("0001-01-01"))
			this.fechaverificacionempleo = "";
		else if (fechaverificacionempleo != null) {
			temp = Date.valueOf(fechaverificacionempleo);
			this.fechaverificacionempleo = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.fechaverificacionempleo = temporal.init_fecha(this.fechaverificacionempleo);
		}
	}

}
