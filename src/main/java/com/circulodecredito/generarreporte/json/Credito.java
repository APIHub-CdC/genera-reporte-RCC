package com.circulodecredito.generarreporte.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credito {
	@JsonProperty("fechaActualizacion")
	  private String fechaActualizacion = null;
	@JsonProperty("registroImpugnado")
	  private Integer registroImpugnado = null;
	@JsonProperty("claveOtorgante")
	  private String claveOtorgante = null;
	@JsonProperty("nombreOtorgante")
	  private String nombreOtorgante = null;
	@JsonProperty("cuentaActual")
	  private String cuentaActual = null;
	@JsonProperty("tipoResponsabilidad")
	  private String tipoResponsabilidad = null;
	@JsonProperty("tipoCuenta")
	  private String tipoCuenta = null;
	@JsonProperty("tipoCredito")
	  private String tipoCredito = null;
	@JsonProperty("claveUnidadMonetaria")
	  private String claveUnidadMonetaria = null;
	@JsonProperty("valorActivoValuacion")
	  private Integer valorActivoValuacion = null;
	@JsonProperty("numeroPagos")
	  private Integer numeroPagos = null;
	@JsonProperty("frecuenciaPagos")
	  private String frecuenciaPagos = null;
	@JsonProperty("montoPagar")
	  private Float montoPagar = null;
	@JsonProperty("fechaAperturaCuenta")
	  private String fechaAperturaCuenta = null;
	@JsonProperty("fechaUltimoPago")
	  private String fechaUltimoPago = null;
	@JsonProperty("fechaUltimaCompra")
	  private String fechaUltimaCompra = null;
	@JsonProperty("fechaCierreCuenta")
	  private String fechaCierreCuenta = null;
	@JsonProperty("fechaReporte")
	  private String fechaReporte = null;
	@JsonProperty("ultimaFechaSaldoCero")
	  private String ultimaFechaSaldoCero = null;
	@JsonProperty("garantia")
	  private String garantia = null;
	@JsonProperty("creditoMaximo")
	  private Float creditoMaximo = null;
	@JsonProperty("saldoActual")
	  private Float saldoActual = null;
	@JsonProperty("limiteCredito")
	  private Float limiteCredito = null;
	@JsonProperty("saldoVencido")
	  private Float saldoVencido = null;
	@JsonProperty("numeroPagosVencidos")
	  private Integer numeroPagosVencidos = null;
	@JsonProperty("pagoActual")
	  private String pagoActual = null;
	@JsonProperty("historicoPagos")
	  private String historicoPagos = null;
	@JsonProperty("fechaRecienteHistoricoPagos")
	  private String fechaRecienteHistoricoPagos = null;
	@JsonProperty("fechaAntiguaHistoricoPagos")
	  private String fechaAntiguaHistoricoPagos = null;
	@JsonProperty("clavePrevencion")
	  private String clavePrevencion = null;
	@JsonProperty("totalPagosReportados")
	  private Integer totalPagosReportados = null;
	@JsonProperty("peorAtraso")
	  private Float peorAtraso = null;
	@JsonProperty("fechaPeorAtraso")
	  private String fechaPeorAtraso = null;
	@JsonProperty("saldoVencidoPeorAtraso")
	  private Float saldoVencidoPeorAtraso = null;
	@JsonProperty("montoUltimoPago")
	  private Double montoUltimoPago = null;
	@JsonProperty("idDomicilio")
	  private String idDomicilio = null;
	@JsonProperty("servicios")
	  private String servicios = null;
	@JsonProperty("CAN")
	  private CAN CAN = null;
	public String getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public Integer getRegistroImpugnado() {
		return registroImpugnado;
	}
	public void setRegistroImpugnado(Integer registroImpugnado) {
		this.registroImpugnado = registroImpugnado;
	}
	public String getClaveOtorgante() {
		return claveOtorgante;
	}
	public void setClaveOtorgante(String claveOtorgante) {
		this.claveOtorgante = claveOtorgante;
	}
	public String getNombreOtorgante() {
		return nombreOtorgante;
	}
	public void setNombreOtorgante(String nombreOtorgante) {
		this.nombreOtorgante = nombreOtorgante;
	}
	public String getCuentaActual() {
		return cuentaActual;
	}
	public void setCuentaActual(String cuentaActual) {
		this.cuentaActual = cuentaActual;
	}
	public String getTipoResponsabilidad() {
		return tipoResponsabilidad;
	}
	public void setTipoResponsabilidad(String tipoResponsabilidad) {
		this.tipoResponsabilidad = tipoResponsabilidad;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getTipoCredito() {
		return tipoCredito;
	}
	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}
	public String getClaveUnidadMonetaria() {
		return claveUnidadMonetaria;
	}
	public void setClaveUnidadMonetaria(String claveUnidadMonetaria) {
		this.claveUnidadMonetaria = claveUnidadMonetaria;
	}
	public Integer getValorActivoValuacion() {
		return valorActivoValuacion;
	}
	public void setValorActivoValuacion(Integer valorActivoValuacion) {
		this.valorActivoValuacion = valorActivoValuacion;
	}
	public Integer getNumeroPagos() {
		return numeroPagos;
	}
	public void setNumeroPagos(Integer numeroPagos) {
		this.numeroPagos = numeroPagos;
	}
	public String getFrecuenciaPagos() {
		return frecuenciaPagos;
	}
	public void setFrecuenciaPagos(String frecuenciaPagos) {
		this.frecuenciaPagos = frecuenciaPagos;
	}
	public Float getMontoPagar() {
		return montoPagar;
	}
	public void setMontoPagar(Float montoPagar) {
		this.montoPagar = montoPagar;
	}
	public String getFechaAperturaCuenta() {
		return fechaAperturaCuenta;
	}
	public void setFechaAperturaCuenta(String fechaAperturaCuenta) {
		this.fechaAperturaCuenta = fechaAperturaCuenta;
	}
	public String getFechaUltimoPago() {
		return fechaUltimoPago;
	}
	public void setFechaUltimoPago(String fechaUltimoPago) {
		this.fechaUltimoPago = fechaUltimoPago;
	}
	public String getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}
	public void setFechaUltimaCompra(String fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	public String getFechaCierreCuenta() {
		return fechaCierreCuenta;
	}
	public void setFechaCierreCuenta(String fechaCierreCuenta) {
		this.fechaCierreCuenta = fechaCierreCuenta;
	}
	public String getFechaReporte() {
		return fechaReporte;
	}
	public void setFechaReporte(String fechaReporte) {
		this.fechaReporte = fechaReporte;
	}
	public String getUltimaFechaSaldoCero() {
		return ultimaFechaSaldoCero;
	}
	public void setUltimaFechaSaldoCero(String ultimaFechaSaldoCero) {
		this.ultimaFechaSaldoCero = ultimaFechaSaldoCero;
	}
	public String getGarantia() {
		return garantia;
	}
	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}
	public Float getCreditoMaximo() {
		return creditoMaximo;
	}
	public void setCreditoMaximo(Float creditoMaximo) {
		this.creditoMaximo = creditoMaximo;
	}
	public Float getSaldoActual() {
		return saldoActual;
	}
	public void setSaldoActual(Float saldoActual) {
		this.saldoActual = saldoActual;
	}
	public Float getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(Float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public Float getSaldoVencido() {
		return saldoVencido;
	}
	public void setSaldoVencido(Float saldoVencido) {
		this.saldoVencido = saldoVencido;
	}
	public Integer getNumeroPagosVencidos() {
		return numeroPagosVencidos;
	}
	public void setNumeroPagosVencidos(Integer numeroPagosVencidos) {
		this.numeroPagosVencidos = numeroPagosVencidos;
	}
	public String getPagoActual() {
		return pagoActual;
	}
	public void setPagoActual(String pagoActual) {
		this.pagoActual = pagoActual;
	}
	public String getHistoricoPagos() {
		return historicoPagos;
	}
	public void setHistoricoPagos(String historicoPagos) {
		this.historicoPagos = historicoPagos;
	}
	public String getFechaRecienteHistoricoPagos() {
		return fechaRecienteHistoricoPagos;
	}
	public void setFechaRecienteHistoricoPagos(String fechaRecienteHistoricoPagos) {
		this.fechaRecienteHistoricoPagos = fechaRecienteHistoricoPagos;
	}
	public String getFechaAntiguaHistoricoPagos() {
		return fechaAntiguaHistoricoPagos;
	}
	public void setFechaAntiguaHistoricoPagos(String fechaAntiguaHistoricoPagos) {
		this.fechaAntiguaHistoricoPagos = fechaAntiguaHistoricoPagos;
	}
	public String getClavePrevencion() {
		return clavePrevencion;
	}
	public void setClavePrevencion(String clavePrevencion) {
		this.clavePrevencion = clavePrevencion;
	}
	public Integer getTotalPagosReportados() {
		return totalPagosReportados;
	}
	public void setTotalPagosReportados(Integer totalPagosReportados) {
		this.totalPagosReportados = totalPagosReportados;
	}
	public Float getPeorAtraso() {
		return peorAtraso;
	}
	public void setPeorAtraso(Float peorAtraso) {
		this.peorAtraso = peorAtraso;
	}
	public String getFechaPeorAtraso() {
		return fechaPeorAtraso;
	}
	public void setFechaPeorAtraso(String fechaPeorAtraso) {
		this.fechaPeorAtraso = fechaPeorAtraso;
	}
	public Float getSaldoVencidoPeorAtraso() {
		return saldoVencidoPeorAtraso;
	}
	public void setSaldoVencidoPeorAtraso(Float saldoVencidoPeorAtraso) {
		this.saldoVencidoPeorAtraso = saldoVencidoPeorAtraso;
	}
	public Double getMontoUltimoPago() {
		return montoUltimoPago;
	}
	public void setMontoUltimoPago(Double montoUltimoPago) {
		this.montoUltimoPago = montoUltimoPago;
	}
	public String getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(String idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	public String getServicios() {
		return servicios;
	}
	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	public CAN getCAN() {
		return CAN;
	}
	public void setCAN(CAN cAN) {
		CAN = cAN;
	}
	  
	  
}
