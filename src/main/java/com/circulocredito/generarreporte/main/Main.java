package com.circulocredito.generarreporte.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.jdom.Element;

import com.cdc.validacionescore.beans.DatosGenerales;
import com.cdc.validacionescore.response.ReporteCreditoResponse;
import com.cdc.validacionescore.validador.ValidacionesCore;
import com.circulodecredito.generarreporte.beans.CatalogosDTO;
import com.circulodecredito.generarreporte.beans.CountsBeanRC;
import com.circulodecredito.generarreporte.beans.summarizedProductBeanRC;
import com.circulodecredito.generarreporte.beans.summarizedVariablesBeanRC;
import com.circulodecredito.generarreporte.constantes.ConstantesEstatus;
import com.circulodecredito.generarreporte.constantes.ConstantesExclusionFIS;
import com.circulodecredito.generarreporte.constantes.ConstantesFechas;
import com.circulodecredito.generarreporte.constantes.ConstantesGenericas;
import com.circulodecredito.generarreporte.constantes.ConstantesIDs;
import com.circulodecredito.generarreporte.constantes.ConstantesMensaje;
import com.circulodecredito.generarreporte.dao.CatalogosDao;
import com.circulodecredito.generarreporte.json.Consulta;
import com.circulodecredito.generarreporte.json.Credito;
import com.circulodecredito.generarreporte.json.DomicilioRespuesta;
import com.circulodecredito.generarreporte.mapper.Can;
import com.circulodecredito.generarreporte.mapper.ConsultaEfectuada;
import com.circulodecredito.generarreporte.mapper.ConsultasEfectuadas;
import com.circulodecredito.generarreporte.mapper.Cuenta;
import com.circulodecredito.generarreporte.mapper.Cuentas;
import com.circulodecredito.generarreporte.mapper.CuentasCan;
import com.circulodecredito.generarreporte.mapper.DescripcionRazones;
import com.circulodecredito.generarreporte.mapper.Domicilio;
import com.circulodecredito.generarreporte.mapper.Domicilios;
import com.circulodecredito.generarreporte.mapper.Empleo;
import com.circulodecredito.generarreporte.mapper.Empleos;
import com.circulodecredito.generarreporte.mapper.Encabezado;
import com.circulodecredito.generarreporte.mapper.Grafica;
import com.circulodecredito.generarreporte.mapper.Graficas;
import com.circulodecredito.generarreporte.mapper.Mensaje;
import com.circulodecredito.generarreporte.mapper.Mensajes;
import com.circulodecredito.generarreporte.mapper.Nombre;
import com.circulodecredito.generarreporte.mapper.Persona;
import com.circulodecredito.generarreporte.mapper.Personas;
import com.circulodecredito.generarreporte.mapper.ProductoResumen;
import com.circulodecredito.generarreporte.mapper.Respuesta;
import com.circulodecredito.generarreporte.mapper.ResumenPorProducto;
import com.circulodecredito.generarreporte.mapper.Score;
import com.circulodecredito.generarreporte.mapper.Scores;
import com.circulodecredito.generarreporte.response.GenerarReporteResponse;
import com.circulodecredito.generarreporte.service.GenerarReporteService;
import com.circulodecredito.generarreporte.service.Validador;
import com.circulodecredito.generarreporte.util.NormalizarDatos;
import com.circulodecredito.generarreporte.util.ReadingJDOMRC;
import com.circulodecredito.generarreporte.util.TypeOfCoinExchangeRC;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class Main {

	public static  GenerarReporteService generarReporteService ;
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	public final static String XML_PATTERN = "#,##0.##";
	public static Validador validador = new Validador();
	
	public static ValidacionesCore validacionesCore = new ValidacionesCore();
	
	
	static CatalogosDao cat = new CatalogosDao();
	
	public static com.circulodecredito.generarreporte.json.Respuesta resp = new com.circulodecredito.generarreporte.json.Respuesta();
	
	public static NormalizarDatos normalizarDatos = new NormalizarDatos();
	
	
	
	public static void main(String args[]) {
		
		
		String fecha = "2019-08-23";
		
		String rutaPdf = "/Users/globatos/Documents/PDF_API/pdfCreado1.pdf";
		
		String json = "{\"folioConsulta\":\"19698610\",\"folioConsultaOtorgante\":\"1\",\"claveOtorgante\":\"0000081008\",\"declaracionesConsumidor\":null,\"persona\":{\"apellidoPaterno\":\"SESENTAYDOS\",\"apellidoMaterno\":\"PRUEBA\",\"nombres\":\"JUAN\",\"fechaNacimiento\":\"1965-08-09\",\"RFC\":\"SEPJ650809JG1\",\"nacionalidad\":\"MX\",\"residencia\":5,\"estadoCivil\":\"C\",\"sexo\":\"M\",\"numeroDependientes\":\"0\"},\"consultas\":[{\"fechaConsulta\":\"2020-06-10\",\"nombreOtorgante\":\"REPORTE DE CREDITO ESPECIAL\",\"telefonoOtorgante\":\"51662455\",\"tipoCredito\":\"M\",\"claveUnidadMonetaria\":\"MX\",\"importeCredito\":\"1\"},{\"fechaConsulta\":\"2018-08-24\",\"nombreOtorgante\":\"CONSUMIDOR FINAL / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2018-06-13\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2018-06-01\",\"nombreOtorgante\":\"FIANZAS / BC\",\"tipoCredito\":\"FI\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2018-05-24\",\"nombreOtorgante\":\"CONSUMIDOR FINAL / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2018-03-14\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2018-02-24\",\"nombreOtorgante\":\"CONSUMIDOR FINAL / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2017-11-23\",\"nombreOtorgante\":\"CONSUMIDOR FINAL / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2017-09-15\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2017-08-23\",\"nombreOtorgante\":\"CONSUMIDOR FINAL / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2017-05-25\",\"nombreOtorgante\":\"FIANZAS / BC\",\"tipoCredito\":\"FI\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2017-05-23\",\"nombreOtorgante\":\"CONSUMIDOR FINAL / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2017-03-08\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoCredito\":\"TC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"},{\"fechaConsulta\":\"2017-02-23\",\"nombreOtorgante\":\"CONSUMIDOR FINAL / BC\",\"tipoCredito\":\"NC\",\"importeCredito\":\"0\",\"tipoResponsabilidad\":\"I\"}],\"creditos\":[{\"fechaActualizacion\":\"2020-05-31\",\"registroImpugnado\":\"0\",\"nombreOtorgante\":\"REPORTE DE CREDITO ESPECIAL\",\"cuentaActual\":\"1234567890135\",\"tipoResponsabilidad\":\"I\",\"tipoCuenta\":\"F\",\"tipoCredito\":\"CC\",\"claveUnidadMonetaria\":\"UD\",\"valorActivoValuacion\":\"1098\",\"numeroPagos\":\"40\",\"frecuenciaPagos\":\"M\",\"montoPagar\":\"20\",\"fechaAperturaCuenta\":\"2017-01-28\",\"fechaUltimoPago\":\"2020-04-21\",\"fechaUltimaCompra\":\"2020-04-03\",\"fechaReporte\":\"2020-05-31\",\"creditoMaximo\":\"160000\",\"saldoActual\":\"100\",\"limiteCredito\":\"200000\",\"saldoVencido\":\"70\",\"numeroPagosVencidos\":\"4\",\"pagoActual\":\"02\",\"historicoPagos\":\"0201 V V V V V V V V V V V V V0201 V V\",\"totalPagosReportados\":\"0\",\"peorAtraso\":\"2\",\"fechaPeorAtraso\":\"2020-05-31\",\"saldoVencidoPeorAtraso\":\"70\"},{\"fechaActualizacion\":\"2018-09-14\",\"registroImpugnado\":\"0\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoResponsabilidad\":\"I\",\"tipoCuenta\":\"R\",\"tipoCredito\":\"TC\",\"claveUnidadMonetaria\":\"MX\",\"frecuenciaPagos\":\"M\",\"montoPagar\":\"1925\",\"fechaAperturaCuenta\":\"1998-08-25\",\"fechaUltimoPago\":\"2018-08-13\",\"fechaUltimaCompra\":\"2018-08-26\",\"fechaReporte\":\"2018-08-31\",\"creditoMaximo\":\"118648\",\"saldoActual\":\"20353\",\"limiteCredito\":\"154000\",\"saldoVencido\":\"0\",\"numeroPagosVencidos\":\"0\",\"pagoActual\":\"V\",\"historicoPagos\":\"V V V V V V V V V V V V V V\",\"saldoVencidoPeorAtraso\":\"0\",\"CAN\":{\"identificadorCAN\":\"01\",\"prelacionOrigen\":\"1\",\"prelacionActual\":\"1\",\"fechaAperturaCAN\":\"2019-12-01\",\"fechaCancelacionCAN\":\"2019-12-01\",\"historicoCAN\":\"2\",\"fechaMACAN\":\"2019-12-01\"}},{\"fechaActualizacion\":\"2018-09-13\",\"registroImpugnado\":\"0\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoResponsabilidad\":\"I\",\"tipoCuenta\":\"R\",\"tipoCredito\":\"TC\",\"claveUnidadMonetaria\":\"MX\",\"frecuenciaPagos\":\"M\",\"montoPagar\":\"0\",\"fechaAperturaCuenta\":\"2010-12-21\",\"fechaUltimoPago\":\"2018-08-23\",\"fechaUltimaCompra\":\"2018-08-28\",\"fechaReporte\":\"2018-08-31\",\"creditoMaximo\":\"124551\",\"saldoActual\":\"37456\",\"limiteCredito\":\"172500\",\"saldoVencido\":\"0\",\"numeroPagosVencidos\":\"0\",\"pagoActual\":\"V\",\"historicoPagos\":\"V V V V V V V V V V V V V\",\"saldoVencidoPeorAtraso\":\"0\"},{\"fechaActualizacion\":\"2018-09-07\",\"registroImpugnado\":\"0\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoResponsabilidad\":\"I\",\"tipoCuenta\":\"R\",\"tipoCredito\":\"LC\",\"claveUnidadMonetaria\":\"MX\",\"frecuenciaPagos\":\"M\",\"montoPagar\":\"0\",\"fechaAperturaCuenta\":\"2004-06-07\",\"fechaUltimoPago\":\"2018-06-21\",\"fechaUltimaCompra\":\"2015-08-14\",\"fechaReporte\":\"2018-08-31\",\"creditoMaximo\":\"252703\",\"saldoActual\":\"0\",\"limiteCredito\":\"250000\",\"saldoVencido\":\"0\",\"numeroPagosVencidos\":\"1\",\"pagoActual\":\"V\",\"historicoPagos\":\"V V V V---------- V V V V V01 V V V V V V V V V V\",\"clavePrevencion\":\"IA\",\"saldoVencidoPeorAtraso\":\"0\"},{\"fechaActualizacion\":\"2017-09-06\",\"registroImpugnado\":\"0\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoResponsabilidad\":\"I\",\"tipoCuenta\":\"R\",\"tipoCredito\":\"TC\",\"claveUnidadMonetaria\":\"MX\",\"frecuenciaPagos\":\"M\",\"montoPagar\":\"0\",\"fechaAperturaCuenta\":\"1998-08-25\",\"fechaUltimoPago\":\"2017-08-10\",\"fechaUltimaCompra\":\"2017-08-28\",\"fechaCierreCuenta\":\"2017-08-31\",\"fechaReporte\":\"2017-08-31\",\"creditoMaximo\":\"118648\",\"saldoActual\":\"0\",\"limiteCredito\":\"154000\",\"saldoVencido\":\"0\",\"numeroPagosVencidos\":\"0\",\"pagoActual\":\"--\",\"clavePrevencion\":\"LS\",\"saldoVencidoPeorAtraso\":\"0\"},{\"fechaActualizacion\":\"2017-09-06\",\"registroImpugnado\":\"0\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoResponsabilidad\":\"I\",\"tipoCuenta\":\"R\",\"tipoCredito\":\"TC\",\"claveUnidadMonetaria\":\"MX\",\"frecuenciaPagos\":\"M\",\"montoPagar\":\"0\",\"fechaAperturaCuenta\":\"1998-08-25\",\"fechaUltimoPago\":\"2017-08-10\",\"fechaUltimaCompra\":\"2017-08-28\",\"fechaCierreCuenta\":\"2017-08-31\",\"fechaReporte\":\"2017-08-31\",\"creditoMaximo\":\"118648\",\"saldoActual\":\"0\",\"limiteCredito\":\"154000\",\"saldoVencido\":\"0\",\"numeroPagosVencidos\":\"1\",\"pagoActual\":\"V\",\"historicoPagos\":\"V V V V V V V V V V V V V V V02 V V V V V V V V V\",\"clavePrevencion\":\"CC\",\"saldoVencidoPeorAtraso\":\"0\"},{\"fechaActualizacion\":\"2018-08-28\",\"registroImpugnado\":\"0\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoResponsabilidad\":\"I\",\"tipoCuenta\":\"R\",\"tipoCredito\":\"TC\",\"claveUnidadMonetaria\":\"MX\",\"frecuenciaPagos\":\"M\",\"montoPagar\":\"0\",\"fechaAperturaCuenta\":\"2010-12-21\",\"fechaUltimoPago\":\"2017-07-25\",\"fechaUltimaCompra\":\"2017-07-28\",\"fechaCierreCuenta\":\"2017-08-01\",\"fechaReporte\":\"2017-07-31\",\"creditoMaximo\":\"124551\",\"saldoActual\":\"0\",\"limiteCredito\":\"172500\",\"saldoVencido\":\"0\",\"numeroPagosVencidos\":\"1\",\"pagoActual\":\"V\",\"historicoPagos\":\"V V V V V V V V---- V V V04 V V V V V V V V V V V\",\"clavePrevencion\":\"CA\",\"saldoVencidoPeorAtraso\":\"0\"},{\"fechaActualizacion\":\"2015-06-01\",\"registroImpugnado\":\"0\",\"nombreOtorgante\":\"BANCO / BC\",\"tipoResponsabilidad\":\"I\",\"tipoCuenta\":\"H\",\"tipoCredito\":\"BR\",\"claveUnidadMonetaria\":\"MX\",\"numeroPagos\":\"120\",\"frecuenciaPagos\":\"M\",\"montoPagar\":\"0\",\"fechaAperturaCuenta\":\"2006-06-16\",\"fechaUltimoPago\":\"2015-05-27\",\"fechaCierreCuenta\":\"2015-05-27\",\"fechaReporte\":\"2015-05-31\",\"creditoMaximo\":\"1538820\",\"saldoActual\":\"0\",\"limiteCredito\":\"1538820\",\"saldoVencido\":\"0\",\"numeroPagosVencidos\":\"1\",\"pagoActual\":\"V\",\"historicoPagos\":\"V V V V V V V13 V V V V V V V V V V V V V V V V V\",\"clavePrevencion\":\"CC\",\"saldoVencidoPeorAtraso\":\"0\"},{\"fechaActualizacion\":\"2014-10-28\",\"registroImpugnado\":\"0\",\"nombreOtorgante\":\"TIENDA COMERCIAL / BC\",\"tipoResponsabilidad\":\"I\",\"tipoCuenta\":\"R\",\"tipoCredito\":\"LC\",\"claveUnidadMonetaria\":\"MX\",\"frecuenciaPagos\":\"M\",\"montoPagar\":\"0\",\"fechaAperturaCuenta\":\"2001-11-28\",\"fechaUltimoPago\":\"2011-08-17\",\"fechaUltimaCompra\":\"2010-06-05\",\"fechaCierreCuenta\":\"2014-10-06\",\"fechaReporte\":\"2014-10-08\",\"creditoMaximo\":\"37500\",\"saldoActual\":\"0\",\"limiteCredito\":\"37500\",\"saldoVencido\":\"0\",\"numeroPagosVencidos\":\"0\",\"pagoActual\":\"--\",\"historicoPagos\":\"------------ V V V------ V V V V V V V V V V V V V\",\"saldoVencidoPeorAtraso\":\"0\"}],\"domicilios\":[{\"direccion\":\"PASADISO ENCONTRADO 58\",\"coloniaPoblacion\":\"MONTEVIDEO\",\"delegacionMunicipio\":\"GUSTAVO A MADERO\",\"ciudad\":\"CIUDAD DE MÉXICO\",\"estado\":\"DF\",\"CP\":\"07730\",\"fechaResidencia\":\"2020-06-10\",\"fechaRegistroDomicilio\":\"2020-06-10\"},{\"direccion\":\"PASADISO ENCONTRADO 58\",\"coloniaPoblacion\":\"MONTEVIDEO\",\"delegacionMunicipio\":\"GUSTAVO A MADERO\",\"ciudad\":\"CIUDAD DE MXICO\",\"estado\":\"CDMX\",\"CP\":\"07730\",\"fechaResidencia\":\"2020-06-02\",\"numeroTelefono\":\"55664420\",\"tipoDomicilio\":\"C\",\"tipoAsentamiento\":\"0\",\"fechaRegistroDomicilio\":\"2020-06-02\"}],\"empleos\":[{\"nombreEmpresa\":\"EMPRESA EJEMPLO\",\"direccion\":\"PASADISO ENCONTRADO 58\",\"coloniaPoblacion\":\"MONTEVIDEO\",\"delegacionMunicipio\":\"GUSTAVO A MADERO\",\"ciudad\":\"CIUDAD DE MXICO\",\"estado\":\"CDMX\",\"CP\":\"07730\",\"numeroTelefono\":\"54783257\",\"extension\":\"1110\",\"fax\":\"54146531\",\"puesto\":\"AUXILIAR ADMINISTRATIVO\",\"fechaContratacion\":\"2000-02-02\",\"claveMoneda\":\"UD\",\"salarioMensual\":\"6499\",\"fechaUltimoDiaEmpleo\":\"2020-06-02\",\"fechaVerificacionEmpleo\":\"2000-05-10\"}],\"scores\":[{\"nombreScore\":\"FICO\",\"valor\":720,\"razones\":[\"D2\",\"P9\",\"K0\",\"E0\"]}],\"mensajes\":[{\"tipoMensaje\":\"2\",\"leyenda\":\"No se obtuvo respuesta de otras SIC´s\"}]}";		

		
		
//		String fecha = args[0];//fecha
//		String rutaPdf = args[1]; //rutaPdf
//		String json = args[2]; // json
		
		
		 
		resp = jsonToOb(json);
	
		String json2 = xml(resp);	
		
	
		String cadena = generarReporteServiceXml(normalizarDatos.sNormalizaTextoNFC(json2,7), null, fecha, rutaPdf);
		
		System.out.println(cadena);
	}
	
	private static String xml(com.circulodecredito.generarreporte.json.Respuesta resp) {
		com.circulodecredito.generarreporte.xml.Respuesta respXml = new com.circulodecredito.generarreporte.xml.Respuesta();
		com.circulodecredito.generarreporte.xml.Personas personas = new com.circulodecredito.generarreporte.xml.Personas();
		com.circulodecredito.generarreporte.xml.Persona persona = new com.circulodecredito.generarreporte.xml.Persona();
		com.circulodecredito.generarreporte.xml.Encabezado encabezado = new com.circulodecredito.generarreporte.xml.Encabezado();
		com.circulodecredito.generarreporte.xml.Nombre nombre = new com.circulodecredito.generarreporte.xml.Nombre();
		
		
		String xml = null;
		//ENCABEZADO
		encabezado.setClaveOtorgante(resp.getClaveOtorgante());
		encabezado.setExpedienteEncontrado("");
		encabezado.setFolioConsulta(resp.getFolioConsulta());
		encabezado.setFolioConsultaOtorgante(resp.getFolioConsultaOtorgante());
		
		//NOMBRE
		nombre.setApellidoPaterno(resp.getPersona().getApellidoPaterno());
		nombre.setApellidoMaterno(resp.getPersona().getApellidoMaterno());
		nombre.setApellidoAdicional(resp.getPersona().getApellidoAdicional());
		nombre.setNombres(resp.getPersona().getNombres());
		nombre.setFechaNacimiento(resp.getPersona().getFechaNacimiento());
		nombre.setRfc(resp.getPersona().getRFC());
		nombre.setCurp(resp.getPersona().getCURP());
		nombre.setNacionalidad(resp.getPersona().getNacionalidad());
		nombre.setResidencia(String.valueOf(resp.getPersona().getResidencia()));
		nombre.setEstadoCivil(resp.getPersona().getEstadoCivil());
		nombre.setSexo(resp.getPersona().getSexo());
		nombre.setClaveElectorIFE(resp.getPersona().getClaveElectorIFE());
		nombre.setNumeroDependientes(String.valueOf(resp.getPersona().getNumeroDependientes()));
		nombre.setFechaDefuncion(resp.getPersona().getFechaDefuncion());
		
		//DOMICILIO
		com.circulodecredito.generarreporte.xml.Domicilios domicilios = new com.circulodecredito.generarreporte.xml.Domicilios();
		ArrayList<com.circulodecredito.generarreporte.xml.Domicilio> arrDom = new ArrayList<com.circulodecredito.generarreporte.xml.Domicilio>();
		
		for (DomicilioRespuesta dom: resp.getDomicilios()) {
			com.circulodecredito.generarreporte.xml.Domicilio domicilio = new com.circulodecredito.generarreporte.xml.Domicilio();
			
			domicilio.setDireccion(dom.getDireccion());
			domicilio.setColoniaPoblacion(dom.getColoniaPoblacion());
			domicilio.setDelegacionMunicipio(dom.getDelegacionMunicipio());
			domicilio.setCiudad(dom.getCiudad());
			domicilio.setEstado(dom.getEstado());
			domicilio.setCp(dom.getEstado());
			domicilio.setFechaResidencia(dom.getFechaResidencia());
			domicilio.setNumeroTelefono(dom.getNumeroTelefono());
			domicilio.setTipoDomicilio(dom.getTipoDomicilio());
			domicilio.setTipoAsentamiento(dom.getTipoAsentamiento());
			domicilio.setFechaRegistroDomicilio(dom.getFechaRegistroDomicilio());
			domicilio.setTipoAltaDomicilio(String.valueOf(dom.getTipoAltaDomicilio()));
			domicilio.setNumeroOtorgantesCarga(String.valueOf(dom.getNumeroOtorgantesCarga()));
			domicilio.setNumeroOtorgantesConsulta(String.valueOf(dom.getNumeroOtorgantesConsulta()));
			domicilio.setIdDomicilio(dom.getIdDomicilio());
			arrDom.add(domicilio);
		}
		
		domicilios.setDomicilio(arrDom);
		
		
		//EMPLEOS
		com.circulodecredito.generarreporte.xml.Empleos empleos = new com.circulodecredito.generarreporte.xml.Empleos();
		ArrayList<com.circulodecredito.generarreporte.xml.Empleo> arrEmp =new  ArrayList<com.circulodecredito.generarreporte.xml.Empleo>();
		
		for(com.circulodecredito.generarreporte.json.Empleo emp: resp.getEmpleos()) {
			
			com.circulodecredito.generarreporte.xml.Empleo empleo = new com.circulodecredito.generarreporte.xml.Empleo();
			
			empleo.setNombreEmpresa(emp.getNombreEmpresa());
			empleo.setDireccion(emp.getDireccion());
			empleo.setColoniaPoblacion(emp.getColoniaPoblacion());
			empleo.setDelegacionMunicipio(emp.getDelegacionMunicipio());
			empleo.setCiudad(emp.getCiudad());
			empleo.setEstado(emp.getEstado());
			empleo.setCp(emp.getCP());
			empleo.setNumeroTelefono(emp.getNumeroTelefono());
			empleo.setExtension(emp.getExtension());
			empleo.setFax(emp.getFax());
			empleo.setPuesto(emp.getPuesto());
			empleo.setFechaContratacion(emp.getFechaContratacion());
			empleo.setClaveMoneda(emp.getClaveMoneda());
			empleo.setSalarioMensual(String.valueOf(emp.getSalarioMensual()));
			empleo.setFechaUltimoDiaEmpleo(emp.getFechaUltimoDiaEmpleo());
			empleo.setFechaVerificacionEmpleo(emp.getFechaVerificacionEmpleo());
			arrEmp.add(empleo);
		}
		empleos.setLstEmpleo(arrEmp);
		
		//MENSAJES
		com.circulodecredito.generarreporte.xml.Mensajes mensajes = new com.circulodecredito.generarreporte.xml.Mensajes();
		ArrayList<com.circulodecredito.generarreporte.xml.Mensaje> arrMen = new ArrayList<com.circulodecredito.generarreporte.xml.Mensaje>();
		
		for(com.circulodecredito.generarreporte.json.Mensaje men : resp.getMensajes()) {
			com.circulodecredito.generarreporte.xml.Mensaje mensaje = new com.circulodecredito.generarreporte.xml.Mensaje();
			
			mensaje.setTipoMensaje(String.valueOf(men.getTipoMensaje()));
			//mensaje.setLeyenda(generaMensajeLeyenda(men.getLeyenda()));
			mensaje.setLeyenda(men.getLeyenda());
			
			//mensaje.setTipoMensaje("2");
			//mensaje.setLeyenda("1");
			mensaje.setConsecutivo(null);
			arrMen.add(mensaje);
		}
		mensajes.setMensaje(arrMen);
		
		
		//Cuentas
		com.circulodecredito.generarreporte.xml.Cuentas cuentas = new com.circulodecredito.generarreporte.xml.Cuentas();
		ArrayList<com.circulodecredito.generarreporte.xml.Cuenta> arrCue = new ArrayList<com.circulodecredito.generarreporte.xml.Cuenta>();
		
		for(Credito cred:resp.getCreditos()) {
			com.circulodecredito.generarreporte.xml.Cuenta cuenta = new com.circulodecredito.generarreporte.xml.Cuenta();
			
			com.circulodecredito.generarreporte.xml.Can can = new com.circulodecredito.generarreporte.xml.Can();
			
			//CAN
			if(cred.getCAN() == null) {
				//can = new com.circulodecredito.generarreporte.xml.Can();
				
				//System.out.println("null can");
				//com.circulodecredito.generarreporte.xml.Can can = new com.circulodecredito.generarreporte.xml.Can();
				//cuenta.setCan(can);
				//com.circulodecredito.generarreporte.xml.Can can = new com.circulodecredito.generarreporte.xml.Can();
				
			}
			else {
				//System.out.println("lleno can");
				
				can.setIdentiicadorCan(cred.getCAN().getIdentificadorCAN());
				can.setPrelacionOrigen(String.valueOf(cred.getCAN().getPrelacionOrigen()));
				can.setPrelacionAnual(String.valueOf(cred.getCAN().getPrelacionActual()));
				can.setFechaAperturaCan(cred.getCAN().getFechaAperturaCAN());
				can.setFechaCancelacionCan(cred.getCAN().getFechaCancelacionCAN());
				can.setHistoricoCan(cred.getCAN().getHistoricoCAN());
				can.setFechaMRCAN(cred.getCAN().getFechaMRCAN());
				can.setFechaMACAN(cred.getCAN().getFechaMACAN());
			}
			
			cuenta.setCan(can);
			cuenta.setFechaActualizacion(cred.getFechaActualizacion());
			cuenta.setRegistroImpugnado(String.valueOf(cred.getRegistroImpugnado()));
			cuenta.setClaveOtorgante(cred.getClaveOtorgante());
			cuenta.setNombreOtorgante(cred.getNombreOtorgante());
			cuenta.setCuentaActual(cred.getCuentaActual());
			cuenta.setTipoResponsabilidad(cred.getTipoResponsabilidad());
			cuenta.setTipoCuenta(cred.getTipoCuenta());
			cuenta.setTipoCredito(cred.getTipoCredito());
			cuenta.setClaveUnidadMonetaria(cred.getClaveUnidadMonetaria());
			cuenta.setValorActivoValuacion(String.valueOf(cred.getValorActivoValuacion()));
			cuenta.setNumeroPagos(String.valueOf(cred.getNumeroPagos()));
			cuenta.setFrecuenciaPagos(cred.getFrecuenciaPagos());
			cuenta.setMontoPagar(formatoSinDecimales(String.valueOf(cred.getMontoPagar())));
			cuenta.setFechaAperturaCuenta(cred.getFechaAperturaCuenta());
			cuenta.setFechaUltimoPago(cred.getFechaUltimoPago());
			cuenta.setFechaUltimaCompra(cred.getFechaUltimaCompra());
			cuenta.setFechaCierreCuenta(cred.getFechaCierreCuenta());
			cuenta.setFechaReporte(cred.getFechaReporte());
			cuenta.setUltimaFechaSaldoCero(cred.getUltimaFechaSaldoCero());
			cuenta.setGarantia(cred.getGarantia());
			cuenta.setCreditoMaximo(formatoSinDecimales(String.valueOf(cred.getCreditoMaximo())));
			cuenta.setSaldoActual(formatoSinDecimales(String.valueOf(cred.getSaldoActual())));
			cuenta.setLimiteCredito(formatoSinDecimales(String.valueOf(cred.getLimiteCredito())));
			cuenta.setSaldoVencido(formatoSinDecimales(String.valueOf(cred.getSaldoVencido())));
			cuenta.setNumeroPagosVencidos(String.valueOf(cred.getNumeroPagosVencidos()));
			cuenta.setPagoActual(cred.getPagoActual());
			cuenta.setHistoricoPagos(cred.getHistoricoPagos());
			cuenta.setFechaRecienteHistoricoPagos(cred.getFechaRecienteHistoricoPagos());
			cuenta.setFechaAntiguaHistoricoPagos(cred.getFechaAntiguaHistoricoPagos());
			cuenta.setClavePrevencion(cred.getClavePrevencion());
			cuenta.setTotalPagosReportados(String.valueOf(cred.getTotalPagosReportados()));
			cuenta.setPeorAtraso(String.valueOf(cred.getPeorAtraso()));
			cuenta.setFechaPeorAtraso(cred.getFechaPeorAtraso());
			cuenta.setSaldoVencidoPeorAtraso(formatoSinDecimales(String.valueOf(cred.getSaldoVencidoPeorAtraso())));
			cuenta.setMontoUltimoPago(String.valueOf(cred.getMontoUltimoPago()));
			cuenta.setIdDomicilio(cred.getIdDomicilio());
			cuenta.setServicios(cred.getServicios());
			
			arrCue.add(cuenta);
		}
		
		cuentas.setCuenta(arrCue);
		
		
		//CONSULTAS EFECTUADAS
		
		com.circulodecredito.generarreporte.xml.ConsultasEfectuadas consEfectuadas = new com.circulodecredito.generarreporte.xml.ConsultasEfectuadas();
		ArrayList<com.circulodecredito.generarreporte.xml.ConsultaEfectuada> arrConEfe = new ArrayList<com.circulodecredito.generarreporte.xml.ConsultaEfectuada>();
		
		
		for(Consulta con: resp.getConsultas()) {
			com.circulodecredito.generarreporte.xml.ConsultaEfectuada consEfectuada = new com.circulodecredito.generarreporte.xml.ConsultaEfectuada();
			
			consEfectuada.setFechaConsulta(con.getFechaConsulta());
			consEfectuada.setClaveOtorgante(con.getClaveOtorgante());
			consEfectuada.setNombreOtorgante(con.getNombreOtorgante());
			consEfectuada.setDireccionOtorgante(con.getDireccionOtorgante());
			consEfectuada.setTelefonoOtorgante(con.getTelefonoOtorgante());
			consEfectuada.setTipoCredito(con.getTipoCredito());
			consEfectuada.setImporteCredito(String.valueOf(con.getImporteCredito()));
			consEfectuada.setClaveUnidadMonetaria(con.getClaveUnidadMonetaria());
			consEfectuada.setTipoResponsabilidad(con.getTipoResponsabilidad());
			consEfectuada.setIdDomicilio(con.getIdDomicilio());
			//consEfectuada.setServicios(con.get);
			arrConEfe.add(consEfectuada);
		}
		consEfectuadas.setConsultaEfectuada(arrConEfe);
		
		//SCORES
		com.circulodecredito.generarreporte.xml.Scores scores = new com.circulodecredito.generarreporte.xml.Scores();
		
		for(com.circulodecredito.generarreporte.json.Score sc:resp.getScores()) {
			com.circulodecredito.generarreporte.xml.Score score = new com.circulodecredito.generarreporte.xml.Score();
			
			score.setNombreScore(sc.getNombreScore());
			score.setValor(String.valueOf(sc.getValor()));
			score.setRazon1(sc.getRazones().get(0));
			score.setRazon2(sc.getRazones().get(1));
			score.setRazon3(sc.getRazones().get(2));
			score.setRazon4(sc.getRazones().get(3));
			scores.setScore(score);
		}
		
		persona.setScores(scores);
		persona.setConsultasEfectuadas(consEfectuadas);
		persona.setCuentas(cuentas);
		persona.setMensajes(mensajes);
		persona.setEmpleos(empleos);
		persona.setDomicilios(domicilios);
		persona.setEncabezado(encabezado);
		persona.setNombre(nombre);
		
		personas.setPersona(persona);
		respXml.setPersonas(personas);
		
		try {
	        JAXBContext context = JAXBContext.newInstance(com.circulodecredito.generarreporte.xml.Respuesta.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(respXml, sw);
	        xml = sw.toString();
	       // System.out.println(xml);

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
		
		return xml;
	}
	
	
	private static com.circulodecredito.generarreporte.json.Respuesta jsonToOb(String json) {
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			resp = objectMapper.readValue(json, com.circulodecredito.generarreporte.json.Respuesta.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}	
		
		return resp;
	}
	
	private static String validarFecha (String fecha){
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
	
	public static  String generarReporteServiceXml(String xml, ReporteCreditoResponse respuesta, String fechaReporte,String rutaPdf) {
		
		String cadena = "0";
		GenerarReporteResponse response = new GenerarReporteResponse();
		byte[] pdfBytes = null;
		
		String imagenTacometro;	
		InputStream reportStream = null;
		
		String mensajeFecha = validarFecha(fechaReporte);
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
		           
		            objectRespuesta = generarFormatoXML(xml, objectRespuesta, fechaReporte);
		            
		            
		        //conversion de Objeto RC a Objeto Respuesta para Jasper 
				}else if(respuesta != null){
					objectRespuesta = convertirRCEResponseToRespuesta(respuesta, fechaReporte);
					
				}
	            
				if(objectRespuesta != null) {

					ArrayList<Respuesta> dataList = new ArrayList<Respuesta>();
					dataList.add(objectRespuesta);
					
					JRBeanCollectionDataSource beanColDataSource = new 
					         JRBeanCollectionDataSource(dataList); //este pasa los datos a jasper
					
					imagenTacometro = validador.obtenerImgTacometro(objectRespuesta);
					//System.out.println("ruta:: "+imagenTacometro);
					Map params = new HashMap();
			        params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, DATE_PATTERN);
			        params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, XML_PATTERN);
			        params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.ENGLISH);
			        params.put(JRParameter.REPORT_LOCALE, Locale.US);
			        if(imagenTacometro != null && !imagenTacometro.equals("")) {
			        	params.put("imagenTacometro", imagenTacometro);
			        }
			        reportStream = Main.class.getResourceAsStream("/com/circulodecredito/jrxml/reportes/rcc.jrxml");
			        //reportStream = new FileInputStream("/Users/globatos/Documents/JASPER_API/rcc/rcc.jrxml");
			        params.put("imagenLogo","com/circulodecredito/jrxml/reportes/imagenes/Logo_RC.gif");
			        params.put("imagenCerrada","com/circulodecredito/jrxml/reportes/imagenes/Cerrada.jpg");
			        params.put("imagenNegativo","com/circulodecredito/jrxml/reportes/imagenes/Negativo.jpg");
			        params.put("imagenPositivo","com/circulodecredito/jrxml/reportes/imagenes/Positivo.jpg");
			       
			        //params.put("subrepPath", "resources/reportes/rcc/");
			        params.put("subrepPath", "com/circulodecredito/jrxml/reportes/");
			        JasperReport report = JasperCompileManager.compileReport(reportStream);
			        JasperPrint reportPrint = JasperFillManager.fillReport(report, params, beanColDataSource);
			        pdfBytes = JasperExportManager.exportReportToPdf(reportPrint);
			        
			        JRPdfExporter exporter = new JRPdfExporter();
					exporter.setExporterInput(new SimpleExporterInput(reportPrint));
					exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new java.io.File(rutaPdf)));
					SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
					exporter.setConfiguration(configuration);
			    	exporter.exportReport();
			    	cadena = "1";
				}
				response.setSuccess(true);
			} catch(JRException ex) {
				cadena = "0";
			}catch(Exception ex) {
				cadena = "0";
			} finally {
				try {
					if(reportStream != null) {
						reportStream.close();
					}
				} catch (IOException e) {
					//LOGG.error("IOException",e);
					cadena = "0";
				}
			}
		}else{
			cadena = "0";
		}
		return cadena;
	}
	
	public static Respuesta convertirRCEResponseToRespuesta (ReporteCreditoResponse respuestaRC, String fechaReporte) {
		Respuesta respuesta = llenarObjetoRespuesta(respuestaRC);
		
		if(respuesta != null) {
			String xml = respuestaToXML(respuesta);
			try {
				respuesta = generarFormatoXML(xml, respuesta, fechaReporte);
			} catch (ParseException e) {
				//LOGG.error("Error al generar datos para el PDF");
				e.printStackTrace();
			}
		}
		
		return respuesta;
	}
	
	public static String respuestaToXML(Respuesta respuesta) {
		String xmlContent = null;
		try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Respuesta.class);
             
            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            //Print XML String to Console
            StringWriter sw = new StringWriter();
             
            //Write XML to StringWriter
            jaxbMarshaller.marshal(respuesta, sw);
             
            //Verify XML Content
            xmlContent = sw.toString();
            System.out.println( xmlContent );
 
        } catch (JAXBException e) {
            e.printStackTrace();
        }
		return xmlContent;
	}
	
	public static Respuesta llenarObjetoRespuesta (ReporteCreditoResponse respuestaRC) {
		Respuesta respuesta = new Respuesta();
		Personas personas = new Personas();
		Persona persona = new Persona();
		
		//Encabezado
		Encabezado enc = new Encabezado();
		enc.setExpedienteEncontrado(respuestaRC.getNperscve() != null && respuestaRC.getNperscve() > 0 ? "1" : "0");
		enc.setFolioConsulta(respuestaRC.getFolioConsulta());
		persona.setEncabezado(enc);
		
		//Nombre
		List<DatosGenerales> listDG = respuestaRC.getDatosGenerales();
		for(DatosGenerales dg : listDG ) {
			Nombre nombre = new Nombre();
			nombre.setApellidoAdicional(dg.getApellAdicional());
			nombre.setApellidoMaterno(dg.getApellMaterno());
			nombre.setApellidoPaterno(dg.getApellPaterno());
			nombre.setClaveElectorIFE(null);
			nombre.setCurp(dg.getCurp());
			nombre.setEstadoCivil(dg.getEdoCivil());
			nombre.setFechaDefuncion(validacionesCore.convertirDDMMYYYYToYYYYMMDD(dg.getFechaDefuncion()));
			nombre.setFechaNacimiento(validacionesCore.convertirDDMMYYYYToYYYYMMDD(dg.getFechaNac()));
			nombre.setFechaDefuncion(dg.getFechaDefuncion());
			nombre.setFechaNacimiento(dg.getFechaNac());
			nombre.setNacionalidad(dg.getPais());
			nombre.setNombres(dg.getNombre());
			nombre.setNumeroDependientes(dg.getNumDependientes() != null ? String.valueOf(dg.getNumDependientes()) : null);
			nombre.setResidencia(dg.getTipoResidencia() != null ? String.valueOf(dg.getTipoResidencia()) : null);
			nombre.setRfc(dg.getRfc());
			nombre.setSexo(dg.getSexo());
			persona.setNombre(nombre);
		}
		
		//Domicilios
		List<com.cdc.validacionescore.beans.Domicilio> listDom = respuestaRC.getDomicilios();
		if(listDom != null && !listDom.isEmpty()) {
			Domicilios domicilios = new Domicilios();
			List<Domicilio> listDomicilios = new ArrayList<Domicilio>();
 			for(com.cdc.validacionescore.beans.Domicilio dom : listDom) {
				Domicilio d = new Domicilio();
				d.setCiudad(dom.getCiudad());
				d.setColoniaPoblacion(dom.getColonia());
				d.setCp(dom.getCp());
				d.setDelegacionMunicipio(dom.getMunicipio());
				d.setDireccion(dom.getCalle());
				d.setEstado(dom.getEstado());
				d.setFechaRegistroDomicilio(validacionesCore.convertirDDMMYYYYToYYYYMMDD(dom.getFechaRegistroDomicilio()));
				d.setFechaResidencia(validacionesCore.convertirDDMMYYYYToYYYYMMDD(dom.getFechaResidencia()));
				d.setFechaRegistroDomicilio(dom.getFechaRegistroDomicilio());
				d.setFechaResidencia(dom.getFechaResidencia());
				d.setIdDomicilio(dom.getIdDomicilio());
				d.setNumeroOtorgantesCarga(null);
				d.setNumeroOtorgantesConsulta(null);
				d.setNumeroTelefono(dom.getNumeroTelefono());
				d.setTipoAltaDomicilio(dom.getTipoAltaDomicilio());
				d.setTipoAsentamiento(dom.getTipoAsentamiento());
				d.setTipoDomicilio(dom.getTipoDomicilio());
				listDomicilios.add(d);
			}
 			domicilios.setDomicilio(listDomicilios);
 			persona.setDomicilios(domicilios);
		}
		
		//Empleos
		List<com.cdc.validacionescore.beans.Empleo> listEmpl = respuestaRC.getEmpleos();
		if(listEmpl != null && !listEmpl.isEmpty()) {
			Empleos empleos = new Empleos();
			List<Empleo> listEmpleos = new ArrayList<Empleo>();
			for(com.cdc.validacionescore.beans.Empleo emp : listEmpl) {
				Empleo e = new Empleo();
				e.setCiudad(emp.getCiudad());
				e.setClaveMoneda(emp.getClaveMoneda());
				e.setColoniaPoblacion(emp.getColonia());
				e.setCp(emp.getCp());
				e.setDelegacionMunicipio(emp.getDelegacionMunicipio());
				e.setDireccion(emp.getDireccion());
				e.setEstado(emp.getEstado());
				e.setExtension(emp.getExtension());
				e.setFax(emp.getFax());
				e.setFechaContratacion(validacionesCore.convertirDDMMYYYYToYYYYMMDD(emp.getFechaContratacion()));
				e.setFechaUltimoDiaEmpleo(validacionesCore.convertirDDMMYYYYToYYYYMMDD(emp.getFechaUltimoDiaEmpleo()));
				e.setFechaVerificacionEmpleo(validacionesCore.convertirDDMMYYYYToYYYYMMDD(emp.getFechaVerificacionEmpleo()));
				e.setNombreEmpresa(emp.getNombreEmpresa());
				e.setNumeroTelefono(emp.getNumeroTelefono());
				e.setPuesto(emp.getPuesto());
				e.setSalarioMensual(emp.getSalarioMensual() != null ? String.valueOf(emp.getSalarioMensual()) : null);
				listEmpleos.add(e);
			}
			empleos.setLstEmpleo(listEmpleos);
			persona.setEmpleos(empleos);
		}
		
		//Mensajes
		List<com.cdc.validacionescore.beans.Mensaje> lstMen = respuestaRC.getMensajes();
		if(lstMen != null && !lstMen.isEmpty()) {
			Mensajes mensajes = new Mensajes();
			List<Mensaje> lstMensajes = new ArrayList<Mensaje>();
			for(com.cdc.validacionescore.beans.Mensaje men : lstMen) {
				Mensaje m = new Mensaje();
				m.setLeyenda(men.getLeyenda());
				m.setTipoMensaje(men.getTipoMensaje());
				lstMensajes.add(m);
			}
			mensajes.setMensaje(lstMensajes);
			persona.setMensajes(mensajes);
		}
		
		//Cuentas
		List<com.cdc.validacionescore.beans.Cuentas> lstCue = respuestaRC.getCuentas();
		if(lstCue != null && !lstCue.isEmpty()) {
			Cuentas cuentas = new Cuentas();
			List<Cuenta> lstCuentas = new ArrayList<Cuenta>();
			for(com.cdc.validacionescore.beans.Cuentas cue : lstCue) {
				Cuenta c = new Cuenta();
				
				//TO_DO agregar lo de CAN en la versión 2 de RC
				
				//c.setClaveOtorgante);
				c.setClavePrevencion(cue.getCveTipoObs());
				c.setClaveUnidadMonetaria(cue.getCveUnidadMonet());
				c.setCreditoMaximo(cue.getMontoMax() != null ? String.valueOf(cue.getMontoMax()) : null);
				c.setCuentaActual(cue.getNumCta());
				c.setFechaActualizacion(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaAct()));
				c.setFechaAntiguaHistoricoPagos(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaAntiguaHistoricoPagos()));
				c.setFechaAperturaCuenta(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaApertCta()));
				c.setFechaCierreCuenta(
						"01-01-0001".equals(cue.getFechaCierreCta()) ? "" : 
						validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaCierreCta()));
				c.setFechaPeorAtraso(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaPeorAtraso()));
				c.setFechaRecienteHistoricoPagos(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaRecienteHistoricoPagos()));
				c.setFechaReporte(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaReporte()));
				c.setFechaUltimaCompra(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaUltCompra()));
				c.setFechaUltimoPago(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaUltPago()));
				
				c.setFrecuenciaPagos(cue.getCveFrecPago());
				c.setGarantia(cue.getGarantia());
				c.setHistoricoPagos(cue.getsHPXml());
				//c.setIdDomicilio();
				c.setLimiteCredito(cue.getLimiteCred() != null ? String.valueOf(cue.getLimiteCred()) : null);
				c.setMontoPagar(cue.getMontoPagar() != null ? String.valueOf(cue.getMontoPagar()) : null);
				c.setMontoUltimoPago(cue.getCanMontoUltimoPago() != null ? String.valueOf(cue.getCanMontoUltimoPago()) : null);
				
				String nombreOtor = cue.getNombCortoOtor() != null ? cue.getNombCortoOtor().replaceAll("&amp;", "&") : null;
				c.setNombreOtorgante(nombreOtor);
				c.setNumeroPagos(cue.getNumPagos() != null ? String.valueOf(cue.getNumPagos()) : null);
				c.setNumeroPagosVencidos(cue.getNumPagosVenc() != null ? String.valueOf(cue.getNumPagosVenc()) : null);
				c.setPagoActual(cue.getSaldoAct() != null ? String.valueOf(cue.getSaldoAct()) : null);
				c.setPeorAtraso(cue.getPeorAtraso() != null ? String.valueOf(cue.getPeorAtraso()) : null);
				//c.setRegistroImpugnado(cue.getIm);
				c.setSaldoActual(cue.getSaldoAct() != null ? String.valueOf(cue.getSaldoAct()) : null);
				c.setSaldoVencido(cue.getSaldoVenc() != null ? String.valueOf(cue.getSaldoVenc()) : null);
				c.setSaldoVencidoPeorAtraso(cue.getSaldoVencPeorAtraso() != null ? String.valueOf(cue.getSaldoVencPeorAtraso()) : null);
				//c.setServicios();
				c.setTipoCredito(cue.getCveTipoContra());
				c.setTipoCuenta(cue.getTipoCtaCve());
				c.setTipoResponsabilidad(cue.getCveTipoResp());
				c.setTotalPagosReportados(cue.getTotalPagosReportados() != null ? String.valueOf(cue.getTotalPagosReportados()) : null);
				c.setUltimaFechaSaldoCero(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cue.getFechaUltCeros()));
				c.setValorActivoValuacion(cue.getValActCred() != null ? String.valueOf(cue.getValActCred()) : null);
				
				lstCuentas.add(c);
			}
			cuentas.setCuenta(lstCuentas);
			persona.setCuentas(cuentas);
		}
		
		//consultas
		List<com.cdc.validacionescore.beans.Consultas> lstCons = respuestaRC.getConsultas();
		if(lstCons != null && !lstCons.isEmpty()) {
			ConsultasEfectuadas consultasEfectuadas = new ConsultasEfectuadas();
			List<ConsultaEfectuada> lstConsultas = new ArrayList<ConsultaEfectuada>();
			for(com.cdc.validacionescore.beans.Consultas cons : lstCons) {
				ConsultaEfectuada c = new ConsultaEfectuada();
				c.setClaveOtorgante(cons.getCveOtorgante());
				c.setClaveUnidadMonetaria(cons.getCveUnidadMonet());
				c.setDireccionOtorgante(cons.getCalleOtor());
				c.setFechaConsulta(validacionesCore.convertirDDMMYYYYToYYYYMMDD(cons.getFechaEjec()));
				//c.setIdDomicilio(cons.ge);
				c.setImporteCredito(cons.getImporte() != null ? String.valueOf(cons.getImporte()) : null);
				String nombreOtor = cons.getNombOtorgante() != null ? cons.getNombOtorgante().replaceAll("&amp;", "&") : null;
				c.setNombreOtorgante(nombreOtor);
				c.setTelefonoOtorgante(cons.getTelefonoOtor());
				c.setTipoCredito(cons.getTipoCtaCve());
				c.setTipoResponsabilidad(cons.getTipoResponsibilidad());
				lstConsultas.add(c);
			}
			consultasEfectuadas.setConsultaEfectuada(lstConsultas);
			persona.setConsultasEfectuadas(consultasEfectuadas);
		}
		
		//Scores
		com.cdc.validacionescore.beans.Score sco = respuestaRC.getScore();
		if(sco != null) {
			Scores scores = new Scores();
			Score score = new Score();
			
			score.setCodigo(sco.getCodigo());
			score.setError(sco.getErrorCode());
			score.setValor(sco.getScore() != null ? String.valueOf(sco.getScore()) : null);
			score.setRazon1(sco.getReasonCode1());
			score.setRazon2(sco.getReasonCode2());
			score.setRazon3(sco.getReasonCode3());
			score.setRazon4(sco.getReasonCode4());
			
			scores.setScore(score);
			persona.setScores(scores);
		}
		
		//Declarativas
		List<com.cdc.validacionescore.beans.Declarativa> lstDec = respuestaRC.getDeclarativas();
		if(lstDec != null && !lstDec.isEmpty()) {
			String declarativa = "";
			for(com.cdc.validacionescore.beans.Declarativa d : lstDec) {
				if(d.getDeclarativa() != null && !"".equals(d.getDeclarativa())) {
					declarativa += d.getDeclarativa() + " \n";
				}
			}
			persona.setDeclaracionesConsumidor(declarativa);
		}
		
		personas.setPersona(persona);
		respuesta.setPersonas(personas);
		return respuesta;
	}
	
	public static Respuesta generarFormatoXML(String xml, Respuesta respuesta, String fechaReporte) throws ParseException {
		
		
		CatalogosDTO catalogos = cat.llenaCatalogos();
		
		String folioConsulta = respuesta.getPersonas().getPersona().getEncabezado().getFolioConsulta();
		
		if (respuesta != null && respuesta.getPersonas().getPersona().getCuentas() != null
				&& respuesta.getPersonas().getPersona().getCuentas().getCuenta() != null
				&& !respuesta.getPersonas().getPersona().getCuentas().getCuenta().isEmpty()
				&& respuesta.getPersonas().getPersona().getCuentas().getCuenta().get(0).getHistoricoPagos() != null) {
			respuesta = genInd(xml, respuesta, catalogos);
		}
		
		respuesta = generaMensaje(respuesta, ConstantesIDs.TIPO_MENSAJE_CONSOLIDADO); // consolidado
		respuesta = generaMensaje(respuesta, ConstantesIDs.TIPO_MENSAJE_PLD); // pld
		respuesta = ultimosDoceHistorico(respuesta);
		respuesta = obtProdCred(respuesta, catalogos.getCatalogoResponsabilidad(), "responsabilidad", catalogos);
		respuesta = obtProdCred(respuesta, catalogos.getCatalogoCuenta(), "cuenta", catalogos);
		respuesta = obtProdCred(respuesta, catalogos.getCatalogoProducto(), "contrato", catalogos);
		respuesta = obtProdCred(respuesta, catalogos.getCatalogoCuenta(), "contrato", catalogos);
		respuesta = obtProd(respuesta, catalogos.getCatalogoProducto());
		respuesta = chgFormDate(respuesta);
		respuesta = obtenerRazonScore(respuesta, catalogos);
		respuesta = obtenerFechaConsulta(respuesta, fechaReporte);
		respuesta = obtenerFolioConsultaBC(respuesta, folioConsulta);
		respuesta = obtenerCan(respuesta); // CuentasCan
		respuesta = changeCaracterAmpersan(respuesta);
		
		return respuesta;
	}

	public static Respuesta changeCaracterAmpersan(Respuesta respuesta) {
		if(respuesta.getPersonas().getPersona().getConsultasEfectuadas() != null &&
				respuesta.getPersonas().getPersona().getConsultasEfectuadas().getConsultaEfectuada() != null) {
			for(ConsultaEfectuada cons : respuesta.getPersonas().getPersona().getConsultasEfectuadas().getConsultaEfectuada()) {
				if(cons.getNombreOtorgante() != null) {
					cons.setNombreOtorgante(cons.getNombreOtorgante().replaceAll("&amp;", "&"));
				}
			}
		}
		return respuesta;
	}
	
