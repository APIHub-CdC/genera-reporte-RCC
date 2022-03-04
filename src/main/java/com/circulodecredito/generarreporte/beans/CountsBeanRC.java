package com.circulodecredito.generarreporte.beans;

import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;

import com.circulodecredito.generarreporte.util.FechaFormatRC;


/**
* CountsBean mantain the information of the personal registered accounts persistent.

* @version $Id: CountsBean.java,v 1.4 2006/02/03 01:23:50 jcdiaz Exp $
* @author	 <a href="mailto:carlos.diaz@edgebound.com">Juan Carlos D�az Ram�rez.</a>
* @serial EB..CSREPNB
* @since 1.0.0, 02/MARZO/2004
*/

@SuppressWarnings("serial")
public final class CountsBeanRC implements Serializable {

	/**
	* Default constructor.
	*/
	public CountsBeanRC() {
		super();
	}
	private String tipoCuenta = ""; //icb
	
	private String	fechaPeorAtraso		= "";
	private String	SaldoPeorAtraso		= "";
	private String	MopPeorAtraso		= "";
	private String FechaAperturaCalculo  = "";
	
	public String getFechaAperturaCalculo() {
		return FechaAperturaCalculo;
	}
	public String   getFechaPeorAtraso ( ) {
		return this.fechaPeorAtraso;
	}
	public void setFechaPeorAtraso ( String   pStr ) {
		pStr = (( pStr == null) ? "" : pStr.trim());
		this.fechaPeorAtraso = pStr;
	}
	public String   getSaldoPeorAtraso ( ) {
		return this.SaldoPeorAtraso;
	}
	public void setSaldoPeorAtraso ( String   pStr ) {
		pStr = (( pStr == null) ? "" : pStr.trim());
		this.SaldoPeorAtraso = pStr;
	}
	public String   getPeorAtraso ( ) {
		return this.MopPeorAtraso;
	}
	public void setPeorAtraso ( String   pStr ) {
		pStr = (( pStr == null) ? "" : pStr.trim());
		this.MopPeorAtraso = pStr;
	}
	// ----------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Fecha Actualizaci�n "</strong></font>
	*/
	private String fechaactualizacion = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Registro Impugnado "</strong></font>
	*/
	private String registroimpugnado = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Clave de Otorgante "</strong></font>
	*/
	private String claveotor = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Nombre del Otorgante "</strong></font>
	*/
	private String nombreotor = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>"Cuenta Actual"</strong></font>
	*/
	private String numcount = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Tipo de Responsabilidad "</strong></font>
	*/
	private String tiporesponsabilidad = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Tipo de Cuenta "</strong></font>
	*/
	private String clavetipocuenta = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Tipo de Credito "</strong></font>
	*/
	private String clavetipocredito = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Clave de la moneda "</strong></font>
	*/
	private String clavemoneda = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Valor Activo Valuaci�n "</strong></font>
	*/
	private String valoractivo = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" N�mero de Pagos "</strong></font>
	*/
	private String pagos = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Frecuencia de Pagos "</strong></font>
	*/
	private String frecpago = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Monto a Pagar"</strong></font>
	*/
	private String monto = null; //float
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Fecha de Apertura de Cuenta "</strong></font>
	*/
	private String apertura = null; //String
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Fecha de �ltimo Pago "</strong></font>
	*/
	private String ultpago = null; //String
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Fecha de �ltima Compra "</strong></font>
	*/
	private String ultcomp = null; //String
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Fecha de Cierre de Cuenta"</strong></font>
	*/
	private String cierre = null; //String
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Fecha de Reporte"</strong></font>
	*/
	private String fechareporte = null; //String
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Fecha de �ltima vez en ceros"</strong></font>
	*/
	private String ultceros = null; //String
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Garant�a "</strong></font>
	*/
	private String garantia = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Cr�dito M�ximo "</strong></font>
	*/
	private String creditomaximo = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Saldo Actual "</strong></font>
	*/
	private String actual = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" L�mite de Cr�dito "</strong></font>
	*/
	private String limite = null; //float
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Saldo Vencido "</strong></font>
	*/
	private String vencido = null; //float
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" N�mero de Pagos Vencidos "</strong></font>
	*/
	private String npagosvencidos = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Pago Actual "</strong></font>
	*/
	private String pagoactual = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Historico de Pagos"</strong></font>
	*/
	private String historicopago = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Fecha Reciente Historico de Pagos"</strong></font>
	*/
	private String fecharecientehistoricopago = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Fecha Antigua Historico de Pagos"</strong></font>
	*/
	private String fechaantiguahistoricopago = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Clave de Prevenci�n "</strong></font>
	*/
	private String claveprevencion = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Total Pagos Reportados "</strong></font>
	*/
	private String totalpagosreportados = null;
	/**
	* Flag to indicate if the search was succesfully.
	*/
	private boolean flag = false;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>" Grupo Otorgante "</strong></font>
	*/
	private String grupootorgante = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>"Descripcion Tipo Cuenta"</strong></font>
	*/
	private String descripciontipocuenta = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>"Descripcion Tipo Contrato"</strong></font>
	*/
	private String descripciontipocontrato = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>"Descripcion Tipo Responsabilidad"</strong></font>
	*/
	private String descripciontiporesponsabilidad = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>"Descripcion Tipo Otorgante"</strong></font>
	*/
	private String descripciontipootorgante = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>"Descripcion Unidad Monetaria"</strong></font>
	*/
	private String descripcionmoneda = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>"Tipo de Corte"</strong></font>
	*/
	private String descripcioncorte = null;
	/**
	* Variable that holds the value of the element <font color="#000033" size="2" face="Tahoma"><strong>"Descripci�n del Tipo de Corte."</strong></font>
	*/
	private String descripcionobservacion = null;
	/**
	* Variable privada de tipo boolean que indica cuando la persona tiene un� cuenta de tipo revolvente.
	*/
	private boolean brevolvente = false;


