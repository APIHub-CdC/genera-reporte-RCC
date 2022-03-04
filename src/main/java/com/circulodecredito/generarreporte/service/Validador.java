package com.circulodecredito.generarreporte.service;

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
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.circulodecredito.generarreporte.mapper.*;
//import org.apache.log4j.Logger;
import org.jdom.Element;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.circulodecredito.generarreporte.constantes.ConstantesRutas;
import com.circulodecredito.generarreporte.dao.CatalogosDao;
import com.circulodecredito.generarreporte.dao.ConsultasDao;
import com.circulodecredito.generarreporte.util.ReadingJDOMRC;
import com.circulodecredito.generarreporte.util.TypeOfCoinExchangeRC;

@Service
public class Validador {

	//static final Logger LOGG = Logger.getLogger("generarReporteLog");

	@Autowired
	private CatalogosDao catalogosDao;
	@Autowired
	private ConsultasDao consultasDao;
	@Autowired
	private ValidacionesCore validacionesCore;

	
	public Respuesta convertirRCEResponseToRespuesta (ReporteCreditoResponse respuestaRC, String fechaReporte) {
		Respuesta respuesta = this.llenarObjetoRespuesta(respuestaRC);
		
		if(respuesta != null) {
			String xml = this.respuestaToXML(respuesta);
			try {
				respuesta = this.generarFormatoXML(xml, respuesta, fechaReporte);
			} catch (ParseException e) {
				//LOGG.error("Error al generar datos para el PDF");
				e.printStackTrace();
			}
		}
		
		return respuesta;
	}
	