public static Respuesta genInd(String xml, Respuesta respuesta, CatalogosDTO catalogos) throws ParseException {
		
		TypeOfCoinExchangeRC ltypeOfCoinExchange = null;
		ltypeOfCoinExchange = new TypeOfCoinExchangeRC(catalogos.getCatalogoCambio());

		StringReader strrdr = new StringReader(xml);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		ReadingJDOMRC myreadingFile = new ReadingJDOMRC(strrdr);
		Vector vctr = new Vector();
		Vector counts = new Vector();

		String producto = null;
		CountsBeanRC countsb = new CountsBeanRC();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String hoy = sdf.format(new java.util.Date());
		Element myroot = myreadingFile.ReadFileRoot();
		counts = myreadingFile.getCountsBean(myroot);
		vctr = counts;
		HashMap<String, Long> mapeoLimites = new HashMap<String, Long>();
		HashMap<String, Long> mapeoAprobado = new HashMap<String, Long>();
		HashMap<String, Long> mapeoActual = new HashMap<String, Long>();
		HashMap<String, Long> mapeoVencido = new HashMap<String, Long>();
		ArrayList<String> listaProductos = new ArrayList<String>();
		Long limites = 0l;
		Long aprobado = 0l;
		Long actual = 0l;
		Long vencido = 0l;
		Long ctaVigentesCorriente = 0l;
		Long ctaVigentesAtraso = 0l;
		Long ctasAbierAnio = 0l;
		Long sumCredMax = 0l;
		Long fechaApAnt = 0l;
		Long montoMayor = 0l;
		Boolean alMenosUnCreditoActivo = false;
		for (int i = 0; i < vctr.size(); i++) {
			
			
			countsb = (CountsBeanRC) vctr.elementAt(i);
			
			if(!alMenosUnCreditoActivo && (countsb.getCierre() == null || "01-01-0001".equals(countsb.getCierre()) || "".equals(countsb.getCierre()))) {
				//System.out.println("entro al menos uno activo");
				alMenosUnCreditoActivo = true;
			}
			
			String vencidoF = "";
			if (countsb.getVencido().contains(",")) {
				vencidoF = countsb.getVencido().replaceAll(",", "");
			} else {
				vencidoF = countsb.getVencido();
			}

			if (vencidoF.equals("0") && countsb.getCierre().length() == 0) {
				producto = countsb.getClavetipocredito() + "**1";
				ctaVigentesCorriente++;
			} else if (vencidoF.length() > 0 && !vencidoF.equals("0")) {
				producto = countsb.getClavetipocredito() + "**2";
				ctaVigentesAtraso++;
			}

			if (countsb.getCierre().length() > 0) {
				producto = countsb.getClavetipocredito() + "**3";
			}
			limites = (Long) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getLimite());
			aprobado = (Long) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getCreditomaximo());
			actual = (Long) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getActual());
			vencido = (Long) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getVencido());

			if (listaProductos.contains(producto)) {
				mapeoLimites.put(producto, mapeoLimites.get(producto) + limites);
				mapeoAprobado.put(producto, mapeoAprobado.get(producto) + aprobado);
				mapeoActual.put(producto, mapeoActual.get(producto) + actual);
				mapeoVencido.put(producto, mapeoVencido.get(producto) + vencido);

			} else {
				listaProductos.add(producto);
				mapeoLimites.put(producto, limites);
				mapeoAprobado.put(producto, aprobado);
				mapeoActual.put(producto, actual);
				mapeoVencido.put(producto, vencido);
			}

			// Para fecha mas antigua
			if (fechaApAnt == 0 || Integer.parseInt(countsb.getFechaAperturaCalculo()) < fechaApAnt) {
				fechaApAnt = Long.valueOf(countsb.getFechaAperturaCalculo());
			}
			// Para monto mayor
			if (aprobado > montoMayor && !countsb.getClavetipocuenta().equals("R")) {
				montoMayor = aprobado;
				/*System.out.println("aprobado: "+aprobado);
				System.out.println("montoMayor: "+montoMayor);*/
			} else if (limites > montoMayor && countsb.getClavetipocuenta().equals("R")) {
				montoMayor = limites;
				/*System.out.println("limites: "+limites);
				System.out.println("montoMayor: "+montoMayor);*/
			}
			// para sumatoria de montomayor
			if (!countsb.getClavetipocuenta().equals("R")) {
				sumCredMax += aprobado;
				/*System.out.println("sumCredMax: "+sumCredMax);
				System.out.println("aprobado: "+aprobado);
				System.out.println("sumCredMax += aprobado : "+sumCredMax);*/
			} else {
				
				sumCredMax += limites;
				/*System.out.println("sumCredMax"+sumCredMax);
				System.out.println("limites: "+limites);
				System.out.println("sumCredMax += limites : "+sumCredMax);*/
			}
			// cuentas abiertas en presenta ano
			if (countsb.getFechaAperturaCalculo().length() > 0
					&& countsb.getFechaAperturaCalculo().substring(0, 4).equals(hoy.substring(0, 4))) {
				ctasAbierAnio++;
			}
		}

		summarizedVariablesBeanRC lsummarizedVariablesBean = new summarizedVariablesBeanRC();
		if (!listaProductos.isEmpty()) {
			Collections.sort(listaProductos);
			Long sumSalAct = 0l;

			for (int i = 0; i < listaProductos.size(); i++) {
				producto = listaProductos.get(i);
				summarizedProductBeanRC lsummarizedProductBean = new summarizedProductBeanRC();
				lsummarizedProductBean.setLimiteCred(mapeoLimites.get(producto));
				lsummarizedProductBean.setCredAprobado(mapeoAprobado.get(producto));
				lsummarizedProductBean.setSdoActual(mapeoActual.get(producto));
				lsummarizedProductBean.setSdoVencido(mapeoVencido.get(producto));
				sumSalAct += mapeoActual.get(producto);
			}
			lsummarizedVariablesBean.setTotalCreditosAbiertos(ctasAbierAnio);
			lsummarizedVariablesBean
					.setFechaAperCredAntiguo(java.sql.Date.valueOf(sdf2.format(sdf.parse(String.valueOf(fechaApAnt)))));
			lsummarizedVariablesBean.setMontoMayorAprobado(montoMayor);
			lsummarizedVariablesBean.setTotalCtasVigentesCorriente(ctaVigentesCorriente);
			lsummarizedVariablesBean.setTotalCtasVigentesAtraso(ctaVigentesAtraso);
			//System.out.println("sumCredMax : "+sumCredMax);
			lsummarizedVariablesBean.setSumatoriaCreditosMaximos(sumCredMax);
			lsummarizedVariablesBean.setSumatoriaSaldosActuales(sumSalAct);
			lsummarizedVariablesBean.setExistenCuentas(Long.valueOf(vctr.size()));
		}

		Long intTotalCreditosAbiertos = lsummarizedVariablesBean.getTotalCreditosAbiertosAnio();
		String dateFechaAperCredAntiguoStr = lsummarizedVariablesBean.getStrFechaAperCredAntiguo();
		Long intMontoMayorAprobado = lsummarizedVariablesBean.getMontoMayorAprobado();
		Long intTotalCtasVigentesCorriente = lsummarizedVariablesBean.getTotalCtasVigentesCorriente();
		Long intTotalCtasVigentesAtrasos = lsummarizedVariablesBean.getTotalCtasVigentesAtraso();
		Long intSumatoriaCreditosMaximos = lsummarizedVariablesBean.getSumatoriaCreditosMaximos();
		Long intSumatoriaSaldosActuales = lsummarizedVariablesBean.getSumatoriaSaldosActuales();


		Long intCreditosMaximosMenosSaldoActual = 0L;
		Long totalB = 0L;
		
		BigDecimal porcentajeAA = BigDecimal.ZERO.setScale(2, RoundingMode.FLOOR);
		BigDecimal porcentajeAB = BigDecimal.ZERO.setScale(2, RoundingMode.FLOOR);
		BigDecimal porcentajeBA = BigDecimal.ZERO.setScale(2, RoundingMode.FLOOR);
		BigDecimal porcentajeBB = BigDecimal.ZERO.setScale(2, RoundingMode.FLOOR);
		
		/*System.out.println("intSumatoriaCreditosMaximos ::: "+intSumatoriaCreditosMaximos);
		System.out.println("intSumatoriaSaldosActuales ::: "+intSumatoriaSaldosActuales);
		System.out.println("intSumatoriaCreditosMaximos < intSumatoriaSaldosActuales"+(intSumatoriaCreditosMaximos < intSumatoriaSaldosActuales));*/
		// calcular grafica analisis deuda
		if(intSumatoriaCreditosMaximos < intSumatoriaSaldosActuales){
			//System.out.println("Entro ::: 1");
			intCreditosMaximosMenosSaldoActual = intSumatoriaSaldosActuales;
			porcentajeBB = BigDecimal.valueOf(100.00);
		}else {
			/*System.out.println("Entro ::: 2");
			System.out.println("intSumatoriaCreditosMaximos ::: "+intSumatoriaCreditosMaximos);
			System.out.println("intSumatoriaSaldosActuales ::: "+intSumatoriaSaldosActuales);
			System.out.println("intCreditosMaximosMenosSaldoActual = intSumatoriaCreditosMaximos - intSumatoriaSaldosActuales ::: "+intCreditosMaximosMenosSaldoActual);Ç*/
			intCreditosMaximosMenosSaldoActual = intSumatoriaCreditosMaximos - intSumatoriaSaldosActuales;
			//System.out.println("totalB = intCreditosMaximosMenosSaldoActual + intSumatoriaSaldosActuales ::: "+(intCreditosMaximosMenosSaldoActual + intSumatoriaSaldosActuales));
			totalB = intCreditosMaximosMenosSaldoActual + intSumatoriaSaldosActuales;
			if (totalB > 0) {
				//System.out.println("Entro ::: 3");
				porcentajeBB = BigDecimal.valueOf((intSumatoriaSaldosActuales) * 100 / totalB).setScale(2,
						RoundingMode.FLOOR);
				//System.out.println("porcentajeBB ::: "+porcentajeBB);
			}
			if (porcentajeBB.intValue() > 100) {
				//System.out.println("Entro ::: 4");
				porcentajeBB = BigDecimal.valueOf(100.00).setScale(2, RoundingMode.FLOOR);
				//System.out.println("porcentajeBB ::: "+porcentajeBB);
			} else if (porcentajeBB.intValue() < 0) {
				//System.out.println("Entro ::: 5");
				porcentajeBB = BigDecimal.ZERO.setScale(2, RoundingMode.FLOOR);
				//System.out.println("porcentajeBB ::: "+porcentajeBB);
			}
			
		}
		
		porcentajeBA = BigDecimal.valueOf(100L).subtract(porcentajeBB).setScale(2, RoundingMode.FLOOR);
		//System.out.println("porcentajeBA ::: "+porcentajeBA);
		
		// calcular grafica creditos activos
		Long totalA = intTotalCtasVigentesCorriente + intTotalCtasVigentesAtrasos;
		if (totalA > 0) {
			porcentajeAA = BigDecimal.valueOf((intTotalCtasVigentesCorriente) * 100 / totalA).setScale(2,
					RoundingMode.FLOOR);

		}
		
		if (porcentajeAA.intValue() > 100) {
			porcentajeAA = BigDecimal.valueOf(100.00).setScale(2, RoundingMode.FLOOR);
		} else if (porcentajeAA.intValue() < 0) {
			porcentajeAA = BigDecimal.ZERO.setScale(2, RoundingMode.FLOOR);
		}
		porcentajeAB = BigDecimal.valueOf(100L).subtract(porcentajeAA).setScale(2, RoundingMode.FLOOR);
		
