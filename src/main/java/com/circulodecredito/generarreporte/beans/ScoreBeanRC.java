package com.circulodecredito.generarreporte.beans;

import java.io.Serializable;

/**
* Esta clase implementa el Bean para almacenar elementos de score del XML de respuesta
* cuando un Reporte de Cr�dito sea solicitado.
* @author Tecnoskill, S.A. de C.V. seg�n base de Juan Carlos D�az Ram�rez(BCF).
* @since 10/JULIO/2009
*/
public final class ScoreBeanRC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreScore = null;
	private String valorScore = null;
	private String errorScore = null;
	private String valIndScore[] = new String[5];
	private String nomIndScore[] = new String [5];
	private String razones[] = new String [5];
	private String sinScore = null;
	
	public ScoreBeanRC()
	{
		for (int i = 0; i < 5; i++){
			valIndScore[i] = new String();
			nomIndScore[i] = new String();
		}
	}

	public String getNombreScore() {
		return nombreScore;
	}

	public void setNombreScore(String nombreScore) {
		this.nombreScore = nombreScore;
	}

	public String[] getNomIndScore() {
		return nomIndScore;
	}
	
	public String getNomIndScore(int pos) {
		return nomIndScore[pos];
	}

	public void setNomIndScore(String[] nomIndScore) {
		this.nomIndScore = nomIndScore;
	}
	
	public void setNomIndScore(String nomIndScore, int pos) {
		this.nomIndScore[pos] = nomIndScore;
	}

	public String[] getValIndScore() {
		return valIndScore;
	}
	
	public String getValIndScore(int pos) {
		return valIndScore[pos];
	}
	

	public void setValIndScore(String[] valIndScore) {
		this.valIndScore = valIndScore;
	}
	
	public void setValIndScore(String valIndScore, int pos) {
		this.valIndScore[pos] = valIndScore;
	}

	public String getValorScore() {
		return valorScore;
	}

	public void setValorScore(String valorScore) {
		this.valorScore = valorScore;
	}

	public String getErrorScore() {
		return errorScore;
	}

	public void setErrorScore(String errorScore) {
		this.errorScore = errorScore;
	}

	public String[] getRazones() {
		return razones;
	}

	public void setRazones(String[] razones) {
		this.razones = razones;
	}
	
	
	
	public String getIndRazon(int pos) {
		return razones[pos];
	}

	public void setNomIndRazon(String nomIndRazon, int pos) {
		this.razones[pos] = nomIndRazon;
	}

	public String getSinScore() {
		return sinScore;
	}

	public void setSinScore(String sinScore) {
		this.sinScore = sinScore;
	}
	
	
	

}
