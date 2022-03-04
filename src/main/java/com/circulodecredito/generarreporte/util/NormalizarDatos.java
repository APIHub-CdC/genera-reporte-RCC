package com.circulodecredito.generarreporte.util;

import java.text.Normalizer;

public class NormalizarDatos {
	
	public static String sNormalizaTextoNFC(String entrada, Integer iFiltro){
		String salida = null;
		String sFiltro;
		try {
			
			switch(iFiltro) {
				case 1: 
					sFiltro = "[^ÁÉÍÓÚÑáéíóúña-zA-Z0-9 *]";//Letras, numeros, espacios.INTL
					break;
				case 2:
					sFiltro = "[^a-zA-Z0-9 ]";//Letras, numeros.
					break;
				case 3:
					sFiltro = "[^a-zA-Z]";//Letras.
					break;
				case 4:
					sFiltro = "[^0-9]";//Numeros.
					break;
				case 5:
					sFiltro = "[^a-zA-Z0-9 _-]";//Folios
					break;
				case 6:
					sFiltro = "[^0-9-]";//Fechas
					break;
				case 7:
					sFiltro = "[^ÁÉÍÓÚÑáéíóúña-zA-Z0-9{}:, /'\"-_?.<>]";
					break;
				default://Valor default 0
					sFiltro = "[^ÁÉÍÓÚÑáéíóúña-zA-Z0-9]";//Letras, numeros, espacios. XML
					break;
			}
			
			
			
			if(null != entrada) {
				salida = Normalizer
				        .normalize(entrada, Normalizer.Form.NFC)
				        .replaceAll(sFiltro, "");
				salida = salida.replaceAll("&", "&amp;amp;");
			}
		} catch (Exception e) {
			salida = entrada;
		}
		return salida;
	}

}
