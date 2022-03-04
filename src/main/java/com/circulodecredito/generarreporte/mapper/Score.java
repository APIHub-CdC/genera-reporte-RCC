package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Score {
    private String nombreScore;
    private String codigo;
    private String valor;
    private String razon1;
    private String razon2;
    private String razon3;
    private String razon4;
    private String error;
    private Indicadores indicadores;

    @XmlElement(name ="Indicadores")
    public Indicadores getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(Indicadores indicadores) {
		this.indicadores = indicadores;
	}

	@XmlElement(name ="NombreScore")
    public String getNombreScore() {
        return nombreScore;
    }

    @XmlElement(name ="Codigo")
    public String getCodigo() {
        return codigo;
    }

    @XmlElement(name ="Valor")
    public String getValor() {
        return valor;
    }

    @XmlElement(name ="Razon1")
    public String getRazon1() {
        return razon1;
    }

    @XmlElement(name ="Razon2")
    public String getRazon2() {
        return razon2;
    }
    
    @XmlElement(name ="Razon3")
    public String getRazon3() {
        return razon3;
    }
    
    @XmlElement(name ="Razon4")
    public String getRazon4() {
        return razon4;
    }
    
    @XmlElement(name ="Error")
    public String getError() {
        return error;
    }

    public void setNombreScore(String nombreScore) {
        this.nombreScore = nombreScore;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setRazon1(String razon1) {
        this.razon1 = razon1;
    }

    public void setRazon2(String razon2) {
        this.razon2 = razon2;
    }
    
    public void setRazon3(String razon3) {
        this.razon3 = razon3;
    }
    
    public void setRazon4(String razon4) {
        this.razon4 = razon4;
    }
    
    public void setError(String error) {
        this.error = error;
    }
}
