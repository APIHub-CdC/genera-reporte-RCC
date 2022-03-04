package com.circulodecredito.generarreporte.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author israel
 *
 */
public class ConvertFechas {

	/**
	 * Resta  años a la fecha actual
	 * @param oFecha
	 * @return
	 */
	public static Date restaAnnio(int annio) {
		Date oFecha = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTimeInMillis(oFecha.getTime());
		cl.add(Calendar.YEAR, - annio);
		return cl.getTime();
	}
	
	/**
	 * Compara si la fecha de la consulta es menor a la fecha calculada
	 * @param fechaConsulta  --> parametro de la fecha de conculta
	 * @param fechaCalculada  --> fecha calculada --> fecha actual menos 2 annios
	 * @return  true = menor, false es igual o mayor a la fecha calculada
	 */
	public static Boolean esFechaMenor(Date fechaConsulta, Date fechaCalculada) {
		Boolean result = false;
		if (fechaConsulta.getTime() < fechaCalculada.getTime()) {
			result = true;
		}
		return result;
	}
	
	
	
	public Date stringToDateTime(String pSFecha) {
		
		if (!pSFecha.equals("")  && pSFecha != null) {
			String myFecha = pSFecha.substring(8, 10)+"/"+pSFecha.substring(5, 7)+"/"+pSFecha.substring(0, 4) ;
			try {
				return stringToDate(myFecha);
			} catch (Exception e) {
				
			}
		}
		return null;
	}
	
	/**
	 * Formato ddMMyyyyHHmmss
	 * 
	 * @param myDate
	 * @return
	 * @throws ParseException 
	 */
	public static Date stringToDate(String aFechaDD_SS) throws ParseException {
		
			SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyy");
			myFormat.setLenient(true);
			Date myDate = myFormat.parse(aFechaDD_SS);
			return myDate;
		
	}
	
	/**
	 * Verifica si la fecha ingresada es menor a la actual
	 * @param fecha1 --> Parametro transportador de datos 
	 * @return --> Objeto de tipo boolean
	 */
	public boolean esFechaMenor(Date fecha1) {
		Date fechaActual = new Date();
		boolean lbEsFechaMayor = false;
		if (fecha1.getTime() < fechaActual.getTime()) {
			lbEsFechaMayor = true;
		}
		return lbEsFechaMayor;
	}
	
	/**
	 * Convierte un dato de tipo Date a String
	 * devolviendo formato (dd/MM/yyyy) 
	 * @param fecha --> Parametro transportador de datos
	 * @return --> Objeto de tipo String
	 */
	public String dateToStringMascara(Date fecha) {
		if (fecha == null) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate = dateFormat.format(fecha);
		
		return stringDate;
	}
	
	
	
}
