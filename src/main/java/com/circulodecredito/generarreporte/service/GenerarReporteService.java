package com.circulodecredito.generarreporte.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdc.validacionescore.response.ReporteCreditoResponse;
import com.circulodecredito.generarreporte.constantes.ConstantesError;
import com.circulodecredito.generarreporte.mapper.Cuenta;
import com.circulodecredito.generarreporte.mapper.CuentasCan;
import com.circulodecredito.generarreporte.mapper.Respuesta;
import com.circulodecredito.generarreporte.response.GenerarReporteResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;

@Service
public class GenerarReporteService {
	
	//static final Logger LOGG = Logger.getLogger("generarReporteLog");
	
	private final String DATE_PATTERN = "yyyy-MM-dd";
	private final String XML_PATTERN = "#,##0.##";
	
	@Autowired
	private Validador validador;
	
	private String validarFecha (String fecha){
		String mensaje = null;
		if (fecha != null && !fecha.equals("")){
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
			try {
				Date fechaDate = dateFormat.parse(fecha);
				if(fechaDate.after(new Date())){
					mensaje = "La Fecha Reporte no puede ser mayor a la fecha Actual";
				}
			} catch (ParseException e) {
				mensaje = "Formato de fecha incorrecto de Fecha Reporte: "+DATE_PATTERN;
			}
		}
		return mensaje;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenerarReporteResponse generarReporteService(String xml, ReporteCreditoResponse respuesta, String fechaReporte) {
		GenerarReporteResponse response = new GenerarReporteResponse();
		byte[] pdfBytes = null;
		
		String imagenTacometro;	
		InputStream reportStream = null;
		
		String mensajeFecha = this.validarFecha(fechaReporte);
		if(mensajeFecha == null){
			try {
				
				Respuesta objectRespuesta = null;
				//conversion de XML a objeto
				if(xml != null && !"".equals(xml)) {
					
					Long inicioXml = System.currentTimeMillis();
					JAXBContext jc = JAXBContext.newInstance(Respuesta.class);
		            Unmarshaller unmarshaller = jc.createUnmarshaller();
		            StreamSource streamSource = new StreamSource(new StringReader(xml));
		            JAXBElement<Respuesta> je = unmarshaller.unmarshal(streamSource, Respuesta.class);
		            objectRespuesta = (Respuesta) je.getValue();
		            System.out.println("Tiempo Conversion XML :"+(System.currentTimeMillis() -inicioXml));
		            objectRespuesta = validador.generarFormatoXML(xml, objectRespuesta, fechaReporte);
		            
		        //conversion de Objeto RC a Objeto Respuesta para Jasper 
				}else if(respuesta != null){
					objectRespuesta = validador.convertirRCEResponseToRespuesta(respuesta, fechaReporte);
				}
	            
				if(objectRespuesta != null) {

					ArrayList<Respuesta> dataList = new ArrayList<Respuesta>();
					dataList.add(objectRespuesta);
					
					JRBeanCollectionDataSource beanColDataSource = new 
					         JRBeanCollectionDataSource(dataList); //este pasa los datos a jasper
					
					imagenTacometro = validador.obtenerImgTacometro(objectRespuesta);
					Map params = new HashMap();
			        params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, DATE_PATTERN);
			        params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, XML_PATTERN);
			        params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.ENGLISH);
			        params.put(JRParameter.REPORT_LOCALE, Locale.US);
			        if(imagenTacometro != null && !imagenTacometro.equals("")) {
			        	params.put("imagenTacometro", imagenTacometro);
			        }
			        reportStream = getClass().getResourceAsStream("/reportes/rcc/rcc.jrxml");
			        params.put("subrepPath", "/reportes/rcc/");
			        JasperReport report = JasperCompileManager.compileReport(reportStream);
			        JasperPrint reportPrint = JasperFillManager.fillReport(report, params, beanColDataSource);
			        pdfBytes = JasperExportManager.exportReportToPdf(reportPrint);
				}
				response.setSuccess(true);
			} catch(JRException ex) {
				ex.printStackTrace();
				//LOGG.error("JRException",ex);
				response.setSuccess(false);
				response.setErrorCode(ConstantesError.INTERNAL_SERVER_ERROR_CODE);
				response.setErrorDescription(ConstantesError.INTERNAL_SERVER_ERROR);
				System.out.println(ex);
			}catch(Exception ex) {
				ex.printStackTrace();
				//LOGG.error("Exception",ex);
				response.setSuccess(false);
				response.setErrorCode(ConstantesError.INTERNAL_SERVER_ERROR_CODE);
				response.setErrorDescription(ConstantesError.INTERNAL_SERVER_ERROR);
				System.out.println(ex);
			} finally {
				try {
					if(reportStream != null) {
						reportStream.close();
					}
				} catch (IOException e) {
					//LOGG.error("IOException",e);
				}
			}
			response.setPdfBytes(pdfBytes);
		}else{
			response.setSuccess(false);
			response.setErrorCode(ConstantesError.BAD_REQUEST_FORMAT_CODE);
			response.setErrorDescription(mensajeFecha);
		}
		return response;
	}
	
	
	
}
