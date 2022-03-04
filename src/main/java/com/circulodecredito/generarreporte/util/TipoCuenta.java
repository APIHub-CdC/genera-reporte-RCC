/**
 * 
 */
package com.circulodecredito.generarreporte.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author israel
 *
 */
public class TipoCuenta {

	private Map<String, String> tipoCuentaBuro;
	
	public TipoCuenta (){
		tipoCuentaBuro = new HashMap<String, String>();
//		tipoCuentaBuro.put("AG","AGROPECUARIO (PFAE)");
//		tipoCuentaBuro.put("CE","CARTAS DE CRÃ‰DITO (PFAE)");
//		tipoCuentaBuro.put("CS","CRÃ‰DITO SIMPLE (PFAE)");
//		tipoCuentaBuro.put("CT","CON COLATERAL (PFAE)");
//		tipoCuentaBuro.put("DE","DESCUENTOS (PFAE)");
//		tipoCuentaBuro.put("FI","FIDEICOMISO (PFAE)");
//		tipoCuentaBuro.put("HA","HABILITACIÃ“N O AVÃO (PFAE)");
//		tipoCuentaBuro.put("OA","OTROS ADEUDOS VENCIDOS (PFAE)");
//		tipoCuentaBuro.put("PA","PRÃ‰STAMO PARA PERSONAS FÃ�SICAS CON ACTIVIDAD EMPRESARIAL (PFAE)");
//		tipoCuentaBuro.put("PG","PGUE - PRÃ‰STAMO COMO GARANTÃ�A DE UNIDADES INDUSTRIALES PARA PFAE");
//		tipoCuentaBuro.put("PR","PRENDARIO (PFAE)");
//		tipoCuentaBuro.put("PQ","QUIROGRAFARIO (PFAE)");
//		tipoCuentaBuro.put("RC","REESTRUCTURADO (PFAE)");
//		tipoCuentaBuro.put("RD","REDESCUENTO (PFAE)");
//		tipoCuentaBuro.put("RF","REFACCIONARIO (PFAE)");
//		tipoCuentaBuro.put("RN","RENOVADO (PFAE)");
		//tipoCuentaBuro.put("TE","TARJETA DE CRÃ‰DITO EMPRESARIAL");
		tipoCuentaBuro.put("AE","FISICA ACTIVIDAD EMPRESARIAL");
		//tipoCuentaBuro.put("PB","PRESTAMO PERSONAL BANCARIO");
		tipoCuentaBuro.put("PM","PRESTAMO EMPRESARIAL");
		
	}
	
	/**
	 * Obtiene la instancia de un objeto a traves del mapeo
	 * @param tipoCredito
	 * @return
	 */
	public String descriptionTipoCuenta (String tipoCredito, String nombreOtorgante) {
		String desc = "";
		if ( tipoCuentaBuro.containsKey(tipoCredito) ) {
			desc = "PFAE";
		}
		return desc;
	}
	
	
	
}
