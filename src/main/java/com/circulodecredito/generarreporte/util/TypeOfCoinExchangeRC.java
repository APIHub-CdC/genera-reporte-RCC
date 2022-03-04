/*
 * Created on 3/08/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.circulodecredito.generarreporte.util;

import java.util.HashMap;

//import org.apache.log4j.Logger;


/**
 * @author afloresp
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TypeOfCoinExchangeRC {

	//static final Logger LOGG = Logger.getLogger("generarReporteLog");
	@SuppressWarnings("unused")
	private  TypeOfCoinExchangeRC	 ltypeOfCoinExchange = null;
	private  HashMap<String, Float>		hashTiposCambios	= null;
	
	public TypeOfCoinExchangeRC( HashMap<String, Float> catalogoCambio ){
		hashTiposCambios = catalogoCambio;
	}
	
	public TypeOfCoinExchangeRC( ){
		//hashTiposCambios = catalogoCambio;
	}

	private String  quitarCommas ( String  pStr ) {

		String   strReturn = "";
		boolean		existeComma = true;
		boolean		existePunto = true;
		int			posicionComma = 0;
		try {
			strReturn = (( pStr == null) ? "" : pStr.trim());
			while ( existeComma ) {
				posicionComma =  strReturn.indexOf(",");
				if ( posicionComma == -1 )
					existeComma = false;
				else {
					strReturn = strReturn.substring(0, (posicionComma) ) + strReturn.substring( posicionComma + 1 );
				}
			}
			
			while ( existePunto ) {
				posicionComma =  strReturn.indexOf(".");
				if ( posicionComma == -1 )
					existePunto = false;
				else {
					strReturn = strReturn.substring(0, (posicionComma) ) + strReturn.substring( posicionComma + 1 );
				}
			}
		} catch ( Exception e ) {
			strReturn = pStr;
		}
		return strReturn;
	}
	public long	convertToPESOS (  String  pCveTipoCambio,   String	pCantidad ) {
		long		localAmount = 0L;
		try {
			pCantidad = (( pCantidad == null) ? "0" : quitarCommas(pCantidad.trim()));
			localAmount = Long.valueOf(pCantidad).longValue();
		} catch ( Exception e ) {
			localAmount = 0L;
		}
		return convertToPESOS (  pCveTipoCambio,  localAmount  );
	}
	public long	convertToPESOS (  String  pCveTipoCambio,   int	pCantidad ) {
		return convertToPESOS (  pCveTipoCambio,   (long)pCantidad );
	}
	public long	convertToPESOS (  String  pCveTipoCambio,   long	pCantidad ) {
		long		convertedAmount		= 0L;
		float		floatConvertAmount	= 0.0f; 
		Float		local_Float			= null;
		try {
			local_Float	= new Float("-1f");
			if ( !pCveTipoCambio.equals("US") || !pCveTipoCambio.equals("MX") || !pCveTipoCambio.equals("UD") ){
				pCveTipoCambio = "MX";
			}
			local_Float = (Float) hashTiposCambios.get( pCveTipoCambio );
			if ( local_Float == null  && (!pCveTipoCambio.equalsIgnoreCase("MX") )) { //&& !pCveTipoCambio.equalsIgnoreCase("PESOS MEXICANOS"))) {
				throw new Exception ( "\t\t Converting  Coin Type={" + pCveTipoCambio + "}  Amount={" + pCantidad + "} and there is not equivalence." );
			} else {
				if ( pCveTipoCambio.equalsIgnoreCase("MX") ) { // || pCveTipoCambio.equalsIgnoreCase("PESOS MEXICANOS")) {
					convertedAmount =  pCantidad;
				} else if(local_Float != null){
					float     equivalenceFloat = local_Float.floatValue();
					floatConvertAmount = (float)pCantidad  *  equivalenceFloat;
					convertedAmount = (long) floatConvertAmount;
				}
			}
		} catch( Exception e) {
			//LOGG.error("\t\t ::: Error convertToPESOS() -> [" + e.getMessage() + "]", e);
		} finally {
			local_Float	= null;
		}
		return  convertedAmount;
	}
		
	
}