	public String getFechaactualizacion() {
		return (this.fechaactualizacion);
	}

	public void setFechaactualizacion(String fechaactualizacion) {
		if (fechaactualizacion == null)
			this.fechaactualizacion = "";
		else {
			this.fechaactualizacion = fechaactualizacion;
			if (fechaactualizacion.equals("ND"))
				this.fechaactualizacion = "";
			if (fechaactualizacion.equals("NO PROPORCIONADO"))
				this.fechaactualizacion = "";
		}
	}

	public String getRegistroimpugnado() {
		return (this.registroimpugnado);
	}

	public void setRegistroimpugnado(String registroimpugnado) {
		if (registroimpugnado == null)
			this.registroimpugnado = "";
		else {
			this.registroimpugnado = registroimpugnado;
			if (registroimpugnado.equals("ND"))
				this.registroimpugnado = "";
			if (registroimpugnado.equals("NO PROPORCIONADO"))
				this.registroimpugnado = "";
		}
	}

	public String getClaveotor() {
		return (this.claveotor);
	}

	public void setClaveotor(String claveotor) {
		if (claveotor == null)
			this.claveotor = "";
		else {
			this.claveotor = claveotor;
			if (claveotor.equals("ND"))
				this.claveotor = "";
			if (claveotor.equals("NO PROPORCIONADO"))
				this.claveotor = "";
		}
	}

	public String getNombreotor() {
		return (this.nombreotor);
	}

	public void setNombreotor(String nombreotor) {
		if (nombreotor == null)
			this.nombreotor = "";
		else {
			this.nombreotor = nombreotor;
			if (nombreotor.equals("ND"))
				this.nombreotor = "";
			if (nombreotor.equals("NO PROPORCIONADO"))
				this.nombreotor = "";
		}
	}

	public String getNumcount() {
		return (this.numcount);
	}

	public void setNumcount(String numcount) {
		if (numcount == null)
			this.numcount = "";
		else {
			this.numcount = numcount;
			if (numcount.equals("ND"))
				this.numcount = "";
			if (numcount.equals("NO PROPORCIONADO"))
				this.numcount = "";
		}
	}

	public String getTiporesponsabilidad() {
		return (this.tiporesponsabilidad);
	}

