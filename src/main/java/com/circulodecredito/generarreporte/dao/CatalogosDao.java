package com.circulodecredito.generarreporte.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.circulodecredito.generarreporte.beans.CatalogosDTO;
import com.circulodecredito.generarreporte.constantes.ConstantesSP;

import oracle.jdbc.OracleTypes;

@Repository
public class CatalogosDao extends GenericDao {
	
	//static final Logger LOGG = Logger.getLogger("generarReporteLog");
	
//	public CatalogosDTO llenaCatalogos() {
//		HashMap<String, String> catalogoProducto = new HashMap<String, String>();
//		HashMap<String, Float> catalogoCambio = new HashMap<String, Float>();
//		HashMap<String, String> catalogoResponsabilidad = new HashMap<String, String>();
//		HashMap<String, String> catalogoCveObs = new HashMap<String, String>();
//		HashMap<String, String> catalogoCuenta = new HashMap<String, String>();
//		HashMap<String, String> catalogoCodigoScore = new HashMap<String, String>();
//		Connection conn = null;
//		CallableStatement cstmt = null;
//		ResultSet rs = null;
//		CatalogosDTO catalogos = new CatalogosDTO();
//		try {
//			conn = getJdbcTemplate().getDataSource().getConnection();
//			cstmt = conn.prepareCall(ConstantesSP.SP_CATALOGOS);
//			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
//			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
//			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
//			cstmt.registerOutParameter(4, OracleTypes.CURSOR);
//			cstmt.registerOutParameter(5, OracleTypes.CURSOR);
//			cstmt.registerOutParameter(6, OracleTypes.CURSOR);
//			cstmt.execute();
//			
//			rs = (ResultSet) cstmt.getObject(1);
//			while (rs.next()) {
//				catalogoCambio.put(rs.getString("ID"), rs.getFloat("NUM_CAMBIO"));
//			}
//			rs.close();
//			rs = (ResultSet) cstmt.getObject(2);
//			while (rs.next()) {
//				catalogoResponsabilidad.put(rs.getString("CTIPORESPCVE"), rs.getString("VCTIPORESPDESC"));
//			}
//			rs.close();
//			rs = (ResultSet) cstmt.getObject(3);
//			while (rs.next()) {
//				catalogoCveObs.put(rs.getString("CTIPOOBSCVE"), rs.getString("VCTIPOOBSDESC"));
//			}
//			rs.close();
//			rs = (ResultSet) cstmt.getObject(4);
//			while (rs.next()) {
//				catalogoCuenta.put(rs.getString("CTIPOCTACVE"), rs.getString("VCTIPOCTADESC"));
//			}
//			rs.close();
//			rs = (ResultSet) cstmt.getObject(5);
//			while (rs.next()) {
//				catalogoCodigoScore.put(rs.getString("CVE_CODIGO"), rs.getString("DES_CODIGO"));
//			}
//			rs.close();
//			rs = (ResultSet) cstmt.getObject(6);
//			while (rs.next()) {
//				catalogoProducto.put(rs.getString("CTIPOCONTRACVE"), rs.getString("VCTIPOCONTRADESC"));
//			}
//			rs.close();
//			conn.close();
//			cstmt.close();
//			catalogos.setCatalogoCambio(catalogoCambio);
//			catalogos.setCatalogoCveObs(catalogoCveObs);
//			catalogos.setCatalogoCuenta(catalogoCuenta);
//			catalogos.setCatalogoProducto(catalogoProducto);
//			catalogos.setCatalogoCodigoScore(catalogoCodigoScore);
//			catalogos.setCatalogoResponsabilidad(catalogoResponsabilidad);
//		} catch(SQLException ex) {
//			LOGG.error("SQLException" + ex.toString());
//			System.out.println(ex);
//		} catch(Exception ex) {
//			LOGG.error("Exception" + ex.toString());
//			System.out.println(ex);
//		} finally {
//			try {
//				if(conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//				if(cstmt != null && !cstmt.isClosed()) {
//					cstmt.close();
//				}
//				if(rs != null && !rs.isClosed()) {
//					rs.close();
//				}
//			} catch(SQLException ex) {
//				LOGG.error("SQLException" + ex.toString());
//				System.out.println(ex);
//			} catch(Exception ex) {
//				LOGG.error("Exception" + ex.toString());
//				System.out.println(ex);
//			}
//		}
//		return catalogos;
//	}
	
	
	public CatalogosDTO llenaCatalogos() {
		HashMap<String, String> catalogoProducto = new HashMap<String, String>();
		HashMap<String, Float> catalogoCambio = new HashMap<String, Float>();
		HashMap<String, String> catalogoResponsabilidad = new HashMap<String, String>();
		HashMap<String, String> catalogoCveObs = new HashMap<String, String>();
		HashMap<String, String> catalogoCuenta = new HashMap<String, String>();
		HashMap<String, String> catalogoCodigoScore = new HashMap<String, String>();
		
		CatalogosDTO catalogos = new CatalogosDTO();
		
		try {
			
			//CATALOGOTIPOCAMBIO
			catalogoCambio.put("US",19.8823f);
			catalogoCambio.put("UD",6.814659f);
			catalogoCambio.put("MX",1f);

			//CATALOGO RESPONSABILIDAD
			catalogoResponsabilidad.put("I", "INDIVIUDAL");
			catalogoResponsabilidad.put("M", "MANCOMUNADO");
			catalogoResponsabilidad.put("O", "OBLIGATORIO SOLIDARI");
			catalogoResponsabilidad.put("A", "AVAL");
			catalogoResponsabilidad.put("U", "Usuario Adicional");
			catalogoResponsabilidad.put("T", "TITULAR CON AVAL");
			catalogoResponsabilidad.put("S", "ACCIONISTA");
			
			//CATALOGO CVE OBSERVACION
			catalogoCveObs.put("AD", "CUENTA O MONTO EN ACLARACI??N");
			catalogoCveObs.put("CA", "CARTERA AL CORRIENTE VENDIDA O CEDIDA A UN USUARIO DE UNA SOCIEDAD");
			catalogoCveObs.put("CC", "CUENTA CANCELADA O CERRADA");
			catalogoCveObs.put("CI", "ELIMINADA");
			catalogoCveObs.put("CL", "CUENTA CERRADA QUE ESTUVO EN COBRANZA Y FUE PAGADA TOTALMENTE SIN CAUSAR QUEBRANTO");
			catalogoCveObs.put("CM", "ELIMINADA");
			catalogoCveObs.put("CP", "ELIMINADA");
			catalogoCveObs.put("CR", "ELIMINADA");
			catalogoCveObs.put("CV", "CUENTA QUE NO EST?? AL CORRIENTE VENDIDA O CEDIDA A UN USUARIO DE UNA SOCIEDAD");
			catalogoCveObs.put("CZ", "ELIMINADA");
			catalogoCveObs.put("DP", "ELIMINADA");
			catalogoCveObs.put("DR", "ELIMINADA");
			catalogoCveObs.put("FD", "CUENTA FRAUDULENTA");
			catalogoCveObs.put("FN", "FRAUDE NO ATRIBUIBLE AL CONSUMIDOR");
			catalogoCveObs.put("FP", "FIANZA PAGADA");
			catalogoCveObs.put("FR", "ADJUDICACI??N O APLICACI??N DE GARANT??A");
			catalogoCveObs.put("IA", "CUENTA INACTIVA");
			catalogoCveObs.put("IR", "ELIMINADA");
			catalogoCveObs.put("LC", "CONVENIO DE FINIQUITO O PAGO MENOR ACORDADO CON EL CONSUMIDOR");
			catalogoCveObs.put("LS", "TARJETA DE CR??DITO EXTRAVIADA O ROBADA");
			catalogoCveObs.put("MD", "ELIMINADA");
			catalogoCveObs.put("PC", "CUENTA EN  COBRANZA");
			catalogoCveObs.put("PD", "PRORROGA OTORGADA DEBIDO A UN DESASSTRE NATURAL");
			catalogoCveObs.put("PL", "ELIMINADA");
			catalogoCveObs.put("PS", "ELIMINADA");
			catalogoCveObs.put("RC", "ELIMINADA");
			catalogoCveObs.put("RE", "ELIMINADA");
			catalogoCveObs.put("RF", "RESOLUCI??N JUDICIAL FAVORABLE AL CLIENTE");
			catalogoCveObs.put("RR", "ELIMINADA");
			catalogoCveObs.put("RV", "CUENTA REESTRUCTURADA SIN PAGO MENOR POR MODIFICACI??N DE LA SITUACI??N DEL CLIENTE, A PETICI??N");
			catalogoCveObs.put("SC", "ELIMINADA");
			catalogoCveObs.put("SG", "DEMANDA POR EL OTORGANTE");
			catalogoCveObs.put("SL", "ELIMINADA");
			catalogoCveObs.put("SP", "ELIMINADA");
			catalogoCveObs.put("ST", "ELIMINADA");
			catalogoCveObs.put("SU", "ELIMINADA");
			catalogoCveObs.put("TC", "ELIMINADA");
			catalogoCveObs.put("TL", "ELIMINADA");
			
			
			//CATALOGO CUENTA
			catalogoCuenta.put("F", "PAGOS FIJOS");
			catalogoCuenta.put("H", "HIPOTECA");
			catalogoCuenta.put("L", "SIN LIMITE PREESTABL");
			catalogoCuenta.put("R", "REVOLVENTE");
			catalogoCuenta.put("M", "MONITOREO");
			catalogoCuenta.put("Q", "QUIROGRAFARIO");
			catalogoCuenta.put("A", "HABILITACION DE AVIO");
			catalogoCuenta.put("E", "REFACCIONARIO");
			catalogoCuenta.put("P", "PRENDARIO");
			
			
			
			//CATALOGO CODIGO SCORE
			catalogoCodigoScore.put("A0", "El historial de pago de la cuenta es demasiado reciente para su clasificaci??n");
			catalogoCodigoScore.put("A1", "Ultimo reporte de la Cuenta con estatus de morosidad.");
			catalogoCodigoScore.put("A2", "Monto de cr??dito disponible en cuenta(s) revolvente(s).");
			catalogoCodigoScore.put("A3", "El monto de deuda en cuentas es demasiado alto.");
			catalogoCodigoScore.put("A5", "Monto de deuda en cuentas enviadas a cobranza.");
			catalogoCodigoScore.put("A6", "Monto de deuda en cuentas morosas.");
			catalogoCodigoScore.put("A7", "El monto de deuda en cuentas abiertas recientemente es demasiado alto.");
			catalogoCodigoScore.put("B5", "Monto de deuda en cuentas de cr??dito revolventes demasiado alto.");
			catalogoCodigoScore.put("B6", "Saldo vencido en cuentas.");
			catalogoCodigoScore.put("D0", "Declaraci??n de quiebra reportada.");
			catalogoCodigoScore.put("D1", "Fecha de la ??ltima consulta muy reciente.");
			catalogoCodigoScore.put("D2", "Morosidad en cuentas.");
			catalogoCodigoScore.put("D3", "Morosidad en cuentas abiertas recientemente.");
			catalogoCodigoScore.put("D4", "Registro p??blico adverso o cobranza reportada.");
			catalogoCodigoScore.put("D5", "Morosidad frecuente.");
			catalogoCodigoScore.put("D6", "Nivel de morosidad en cuentas.");
			catalogoCodigoScore.put("D7", "Morosidad grave.");
			catalogoCodigoScore.put("D8", "Morosidad grave, registro p??blico adverso o cobranza reportada.");
			catalogoCodigoScore.put("E0", "Informaci??n Demogr??fica.");
			catalogoCodigoScore.put("E1", "Falta informaci??n demogr??fica.");
			catalogoCodigoScore.put("E2", "N??mero de consultas.");
			catalogoCodigoScore.put("E3", "Frecuencia de consultas.");
			catalogoCodigoScore.put("E4", "Falta de informaci??n reciente de la cuenta");
			catalogoCodigoScore.put("E5", "Monto de deuda en lo registro p??blico adverso.");
			catalogoCodigoScore.put("E6", "Proporci??n del saldo respecto al l??mite de cr??dito en cuenta(s).");
			catalogoCodigoScore.put("F0", "Historial de pagos fijos insuficiente.");
			catalogoCodigoScore.put("F1", "Falta de cuentas de cr??dito de reciente creaci??n.");
			catalogoCodigoScore.put("F3", "Falta de informaci??n reciente de pr??stamo de autofinanciamiento.");
			catalogoCodigoScore.put("F4", "Falta de informaci??n reciente de pr??stamo de auto.");
			catalogoCodigoScore.put("F7", "Falta de informaci??n reciente de pr??stamos a plazo fijo.");
			catalogoCodigoScore.put("F8", "Falta de informaci??n reciente de pr??stamos hipotecarios.");
			catalogoCodigoScore.put("G1", "Falta de informaci??n reciente de cuentas revolventes.");
			catalogoCodigoScore.put("G6", "No hay saldos revolventes recientes.");
			catalogoCodigoScore.put("J0", "Antig??edad desde la apertura de cuenta(s).");
			catalogoCodigoScore.put("J4", "Antig??edad desde la apertura de pr??stamos a plazo fijo.");
			catalogoCodigoScore.put("J5", "Antig??edad desde la apertura de cuenta(s) hipotecaria(s).");
			catalogoCodigoScore.put("J8", "Antig??edad desde la apertura de cuenta(s) revolvente(s).");
			catalogoCodigoScore.put("K0", "Tiempo transcurrido desde la Morosidad es demasiado reciente o desconocido.");
			catalogoCodigoScore.put("K1", "Tiempo transcurrido desde el registro p??blico adverso o de la cobranza es demasiado corto.");
			catalogoCodigoScore.put("K2", "Tiempo transcurrido desde la apertura de cuenta m??s reciente es demasiado corto.");
			catalogoCodigoScore.put("K6", "Tiempo transcurrido desde la apertura de cuenta(s) de pr??stamo a plazo fijo m??s reciente es demasiado corto.");
			catalogoCodigoScore.put("M1", "Cantidad de Cuentas en mora.");
			catalogoCodigoScore.put("M5", "Cantidad de Registros p??blicos adversos o negativos.");
			catalogoCodigoScore.put("M9", "Cantidad de Cuentas enviadas a cobranza.");
			catalogoCodigoScore.put("N2", "Cantidad de Cuentas abiertas.");
			catalogoCodigoScore.put("N3", "Cantidad de Pr??stamos abiertos a plazo fijo.");
			catalogoCodigoScore.put("N7", "Cantidad de Cuentas revolventes.");
			catalogoCodigoScore.put("N8", "Cantidad de Cuentas revolventes con saldo superior al l??mite.");
			catalogoCodigoScore.put("P1", "Proporci??n del saldo respecto al l??mite para cuentas morosas demasiado alto.");
			catalogoCodigoScore.put("P6", "Proporci??n del saldo respecto al l??mite para cuentas revolventes demasiado alto.");
			catalogoCodigoScore.put("P9", "Proporci??n del saldo de Pr??stamos respecto al Monto de los Pr??stamos demasiado alto.");
			catalogoCodigoScore.put("Q0", "Proporci??n del saldo revolvente respecto de saldos totales demasiado alto.");
			catalogoCodigoScore.put("R0", "Muy pocas cuentas con pagos al corriente seg??n lo acordado.");
			catalogoCodigoScore.put("R1", "Muy pocas cuentas con saldos.");
			catalogoCodigoScore.put("R2", "Muy pocas cuentas con informaci??n de pago reciente.");
			catalogoCodigoScore.put("R3", "Muy pocas cuentas activas.");
			catalogoCodigoScore.put("R7", "Muy pocas cuentas a plazo fijo.");
			catalogoCodigoScore.put("S0", "Muy pocas cuentas de cr??dito revolvente.");
			catalogoCodigoScore.put("T0", "Demasiadas cuentas abiertas recientemente.");
			catalogoCodigoScore.put("T1", "Demasiadas cuentas con saldos.");
			catalogoCodigoScore.put("T4", "Demasiadas cuentas a plazo fijo.");
			catalogoCodigoScore.put("T5", "Demasiadas consultas en los ??ltimos 12 meses.");
			catalogoCodigoScore.put("T6", "Demasiadas cuentas activadas recientemente.");
			catalogoCodigoScore.put("U4", "Demasiadas cuentas abiertas recientemente con saldos.");
			catalogoCodigoScore.put("U7", "Demasiadas cuentas a plazo fijo abiertas recientemente.");
			catalogoCodigoScore.put("V3", "Demasiadas cuentas revolventes.");
			catalogoCodigoScore.put("X0", "Cuentas con pagos vencidos.");
			catalogoCodigoScore.put("C1", "No existe el expediente.");
			catalogoCodigoScore.put("C2", "El expediente encontrado no tiene cuentas.");
			catalogoCodigoScore.put("C3", "El expediente encontrado est?? marcado como fallecido.");
			catalogoCodigoScore.put("C4", "El expediente encontrado no tiene cuentas activas en los ??ltimos 24 meses.");
			catalogoCodigoScore.put("C5", "El titular del expediente encontrado est?? marcado como fraudulento.");
			catalogoCodigoScore.put("A9", "El monto de deuda en cuenta(s) abierta(s) recientemente en  financieras para el consumidor es demasiado alto");
			catalogoCodigoScore.put("B0", "El monto de deuda en cuenta(s) abierta(s) de consumo es demasiado algo");
			catalogoCodigoScore.put("B1", "El monto de deuda en cuenta(s) abierta(s) de cargo(s) revolvente es demasiado alto");
			catalogoCodigoScore.put("B2", "El monto de deuda en cuenta(s) abierta(s) en compa????as de finanzas al consumidor es demasiado alto");
			catalogoCodigoScore.put("B3", "Monto de deuda en cuenta(s) de consumo");
			catalogoCodigoScore.put("B4", "Monto de deuda en cuenta(s) revolente");
			catalogoCodigoScore.put("B7", "El monto de deuda en cuenta(s) revolvente es demasiado alto");
			catalogoCodigoScore.put("D9", "Morosidad en cuenta relacionada");
			catalogoCodigoScore.put("D10", "Morosidad en prestamo relacionado");
			catalogoCodigoScore.put("D11", "Morosidad reciente en cuenta relacionada");
			catalogoCodigoScore.put("D12", "Morosidad en prestamo de consumo");
			catalogoCodigoScore.put("D13", "Morosidad relacionado al pago semanal del cr??dito");
			catalogoCodigoScore.put("D14", "Morosidad en pago semanal del cr??dito");
			catalogoCodigoScore.put("E7", "Frecuencia de consultas relacionadas.");
			catalogoCodigoScore.put("E8", "Informaci??n insuficiente");
			catalogoCodigoScore.put("F2", "Falta de informaci??n reciente en cuenta(s) revolventes");
			catalogoCodigoScore.put("F6", "Falta de informaci??n reciente en cuenta(s) en financieras para el consumidor");
			catalogoCodigoScore.put("G0", "Falta de informaci??n reciente en cuenta(s) al consumo");
			catalogoCodigoScore.put("G2", "Sin pr??stamos hipotecarios");
			catalogoCodigoScore.put("G4", "Sin informaci??n reciente de balances hipotecarios");
			catalogoCodigoScore.put("G5", "Sin balances recientes de consumo");
			catalogoCodigoScore.put("G7", "Sin previa mora en pago");
			catalogoCodigoScore.put("G8", "Sin cuenta(s) con pago semanal");
			catalogoCodigoScore.put("J1", "Antig??edad desde la apertura de cuenta(s) automotrices");
			catalogoCodigoScore.put("J3", "Antig??edad desde la apertura de cuenta(s) de cr??ditos en financieras al consumidor");
			catalogoCodigoScore.put("J6", "Antig??edad desde la apertura en cuenta(s) abierta(s).");
			catalogoCodigoScore.put("J7", "Antig??edad desde la apertura en cuenta(s) al consumo");
			catalogoCodigoScore.put("J10", "Antig??edad desde la apertura en el hogar");
			catalogoCodigoScore.put("K3", "Tiempo transcurrido desde la apertura de cuenta(s) de automotriz m??s reciente es demasiado corto.");
			catalogoCodigoScore.put("K5", "Tiempo transcurrido desde la apertura de cuenta(s) en financieras para el consumidor m??s reciente es demasiado corto.");
			catalogoCodigoScore.put("K7", "Tiempo transcurrido desde la apertura de cuenta(s) al consumo m??s reciente es demasiado corto.");
			catalogoCodigoScore.put("K8", "Tiempo transcurrido desde la apertura de cuenta(s) revolvente(s) m??s reciente es demasiado corto.");
			catalogoCodigoScore.put("K9", "Tiempo transcurrido desde la apertura de cuenta(s) en compa????as de finanzas m??s reciente es demasiado corto.");
			catalogoCodigoScore.put("K10", "Tiempo relacionado desde la Morosidad es demasiado reciente o desconocido.");
			catalogoCodigoScore.put("M0", "Cantidad de Cuentas actualmente con estatus de mora.");
			catalogoCodigoScore.put("M2", "Cantidad de Cuentas actualmente con reciente mora.");
			catalogoCodigoScore.put("M4", "Cantidad de Cuentas de consumo activa");
			catalogoCodigoScore.put("M6", "Cantidad de Registros de impago");
			catalogoCodigoScore.put("M10", "Cantidad de Registros relacionados negativos.");
			catalogoCodigoScore.put("N0", "Cantidad de Cuentas abiertas en financieras para el consumidor relacionados al periodo  de financiamientos al consumo");
			catalogoCodigoScore.put("N1", "Cantidad de consultas en financieras para el consumidor.");
			catalogoCodigoScore.put("N4", "Cantidad de Cuentas recientes en financieras para el cosumidor");
			catalogoCodigoScore.put("N5", "Cantidad de Cuentas de consumo");
			catalogoCodigoScore.put("N6", "Cantidad de Balances en Cuentas de consumo");
			catalogoCodigoScore.put("N9", "Cantidad en Cuentas abiertas");
			catalogoCodigoScore.put("N10", "Cantidad en Cuentas con pagos semanales");
			catalogoCodigoScore.put("P0", "Proporci??n del saldo respecto al l??mite para cuenta(s) demasiado alto.");
			catalogoCodigoScore.put("P2", "Proporci??n del saldo respecto al l??mite para cuenta(s) en financieras para el consumidor  es muy alto");
			catalogoCodigoScore.put("P3", "Proporci??n del saldo respecto al l??mite para cuenta(s) de consumo es muy alto");
			catalogoCodigoScore.put("P7", "Proporci??n del saldo respecto al l??mite para cuenta(s) de compa????a de finanzas es muy alto");
			catalogoCodigoScore.put("P8", "Proporci??n del saldo respecto al l??mite para montos de pr??stamos es muy alto");
			catalogoCodigoScore.put("R6", "Muy pocas cuentas de financieras para el consumidor con informaci??n de pago reciente");
			catalogoCodigoScore.put("R8", "Muy pocas cuentas de consumo.");
			catalogoCodigoScore.put("R9", "Muy pocas cuentas de consumo con informaci??n de pago reciente.");
			catalogoCodigoScore.put("R10", "Muy pocas cuentas relacionadas pagadas al corriente");
			catalogoCodigoScore.put("S1", "Muy pocas cuentas de cr??dito revolvente con informaci??n de pago reciente");
			catalogoCodigoScore.put("S2", "Muy pocas cuentas de compa????as de finanzas con informaci??n de pago reciente");
			catalogoCodigoScore.put("T3", "Demasidas cuentas en financieras para el consumidor");
			catalogoCodigoScore.put("T7", "Demasiadas cuentas activadas de auto recientemente.");
			catalogoCodigoScore.put("T9", "Demasiadas cuentas activadas recientemente en financieras para el consumidor");
			catalogoCodigoScore.put("U0", "Demasiadas cuentas activadas recientemente de pr??stamos");
			catalogoCodigoScore.put("U1", "Demasiadas cuentas activadas recientemente de consumo");
			catalogoCodigoScore.put("U2", "Demasiadas cuentas activadas en compa????a de finanzas");
			catalogoCodigoScore.put("U6", "Demasiadas cuentas abiertas recientemente en financieras para el consumidor");
			catalogoCodigoScore.put("U8", "Demasiadas cuentas de consumo recientemente abiertas con saldos");
			catalogoCodigoScore.put("U9", "Demasiadas cuentas revolventes recientemente abiertas");
			catalogoCodigoScore.put("V0", "Demasiadas cuentas revolventes recientemente abiertas con saldos");
			catalogoCodigoScore.put("V1", "Demasiadas cuentas recientemente abiertas en compa????as financieras");
			catalogoCodigoScore.put("V2", "Demasiadas cuentas de consumo");
			catalogoCodigoScore.put("W4", "Falta de informaci??n reciente en cargos de tarjetas");
			catalogoCodigoScore.put("W5", "Sin saldos recientes en tarjetas");
			catalogoCodigoScore.put("W6", "Proporci??n de saldos a los l??mites de cr??dito en cargos de tarjetas es muy alta");
			catalogoCodigoScore.put("A0", "El historial de pago de la(s) cuenta(s) es demasiado reciente para su clasificaci??n");
			catalogoCodigoScore.put("A1", "??ltimo reporte de la(s) cuenta(s) con estatus de morosidad.");
			catalogoCodigoScore.put("A2", "Monto de cr??dito disponible en cuenta(s) revolvente(s).");
			catalogoCodigoScore.put("A3", "El monto de deuda en cuenta(s) es demasiado alto.");
			catalogoCodigoScore.put("A5", "Monto de deuda en cuenta(s) enviada(s) a cobranza.");
			catalogoCodigoScore.put("A6", "Monto de deuda en cuenta(s) morosa(s).");
			catalogoCodigoScore.put("A7", "El monto de deuda en cuenta(s) abierta(s) recientemente es demasiado alto.");
			catalogoCodigoScore.put("B5", "Monto de deuda en cuenta(s) de cr??dito(s) revolvente(s) demasiado alto.");
			catalogoCodigoScore.put("B6", "Saldo vencido en cuenta(s).");
			catalogoCodigoScore.put("D0", "Declaraci??n de quiebra reportada.");
			catalogoCodigoScore.put("D1", "Fecha de la ??ltima consulta muy reciente.");
			catalogoCodigoScore.put("D2", "Morosidad en cuenta(s).");
			catalogoCodigoScore.put("D3", "Morosidad en cuenta(s) abierta(s) recientemente.");
			catalogoCodigoScore.put("D4", "Registro(s) p??blico(s) adverso(s) o cobranza reportada.");
			catalogoCodigoScore.put("D5", "Morosidad frecuente.");
			catalogoCodigoScore.put("D6", "Nivel de morosidad en cuentas.");
			catalogoCodigoScore.put("D7", "Morosidad grave.");
			catalogoCodigoScore.put("D8", "Morosidad grave, registro p??blico adverso o cobranza reportada.");
			catalogoCodigoScore.put("E0", "Informaci??n Demogr??fica.");
			catalogoCodigoScore.put("E1", "Falta informaci??n demogr??fica.");
			catalogoCodigoScore.put("E2", "N??mero de consultas.");
			catalogoCodigoScore.put("E3", "Frecuencia de consultas.");
			catalogoCodigoScore.put("E4", "Falta de informaci??n reciente de la(s) cuenta(s)");
			catalogoCodigoScore.put("E5", "Monto de deuda en registro(s) p??blico(s) adverso(s).");
			catalogoCodigoScore.put("E6", "Proporci??n del saldo respecto al l??mite de cr??dito en cuenta(s).");
			catalogoCodigoScore.put("F0", "Historial de pagos fijos insuficiente.");
			catalogoCodigoScore.put("F1", "Falta de cuentas de cr??dito de reciente creaci??n.");
			catalogoCodigoScore.put("F3", "Falta de informaci??n reciente de pr??stamo(s) de autofinanciamiento.");
			catalogoCodigoScore.put("F4", "Falta de informaci??n reciente de pr??stamo(s) de auto.");
			catalogoCodigoScore.put("F7", "Falta de informaci??n reciente de pr??stamo(s) a plazo fijo.");
			catalogoCodigoScore.put("F8", "Falta de informaci??n reciente de pr??stamo(s) hipotecarios.");
			catalogoCodigoScore.put("F9", "Falta de informaci??n reciente de pr??stamo(s) con garant??a(s).");
			catalogoCodigoScore.put("G1", "Falta de informaci??n reciente de cuentas revolventes.");
			catalogoCodigoScore.put("G6", "No hay saldos revolventes recientes.");
			catalogoCodigoScore.put("J0", "Antig??edad desde la apertura de cuenta(s).");
			catalogoCodigoScore.put("J4", "Antig??edad desde la apertura de pr??stamo(s) a plazo fijo.");
			catalogoCodigoScore.put("J5", "Antig??edad desde la apertura de cuenta(s) hipotecaria(s).");
			catalogoCodigoScore.put("J8", "Antig??edad desde la apertura de cuenta(s) revolvente(s).");
			catalogoCodigoScore.put("J9", "Antig??edad desde la apertura de cuenta(s) con garant??a(s).");
			catalogoCodigoScore.put("K0", "Tiempo transcurrido desde la Morosidad es demasiado reciente o desconocido.");
			catalogoCodigoScore.put("K1", "Tiempo transcurrido desde registro(s) p??blico(s) adverso(s) o cobranza es demasiado corto.");
			catalogoCodigoScore.put("K2", "Tiempo transcurrido desde la apertura de cuenta m??s reciente es demasiado corto.");
			catalogoCodigoScore.put("K6", "Tiempo transcurrido desde la apertura de cuenta(s) de pr??stamo a plazo fijo m??s reciente es demasiado corto");
			catalogoCodigoScore.put("M1", "Cantidad de Cuentas en mora.");
			catalogoCodigoScore.put("M5", "Cantidad de Registros p??blicos adversos o negativos");
			catalogoCodigoScore.put("M9", "Cantidad de Cuentas enviadas a cobranza.");
			catalogoCodigoScore.put("N2", "Cantidad de Cuentas abiertas.");
			catalogoCodigoScore.put("N3", "Cantidad de Pr??stamos abiertos a plazo fijo.");
			catalogoCodigoScore.put("N7", "Cantidad de Cuentas revolventes.");
			catalogoCodigoScore.put("N8", "Cantidad de Cuentas revolventes con saldo superior al l??mite.");
			catalogoCodigoScore.put("P1", "Proporci??n del saldo respecto al l??mite para cuenta(s) morosa(s) demasiado alto.");
			catalogoCodigoScore.put("P6", "Proporci??n del saldo respecto al l??mite para cuenta(s) revolvente(s) demasiado alto.");
			catalogoCodigoScore.put("P9", "Proporci??n del saldo de Pr??stamo(s) respecto al Monto de los Pr??stamo(s) demasiado alto.");
			catalogoCodigoScore.put("Q0", "Proporci??n del saldo(s) revolvente(s) respecto de saldo(s) total(s) demasiado alto.");
			catalogoCodigoScore.put("R0", "Muy pocas cuentas con pagos al corriente seg??n lo pactado.");
			catalogoCodigoScore.put("R1", "Muy pocas cuentas con saldos.");
			catalogoCodigoScore.put("R2", "Muy pocas cuentas con informaci??n de pago reciente.");
			catalogoCodigoScore.put("R3", "Muy pocas cuentas activas.");
			catalogoCodigoScore.put("R7", "Muy pocas cuentas a plazo fijo.");
			catalogoCodigoScore.put("S0", "Muy pocas cuentas de cr??dito revolvente.");
			catalogoCodigoScore.put("T0", "Demasiadas cuentas abiertas recientemente.");
			catalogoCodigoScore.put("T1", "Demasiadas cuentas con saldos.");
			catalogoCodigoScore.put("T4", "Demasiadas cuentas a plazo fijo.	");
			catalogoCodigoScore.put("T5", "Demasiadas consultas en los ??ltimos 12 meses.");
			catalogoCodigoScore.put("T6", "Demasiadas cuentas activadas recientemente.");
			catalogoCodigoScore.put("U4", "Demasiadas cuentas abiertas recientemente con saldos.");
			catalogoCodigoScore.put("U7", "Demasiadas cuentas recientemente abiertas de pr??stamos");
			catalogoCodigoScore.put("V3", "Demasiadas cuentas revolventes.");
			catalogoCodigoScore.put("X0", "Cuentas con pago(s) vencido(s).");
			
			
			//CATALOGO PRODUCTO
			catalogoProducto.put("AA", "ARRENDAMIENTO AUTOMOTRIZ");
			catalogoProducto.put("CA", "COMPRA DE AUTOMOVIL");
			catalogoProducto.put("FI", "FIANZA");
			catalogoProducto.put("TC", "TARJETA DE CREDITO");
			catalogoProducto.put("LC", "LINEA DE CREDITO");
			catalogoProducto.put("AR", "ARRENDAMIENTO");
			catalogoProducto.put("PP", "PRESTAMO PERSONAL");
			catalogoProducto.put("BR", "BIENES RAICES");
			catalogoProducto.put("TG", "TARJETA GARANTIZADA");
			catalogoProducto.put("CC", "CREDITO AL CONSUMO");
			catalogoProducto.put("HV", "HIPOTECARIO O VIVIENDA");
			catalogoProducto.put("ND", "NO DISPONIBLE");
			catalogoProducto.put("TS", "TARJETA DE SERVICIOS");
			catalogoProducto.put("TD", "TARJETA DEPARTAMENTAL");
			catalogoProducto.put("AM", "APARATOS/MUEBLES");
			catalogoProducto.put("AV", "AVIACI??N");
			catalogoProducto.put("BL", "BOTE/LANCHA");
			catalogoProducto.put("CO", "CONSOLIDACI??N");
			catalogoProducto.put("EQ", "EQUIPO");
			catalogoProducto.put("FT", "FACTORAJE");
			catalogoProducto.put("HE", "PR??STAMO TIPO HOME EQUITY");
			catalogoProducto.put("MC", "MEJORAS A LA CASA");
			catalogoProducto.put("OT", "OTROS (MULTIPLES CREDITOS)");
			catalogoProducto.put("ED", "EDITORIAL");
			catalogoProducto.put("VR", "VEH??CULO RECREATIVO");
			catalogoProducto.put("NG", "PR??STAMO NO GARANTIZADO");
			catalogoProducto.put("PG", "PR??STAMO GARANTIZADO");
			catalogoProducto.put("SH", "SEGUNDA HIPOTECA");
			catalogoProducto.put("PE", "PR??STAMO PARA ESTUDIANTE");
			catalogoProducto.put("NC", "DESCONOCIDO");
			catalogoProducto.put("HB", "HIPOTECARIO BANCARIO");
			catalogoProducto.put("AB", "AUTOMOTRIZ BANCARIO");
			catalogoProducto.put("PB", "PRESTAMO PERSONAL BANCARIO");
			catalogoProducto.put("UI", "USO INTERNO");
			catalogoProducto.put("PM", "PRESTAMO EMPRESARIAL");
			catalogoProducto.put("AE", "FISICA ACTIVIDAD EMPRESARIAL");
			catalogoProducto.put("PC", "PROCAMPO");
			catalogoProducto.put("BC", "BANCA COMUNAL");
			
			
			//AGREGA CATALOGOS
			catalogos.setCatalogoCambio(catalogoCambio);
			catalogos.setCatalogoCveObs(catalogoCveObs);
			catalogos.setCatalogoCuenta(catalogoCuenta);
			catalogos.setCatalogoProducto(catalogoProducto);
			catalogos.setCatalogoCodigoScore(catalogoCodigoScore);
			catalogos.setCatalogoResponsabilidad(catalogoResponsabilidad);
			
		} catch(Exception ex) {
			//LOGG.error("Exception" + ex.toString());
			System.out.println(ex);
		} 
		return catalogos;
	}


}
