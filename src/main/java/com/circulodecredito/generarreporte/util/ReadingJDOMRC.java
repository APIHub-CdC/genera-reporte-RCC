package com.circulodecredito.generarreporte.util;

import com.circulodecredito.generarreporte.beans.AdressBeanRC;
import com.circulodecredito.generarreporte.beans.AuthenticationBeanRC;
import com.circulodecredito.generarreporte.beans.ConsultsBeanRC;
import com.circulodecredito.generarreporte.beans.CountsBeanRC;
import com.circulodecredito.generarreporte.beans.HeaderBeanRC;
import com.circulodecredito.generarreporte.beans.JobBeanRC;
import com.circulodecredito.generarreporte.beans.MessagesBeanRC;
import com.circulodecredito.generarreporte.beans.NamesBeanRC;
import com.circulodecredito.generarreporte.beans.ScoreBeanRC;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
//import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

@SuppressWarnings("rawtypes")
public class ReadingJDOMRC {

	ConvertFechas conver = new ConvertFechas();
	private Document doc = null;
	private SAXBuilder parser = new SAXBuilder();
	private List children = null;
	private Element element = null;
	private NamesBeanRC persona = new NamesBeanRC();
	private Vector domvector = new Vector();
	private Vector jobvector = new Vector();
	private Vector countsvector = new Vector();
	private Vector consultsvector = new Vector();
	private HeaderBeanRC headerbean = new HeaderBeanRC();
	private AuthenticationBeanRC authBean = new AuthenticationBeanRC();
	private ScoreBeanRC scoreBean = new ScoreBeanRC();
	private String declarativas = null;
	private int posIndicador = 0;
	private Date fechaCalculada = ConvertFechas.restaAnnio(2);
	

	private Vector messagesvector = new Vector();

//	static Logger logger = Logger.getLogger(ReadingJDOMRC.class);
//	static Logger errorLogger = Logger.getLogger("errorLogger." + ReadingJDOMRC.class);

	public ReadingJDOMRC(Reader xml) {
		try {
			doc = parser.build(xml);
			posIndicador = 0;

		} catch (JDOMException e) {
//			errorLogger.error(xml + " is not well-formed.");
//			errorLogger.error(e);
		} catch (IOException e) {
//			errorLogger.error("Could not check " + xml);
//			errorLogger.error(" because ", e);
		}
	}

	public ReadingJDOMRC(String xml) {
		try {
			doc = parser.build(xml);
			posIndicador = 0;
		} catch (JDOMException e) {
//			errorLogger.error(xml + " is not well-formed.");
//			errorLogger.error(e);
		} catch (IOException e) {
//			errorLogger.error("Could not check " + xml);
//			errorLogger.error(" because ", e);
		} catch (Exception e) {
//			errorLogger.error("Could not load file " + xml);
//			errorLogger.error(" because ", e);
		}
	}