//		System.out.println("**********************************************");
//		System.out.println("Valores final de porcentaje AA " + porcentajeAA);
//		System.out.println("Valores final de porcentaje AB " + porcentajeAB);
//		System.out.println("**********************************************");
//		System.out.println("Valores final de porcentaje BB " + porcentajeBB);
//		System.out.println("Valores final de porcentaje BA " + porcentajeBA);

		Graficas graficas = new Graficas();
		Grafica grafica1 = new Grafica();
		grafica1.setTipoA("Vigente");
		grafica1.setValorA(String.valueOf(intTotalCtasVigentesCorriente));
		grafica1.setTipoB("Aprobado");
		grafica1.setValorB(String.valueOf(intCreditosMaximosMenosSaldoActual));
		
		if(alMenosUnCreditoActivo) {
			grafica1.setPorcentajeAA(String.valueOf(porcentajeAA));
			grafica1.setPorcentajeAB(String.valueOf(porcentajeAB));
		}else {
			grafica1.setPorcentajeAA("0");
			grafica1.setPorcentajeAB("0");
		}
		grafica1.setPorcentajeBA(String.valueOf(porcentajeBA));
		grafica1.setPorcentajeBB(String.valueOf(porcentajeBB));
		grafica1.setMontoMayorAprobado(String.valueOf(intMontoMayorAprobado));
		grafica1.setFechasMasAntiguo(dateFechaAperCredAntiguoStr);
		grafica1.setAbiertosPresente(String.valueOf(intTotalCreditosAbiertos));

		/*
		 * if(xml.contains(personaClosTag)) { xmlAux =
		 * xml.substring(0,xml.indexOf(personaClosTag)); xmlAux +=
		 * "<Graficas><Grafica><TipoA>Vigente</TipoA><ValorA>" +
		 * intTotalCtasVigentesCorriente +"</ValorA><TipoB>Aprobado</TipoB><ValorB>";
		 * xmlAux += intCreditosMaximosMenosSaldoActual + "</ValorB><PorcentajeAA>" +
		 * porcentajeAA + "</PorcentajeAA><PorcentajeAB>" + porcentajeAB; xmlAux +=
		 * "</PorcentajeAB><PorcentajeBA>" + porcentajeBA +
		 * "</PorcentajeBA><PorcentajeBB>" + porcentajeBB + "</PorcentajeBB>"; xmlAux +=
		 * "<MontoMayorAprobado>" + intMontoMayorAprobado +
		 * "</MontoMayorAprobado><FechasMasAntiguo>"+ dateFechaAperCredAntiguoStr;
		 * xmlAux += "</FechasMasAntiguo><AbiertosPresente>"+ intTotalCreditosAbiertos +
		 * "</AbiertosPresente></Grafica>";
		 * 
		 * xmlAux += "<Grafica><TipoA>Atraso</TipoA><ValorA>" +
		 * intTotalCtasVigentesAtrasos +"</ValorA><TipoB>Actual</TipoB><ValorB>"; xmlAux
		 * += intSumatoriaSaldosActuales + "</ValorB><PorcentajeAA>" + porcentajeAA +
		 * "</PorcentajeAA><PorcentajeAB>" + porcentajeAB; xmlAux +=
		 * "</PorcentajeAB><PorcentajeBA>" + porcentajeBA +
		 * "</PorcentajeBA><PorcentajeBB>" + porcentajeBB + "</PorcentajeBB>"; xmlAux +=
		 * "<MontoMayorAprobado>" + intMontoMayorAprobado +
		 * "</MontoMayorAprobado><FechasMasAntiguo>"+ dateFechaAperCredAntiguoStr;
		 * xmlAux += "</FechasMasAntiguo><AbiertosPresente>"+ intTotalCreditosAbiertos +
		 * "</AbiertosPresente></Grafica>"; xmlAux += "</Graficas>"; xmlAux +=
		 * xml.substring(xml.indexOf(personaClosTag)); }
		 */

		/*
		 * Grafica grafica2 = new Grafica(); grafica2.setTipoA("Atraso");
		 * grafica2.setValorA(String.valueOf(intTotalCtasVigentesAtrasos));
		 * grafica2.setTipoB("Actual");
		 * grafica2.setValorB(String.valueOf(intSumatoriaSaldosActuales));
		 * grafica2.setPorcentajeAA(String.valueOf(porcentajeAA));
		 * grafica2.setPorcentajeAB(String.valueOf(porcentajeAB));
		 * grafica2.setPorcentajeBA(String.valueOf(porcentajeBA));
		 * grafica2.setPorcentajeBB(String.valueOf(porcentajeBB));
		 * grafica2.setMontoMayorAprobado(String.valueOf(intMontoMayorAprobado));
		 * grafica2.setFechasMasAntiguo(dateFechaAperCredAntiguoStr);
		 * grafica2.setAbiertosPresente(String.valueOf(intTotalCreditosAbiertos));
		 */

		List<Grafica> lst = new ArrayList<Grafica>();
		lst.add(grafica1);
		graficas.setGrafica(lst);
		// descomentar para las graficas
		respuesta.getPersonas().getPersona().setGraficas(graficas);

		respuesta = obtResProd(respuesta, vctr, ltypeOfCoinExchange);
		
		return respuesta;
	}