	public void setTiporesponsabilidad(String tiporesponsabilidad) {
		if (tiporesponsabilidad == null)
			this.tiporesponsabilidad = "";
		else {
			this.tiporesponsabilidad = tiporesponsabilidad;
			if (tiporesponsabilidad.equals("ND"))
				this.tiporesponsabilidad = "";
			if (tiporesponsabilidad.equals("NO PROPORCIONADO"))
				this.tiporesponsabilidad = "";
		}
	}

	public String getClavetipocuenta() {
		return (this.clavetipocuenta);
	}

	public void setClavetipocuenta(String clavetipocuenta) {
		if (clavetipocuenta == null)
			this.clavetipocuenta = "";
		else {
			this.clavetipocuenta = clavetipocuenta;
			if (clavetipocuenta.equals("ND"))
				this.clavetipocuenta = "";
			if (clavetipocuenta.equals("NO PROPORCIONADO"))
				this.clavetipocuenta = "";
		}
	}

	public String getClavetipocredito() {
		return (this.clavetipocredito);
	}

	public void setClavetipocredito(String clavetipocredito) {
		if (clavetipocredito == null)
			this.clavetipocredito = "";
		else {
			this.clavetipocredito = clavetipocredito;
			if (clavetipocredito.equals("ND"))
				this.clavetipocredito = "";
			if (clavetipocredito.equals("NO PROPORCIONADO"))
				this.clavetipocredito = "";
		}
	}


	public String getValoractivo() {
		return (this.valoractivo);
	}

	public void setValoractivo(String valoractivo) {
		if (valoractivo == null)
			this.valoractivo = "";
		else {
			this.valoractivo = valoractivo;
			if (valoractivo.equals("ND"))
				this.valoractivo = "";
			if (valoractivo.equals("NO PROPORCIONADO"))
				this.valoractivo = "";
		}
	}

	public String getPagos() {
		return (this.pagos);
	}

	public void setPagos(String pagos) {
		if (pagos == null)
			this.pagos = "";
		else {
			this.pagos = pagos;
			if (pagos.equals("ND"))
				this.pagos = "";
			if (pagos.equals("NO PROPORCIONADO"))
				this.pagos = "";
		}
	}

	public String getFrecpago() {
		return (this.frecpago);
	}

	public void setFrecpago(String frecpago) {
		if (frecpago == null || frecpago.length() == 0)
			this.frecpago = "M";
		else {
			this.frecpago = frecpago;
			if (frecpago.equals("ND"))
				this.frecpago = "M";
			if (frecpago.equals("NO PROPORCIONADO"))
				this.frecpago = "M";
		}
	}

