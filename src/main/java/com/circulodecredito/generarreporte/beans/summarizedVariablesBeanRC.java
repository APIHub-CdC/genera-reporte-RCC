/*
 * Created on 27/07/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.circulodecredito.generarreporte.beans;

import java.sql.Date;

import com.circulodecredito.generarreporte.util.FechaFormatRC;

/**
 * @author afloresp
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class summarizedVariablesBeanRC {
	private Long		p_Total_Creditos_Abiertos_Anio		= 0l;
	private Date	p_Fec_Apert_Credit_Mas_Antiguo		= null;
	private String  str_p_Fec_Apert_Credit_Mas_Antiguo  = "";
	private Long		p_Monto_Mayor_Aprobado				= 0l;
	private Long		p_Total_Ctas_Vigentes_Corrient		= 0l;
	private Long		p_Total_Ctas_Vigentes_Atraso		= 0l;
	private Long		p_Sumatoria_Creditos_Maximos		= 0l;
	private Long		p_Sumatoria_Saldos_Actuales			= 0l;
	private Long		p_Existen_Cuentas					= 0l;
	// ---------------------------------------------------------------------------------------------------
	public void setTotalCreditosAbiertos ( Long	pStr ) {
		this.p_Total_Creditos_Abiertos_Anio	 = pStr;
	}
	public Long	getTotalCreditosAbiertosAnio () { return p_Total_Creditos_Abiertos_Anio; }
	// ---------------------------------------------------------------------------------------------------
	public void setFechaAperCredAntiguo ( Date	pStr ) {
		if (pStr == null)
			p_Fec_Apert_Credit_Mas_Antiguo = null;
		//else if (pStr.equals(""))
		//	p_Fec_Apert_Credit_Mas_Antiguo = "";
		else if (pStr.toString().equals("0001-01-01"))
			this.p_Fec_Apert_Credit_Mas_Antiguo = null;
		else if (pStr != null) {
			//temp = Date.valueOf(fechacons);
			String tmp = "";
			tmp = pStr.toString();
//			System.out.println("Fecha Credito mas antiguo:  -> {" + tmp + "}");
			FechaFormatRC temporal = new FechaFormatRC();
			this.str_p_Fec_Apert_Credit_Mas_Antiguo = temporal.init_fecha(tmp);
		}
		//this.p_Fec_Apert_Credit_Mas_Antiguo	 = pStr;
	}
	public Date	getFechaAperCredAntiguo () { return p_Fec_Apert_Credit_Mas_Antiguo; }
	public String getStrFechaAperCredAntiguo () { return this.str_p_Fec_Apert_Credit_Mas_Antiguo; }
	// ---------------------------------------------------------------------------------------------------
	public void setMontoMayorAprobado ( Long	pStr ) {
		this.p_Monto_Mayor_Aprobado	 = pStr;
	}
	public Long	getMontoMayorAprobado () { return p_Monto_Mayor_Aprobado; }
	// ---------------------------------------------------------------------------------------------------
	public void setTotalCtasVigentesCorriente ( Long	pStr ) {
		this.p_Total_Ctas_Vigentes_Corrient	 = pStr;
	}
	public Long	getTotalCtasVigentesCorriente () { return p_Total_Ctas_Vigentes_Corrient; }
	// ---------------------------------------------------------------------------------------------------
	public void setTotalCtasVigentesAtraso ( Long	pStr ) {
		this.p_Total_Ctas_Vigentes_Atraso	 = pStr;
	}
	public Long	getTotalCtasVigentesAtraso () { return p_Total_Ctas_Vigentes_Atraso; }
	// ---------------------------------------------------------------------------------------------------
	public void setSumatoriaCreditosMaximos ( Long	pStr ) {
		this.p_Sumatoria_Creditos_Maximos	 = pStr;
	}
	public Long	getSumatoriaCreditosMaximos () { return p_Sumatoria_Creditos_Maximos; }
	// ---------------------------------------------------------------------------------------------------
	public void setSumatoriaSaldosActuales ( Long	pStr ) {
		this.p_Sumatoria_Saldos_Actuales	 = pStr;
	}
	public Long	getSumatoriaSaldosActuales () { return p_Sumatoria_Saldos_Actuales; }
	// ---------------------------------------------------------------------------------------------------
	public void setExistenCuentas ( Long	pStr ) {
		this.p_Existen_Cuentas	 = pStr;
	}
	public Long	getExistenCuentas () { return p_Existen_Cuentas; }
	// ---------------------------------------------------------------------------------------------------
}