public static Respuesta generaMensaje(Respuesta respuesta, int opc) {
	List<Mensaje> lstMensajes = (respuesta.getPersonas().getPersona().getMensajes() != null
			&& respuesta.getPersonas().getPersona().getMensajes().getMensaje() != null
			&& !respuesta.getPersonas().getPersona().getMensajes().getMensaje().isEmpty())
					? respuesta.getPersonas().getPersona().getMensajes().getMensaje()
					: null;

	// Consolidado
	if (lstMensajes != null) {
		if (opc == ConstantesIDs.TIPO_MENSAJE_CONSOLIDADO) {
			for (Mensaje mensaje : lstMensajes) {
				
				if (mensaje.getTipoMensaje() != null && mensaje.getTipoMensaje().equals("2")) { // es consolidado
					respuesta.getPersonas().getPersona().setConsolidado(true);
					/*
					if (mensaje.getLeyenda() != null && !"".equals(mensaje.getLeyenda()) && !" ".equals(mensaje.getLeyenda())) {
						int valorSwitch = Integer.valueOf(mensaje.getLeyenda()).intValue();
						switch (valorSwitch) {
						case 1:
							mensaje.setLeyenda(ConstantesMensaje.MENSAJE_BC_1);
							break;
						case 2:
							mensaje.setLeyenda(ConstantesMensaje.MENSAJE_BC_2);
							break;
						case 3:
							mensaje.setLeyenda(ConstantesMensaje.MENSAJE_BC_3);
							break;
						case 4:
							mensaje.setLeyenda(ConstantesMensaje.MENSAJE_BC_4);
							break;
						case 5:
							mensaje.setLeyenda(ConstantesMensaje.MENSAJE_BC_5);
							break;
						case 6:
							mensaje.setLeyenda(ConstantesMensaje.MENSAJE_BC_6);
							break;
						default:
							mensaje.setLeyenda(ConstantesMensaje.MENSAJE_BC_1);
						}
					}
					*/
					respuesta.getPersonas().getPersona().setMostrarMensajes(true);
				}
				
			}
		} else if (opc == ConstantesIDs.TIPO_MENSAJE_PLD) {
			int cont = 1;
			for (Mensaje mensaje : lstMensajes) {
				if (mensaje.getTipoMensaje() != null && mensaje.getTipoMensaje().equals("3")) { // es pld
					
					if(mensaje.getLeyenda().contains("ABCDEF00000")) {
						mensaje.setLeyenda(ConstantesMensaje.MENSAJE_SIN_CONINCIDENCIAS);
					}
					respuesta.getPersonas().getPersona().setMostrarMensajesPld(true);
					mensaje.setConsecutivo(((cont > 9) ? (cont + "") : ("0" + cont)));
					++cont;
				}
			}
		}
	}
	return respuesta;
}