	/**
	* En este m�todo se obtiene el MONTO
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getMonto() {
		return (this.monto);
	}
	/**
	* En este m�todo se almacena el MONTO
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setMonto(String monto) {
		if (monto == null || monto.equals(""))
			this.monto = "";
		else {
			NumberFormat forma;
			forma = NumberFormat.getInstance();

			Long monto1 = new Long(monto);
			long monto2 = monto1.longValue();
			this.monto = forma.format(monto2);
		}
		if (this.monto.equals("ND"))
			this.monto = "";
		if (this.monto.equals("NO PROPORCIONADO"))
			this.monto = "";
	}

	public String getApertura() {
		return (this.apertura);
	}

	public void setApertura(String apertura) {
		Date temp = null;
		if (apertura == null)
			apertura = "";
		else if (apertura.equals(""))
			apertura = "";
		else if (apertura.equals("0001-01-01") || apertura.equals("1901-01-01"))
			apertura = "";
		FechaAperturaCalculo = apertura.replaceAll("-", "");
		if (apertura.length() > 0) {
			temp = Date.valueOf(apertura);
			this.apertura = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.apertura = temporal.init_fecha(this.apertura);
		}
		if (this.apertura == null)
			this.apertura = "";
	}

	public String getUltpago() {
		return (this.ultpago);
	}

	public void setUltpago(String ultpago) {
		Date temp = null;
		if (ultpago == null)
			ultpago = "";
		else if (ultpago.equals(""))
			ultpago = "";
		else if (ultpago.equals("0001-01-01"))
			this.ultpago = "";
		else if (ultpago != null) {
			temp = Date.valueOf(ultpago);
			this.ultpago = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.ultpago = temporal.init_fecha(this.ultpago);
		}
		if (this.ultpago == null)
			this.ultpago = "";
	}

	public String getUltcomp() {
		return (this.ultcomp);
	}

	public void setUltcomp(String ultcomp) {
		Date temp = null;
		if (ultcomp == null)
			ultcomp = "";
		else if (ultcomp.equals(""))
			ultcomp = "";
		else if (ultcomp.equals("0001-01-01"))
			this.ultcomp = "";
		else if (ultcomp != null) {
			temp = Date.valueOf(ultcomp);
			this.ultcomp = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.ultcomp = temporal.init_fecha(this.ultcomp);
		}
		if (this.ultcomp == null)
			this.ultcomp = "";
	}

	public String getCierre() {
		return (this.cierre);
	}

	public void setCierre(String cierre) {
		Date temp = null;
		if (cierre == null)
			cierre = "";
		else if (cierre.equals(""))
			cierre = "";
		else if (cierre.equals("0001-01-01") || cierre.equals("1901-01-01"))
			this.cierre = "";
		else if (cierre != null) {
			temp = Date.valueOf(cierre);
			this.cierre = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.cierre = temporal.init_fecha(this.cierre);
		}
		if (this.cierre == null)
			this.cierre = "";
	}

	public String getFechareporte() {
		return (this.fechareporte);
	}

	public void setFechareporte(String fechareporte) {
		Date temp = null;
		if (fechareporte == null)
			fechareporte = "";
		else if (fechareporte.equals(""))
			fechareporte = "";
		else if (fechareporte.equals("0001-01-01"))
			this.fechareporte = "";
		else if (fechareporte != null) {
			temp = Date.valueOf(fechareporte);
			this.fechareporte = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.fechareporte = temporal.init_fecha(this.fechareporte);
		}
		if (this.fechareporte == null)
			this.fechareporte = "";
	}

	public String getUltceros() {
		return (this.ultceros);
	}

	public void setUltceros(String ultceros) {
		Date temp = null;
		if (ultceros == null)
			ultceros = "";
		else if (ultceros.equals(""))
			ultceros = "";
		else if (ultceros.equals("0001-01-01"))
			this.ultceros = "";
		else if (ultceros != null) {
			temp = Date.valueOf(ultceros);
			this.ultceros = temp.toString();
			FechaFormatRC temporal = new FechaFormatRC();
			this.ultceros = temporal.init_fecha(this.ultceros);
		}
		if (this.ultceros == null)
			this.ultceros = "";
	}

	public String getGarantia() {
		return (this.garantia);
	}

	public void setGarantia(String garantia) {
		if (garantia == null)
			this.garantia = "";
		else {
			this.garantia = garantia;
			if (garantia.equals("ND"))
				this.garantia = "";
			if (garantia.equals("NO PROPORCIONADO"))
				this.garantia = "";
		}
	}

	/**
	* En este m�todo se obtiene el CREDITO MAXIMO
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getCreditomaximo() {
		return (this.creditomaximo);
	}

	/**
	* En este m�todo se almacena el CREDITO MAXIMO
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setCreditomaximo(String creditomaximo) {
		if (creditomaximo == null || creditomaximo.equals(""))
			this.creditomaximo = "0";
		else {
			NumberFormat forma;
			Locale.setDefault(Locale.ENGLISH);
			forma = NumberFormat.getInstance();
			Long creditomaximo1 = new Long(creditomaximo);
			long creditomaximo2 = creditomaximo1.longValue();
			this.creditomaximo = forma.format(creditomaximo2);
		}
		if (this.creditomaximo.equals("ND"))
			this.creditomaximo = "0";
		if (this.creditomaximo.equals("NO PROPORCIONADO"))
			this.creditomaximo = "0";
	}

	/**
		* En este m�todo se obtiene el SALDO ACTUAL
		* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
		* @return String
		*/
	public String getActual() {
		return (this.actual);
	}
	/**
	* En este m�todo se almacena el SALDO ACTUAL
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setActual(String actual) {
		if (actual == null || actual.equals(""))
			this.actual = "";
		else {
			NumberFormat forma;
			forma = NumberFormat.getInstance();
			Long actual1 = new Long(actual);
			long actual2 = actual1.longValue();
			this.actual = forma.format(actual2);
		}
		if (this.actual.equals("ND"))
			this.actual = "";
		if (this.actual.equals("NO PROPORCIONADO"))
			this.actual = "";
	}

	/**
		* En este m�todo se obtiene el LIMITE DE CREDITO
		* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
		* @return String
		*/
	public String getLimite() {
		return (this.limite);
	}
	/**
	* En este m�todo se almacena el LIMITE DE CREDITO
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setLimite(String limite) {
		if (limite == null || limite.equals(""))
			this.limite = "0";
		else {
			NumberFormat forma;
			forma = NumberFormat.getInstance();
			Long limite1 = new Long(limite);
			long limite2 = limite1.longValue();
			this.limite = forma.format(limite2);
		}
		if (this.limite.equals("ND"))
			this.limite = "0";
		if (this.limite.equals("NO PROPORCIONADO"))
			this.limite = "0";

	}

	/**
	* En este m�todo se obtiene el SALDO VENCIDO
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
	* @return String
	*/
	public String getVencido() {
		return (this.vencido);
	}

