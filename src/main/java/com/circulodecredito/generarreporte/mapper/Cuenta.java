package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Cuenta {
    private String fechaActualizacion;
    private String registroImpugnado;
    private String claveOtorgante;
    private String nombreOtorgante;
    private String cuentaActual;
    private String tipoResponsabilidad;
    private String tipoCuenta;
    private String tipoCredito;
    private String claveUnidadMonetaria;
    private String valorActivoValuacion;
    private String numeroPagos;
    private String frecuenciaPagos;
    private String montoPagar;
    private String fechaAperturaCuenta;
    private String fechaUltimoPago;
    private String fechaUltimaCompra;
    private String fechaCierreCuenta;
    private String fechaReporte;
    private String ultimaFechaSaldoCero;
    private String garantia;
    private String creditoMaximo;
    private String saldoActual;
    private String limiteCredito;
    private String saldoVencido;
    private String numeroPagosVencidos;
    private String pagoActual;
    private String historicoPagos;
    private String fechaRecienteHistoricoPagos;
    private String fechaAntiguaHistoricoPagos;
    private String clavePrevencion;
    private String totalPagosReportados;
    private String peorAtraso;
    private String fechaPeorAtraso;
    private String saldoVencidoPeorAtraso;
    private String montoUltimoPago;
    private String idDomicilio;
    private String servicios;
    private Can can;
    private String identiicadorCan;
    private Integer noCred;

	public String getIdentiicadorCan() {
		return identiicadorCan;
	}

	public void setIdentiicadorCan(String identiicadorCan) {
		this.identiicadorCan = identiicadorCan;
	}

	public Integer getNoCred() {
		return noCred;
	}

	public void setNoCred(Integer noCred) {
		this.noCred = noCred;
	}

	@XmlElement(name ="CAN")
    public Can getCan() { return can; }

    public void setCan(Can can) { this.can = can; }

    @XmlElement(name ="MontoUltimoPago")
    public String getMontoUltimoPago() {
		return montoUltimoPago;
	}

	public void setMontoUltimoPago(String montoUltimoPago) {
		this.montoUltimoPago = montoUltimoPago;
	}

	@XmlElement(name ="IdDomicilio")
	public String getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(String idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	@XmlElement(name ="Servicios")
	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	@XmlElement(name ="FechaPeorAtraso")
	public String getFechaPeorAtraso() {
		return fechaPeorAtraso;
	}

	@XmlElement(name ="FechaActualizacion")
    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    @XmlElement(name ="RegistroImpugnado")
    public String getRegistroImpugnado() {
        return registroImpugnado;
    }

    @XmlElement(name ="ClaveOtorgante")
    public String getClaveOtorgante() {
        return claveOtorgante;
    }

    @XmlElement(name ="NombreOtorgante")
    public String getNombreOtorgante() {
        return nombreOtorgante;
    }

    @XmlElement(name ="CuentaActual")
    public String getCuentaActual() {
        return cuentaActual;
    }

    @XmlElement(name ="TipoResponsabilidad")
    public String getTipoResponsabilidad() {
        return tipoResponsabilidad;
    }

    @XmlElement(name ="TipoCuenta")
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    @XmlElement(name ="TipoCredito")
    public String getTipoCredito() {
        return tipoCredito;
    }

    @XmlElement(name ="ClaveUnidadMonetaria")
    public String getClaveUnidadMonetaria() {
        return claveUnidadMonetaria;
    }
    
    @XmlElement(name ="ValorActivoValuacion")
    public String getValorActivoValuacion() {
        return valorActivoValuacion;
    }

    @XmlElement(name ="NumeroPagos")
    public String getNumeroPagos() {
        return numeroPagos;
    }

    @XmlElement(name ="FrecuenciaPagos")
    public String getFrecuenciaPagos() {
        return frecuenciaPagos;
    }

    @XmlElement(name ="MontoPagar")
    public String getMontoPagar() {
        return montoPagar;
    }

    @XmlElement(name ="FechaAperturaCuenta")
    public String getFechaAperturaCuenta() {
        return fechaAperturaCuenta;
    }

    @XmlElement(name ="FechaUltimoPago")
    public String getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    @XmlElement(name ="FechaUltimaCompra")
    public String getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    @XmlElement(name ="FechaCierreCuenta")
    public String getFechaCierreCuenta() {
        return fechaCierreCuenta;
    }

    @XmlElement(name ="FechaReporte")
    public String getFechaReporte() {
        return fechaReporte;
    }

    @XmlElement(name ="UltimaFechaSaldoCero")
    public String getUltimaFechaSaldoCero() {
        return ultimaFechaSaldoCero;
    }

    @XmlElement(name ="Garantia")
    public String getGarantia() {
        return garantia;
    }

    @XmlElement(name ="CreditoMaximo")
    public String getCreditoMaximo() {
        return creditoMaximo;
    }

    @XmlElement(name ="SaldoActual")
    public String getSaldoActual() {
        return saldoActual;
    }

    @XmlElement(name ="LimiteCredito")
    public String getLimiteCredito() {
        return limiteCredito;
    }

    @XmlElement(name ="SaldoVencido")
    public String getSaldoVencido() {
        return saldoVencido;
    }

    @XmlElement(name ="NumeroPagosVencidos")
    public String getNumeroPagosVencidos() {
        return numeroPagosVencidos;
    }

    @XmlElement(name ="PagoActual")
    public String getPagoActual() {
        return pagoActual;
    }

    @XmlElement(name ="HistoricoPagos")
    public String getHistoricoPagos() {
        return historicoPagos;
    }

    @XmlElement(name ="FechaRecienteHistoricoPagos")
    public String getFechaRecienteHistoricoPagos() {
        return fechaRecienteHistoricoPagos;
    }

    @XmlElement(name ="FechaAntiguaHistoricoPagos")
    public String getFechaAntiguaHistoricoPagos() {
        return fechaAntiguaHistoricoPagos;
    }

    @XmlElement(name ="ClavePrevencion")
    public String getClavePrevencion() {
        return clavePrevencion;
    }

    @XmlElement(name ="TotalPagosReportados")
    public String getTotalPagosReportados() {
        return totalPagosReportados;
    }

    @XmlElement(name ="PeorAtraso")
    public String getPeorAtraso() {
        return peorAtraso;
    }

    @XmlElement(name ="SaldoVencidoPeorAtraso")
    public String getSaldoVencidoPeorAtraso() {
        return saldoVencidoPeorAtraso;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public void setRegistroImpugnado(String registroImpugnado) {
        this.registroImpugnado = registroImpugnado;
    }

    public void setClaveOtorgante(String claveOtorgante) {
        this.claveOtorgante = claveOtorgante;
    }

    public void setNombreOtorgante(String nombreOtorgante) {
        this.nombreOtorgante = nombreOtorgante;
    }

    public void setCuentaActual(String cuentaActual) {
        this.cuentaActual = cuentaActual;
    }

    public void setTipoResponsabilidad(String tipoResponsabilidad) {
        this.tipoResponsabilidad = tipoResponsabilidad;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public void setClaveUnidadMonetaria(String claveUnidadMonetaria) {
        this.claveUnidadMonetaria = claveUnidadMonetaria;
    }

    public void setValorActivoValuacion(String valorActivoValuacion) {
        this.valorActivoValuacion = valorActivoValuacion;
    }

    public void setNumeroPagos(String numeroPagos) {
        this.numeroPagos = numeroPagos;
    }

    public void setFrecuenciaPagos(String frecuenciaPagos) {
        this.frecuenciaPagos = frecuenciaPagos;
    }

    public void setMontoPagar(String montoPagar) {
        this.montoPagar = montoPagar;
    }

    public void setFechaAperturaCuenta(String fechaAperturaCuenta) {
        this.fechaAperturaCuenta = fechaAperturaCuenta;
    }

    public void setFechaUltimoPago(String fechaUltimoPago) {
        this.fechaUltimoPago = fechaUltimoPago;
    }

    public void setFechaUltimaCompra(String fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public void setFechaCierreCuenta(String fechaCierreCuenta) {
        this.fechaCierreCuenta = fechaCierreCuenta;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public void setUltimaFechaSaldoCero(String ultimaFechaSaldoCero) {
        this.ultimaFechaSaldoCero = ultimaFechaSaldoCero;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public void setCreditoMaximo(String creditoMaximo) {
        this.creditoMaximo = creditoMaximo;
    }

    public void setSaldoActual(String saldoActual) {
        this.saldoActual = saldoActual;
    }

    public void setLimiteCredito(String limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void setSaldoVencido(String saldoVencido) {
        this.saldoVencido = saldoVencido;
    }

    public void setNumeroPagosVencidos(String numeroPagosVencidos) {
        this.numeroPagosVencidos = numeroPagosVencidos;
    }

    public void setPagoActual(String pagoActual) {
        this.pagoActual = pagoActual;
    }

    public void setHistoricoPagos(String historicoPagos) {
        this.historicoPagos = historicoPagos;
    }

    public void setFechaRecienteHistoricoPagos(String fechaRecienteHistoricoPagos) {
        this.fechaRecienteHistoricoPagos = fechaRecienteHistoricoPagos;
    }

    public void setFechaAntiguaHistoricoPagos(String fechaAntiguaHistoricoPagos) {
        this.fechaAntiguaHistoricoPagos = fechaAntiguaHistoricoPagos;
    }

    public void setClavePrevencion(String clavePrevencion) {
        this.clavePrevencion = clavePrevencion;
    }

    public void setTotalPagosReportados(String totalPagosReportados) {
        this.totalPagosReportados = totalPagosReportados;
    }

    public void setPeorAtraso(String peorAtraso) {
        this.peorAtraso = peorAtraso;
    }

    public void setFechaPeorAtraso(String fechaPeorAtraso) {
        this.fechaPeorAtraso = fechaPeorAtraso;
    }

    public void setSaldoVencidoPeorAtraso(String saldoVencidoPeorAtraso) {
        this.saldoVencidoPeorAtraso = saldoVencidoPeorAtraso;
    }
}