public static Respuesta ultimosDoceHistorico(Respuesta respuesta) {
	List<Cuenta> lstCuentas = (respuesta.getPersonas().getPersona().getCuentas() != null
			&& respuesta.getPersonas().getPersona().getCuentas().getCuenta() != null
			&& !respuesta.getPersonas().getPersona().getCuentas().getCuenta().isEmpty())
					? respuesta.getPersonas().getPersona().getCuentas().getCuenta()
					: null;

	if (lstCuentas != null) {
		for (Cuenta cuenta : lstCuentas) {
			if (cuenta.getHistoricoPagos() != null && !"".equals(cuenta.getHistoricoPagos())) {
				cuenta.setHistoricoPagos(convertirHistorico(cuenta.getHistoricoPagos()));
			}
		}
	}
	return respuesta;
}


public static Respuesta obtProdCred(Respuesta respuesta, Map<String, String> catalogo, String nombreCatalogo, CatalogosDTO catalogos) {
	List<Cuenta> lstCuentas = (respuesta.getPersonas().getPersona().getCuentas() != null
			&& respuesta.getPersonas().getPersona().getCuentas().getCuenta() != null
			&& !respuesta.getPersonas().getPersona().getCuentas().getCuenta().isEmpty())
					? respuesta.getPersonas().getPersona().getCuentas().getCuenta()
					: null;
	if (lstCuentas != null) {
		for (Cuenta cuenta : lstCuentas) {
			if ("responsabilidad".equals(nombreCatalogo)) {
				if (cuenta.getTipoResponsabilidad() != null && !"".equals(cuenta.getTipoResponsabilidad())) {
					for (Map.Entry<String, String> entry : catalogo.entrySet()) {
						if (cuenta.getTipoResponsabilidad().equals(entry.getKey())) {
							cuenta.setTipoResponsabilidad(entry.getValue());
							break;
						}
					}
				}
			} else if ("cuenta".equals(nombreCatalogo)) {
				
				if(cuenta.getCuentaActual() != null && !"".equals(cuenta.getCuentaActual())) {
					cuenta.setTipoCuenta(cuenta.getCuentaActual());
				}else if (cuenta.getTipoCuenta() != null && !"".equals(cuenta.getTipoCuenta())) {
					for (Map.Entry<String, String> entry : catalogo.entrySet()) {
						if (cuenta.getTipoCuenta().equals(entry.getKey())) {
							cuenta.setTipoCuenta(entry.getValue());
							break;
						}
					}

					// Valida tipo observacion
					cuenta = obtenerClaveObservacion(cuenta, catalogos.getCatalogoCveObs());
				}
			} else if ("contrato".equals(nombreCatalogo)) {
				if (cuenta.getTipoCredito() != null && !"".equals(cuenta.getTipoCredito())) {
					for (Map.Entry<String, String> entry : catalogo.entrySet()) {
						if (cuenta.getTipoCredito().equals(entry.getKey())) {
							cuenta.setTipoCredito(entry.getValue());
							break;
						}
					}

					if (cuenta.getTipoCredito().contains("FISICA ACTIVIDAD EMPRESARIAL")) { // actividad empresarial
						respuesta.getPersonas().getPersona().setFlagEmpresarial(true);
					} else {
						respuesta.getPersonas().getPersona().setFlagNoEmpresarial(true);
					}
				}
			}
			
			if(cuenta.getNombreOtorgante() != null) {
				cuenta.setNombreOtorgante(cuenta.getNombreOtorgante().replaceAll("&amp;", "&"));
			}
		}
	}

	return respuesta;
}