	/**
	* En este m�todo se almacena el SALDO VENCIDO
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito Especial.
	* @param String
	* @return void
	*/
	public void setVencido(String vencido) {
		if (vencido == null || vencido.equals(""))
			this.vencido = "0";
		else {
			NumberFormat forma;
			forma = NumberFormat.getInstance();
			Long vencido1 = new Long(vencido);
			long vencido2 = vencido1.longValue();
			this.vencido = forma.format(vencido2);
		}
		if (this.vencido.equals("ND"))
			this.vencido = "0";
		if (this.vencido.equals("NO PROPORCIONADO"))
			this.vencido = "0";

	}

	public String getNpagosvencidos() {
		return (this.npagosvencidos);
	}

	public void setNpagosvencidos(String npagosvencidos) {
		if (npagosvencidos == null)
			this.npagosvencidos = "";
		else {
			this.npagosvencidos = npagosvencidos;
			if (npagosvencidos.equals("ND"))
				this.npagosvencidos = "";
			if (npagosvencidos.equals("NO PROPORCIONADO"))
				this.npagosvencidos = "";
		}
	}

	public String getPagoactual() {
		return (this.pagoactual);
	}

	public void setPagoactual(String pagoactual) {
		if (pagoactual == null)
			this.pagoactual = "";
		else {
			this.pagoactual = pagoactual;
			if (pagoactual.equals("ND"))
				this.pagoactual = "";
			if (pagoactual.equals("NO PROPORCIONADO"))
				this.pagoactual = "";
		}
	}

	public String getHistoricopago() {
		return (this.historicopago);
	}

	public void setHistoricopago(String historicopago) {
		if (historicopago == null)
			this.historicopago = "";
		else {
			this.historicopago = historicopago;
			if (historicopago.equals("ND"))
				this.historicopago = "";
			if (historicopago.equals("NO PROPORCIONADO"))
				this.historicopago = "";
		}
	}

	public String getFecharecientehistoricopago() {
		return (this.fecharecientehistoricopago);
	}

	public void setFecharecientehistoricopago(String fecharecientehistoricopago) {
		if (fecharecientehistoricopago == null)
			this.fecharecientehistoricopago = "";
		else {
			this.fecharecientehistoricopago = fecharecientehistoricopago;
			if (fecharecientehistoricopago.equals("ND"))
				this.fecharecientehistoricopago = "";
			if (fecharecientehistoricopago.equals("NO PROPORCIONADO"))
				this.fecharecientehistoricopago = "";
		}
	}

	public String getFechaantiguahistoricopago() {
		return (this.fechaantiguahistoricopago);
	}