	public AuthenticationBeanRC getAuthenticationBean(Object o) {
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("NumeroSolicitud"))
				authBean.setNumeroSolicitud(element.getText());
			if (element.getName().equals("Autenticacion")) {
				authBean.setNumeroSolicitud(element.getChildText("NumeroSolicitud"));
				authBean.setEstatus(element.getChildText("EstatusAutenticacion"));
				authBean.setNumeroAutenticacion(element.getChildText("NumeroAutenticacion"));
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getAuthenticationBean(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getAuthenticationBean(child);
			}
		}
		return authBean;
	}
	
	public ScoreBeanRC getScoreBean(Object o) {
		String razones[] = new String[4];
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("Score")) {
				scoreBean.setNombreScore(element.getChildText("NombreScore"));
				scoreBean.setValorScore(element.getChildText("Valor"));
				scoreBean.setErrorScore(element.getChildText("Error"));					
				razones[0] = element.getChildText("Razon1");
				razones[1] = element.getChildText("Razon2");
				razones[2] = element.getChildText("Razon3");
				razones[3] = element.getChildText("Razon4");
				scoreBean.setRazones(razones);
				
			}
			else if (element.getName().equals("Indicador")) {
				scoreBean.setNomIndScore(element.getChildText("Descripcion"), posIndicador);
				scoreBean.setValIndScore(element.getChildText("Valor"), posIndicador);
				posIndicador++;
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getScoreBean(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getScoreBean(child);
			}
		}
		return scoreBean;
	}
	
	public HeaderBeanRC getHeaderBean(Object o) {
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("Encabezado")) {
				//headerbean.setFolioconsulta(element.getChildText("FolioConsultaOtorgante"));
				headerbean.setClaveotorgante(element.getChildText("ClaveOtorgante"));
				headerbean.setExpedienteencontrado(element.getChildText("ExpedienteEncontrado"));
				headerbean.setFolioconsulta(element.getChildText("FolioConsulta"));
				headerbean.setGrupootorgante(element.getChildText("GrupoOtorgante"));
				headerbean.setSubproducto(element.getChildText("SubProducto"));
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getHeaderBean(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getHeaderBean(child);
			}
		}
		return headerbean;
	}

	public NamesBeanRC getNamesBean(Object o) {
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("Nombre")) {
				if (element.getChildren().size() > 0){
					persona.setApellpat(element.getChildText("ApellidoPaterno"));
					persona.setApellmat(element.getChildText("ApellidoMaterno"));
					persona.setApelladic(element.getChildText("ApellidoAdicional"));
					persona.setNombres(element.getChildText("Nombres"));
					persona.setFechnac(element.getChildText("FechaNacimiento"));
					persona.setRfc(element.getChildText("RFC"));
					persona.setNacionalidad(element.getChildText("Nacionalidad"));
					persona.setResidencia(element.getChildText("Residencia"));
					persona.setEstadocivil(element.getChildText("EstadoCivil"));
					persona.setSexo(element.getChildText("Sexo"));
					persona.setClaveife(element.getChildText("ClaveElectorIFE"));
					persona.setNumerodependientes(element.getChildText("NumeroDependientes"));
					persona.setFechadefuncion(element.getChildText("FechaDefuncion"));
					persona.setCurp(element.getChildText("CURP"));
				}
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getNamesBean(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getNamesBean(child);
			}
		}
		return persona;
	}

	@SuppressWarnings("unchecked")
	public Vector getAdressBean(Object o) {
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("Domicilio")) {
				AdressBeanRC domicilio = new AdressBeanRC();
				domicilio.setDireccion(element.getChildText("Direccion"));
				domicilio.setColonia(element.getChildText("ColoniaPoblacion"));
				domicilio.setDelmun(element.getChildText("DelegacionMunicipio"));
				domicilio.setCiudad(element.getChildText("Ciudad"));
				domicilio.setEstado(element.getChildText("Estado"));
				domicilio.setCp(element.getChildText("CP"));
				domicilio.setFecharesidencia(element.getChildText("FechaResidencia"));
				domicilio.setTel(element.getChildText("NumeroTelefono"));
				domicilio.setTipodomicilio(element.getChildText("TipoDomicilio"));
				domicilio.setTipoasentamiento(element.getChildText("TipoAsentamiento"));
				domicilio.setFecharegistro(element.getChildText("FechaRegistroDomicilio"));
				domvector.addElement(domicilio);
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getAdressBean(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getAdressBean(child);
			}
		}
		return domvector;
	}

	@SuppressWarnings("unchecked")
	public Vector getJobBean(Object o) {
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("Empleo")) {
				JobBeanRC job = new JobBeanRC();
				job.setEmpcomp(element.getChildText("NombreEmpresa"));
				job.setEmpdireccion(element.getChildText("Direccion"));
				job.setEmpcolonia(element.getChildText("ColoniaPoblacion"));
				job.setEmpdelmun(element.getChildText("DelegacionMunicipio"));
				job.setEmpciudad(element.getChildText("Ciudad"));
				job.setEmpestado(element.getChildText("Estado"));
				job.setEmpcp(element.getChildText("CP"));
				job.setEmptel(element.getChildText("NumeroTelefono"));
				job.setEmpextension(element.getChildText("Extension"));
				job.setEmpfax(element.getChildText("Fax"));
				job.setEmppuesto(element.getChildText("Puesto"));
				job.setFechacontratacion(element.getChildText("FechaContratacion"));
				job.setEmpclavemoneda(element.getChildText("ClaveMoneda"));
				job.setEmpsalario(element.getChildText("SalarioMensual"));
				job.setFechaultimodiaempleo(element.getChildText("FechaUltimoDiaEmpleo"));
				job.setFechaverificacionempleo(element.getChildText("FechaVerificacionEmpleo"));
				jobvector.addElement(job);
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getJobBean(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getJobBean(child);
			}
		}
		return jobvector;
	}

	@SuppressWarnings("unchecked")
	public Vector getMessages(Object o) {
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("Mensaje")) {
				MessagesBeanRC message = new MessagesBeanRC();
				message.setTipomensaje(element.getChildText("TipoMensaje"));
				message.setCuerpomensaje(element.getChildText("CuerpoMensaje"));
				messagesvector.addElement(message);
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getMessages(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getMessages(child);
			}
		}
		return messagesvector;
	}

	@SuppressWarnings("unchecked")
	public Vector getCountsBean(Object o) {
		String tipoCuenta = "";
		TipoCuenta tipoCuentaBean = new TipoCuenta();
		
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("Cuenta")) {
				CountsBeanRC count = new CountsBeanRC();
				count.setFechaactualizacion(element.getChildText("FechaActualizacion"));
				count.setRegistroimpugnado(element.getChildText("RegistroImpugnado"));
				count.setClaveotor(element.getChildText("ClaveOtorgante"));
				count.setNombreotor(element.getChildText("NombreOtorgante"));
				count.setNumcount(element.getChildText("CuentaActual"));
				count.setTiporesponsabilidad(element.getChildText("TipoResponsabilidad"));
				count.setClavetipocuenta(element.getChildText("TipoCuenta"));
				count.setClavetipocredito(element.getChildText("TipoCredito"));
				//Valida Si es una cuenta de tipo PFAE
				tipoCuenta =  tipoCuentaBean.descriptionTipoCuenta(element.getChildText("TipoCredito"), element.getChildText("NombreOtorgante"));
				if ( !tipoCuenta.equals("") ) {
					count.setTipoCuenta(tipoCuenta);
				}
				//
				count.setClavemoneda(element.getChildText("ClaveUnidadMonetaria"));
				//System.out.println("\t::: -----");
				//System.out.println("\t::: element.getChildText(\"ClaveUnidadMonetaria\")-> [" + element.getChildText("ClaveUnidadMonetaria") + "]");
				count.setValoractivo(element.getChildText("ValorActivoValuacion"));
				count.setPagos(element.getChildText("NumeroPagos"));
				count.setFrecpago(element.getChildText("FrecuenciaPagos"));
				count.setMonto(element.getChildText("MontoPagar"));
				count.setApertura(element.getChildText("FechaAperturaCuenta"));
				count.setUltpago(element.getChildText("FechaUltimoPago"));
				count.setUltcomp(element.getChildText("FechaUltimaCompra"));
				count.setCierre(element.getChildText("FechaCierreCuenta"));
				count.setFechareporte(element.getChildText("FechaReporte"));
				count.setUltceros(element.getChildText("UltimaFechaSaldoCero"));
				count.setGarantia(element.getChildText("Garantia"));
				count.setLimite(element.getChildText("LimiteCredito"));
				count.setActual(element.getChildText("SaldoActual"));
				count.setCreditomaximo(element.getChildText("CreditoMaximo"));		
				count.setVencido(element.getChildText("SaldoVencido"));
				count.setNpagosvencidos(element.getChildText("NumeroPagosVencidos"));				
				count.setPagoactual(element.getChildText("PagoActual"));
				count.setHistoricopago(element.getChildText("HistoricoPagos"));
				count.setFecharecientehistoricopago(
					element.getChildText("FechaRecienteHistoricoPagos"));
				count.setFechaantiguahistoricopago(
					element.getChildText("FechaAntiguaHistoricoPagos"));
				count.setClaveprevencion(element.getChildText("ClavePrevencion"));
				count.setTotalpagosreportados(element.getChildText("TotalPagosReportados"));
				count.setDescripciontipocuenta(element.getChildText("DescripcionTipoCuenta"));
				count.setDescripciontipocontrato(element.getChildText("DescripcionTipoContrato"));
				count.setDescripciontiporesponsabilidad(
					element.getChildText("DescripcionTipoResponsabilidad"));
				count.setDescripciontipootorgante(element.getChildText("DescripcionTipoOtorgante"));
				count.setDescripcionmoneda(element.getChildText("DescripcionMoneda"));
				//System.out.println("\t::: element.getChildText(\"DescripcionMoneda\")-> [" + element.getChildText("DescripcionMoneda") + "]");
				//System.out.println("\t::: element.getChildText(\"ClaveUnidadMonetaria\")-> [" + element.getChildText("ClaveUnidadMonetaria") + "]");
				//System.out.println("\t::: count.getClavemoneda()-> [" + count.getClavemoneda() + "]");
				//System.out.println("\t::: count.getDescripcionmoneda()-> [" + count.getDescripcionmoneda() + "]");
				//System.out.println("\t::: -----");
				count.setDescripcioncorte(element.getChildText("TipoCorte"));
				count.setDescripcionobservacion(element.getChildText("DescripcionTipoObservacion"));
				// -----------------------------------------------------------------------------------------
				count.setFechaPeorAtraso( element.getChildText( "FechaPeorAtraso" )  );
				count.setSaldoPeorAtraso( element.getChildText( "SaldoVencidoPeorAtraso" ));
				count.setPeorAtraso( element.getChildText( "PeorAtraso" ) );
				// -----------------------------------------------------------------------------------------
				String vercvetcuenta = count.getClavetipocuenta();
				if (vercvetcuenta.equals("R"))
					count.setBrevolvente(true);
				countsvector.addElement(count);
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getCountsBean(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getCountsBean(child);
			}
		}
		return countsvector;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public Vector getConsultsBean(Object o) {
		Boolean esMenor;
		
		
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("ConsultaEfectuada")) {
				ConsultsBeanRC consults = new ConsultsBeanRC();
				consults.setFechacons(element.getChildText("FechaConsulta"));
				consults.setClaveotorgante(element.getChildText("ClaveOtorgante"));
				consults.setNomotor(element.getChildText("NombreOtorgante"));
				consults.setTipcred(element.getChildText("TipoCredito"));
				consults.setClavemoneda(element.getChildText("ClaveUnidadMonetaria"));
				consults.setImportecredito(element.getChildText("ImporteCredito"));
				consults.setTiporesponsabilidad(element.getChildText("TipoResponsabilidad"));
				consults.setDescripciontipocuenta(element.getChildText("DescripcionTipoCuenta"));
				consults.setTipootorgante(element.getChildText("DescripcionTipoOtorgante"));
				
				esMenor = conver.esFechaMenor(conver.stringToDateTime(element.getChildText("FechaConsulta")), fechaCalculada);
				if ( !esMenor ) {
					consultsvector.addElement(consults);
				}
					
				
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getConsultsBean(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getConsultsBean(child);
			}
		}
		return consultsvector;
	}

	public String getDeclarativas(Object o) {
		if (o instanceof Element) {
			element = (Element) o;
			children = element.getContent();
			if (element.getName().equals("Persona")) {
				declarativas = element.getChildText("DeclaracionesConsumidor");
			}
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getDeclarativas(child);
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			children = doc.getContent();
			Iterator iterator = children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getDeclarativas(child);
			}
		}
		return declarativas;
	}

	public String getError(Object o) {
//System.out.println("****************************************Object "+o);
		String error = "";
		if (o instanceof Element) {
			element = (Element) o;
			if (element.getName().equals("Error")) {
				this.children = element.getChild("Errores").getContent();
				Iterator iterator = this.children.iterator();
				while (iterator.hasNext()) {
					Element child = (Element) iterator.next();
					error += child.getText() + "<br>";
				}
			}
		} else if (o instanceof Document) {
			Document doc = (Document) o;
			this.children = doc.getContent();
			Iterator iterator = this.children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				getError(child);
			}
		}
		return error;
	}

	public Element ReadFileRoot() {
		Element root = null;
		try {
			root = doc.getRootElement();
		} catch (Exception e) {
//			errorLogger.error("Could not load file ");
//			errorLogger.error(" because ", e);
		}

		return root;
	}
	
	
	

}
