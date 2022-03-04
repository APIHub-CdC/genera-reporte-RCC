package com.circulodecredito.generarreporte.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"success"})
public class GenerarReporteResponse {
	
	@JsonProperty("pdfBytes")
	private byte [] pdfBytes;	
	@JsonProperty("isSuccess")
	private boolean isSuccess;
	@JsonProperty("errorCode")
	private Long errorCode;
	@JsonProperty("errorDescription")
	private String errorDescription;
	
	public GenerarReporteResponse() {
		this.isSuccess = false;
		this.errorCode = 0l;
		this.errorDescription = "";
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
	
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	public boolean isSuccess() {
		return isSuccess;
	}
	
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public Long getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}

	public byte[] getPdfBytes() {
		return pdfBytes;
	}

	public void setPdfBytes(byte[] pdfBytes) {
		this.pdfBytes = pdfBytes;
	}
	
	
}