	public void setFechaantiguahistoricopago(String fechaantiguahistoricopago) {
		if (fechaantiguahistoricopago == null)
			this.fechaantiguahistoricopago = "";
		else {
			this.fechaantiguahistoricopago = fechaantiguahistoricopago;
			if (fechaantiguahistoricopago.equals("ND"))
				this.fechaantiguahistoricopago = "";
			if (fechaantiguahistoricopago.equals("NO PROPORCIONADO"))
				this.fechaantiguahistoricopago = "";
		}
	}

	public String getClaveprevencion() {
		return (this.claveprevencion);
	}

	public void setClaveprevencion(String claveprevencion) {
		if (claveprevencion == null)
			this.claveprevencion = "";
		else {
			this.claveprevencion = claveprevencion;
			if (claveprevencion.equals("ND"))
				this.claveprevencion = "";
			if (claveprevencion.equals("NO PROPORCIONADO"))
				this.claveprevencion = "";
		}
	}

	public String getTotalpagosreportados() {
		return (this.totalpagosreportados);
	}

	public void setTotalpagosreportados(String totalpagosreportados) {
		if (totalpagosreportados == null)
			this.totalpagosreportados = "";
		else {
			this.totalpagosreportados = totalpagosreportados;
			if (totalpagosreportados.equals("ND"))
				this.totalpagosreportados = "";
			if (totalpagosreportados.equals("NO PROPORCIONADO"))
				this.totalpagosreportados = "";
		}
	}

