package com.circulodecredito.generarreporte.controller;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.circulodecredito.generarreporte.request.GenerarReporteRequest;
import com.circulodecredito.generarreporte.response.GenerarReporteResponse;
import com.circulodecredito.generarreporte.service.GenerarReporteService;
import com.circulodecredito.generarreporte.util.NormalizarDatos;
/**
 * Controlador para generar reporte
 * @author lfgodinezl
 * @version 1.0
 */
@RestController
public class GenerarReporteController {
	
	@Autowired
	private GenerarReporteService generarReporteService;
	
	//static final Logger LOGG = Logger.getLogger("generarReporteLog");
	
	
	/**
	 * Genera el reporte de credito por XML
	 * @param request GenerarReporteRequest
	 * @return ResponseEntity
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/generarReporte")
	public ResponseEntity generarReporte(@RequestBody GenerarReporteRequest request) {
		GenerarReporteResponse response = generarReporteService.generarReporteService(
				NormalizarDatos.sNormalizaTextoNFC(request.getXml(),7), null, request.getFechaReporte());
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	/**
	 * Genera el reporte de credito por XML, se usa de test, PDF en bytes
	 * @param request GenerarReporteRequest
	 * @return ResponseEntity
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/generarReporteTest")
	public ResponseEntity generarReporteTest(@RequestBody GenerarReporteRequest request) {
		GenerarReporteResponse response = generarReporteService.generarReporteService(
				NormalizarDatos.sNormalizaTextoNFC(request.getXml(),7), null,request.getFechaReporte());
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(response.getPdfBytes());
	}
	
	/**
	 * Genera el reporte de credito por JSON
	 * @param request GenerarReporteRequest
	 * @return ResponseEntity
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/generarReporteJsonTest")
	public ResponseEntity generarReporteJsonTest(@RequestBody GenerarReporteRequest request) {
		System.out.println("entra a este generarReporteJsonTest");
		GenerarReporteResponse response = generarReporteService.generarReporteService(null,request.getRespuesta(),request.getFechaReporte());
		System.out.println("sale generarReporteJsonTest");
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(response.getPdfBytes());
	}
	
	/**
	 * Genera el reporte de credito por JSON
	 * @param request GenerarReporteRequest
	 * @return ResponseEntity
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/generarReporteJson")
	public ResponseEntity generarReporteJson(@RequestBody GenerarReporteRequest request) {
		GenerarReporteResponse response = generarReporteService.generarReporteService(null,request.getRespuesta(),request.getFechaReporte());
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
}