public static Respuesta obtenerRazonScore(Respuesta respuesta, CatalogosDTO catalogos) {
	DescripcionRazones descripcionRazones = new DescripcionRazones();
	Score score = (respuesta.getPersonas().getPersona().getScores() != null
			&& respuesta.getPersonas().getPersona().getScores().getScore() != null)
					? respuesta.getPersonas().getPersona().getScores().getScore()
					: null;
	if (score != null) {
		if (score.getRazon1() != null && !"".equals(score.getRazon1())) {
			if(!ConstantesExclusionFIS.SCORE_FIS.equals(score.getNombreScore())) {
				for (Map.Entry<String, String> entry : catalogos.getCatalogoCodigoScore().entrySet()) {
					if (score.getRazon1().equals(entry.getKey())) {
						descripcionRazones.setRazon1(score.getRazon1());
						descripcionRazones.setRazonDescripcion1(entry.getValue());
						break;
					}
				}
			}else {
				String descripcionRazonFIS = obtenerRazonesFIS(score.getRazon1());
				descripcionRazones.setRazon1(score.getRazon1());
				descripcionRazones.setRazonDescripcion1(descripcionRazonFIS);
			}
		}

		if (score.getRazon2() != null && !"".equals(score.getRazon2())) {
			if(!ConstantesExclusionFIS.SCORE_FIS.equals(score.getNombreScore())) {
				for (Map.Entry<String, String> entry : catalogos.getCatalogoCodigoScore().entrySet()) {
					if (score.getRazon2().equals(entry.getKey())) {
						descripcionRazones.setRazon2(score.getRazon2());
						descripcionRazones.setRazonDescripcion2(entry.getValue());
					}
				}
			}else {
				String descripcionRazonFIS = obtenerRazonesFIS(score.getRazon2());
				descripcionRazones.setRazon2(score.getRazon2());
				descripcionRazones.setRazonDescripcion2(descripcionRazonFIS);
			}
		}

		if (score.getRazon3() != null && !"".equals(score.getRazon3())) {
			if(!ConstantesExclusionFIS.SCORE_FIS.equals(score.getNombreScore())) {
				for (Map.Entry<String, String> entry : catalogos.getCatalogoCodigoScore().entrySet()) {
					if (score.getRazon3().equals(entry.getKey())) {
						descripcionRazones.setRazon3(score.getRazon3());
						descripcionRazones.setRazonDescripcion3(entry.getValue());
					}
				}
			}else {
				String descripcionRazonFIS = obtenerRazonesFIS(score.getRazon3());
				descripcionRazones.setRazon3(score.getRazon3());
				descripcionRazones.setRazonDescripcion3(descripcionRazonFIS);
			}
		}

		if (score.getRazon4() != null && !"".equals(score.getRazon4())) {
			if(!ConstantesExclusionFIS.SCORE_FIS.equals(score.getNombreScore())) {
				for (Map.Entry<String, String> entry : catalogos.getCatalogoCodigoScore().entrySet()) {
					if (score.getRazon4().equals(entry.getKey())) {
						descripcionRazones.setRazon4(score.getRazon4());
						descripcionRazones.setRazonDescripcion4(entry.getValue());
					}
				}
			}else {
				String descripcionRazonFIS = obtenerRazonesFIS(score.getRazon4());
				descripcionRazones.setRazon4(score.getRazon4());
				descripcionRazones.setRazonDescripcion4(descripcionRazonFIS);
			}
		}
		respuesta.getPersonas().getPersona().setDescripcionRazones(descripcionRazones);
	}

	return respuesta;
}