	public boolean getFlag() {
		return (this.flag);
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getGrupootorgante() {
		return (this.grupootorgante);
	}

	public void setGrupootorgante(String grupootorgante) {
		if (grupootorgante == null)
			this.grupootorgante = "";
		else {
			this.grupootorgante = grupootorgante;
			if (grupootorgante.equals("ND"))
				this.grupootorgante = "";
			if (grupootorgante.equals("NO PROPORCIONADO"))
				this.grupootorgante = "";
		}
	}

	public String getDescripciontipocuenta() {
		return (this.descripciontipocuenta);
	}

	public void setDescripciontipocuenta(String descripciontipocuenta) {
		if (descripciontipocuenta == null)
			this.descripciontipocuenta = "";
		else {
			this.descripciontipocuenta = descripciontipocuenta;
			if (descripciontipocuenta.equals("ND"))
				this.descripciontipocuenta = "";
			if (descripciontipocuenta.equals("NO PROPORCIONADO"))
				this.descripciontipocuenta = "";
		}
	}

	public String getDescripciontipocontrato() {
		return (this.descripciontipocontrato);
	}

	public void setDescripciontipocontrato(String descripciontipocontrato) {
		if (descripciontipocontrato == null)
			this.descripciontipocontrato = "";
		else {
			this.descripciontipocontrato = descripciontipocontrato;
			if (descripciontipocontrato.equals("ND"))
				this.descripciontipocontrato = "";
			if (descripciontipocontrato.equals("NO PROPORCIONADO"))
				this.descripciontipocontrato = "";
		}
	}

	public String getDescripciontiporesponsabilidad() {
		return (this.descripciontiporesponsabilidad);
	}
	public void setDescripciontiporesponsabilidad(String descripciontiporesponsabilidad) {
		if (descripciontiporesponsabilidad == null)
			this.descripciontiporesponsabilidad = "";
		else {
			this.descripciontiporesponsabilidad = descripciontiporesponsabilidad;
			if (descripciontiporesponsabilidad.equals("ND"))
				this.descripciontiporesponsabilidad = "";
			if (descripciontiporesponsabilidad.equals("NO PROPORCIONADO"))
				this.descripciontiporesponsabilidad = "";
		}
	}

	public String getDescripciontipootorgante() {
		return (this.descripciontipootorgante);
	}
	public void setDescripciontipootorgante(String descripciontipootorgante) {
		if (descripciontipootorgante == null)
			this.descripciontipootorgante = "";
		else {
			this.descripciontipootorgante = descripciontipootorgante;
			if (descripciontipootorgante.equals("ND"))
				this.descripciontipootorgante = "";
			if (descripciontipootorgante.equals("NO PROPORCIONADO"))
				this.descripciontipootorgante = "";
		}
	}
	public String getClavemoneda() {
		return (this.clavemoneda);
	}

	public void setClavemoneda(String clavemoneda) {
		if (clavemoneda == null || clavemoneda.length() == 0)
			this.clavemoneda = "MX";
		else {
			this.clavemoneda = clavemoneda;
			if (clavemoneda.equals("N$") || clavemoneda.equals("ND") || clavemoneda.equals("NO PROPORCIONADO"))
				this.clavemoneda = "MX";
		}
	}

	public String getDescripcionmoneda() {
		return (this.descripcionmoneda);
	}
	public void setDescripcionmoneda(String descripcionmoneda) {
		if (descripcionmoneda == null)
			this.descripcionmoneda = "";
		else {
			this.descripcionmoneda = descripcionmoneda;
			if (descripcionmoneda.equals("ND"))
				this.descripcionmoneda = "";
			if (descripcionmoneda.equals("NO PROPORCIONADO"))
				this.descripcionmoneda = "";
		}
	}

	public String getDescripcioncorte() {
		return (this.descripcioncorte);
	}
	public void setDescripcioncorte(String descripcioncorte) {
		if (descripcioncorte == null)
			this.descripcioncorte = "";
		else {
			this.descripcioncorte = descripcioncorte;
			if (descripcioncorte.equals("ND"))
				this.descripcioncorte = "";
			if (descripcioncorte.equals("NO PROPORCIONADO"))
				this.descripcioncorte = "";
		}
	}

	public String getDescripcionobservacion() {
		return (this.descripcionobservacion);
	}
	public void setDescripcionobservacion(String descripcionobservacion) {
		if (descripcionobservacion == null)
			this.descripcionobservacion = "";
		else {
			this.descripcionobservacion = descripcionobservacion;
			if (descripcionobservacion.equals("ND"))
				this.descripcionobservacion = "";
			if (descripcionobservacion.equals("NO PROPORCIONADO"))
				this.descripcionobservacion = "";
		}
	}
	/**
	* En este m�todo se obtiene la BANDERA que indica cuando la persona tiene un� cuenta de tipo revolvente
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito.
	* @return String
	*/
	public boolean getBrevolvente() {
		return (this.brevolvente);
	}
	/**
	* En este m�todo se almacena la BANDERA que indica cuando la persona tiene un� cuenta de tipo revolvente
	* referente al cr�dito otorgado anteriormente a una Persona para un Reporte de Cr�dito.
	* @return String
	*/
	public void setBrevolvente(boolean brevolvente) {
		this.brevolvente = brevolvente;
	}
	public String  getImageFrecuenciaPagos () {
		String   strReturn = "";
		frecpago  = (( frecpago == null) ? "" : frecpago.trim());
		if ( this.frecpago.equalsIgnoreCase("S")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Semanal.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("Q")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Quincenal.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("M")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Mensual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("B")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Bimestral.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("A")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Anual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("V")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Variable.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("C")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Catorcenal.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("T")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Trimestral.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("D")) {
//			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/DeduccionDelSalario.JPG";
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Mensual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("R")) {
//			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/PagoMinimoCuentasRevolventes.JPG";
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Mensual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("U")) {
//			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/UnaSolaExhibicion.JPG";
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Mensual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("E")) {
//			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/UnaSolaExhibicion.JPG";
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Semestral.jpg";
		}
		return strReturn;
	}
	public String  getImageFrecuenciaPagosPDF () {
		String   strReturn = "";
		frecpago  = (( frecpago == null) ? "" : frecpago.trim());
		
		if ( this.frecpago.equalsIgnoreCase("S")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Semanal.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("Q")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Quincenal.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("M")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Mensual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("B")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Bimestral.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("A")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Anual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("V")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Variable.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("C")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Catorcenal.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("T")) {
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Trimestral.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("D")) {
//			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/DeduccionDelSalario.JPG";
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Mensual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("R")) {
//			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/PagoMinimoCuentasRevolventes.JPG";
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Mensual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("U")) {
//			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/UnaSolaExhibicion.JPG";
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Mensual.JPG";
		} else  if ( this.frecpago.equalsIgnoreCase("E")) {
//				strReturn         = "/ccredito/circulodecredito/microfinancieras/images/UnaSolaExhibicion.JPG";
			strReturn         = "/ccredito/circulodecredito/microfinancieras/images/Semestral.jpg";
		}
		return strReturn;
	}
	public String  getImageFrecuenciaPagosTexto () {
		String   strReturn = "";
		frecpago  = (( frecpago == null) ? "" : frecpago.trim());
		if ( this.frecpago.equalsIgnoreCase("S")) {
			strReturn         = "Semanal";
		} else  if ( this.frecpago.equalsIgnoreCase("Q")) {
			strReturn         = "Quincenal";
		} else  if ( this.frecpago.equalsIgnoreCase("M")) {
			strReturn         = "Mensual";
		} else  if ( this.frecpago.equalsIgnoreCase("B")) {
			strReturn         = "Bimestral";
		} else  if ( this.frecpago.equalsIgnoreCase("A")) {
			strReturn         = "Anual";
		} else  if ( this.frecpago.equalsIgnoreCase("V")) {
			strReturn         = "Variable";
		} else  if ( this.frecpago.equalsIgnoreCase("C")) {
			strReturn         = "Catorcenal";
		} else  if ( this.frecpago.equalsIgnoreCase("T")) {
			strReturn         = "Trimestral";
		} else  if ( this.frecpago.equalsIgnoreCase("D")) {
//			strReturn         = "DeduccionDelSalario";
			strReturn         = "Mensual";
		} else  if ( this.frecpago.equalsIgnoreCase("R")) {
//			strReturn         = "PagoMinimoCuentasRevolventes";
			strReturn         = "Mensual";
		} else  if ( this.frecpago.equalsIgnoreCase("U")) {
//			strReturn         = "UnaSolaExhibicion";
			strReturn         = "Mensual";
		}else  if ( this.frecpago.equalsIgnoreCase("E")) {
//			strReturn         = "UnaSolaExhibicion";
			strReturn         = "Semestral";
		}
		return strReturn;
	}
	public String  getImageStatusAccount() {
		String   strReturn = "";
		vencido  = (( vencido == null)? "0" : vencido.trim());
		cierre   = (( cierre == null) ? "" : cierre.trim());
		if ( !cierre.equals("0001-01-01")  &&  !cierre.equals("00010101") && cierre.length() != 0 ) {
			strReturn  = "/ccredito/circulodecredito/microfinancieras/images/Cerrada.jpg";
		} else if ( !vencido.equalsIgnoreCase("0") && !vencido.equalsIgnoreCase("") ){
			strReturn  = "/ccredito/circulodecredito/microfinancieras/images/Negativo.jpg";
		} else if ( vencido.equalsIgnoreCase("0") || vencido.equalsIgnoreCase("") )  {
			strReturn  = "/ccredito/circulodecredito/microfinancieras/images/Positivo.jpg";
		}
		return  strReturn;
	}
	public String  getImageStatusAccountPDF() {
		String   strReturn = "";
		vencido  = (( vencido == null)? "0" : vencido.trim());
		cierre   = (( cierre == null) ? "" : cierre.trim());
		if ( !cierre.equals("0001-01-01")  &&  !cierre.equals("00010101") && cierre.length() != 0 ) {
			strReturn  = "/ccredito/circulodecredito/microfinancieras/images/Cerrada.jpg";
		} else if ( !vencido.equalsIgnoreCase("0") && !vencido.equalsIgnoreCase("") ){
			strReturn  = "/ccredito/circulodecredito/microfinancieras/images/Negativo.jpg";
		} else if ( vencido.equalsIgnoreCase("0") || vencido.equalsIgnoreCase("") )  {
			strReturn  = "/ccredito/circulodecredito/microfinancieras/images/Positivo.jpg";
}
		return  strReturn;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
//	public static void main(String[] args) {
//		NumberFormat forma;
//		Locale.setDefault(Locale.ENGLISH);
//		forma = NumberFormat.getInstance();
//		Long creditomaximo1 = new Long("5004");
//		long creditomaximo2 = creditomaximo1.longValue();
//		CountsBean count = new CountsBean();
//		count.setCreditomaximo("5004");
//	}
}