	public String respuestaToXML(Respuesta respuesta) {
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
	
	public Respuesta llenarObjetoRespuesta (ReporteCreditoResponse respuestaRC) {
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
	
	public Respuesta generarFormatoXML(String xml, Respuesta respuesta, String fechaReporte) throws ParseException {
		
		CatalogosDTO catalogos = catalogosDao.llenaCatalogos();
		
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

	public Respuesta changeCaracterAmpersan(Respuesta respuesta) {
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
	@SuppressWarnings("rawtypes")
	public Respuesta genInd(String xml, Respuesta respuesta, CatalogosDTO catalogos) throws ParseException {
		
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
				System.out.println("entro al menos uno activo");
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
		
		System.out.println("**********************************************");
		System.out.println("Valores final de porcentaje AA " + porcentajeAA);
		System.out.println("Valores final de porcentaje AB " + porcentajeAB);
		System.out.println("**********************************************");
		System.out.println("Valores final de porcentaje BB " + porcentajeBB);
		System.out.println("Valores final de porcentaje BA " + porcentajeBA);

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

	@SuppressWarnings("rawtypes")
	public Respuesta obtResProd(Respuesta respuesta, Vector vctr, TypeOfCoinExchangeRC ltypeOfCoinExchange) {
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

	public Respuesta chgFormDate(Respuesta respuesta) {
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

	public String cambiarFecha(String fechaValidar) {

		if (fechaValidar != null && !"".equals(fechaValidar) && fechaValidar.length() == 10) {
			fechaValidar = generaFormatoFecha(fechaValidar);
		}

		return fechaValidar;
	}

	public String generaFormatoFecha(String fecha) {
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

	public Respuesta ultimosDoceHistorico(Respuesta respuesta) {
		List<Cuenta> lstCuentas = (respuesta.getPersonas().getPersona().getCuentas() != null
				&& respuesta.getPersonas().getPersona().getCuentas().getCuenta() != null
				&& !respuesta.getPersonas().getPersona().getCuentas().getCuenta().isEmpty())
						? respuesta.getPersonas().getPersona().getCuentas().getCuenta()
						: null;

		if (lstCuentas != null) {
			for (Cuenta cuenta : lstCuentas) {
				if (cuenta.getHistoricoPagos() != null && !"".equals(cuenta.getHistoricoPagos())) {
					cuenta.setHistoricoPagos(this.convertirHistorico(cuenta.getHistoricoPagos()));
				}
			}
		}
		return respuesta;
	}

	public String convertirHistorico(String historico) {
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

	public Respuesta generaMensaje(Respuesta respuesta, int opc) {
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

	private Date convertirFecha(String fecha) {
		Date fechaFinal = null;
		if (fecha != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				fechaFinal = dateFormat.parse(fecha);
			} catch (ParseException e) {
				//LOGG.error("Error al convertir fecha");
			}
		}
		return fechaFinal;
	}

	private String convertirFechasTexto(String fecha) {
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

	public Respuesta obtenerFolioConsultaBC(Respuesta respuesta, String folioConsulta) {
		String folioConsultaBC = consultasDao.consultarFolioBC(folioConsulta);
		//folioConsultaBC = "2168170237";
		System.out.println("folio BC >> "+folioConsultaBC);
		if (folioConsultaBC != null && !"".equals(folioConsultaBC)) {
			respuesta.getPersonas().getPersona().setFolioConsultaBC(folioConsultaBC);
		}
		return respuesta;
	}

	/**
	 * 
	 * @param respuesta
	 * @return
	 */
	public Respuesta obtenerCan(Respuesta respuesta) {

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
						c.getCan().setHistoricoCan(this.getHistoricoCAN(c.getCan().getHistoricoCan()));
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
	
	/**
	 * Transforma el historico CAN de BD para el PDF
	 * 1 = A
	 * 2 = C
	 * - = -
	 * @param historicoCAN String
	 * @return String
	 */
	private String getHistoricoCAN(String historicoCAN){
		if(historicoCAN != null && !"".equals(historicoCAN)){
			historicoCAN = historicoCAN.replaceAll("1", "A");
			historicoCAN = historicoCAN.replaceAll("2", "C");
		}
		return historicoCAN;
	}
	
	public Respuesta obtenerFechaConsulta(Respuesta respuesta, String fecha) {
		String fechaConsulta = null;
		if (fecha != null && !fecha.equals("")) {
			Date fechaDate = this.convertirFecha(fecha);
			fechaConsulta = (new java.text.SimpleDateFormat("EEEEE dd MMMMM yyyy", new Locale("es", "ES")))
					.format(fechaDate).toUpperCase();
		} else {
			fechaConsulta = (new java.text.SimpleDateFormat("EEEEE dd MMMMM yyyy", new Locale("es", "ES")))
					.format(new Date()).toUpperCase();
		}

		fechaConsulta = this.convertirFechasTexto(fechaConsulta);

		respuesta.getPersonas().getPersona().setFechaConsultaTexto(fechaConsulta);
		return respuesta;
	}

	public String obtenerImgTacometro(Respuesta respuesta) {
		String url = "";
		Score score = (respuesta.getPersonas().getPersona().getScores() != null
				&& respuesta.getPersonas().getPersona().getScores().getScore() != null)
						? respuesta.getPersonas().getPersona().getScores().getScore()
						: null;

		if (score != null) {
			if (score.getNombreScore() != null && score.getNombreScore().equals("EXTENDED")) {
				url = ConstantesRutas.TACOMETRO_EXTENDED
						+ obtImgExtend(score.getValor() != null ? Integer.valueOf(score.getValor()) : 0)
						+ ConstantesRutas.TACOMETRO_EXTENSION;
			} else if(score.getNombreScore() != null && "FIS".equals(score.getNombreScore())) {
				score.setNombreScore("   FIS Score");
				url = ConstantesRutas.TACOMETRO_FIS
						+ obtImgFis(score.getValor() != null ? Integer.valueOf(score.getValor()) : 0)
						+ ConstantesRutas.TACOMETRO_EXTENSION_PNG;
			} else {
				score.setNombreScore("FICO  Score");
				url = ConstantesRutas.TACOMETRO_FICO
						+ obtImgFico(score.getValor() != null ? Integer.valueOf(score.getValor()) : 0)
						+ ConstantesRutas.TACOMETRO_EXTENSION;
			}
		}

		return url;
	}
	
	public String obtImgFis(int valor) {
		String imagen;
		if (valor == 0) {
			imagen = "FIS0";
		} else if (valor == 400) {
			imagen = "400";
		} else if (valor >= 401 && valor <= 406) {
			imagen = "406";
		} else if (valor >= 407 && valor <= 433) {
			imagen = "433";
		} else if (valor >= 434 && valor <= 480) {
			imagen = "480";
		} else if (valor >= 481  && valor <= 499) {
			imagen = "499";
		} else if (valor >= 500  && valor <= 518) {
			imagen = "518";
		}else if (valor >= 519  && valor <= 538) {
			imagen = "538";
		} else if (valor >= 539  && valor <= 560) {
			imagen = "560";
		} else if (valor >= 561  && valor <= 584) {
			imagen = "584";
		} else if (valor >= 585  && valor <= 598) {
			imagen = "598";
		} else if (valor >= 599  && valor <= 614) {
			imagen = "614";
		} else if (valor >= 615  && valor <= 640) {
			imagen = "640";
		} else if (valor >= 641  && valor <= 654) {
			imagen = "654";
		} else if (valor >= 655  && valor <= 664) {
			imagen = "664";
		} else if (valor >= 665  && valor <= 690) {
			imagen = "690";
		} else if (valor >= 691  && valor <= 720) {
			imagen = "720";
		} else if (valor >= 721  && valor <= 740) {
			imagen = "740";
		} else if (valor >= 741  && valor <= 760) {
			imagen = "760";
		} else if (valor >= 761  && valor <= 780) {
			imagen = "780";
		} else if (valor >= 781  && valor <= 800) {
			imagen = "800";
		} else if (valor > 800) {
			imagen = "820";
		} else {
			imagen = "FIS0";
		}
		return imagen;
	}
	
	public String obtImgExtend(int valor) {
		String imagen;
		if (valor == 0) {
			imagen = "00";
		} else if (valor >= 300 && valor <= 314) {
			imagen = "01";
		} else if (valor >= 315 && valor <= 342) {
			imagen = "02";
		} else if (valor >= 343 && valor <= 369) {
			imagen = "03";
		} else if (valor >= 370 && valor <= 397) {
			imagen = "04";
		} else if (valor >= 398 && valor <= 424) {
			imagen = "05";
		} else if (valor >= 425 && valor <= 452) {
			imagen = "06";
		} else if (valor >= 453 && valor <= 479) {
			imagen = "07";
		} else if (valor >= 480 && valor <= 507) {
			imagen = "08";
		} else if (valor >= 508 && valor <= 534) {
			imagen = "09";
		} else if (valor >= 535 && valor <= 562) {
			imagen = "10";
		} else if (valor >= 563 && valor <= 589) {
			imagen = "11";
		} else if (valor >= 590 && valor <= 617) {
			imagen = "12";
		} else if (valor >= 618 && valor <= 644) {
			imagen = "13";
		} else if (valor >= 645 && valor <= 672) {
			imagen = "14";
		} else if (valor >= 673 && valor <= 699) {
			imagen = "15";
		} else if (valor >= 700 && valor <= 727) {
			imagen = "16";
		} else if (valor >= 728 && valor <= 754) {
			imagen = "17";
		} else if (valor >= 755 && valor <= 782) {
			imagen = "18";
		} else if (valor >= 783 && valor <= 809) {
			imagen = "19";
		} else if (valor >= 810 && valor <= 837) {
			imagen = "20";
		} else if (valor >= 838 && valor <= 850) {
			imagen = "21";
		} else {
			imagen = "default";
		}
		return imagen;
	}

	public String obtImgFico(int valor) {
		String imagen;
		if (valor == 0) {
			imagen = "00";
		} else if (valor >= 300 && valor <= 310) {
			imagen = "01";
		} else if (valor >= 311 && valor <= 330) {
			imagen = "02";
		} else if (valor >= 331 && valor <= 350) {
			imagen = "03";
		} else if (valor >= 351 && valor <= 370) {
			imagen = "04";
		} else if (valor >= 371 && valor <= 390) {
			imagen = "05";
		} else if (valor >= 391 && valor <= 410) {
			imagen = "06";
		} else if (valor >= 411 && valor <= 430) {
			imagen = "07";
		} else if (valor >= 431 && valor <= 450) {
			imagen = "08";
		} else if (valor >= 451 && valor <= 470) {
			imagen = "09";
		} else if (valor >= 471 && valor <= 490) {
			imagen = "10";
		} else if (valor >= 490 && valor <= 510) {
			imagen = "11";
		} else if (valor >= 511 && valor <= 530) {
			imagen = "12";
		} else if (valor >= 531 && valor <= 550) {
			imagen = "13";
		} else if (valor >= 551 && valor <= 570) {
			imagen = "14";
		} else if (valor >= 571 && valor <= 590) {
			imagen = "15";
		} else if (valor >= 591 && valor <= 610) {
			imagen = "16";
		} else if (valor >= 611 && valor <= 630) {
			imagen = "17";
		} else if (valor >= 631 && valor <= 650) {
			imagen = "18";
		} else if (valor >= 651 && valor <= 670) {
			imagen = "19";
		} else if (valor >= 671 && valor <= 690) {
			imagen = "20";
		} else if (valor >= 691 && valor <= 710) {
			imagen = "21";
		} else if (valor >= 711 && valor <= 730) {
			imagen = "22";
		} else if (valor >= 731 && valor <= 750) {
			imagen = "23";
		} else if (valor >= 751 && valor <= 770) {
			imagen = "24";
		} else if (valor >= 771 && valor <= 790) {
			imagen = "25";
		} else if (valor >= 791 && valor <= 810) {
			imagen = "26";
		} else if (valor >= 811 && valor <= 830) {
			imagen = "27";
		} else if (valor >= 831 && valor <= 850) {
			imagen = "28";
		} else {
			imagen = "default";
		}
		return imagen;
	}

	public Cuenta obtenerClaveObservacion(Cuenta cuenta, Map<String, String> catalogo) {
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

	public Respuesta obtProd(Respuesta respuesta, Map<String, String> catalogo) {
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

	public Respuesta obtProdCred(Respuesta respuesta, Map<String, String> catalogo, String nombreCatalogo, CatalogosDTO catalogos) {
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
						cuenta = this.obtenerClaveObservacion(cuenta, catalogos.getCatalogoCveObs());
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
	

	public Respuesta obtenerRazonScore(Respuesta respuesta, CatalogosDTO catalogos) {
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
					String descripcionRazonFIS = this.obtenerRazonesFIS(score.getRazon1());
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
					String descripcionRazonFIS = this.obtenerRazonesFIS(score.getRazon2());
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
					String descripcionRazonFIS = this.obtenerRazonesFIS(score.getRazon3());
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
					String descripcionRazonFIS = this.obtenerRazonesFIS(score.getRazon4());
					descripcionRazones.setRazon4(score.getRazon4());
					descripcionRazones.setRazonDescripcion4(descripcionRazonFIS);
				}
			}
			respuesta.getPersonas().getPersona().setDescripcionRazones(descripcionRazones);
		}

		return respuesta;
	}
	
	private String obtenerRazonesFIS (String razon) {
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
}
