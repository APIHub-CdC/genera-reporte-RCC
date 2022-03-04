/*
 * Created on 27/07/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.circulodecredito.generarreporte.beans;

/**
 * @author afloresp
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class summarizedProductBeanRC {
	private String 	strImagen 			= "";
	private String 	strDescProducto 	= "";
	private String	strIndicadorCta		= "";
	private int		intNumCuentas		= 0;
	private long	lngLimite			= 0L;
	private long	lngAprobado			= 0L;
	private long	lngActual			= 0L;
	private long	lngVencido			= 0L;
	private long	lngPagoSem			= 0L;
	private long	lngPagoQuin			= 0L;
	private long	lngPagoMen			= 0L;

	// ---------------------------------------------------
	public void setImagen ( String pStr ) {
		pStr = (( pStr == null) ? "": pStr.trim() );
		strImagen = pStr;
	}
	public String getImagen () { 
		strImagen = "";
		if ( strIndicadorCta.equalsIgnoreCase("Cta Cerrada") ) {
			strImagen = "/ccredito/circulodecredito/microfinancieras/images/Cerrada.jpg";
		} else if ( strIndicadorCta.equalsIgnoreCase("Al Corriente") ) {
			strImagen = "/ccredito/circulodecredito/microfinancieras/images/Positivo.jpg";
		} else if ( strIndicadorCta.equalsIgnoreCase("Con Atrasos") ) {
			strImagen = "/ccredito/circulodecredito/microfinancieras/images/Negativo.jpg";
		}
		return strImagen; 
	}
	public String getImagenPDF () { 
		strImagen = "";
		if ( strIndicadorCta.equalsIgnoreCase("Cta Cerrada") ) {
			strImagen = "/ccredito/circulodecredito/microfinancieras/images/Cerrada.jpg";
		} else if ( strIndicadorCta.equalsIgnoreCase("Al Corriente") ) {
			strImagen = "/ccredito/circulodecredito/microfinancieras/images/Positivo.jpg";
		} else if ( strIndicadorCta.equalsIgnoreCase("Con Atrasos") ) {
			strImagen = "/ccredito/circulodecredito/microfinancieras/images/Negativo.jpg";
		}
		return strImagen; 
	}
	
	// ---------------------------------------------------
	public void setDescProducto ( String pStr ) {
		pStr = (( pStr == null) ? "": pStr.trim() );
		strDescProducto = pStr;
	}
	public String getDescProducto () { return strDescProducto; }
	// ---------------------------------------------------
	public void setIndicadorCuenta ( String pStr ) {
		pStr = (( pStr == null) ? "": pStr.trim() );
		strIndicadorCta = pStr;
	}
	public String getIndicadorCuenta () { return strIndicadorCta; }
	// ---------------------------------------------------
	public void setNumCuentas ( int pStr ) {
		intNumCuentas = pStr;
	}
	public int getNumCuentas () { return intNumCuentas; }
	// ---------------------------------------------------
	public void setLimiteCred ( long pStr ) {
		lngLimite = pStr;
	}
	public long getLimiteCred () { return lngLimite; }
	// ---------------------------------------------------
	public void setCredAprobado ( long pStr ) {
		lngAprobado = pStr;
	}
	public long getCredAprobado () { return lngAprobado; }
	// ---------------------------------------------------
	public void setSdoActual ( long pStr ) {
		lngActual = pStr;
	}
	public long getSdoActual () { return lngActual; }
	// ---------------------------------------------------
	public void setSdoVencido ( long pStr ) {
		lngVencido = pStr;
	}
	public long getSdoVencido () { return lngVencido; }
	// ---------------------------------------------------
	public void setPagoSem ( long pStr ) {
		lngPagoSem = pStr;
	}
	public long getPagoSem () { return lngPagoSem; }
	// ---------------------------------------------------
	public void setPagoQuin ( long pStr ) {
		lngPagoQuin = pStr;
	}
	public long getPagoQuin () { return lngPagoQuin; }
	// ---------------------------------------------------
	public void setPagoMen ( long pStr ) {
		lngPagoMen = pStr;
	}
	public long getPagoMen () { return lngPagoMen; }
	// ---------------------------------------------------
	
}