public static Respuesta obtProd(Respuesta respuesta, Map<String, String> catalogo) {
	List<ProductoResumen> lstProducto = (respuesta.getPersonas().getPersona().getResumenPorProducto() != null
			&& respuesta.getPersonas().getPersona().getResumenPorProducto().getProductoResumen() != null
			&& !respuesta.getPersonas().getPersona().getResumenPorProducto().getProductoResumen().isEmpty())
					? respuesta.getPersonas().getPersona().getResumenPorProducto().getProductoResumen()
					: null;
	if (lstProducto != null && !lstProducto.isEmpty()) {
		for (ProductoResumen resumen : lstProducto) {
			if (resumen.getTipoCredito() != null && !"".equals(resumen.getTipoCredito())) {
				for (Map.Entry<String, String> entry : catalogo.entrySet()) {
					if (resumen.getTipoCredito().equals(entry.getKey())) {
						resumen.setTipoCredito(entry.getValue());
						break;
					}
				}
			}
		}
	}
	return respuesta;
}

public static Respuesta chgFormDate(Respuesta respuesta) {
	// Nombre
	if (respuesta.getPersonas().getPersona().getNombre().getFechaNacimiento() != null) {
		respuesta.getPersonas().getPersona().getNombre().setFechaNacimiento(
				cambiarFecha(respuesta.getPersonas().getPersona().getNombre().getFechaNacimiento()));
	}

	if (respuesta.getPersonas().getPersona().getNombre().getFechaDefuncion() != null) {
		respuesta.getPersonas().getPersona().getNombre().setFechaDefuncion(
				cambiarFecha(respuesta.getPersonas().getPersona().getNombre().getFechaDefuncion()));
	}

	// Domicilios
	List<Domicilio> lstDomicilio = (respuesta.getPersonas().getPersona().getDomicilios() != null
			&& respuesta.getPersonas().getPersona().getDomicilios().getDomicilio() != null
			&& !respuesta.getPersonas().getPersona().getDomicilios().getDomicilio().isEmpty())
					? respuesta.getPersonas().getPersona().getDomicilios().getDomicilio()
					: null;
	if (lstDomicilio != null && !lstDomicilio.isEmpty()) {
		for (Domicilio domicilio : lstDomicilio) {
			domicilio.setFechaResidencia(cambiarFecha(domicilio.getFechaResidencia()));
			domicilio.setFechaRegistroDomicilio(cambiarFecha(domicilio.getFechaRegistroDomicilio()));
		}
	}
	// Empleos
	List<Empleo> lstEmpleo = (respuesta.getPersonas().getPersona().getEmpleos() != null
			&& respuesta.getPersonas().getPersona().getEmpleos().getLstEmpleo() != null
			&& !respuesta.getPersonas().getPersona().getEmpleos().getLstEmpleo().isEmpty())
					? respuesta.getPersonas().getPersona().getEmpleos().getLstEmpleo()
					: null;
	if (lstEmpleo != null && !lstEmpleo.isEmpty()) {
		for (Empleo empleo : lstEmpleo) {
			empleo.setFechaContratacion(cambiarFecha(empleo.getFechaContratacion()));
			empleo.setFechaUltimoDiaEmpleo(cambiarFecha(empleo.getFechaUltimoDiaEmpleo()));
			empleo.setFechaVerificacionEmpleo(cambiarFecha(empleo.getFechaVerificacionEmpleo()));
		}
	}

	// Cuenta
	List<Cuenta> lstCuenta = (respuesta.getPersonas().getPersona().getCuentas() != null
			&& respuesta.getPersonas().getPersona().getCuentas().getCuenta() != null
			&& !respuesta.getPersonas().getPersona().getCuentas().getCuenta().isEmpty())
					? respuesta.getPersonas().getPersona().getCuentas().getCuenta()
					: null;
	if (lstCuenta != null && !lstCuenta.isEmpty()) {
		for (Cuenta cuenta : lstCuenta) {
			cuenta.setFechaActualizacion(cambiarFecha(cuenta.getFechaActualizacion()));
			cuenta.setFechaAperturaCuenta(cambiarFecha(cuenta.getFechaAperturaCuenta()));
			cuenta.setFechaUltimoPago(cambiarFecha(cuenta.getFechaUltimoPago()));
			cuenta.setFechaUltimaCompra(cambiarFecha(cuenta.getFechaUltimaCompra()));
			cuenta.setFechaCierreCuenta(cambiarFecha(cuenta.getFechaCierreCuenta()));
			cuenta.setFechaReporte(cambiarFecha(cuenta.getFechaReporte()));
			cuenta.setUltimaFechaSaldoCero(cambiarFecha(cuenta.getUltimaFechaSaldoCero()));
			cuenta.setFechaRecienteHistoricoPagos(cambiarFecha(cuenta.getFechaRecienteHistoricoPagos()));
			cuenta.setFechaAntiguaHistoricoPagos(cambiarFecha(cuenta.getFechaAntiguaHistoricoPagos()));
			cuenta.setFechaPeorAtraso(cambiarFecha(cuenta.getFechaPeorAtraso()));
			 
			//si tiene can, convertir fecha FechaAperturaCAN,FechaCancelacionCAN,FechaMRCAN,FechaMACAN
			if(cuenta.getCan() != null) {
				cuenta.getCan().setFechaAperturaCan(cambiarFecha(cuenta.getCan().getFechaAperturaCan()));
				cuenta.getCan().setFechaCancelacionCan(cambiarFecha(cuenta.getCan().getFechaCancelacionCan()));
				cuenta.getCan().setFechaMACAN(cambiarFecha(cuenta.getCan().getFechaMACAN()));
				cuenta.getCan().setFechaMRCAN(cambiarFecha(cuenta.getCan().getFechaMRCAN()));
				
			}
			
		}
	}

	// Consulta efectuada
	List<ConsultaEfectuada> lstConsulta = (respuesta.getPersonas().getPersona().getConsultasEfectuadas() != null
			&& respuesta.getPersonas().getPersona().getConsultasEfectuadas().getConsultaEfectuada() != null
			&& !respuesta.getPersonas().getPersona().getConsultasEfectuadas().getConsultaEfectuada().isEmpty())
					? respuesta.getPersonas().getPersona().getConsultasEfectuadas().getConsultaEfectuada()
					: null;
	if (lstConsulta != null && !lstConsulta.isEmpty()) {
		for (ConsultaEfectuada cons : lstConsulta) {
			cons.setFechaConsulta(cambiarFecha(cons.getFechaConsulta()));
		}
	}

	return respuesta;
}

public static Respuesta obtenerFechaConsulta(Respuesta respuesta, String fecha) {
	String fechaConsulta = null;
	if (fecha != null && !fecha.equals("")) {
		Date fechaDate = convertirFecha(fecha);
		fechaConsulta = (new java.text.SimpleDateFormat("EEEEE dd MMMMM yyyy", new Locale("es", "ES")))
				.format(fechaDate).toUpperCase();
	} else {
		fechaConsulta = (new java.text.SimpleDateFormat("EEEEE dd MMMMM yyyy", new Locale("es", "ES")))
				.format(new Date()).toUpperCase();
	}

	fechaConsulta = convertirFechasTexto(fechaConsulta);

	respuesta.getPersonas().getPersona().setFechaConsultaTexto(fechaConsulta);
	return respuesta;
}


public static Respuesta obtenerFolioConsultaBC(Respuesta respuesta, String folioConsulta) {
	String folioConsultaBC = null;//consultasDao.consultarFolioBC(folioConsulta);
	//String folioConsultaBC = "2168170237";
	//System.out.println("folio BC >> "+folioConsultaBC);
	if (folioConsultaBC != null && !"".equals(folioConsultaBC)) {
		respuesta.getPersonas().getPersona().setFolioConsultaBC(folioConsultaBC);
	}
	return respuesta;
}

public static Respuesta obtenerCan(Respuesta respuesta) {

	if (respuesta.getPersonas().getPersona().getCuentas() != null
			&& respuesta.getPersonas().getPersona().getCuentas().getCuenta() != null
			&& !respuesta.getPersonas().getPersona().getCuentas().getCuenta().isEmpty()) {

		CuentasCan cc = new CuentasCan();

		List<Can> lstCuentaCan = new ArrayList<Can>();

		int noCredNormal = 1;
		int noCredFAE = 1;
		for (Cuenta c : respuesta.getPersonas().getPersona().getCuentas().getCuenta()) {
			
			if (c.getTipoCredito().contains(ConstantesGenericas.FAE)) { // actividad empresarial
				// Se numeran los creditos FAE
				c.setNoCred(noCredFAE);
				++noCredFAE;
			}else{
				// Se numeran los creditos normales
				c.setNoCred(noCredNormal);
				
				if (c.getCan() != null) {
					// los 4 valores faltantes. noCredito, productoResponsabiliad, credito otorgante
					c.getCan().setIdentiicadorCan("01".equals(c.getCan().getIdentiicadorCan()) ? 
							ConstantesEstatus.ESTATUS_ACTIVO_CAN : ConstantesEstatus.ESTATUS_CANCELADO_CAN);
					c.setIdentiicadorCan(c.getCan().getIdentiicadorCan()); //valor de la cuenta 
					c.getCan().setNoCredito(noCredNormal);
					c.getCan().setProductoResponsabiliad(c.getTipoCredito() + " / " + c.getTipoResponsabilidad());
					c.getCan().setCredito(c.getTipoCuenta());
					c.getCan().setOtorgante(c.getNombreOtorgante());
					// historico CAN
					c.getCan().setHistoricoCan(getHistoricoCAN(c.getCan().getHistoricoCan()));
					lstCuentaCan.add(c.getCan());
				}
				++noCredNormal;
			}
		}

		if (lstCuentaCan != null && !lstCuentaCan.isEmpty()) {
			cc.setCan(lstCuentaCan);

			respuesta.getPersonas().getPersona().setCuentasCan(cc);// respuesta con datos
		}

	}

	return respuesta;

}


