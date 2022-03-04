package com.circulodecredito.generarreporte.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.log4j.Logger;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.circulodecredito.generarreporte.constantes.ConstantesSP;

import oracle.jdbc.OracleTypes;

@Repository
public class ConsultasDao extends GenericDao{
	
	//static final Logger LOGG = Logger.getLogger("generarReporteLog");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String consultarFolioBC(String folioConsulta){
		String folioConsultaBC = null;
		try{
			SimpleJdbcCall call = new SimpleJdbcCall(getJdbcTemplate())
					.withProcedureName(ConstantesSP.SP_CONSULTAR_FOLIO_BC)
					.declareParameters(new SqlParameter("p_FOLIO_CONSULTA", OracleTypes.VARCHAR),
							new SqlOutParameter("p_FOLIO_BC", OracleTypes.VARCHAR));
			Map params = new HashMap();
			params.put("p_FOLIO_CONSULTA", folioConsulta);
			Map result = call.execute(params);
			
			if(result != null && result.get("p_FOLIO_BC") != null){
				folioConsultaBC = (String) result.get("p_FOLIO_BC");
			}else{
				//LOGG.info("No encontro folio bc : "+folioConsulta);
			}
		}catch(Exception e){
			//LOGG.error("Error en la consulta de folio BC : ",e);
		}
		System.out.println("busqueda folio bc >>> con folioconsulta "+folioConsulta);
		return folioConsultaBC;
	}
}