public static Respuesta obtResProd(Respuesta respuesta, Vector vctr, TypeOfCoinExchangeRC ltypeOfCoinExchange) {
	String estado;
	Long cantidad;
	Long limite;
	Long aprobado;
	Long actual;
	Long vencido;
	Long semanal;
	Long quincenal;
	Long mensual;
	Long limiteTotal;
	Long aprobadoTotal;
	Long actualTotal;
	Long vencidoTotal;
	Long semanalTotal;
	Long quincenalTotal;
	Long mensualTotal;
	Map<String, String> productos = new HashMap<String, String>();
	CountsBeanRC countsb;
	// StringBuilder cadenaXml = new StringBuilder();
	// cadenaXml.append("<ResumenPorProducto>");
	for (int i = 0; i < vctr.size(); i++) {
		countsb = (CountsBeanRC) vctr.elementAt(i);
		if (countsb.getCierre() != null && !countsb.getCierre().equals("")) {
			estado = "cerrado";
		} else if (countsb.getHistoricopago() == null || countsb.getHistoricopago().equals("")
				|| (countsb.getHistoricopago().length() >=2 && countsb.getHistoricopago().substring(0, 2).contains("V"))) {
			estado = "vigente";
		} else {
			estado = "atraso";
		}
		productos.put(countsb.getClavetipocredito() + ":" + estado, "0");
	}
	limiteTotal = 0l;
	aprobadoTotal = 0l;
	actualTotal = 0l;
	vencidoTotal = 0l;
	semanalTotal = 0l;
	quincenalTotal = 0l;
	mensualTotal = 0l;
	// Obtener cantidades totales
	for (int i = 0; i < vctr.size(); i++) {
		countsb = (CountsBeanRC) vctr.elementAt(i);
		if (countsb.getLimite() != null && !countsb.getLimite().equals("")) {
			limiteTotal += Long.valueOf(
					(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getLimite()));
		}
		// se obtine el saldo aprobado
		if (countsb.getCreditomaximo() != null && !countsb.getCreditomaximo().equals("")) {
			aprobadoTotal += Long.valueOf(
					(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getCreditomaximo()));
		}
		// se obtine el saldo actual
		if (countsb.getActual() != null && !countsb.getActual().equals("")) {
			actualTotal += Long.valueOf(
					(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getActual()));
		}
		// se obtine el saldo vencido
		if (countsb.getVencido() != null && !countsb.getVencido().equals("")) {
			vencidoTotal += Long.valueOf(
					(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getVencido()));
		}
		// Saldo mensual
		if ((countsb.getFrecpago().equals("D") || countsb.getFrecpago().equals("R")
				|| countsb.getFrecpago().equals("U") || countsb.getFrecpago().equals("M"))
				&& (countsb.getMonto() != null && !countsb.getMonto().equals(""))) {
			mensualTotal += Long.valueOf(
					(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getMonto()));
		}
		// Saldo quincenal
		if ((countsb.getMonto() != null && !countsb.getMonto().equals("")) && countsb.getFrecpago().equals("Q")) {
			quincenalTotal += Long.valueOf(
					(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getMonto()));
		}
		// Saldo semanal
		if ((countsb.getMonto() != null && !countsb.getMonto().equals("")) && countsb.getFrecpago().equals("S")) {
			semanalTotal += Long.valueOf(
					(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getMonto()));
		}
	}
	// Obtiene cantidades por producto
	List<ProductoResumen> lstProductoResumen = new ArrayList<ProductoResumen>();
	for (Map.Entry<String, String> entry : productos.entrySet()) {
		cantidad = 0l;
		limite = 0l;
		aprobado = 0l;
		actual = 0l;
		vencido = 0l;
		semanal = 0l;
		quincenal = 0l;
		mensual = 0l;
		for (int i = 0; i < vctr.size(); i++) {
			countsb = (CountsBeanRC) vctr.elementAt(i);
			if (countsb.getCierre() != null && !countsb.getCierre().equals("")) {
				estado = "cerrado";
			} else if (countsb.getHistoricopago() == null || countsb.getHistoricopago().equals("")
					|| (countsb.getHistoricopago().length() >=2 && countsb.getHistoricopago().substring(0, 2).contains("V"))) {
				estado = "vigente";
			} else {
				estado = "atraso";
			}
			if (entry.getKey().equals(countsb.getClavetipocredito() + ":" + estado)) {
				cantidad++;
				// Se obtiene el limite de credito
				if (countsb.getLimite() != null && !countsb.getLimite().equals("")) {
					limite += Long.valueOf((int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(),
							countsb.getLimite()));
				}
				// se obtine el saldo aprobado
				if (countsb.getCreditomaximo() != null && !countsb.getCreditomaximo().equals("")) {
					aprobado += Long.valueOf((int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(),
							countsb.getCreditomaximo()));
				}
				// se obtine el saldo actual
				if (countsb.getActual() != null && !countsb.getActual().equals("")) {
					actual += Long.valueOf((int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(),
							countsb.getActual()));
				}
				// se obtine el saldo vencido
				if (countsb.getVencido() != null && !countsb.getVencido().equals("")) {
					vencido += Long.valueOf((int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(),
							countsb.getVencido()));
				}
				// Saldo mensual
				if ((countsb.getFrecpago().equals("D") || countsb.getFrecpago().equals("R")
						|| countsb.getFrecpago().equals("U") || countsb.getFrecpago().equals("M"))
						&& (countsb.getMonto() != null && !countsb.getMonto().equals(""))) {
					mensual += Long.valueOf(
							(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getMonto()));
				}
				// Saldo quincenal
				if ((countsb.getMonto() != null && !countsb.getMonto().equals(""))
						&& countsb.getFrecpago().equals("Q")) {
					quincenal += Long.valueOf(
							(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getMonto()));
				}
				// Saldo semanal
				if ((countsb.getMonto() != null && !countsb.getMonto().equals(""))
						&& countsb.getFrecpago().equals("S")) {
					semanal += Long.valueOf(
							(int) ltypeOfCoinExchange.convertToPESOS(countsb.getClavemoneda(), countsb.getMonto()));
				}

			}
		}
		String cuentaDesc = entry.getKey();
		ProductoResumen pr = new ProductoResumen();
		pr.setTipoCredito(cuentaDesc.substring(0, cuentaDesc.indexOf(':')));
		pr.setStatus(cuentaDesc.substring(cuentaDesc.indexOf(':') + 1));
		pr.setCantidad(String.valueOf(cantidad));
		pr.setLimite(String.valueOf(limite));
		pr.setAprobado(String.valueOf(aprobado));
		pr.setActual(String.valueOf(actual));
		pr.setVencido(String.valueOf(vencido));
		pr.setSemanal(String.valueOf(semanal));
		pr.setQuincenal(String.valueOf(quincenal));
		pr.setMensual(String.valueOf(mensual));
		pr.setTotalCantidad(String.valueOf(vctr.size()));
		pr.setLimiteTotal(String.valueOf(limiteTotal));
		pr.setAprobadoTotal(String.valueOf(aprobadoTotal));
		pr.setActualTotal(String.valueOf(actualTotal));
		pr.setVencidoTotal(String.valueOf(vencidoTotal));
		pr.setSemanalTotal(String.valueOf(semanalTotal));
		pr.setQuincenalTotal(String.valueOf(quincenalTotal));
		pr.setMensualTotal(String.valueOf(mensualTotal));

		lstProductoResumen.add(pr);
	}
	ResumenPorProducto resumen = new ResumenPorProducto();
	resumen.setProductoResumen(lstProductoResumen);
	respuesta.getPersonas().getPersona().setResumenPorProducto(resumen);

	return respuesta;
}

public static String convertirHistorico(String historico) {
	String histAux = historico;

	String historialFinal = "";
	if (histAux != null && !histAux.equals("") && histAux.length() > 1) {
		Integer periodos = histAux.length() / 2;
		if (periodos > 0) {

			if (periodos > 24) {
				periodos = 24; // maximo periodos de 24
			}

			// separa periodos
			for (int i = 0; i < periodos; i++) {
				if (histAux.substring(0, 2).equals("--")) {
					historialFinal += "-.";
				} else {
					try {
						historialFinal += String.valueOf(Integer.valueOf(histAux.substring(0, 2))) + ".";
					} catch (NumberFormatException e) {
						historialFinal += histAux.substring(0, 2).trim() + ".";
					}
				}
				if (i < periodos) {
					histAux = histAux.substring(2, histAux.length());
				}
			}
			// System.out.println("No. Periodos historico "+periodos);

			// quita el punto del final
			if (historialFinal.endsWith(".")) {
				historialFinal = historialFinal.substring(0, historialFinal.length() - 1);
			}
		}
	} // else{
		// System.out.println("solo hay un periodo "+historico);
		// }
		// System.out.println(historico);
		// System.out.println(historialFinal);

	return historialFinal;
}

public static Cuenta obtenerClaveObservacion(Cuenta cuenta, Map<String, String> catalogo) {
	Integer registroImpugnado = null;
	try {
		registroImpugnado = (cuenta.getRegistroImpugnado() != null && !"".equals(cuenta.getRegistroImpugnado())
				? Integer.valueOf(cuenta.getRegistroImpugnado())
				: null);
	} catch (NumberFormatException ne) {
		System.out.println("No se pudo convertir registro impugnado");
	}

	if (registroImpugnado != null && registroImpugnado >= 1) {
		cuenta.setClavePrevencion("IMPUGNADO");
	} else {
		if (cuenta.getClavePrevencion() != null && !"".equals(cuenta.getClavePrevencion())) {
			for (Map.Entry<String, String> entry : catalogo.entrySet()) {
				if (cuenta.getClavePrevencion().equals(entry.getKey())) {
					cuenta.setClavePrevencion(entry.getValue());
					break;
				}
			}
		}
	}
	return cuenta;
}

private static String obtenerRazonesFIS (String razon) {
	String descripcion = "";
	if(ConstantesExclusionFIS.FIS_E1.equals(razon)) {
		descripcion = ConstantesExclusionFIS.FIS_E1_DESC;
	}else if(ConstantesExclusionFIS.FIS_E2.equals(razon)) {
		descripcion = ConstantesExclusionFIS.FIS_E2_DESC;
	}else if(ConstantesExclusionFIS.FIS_E3.equals(razon)) {
		descripcion = ConstantesExclusionFIS.FIS_E3_DESC;
	}else if(ConstantesExclusionFIS.FIS_E4.equals(razon)) {
		descripcion = ConstantesExclusionFIS.FIS_E4_DESC;
	}
	return descripcion;
}

public static String cambiarFecha(String fechaValidar) {

	if (fechaValidar != null && !"".equals(fechaValidar) && fechaValidar.length() == 10) {
		fechaValidar = generaFormatoFecha(fechaValidar);
	}

	return fechaValidar;
}

private static Date convertirFecha(String fecha) {
	Date fechaFinal = null;
	if (fecha != null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaFinal = dateFormat.parse(fecha);
		} catch (ParseException e) {
			//LOGG.error("Error al convertir fecha");
			System.out.println(e);
		}
	}
	return fechaFinal;
}

private static String convertirFechasTexto(String fecha) {
	if (fecha != null) {
		// Dias
		for (String dia : ConstantesFechas.dias) {
			if (fecha.contains(dia.toUpperCase())) {
				fecha = fecha.replaceAll(dia.toUpperCase(), dia);
				break;
			}
		}
		// Meses
		for (String mes : ConstantesFechas.meses) {
			if (fecha.contains(mes.toUpperCase())) {
				fecha = fecha.replaceAll(mes.toUpperCase(), mes);
				break;
			}
		}
	}
	return fecha;
}

/**
 * Transforma el historico CAN de BD para el PDF
 * 1 = A
 * 2 = C
 * - = -
 * @param historicoCAN String
 * @return String
 */
private static String getHistoricoCAN(String historicoCAN){
	if(historicoCAN != null && !"".equals(historicoCAN)){
		historicoCAN = historicoCAN.replaceAll("1", "A");
		historicoCAN = historicoCAN.replaceAll("2", "C");
	}
	return historicoCAN;
}


public static String generaFormatoFecha(String fecha) {
	String dia = fecha.substring(8);
	int mesNum = Integer.parseInt(fecha.substring(5, 7));
	String anio = fecha.substring(2, 4);
	String mes;

	switch (mesNum) {
	case 1:
		mes = ConstantesFechas.ENERO;
		break;
	case 2:
		mes = ConstantesFechas.FEBRERO;
		break;
	case 3:
		mes = ConstantesFechas.MARZO;
		break;
	case 4:
		mes = ConstantesFechas.ABRIL;
		break;
	case 5:
		mes = ConstantesFechas.MAYO;
		break;
	case 6:
		mes = ConstantesFechas.JUNIO;
		break;
	case 7:
		mes = ConstantesFechas.JULIO;
		break;
	case 8:
		mes = ConstantesFechas.AGOSTO;
		break;
	case 9:
		mes = ConstantesFechas.SEPTIEMBRE;
		break;
	case 10:
		mes = ConstantesFechas.OCTUBRE;
		break;
	case 11:
		mes = ConstantesFechas.NOVIEMBRE;
		break;
	case 12:
		mes = ConstantesFechas.DICIEMBRE;
		break;
	default:
		mes = "";
		break;
	}
	return dia + ConstantesFechas.FECHA_SLASH + mes + ConstantesFechas.FECHA_SLASH + anio;
}

public static String formatoSinDecimales(String numero) {
	if(numero.contains(".")) {
		String[] parts = numero.split("\\.");
		String cifra = parts[0];
		String cifra1 = parts[1];
		numero = cifra;
	}
	
	return numero;
}

public static String generaMensajeLeyenda(String leyenda) {
	
	if (leyenda != null && !"".equals(leyenda) && !" ".equals(leyenda)) {
		
		if(leyenda.equals(ConstantesMensaje.MENSAJE_BC_1)) {
			leyenda = "1";
		}
		if(leyenda.equals(ConstantesMensaje.MENSAJE_BC_2)) {
			leyenda = "2";
		}
		if(leyenda.equals(ConstantesMensaje.MENSAJE_BC_3)) {
			leyenda = "3";
		}
		if(leyenda.equals(ConstantesMensaje.MENSAJE_BC_4)) {
			leyenda = "4";
		}
		if(leyenda.equals(ConstantesMensaje.MENSAJE_BC_5)) {
			leyenda = "5";
		}
		if(leyenda.equals(ConstantesMensaje.MENSAJE_BC_6)) {
			leyenda = "6";
		}
		else {
			leyenda = "1";
		}
			
	}
	return leyenda;
}

}
