package com.circulodecredito.generarreporte.configuration;

import javax.naming.NamingException;
import javax.sql.DataSource;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

/**
 * Clase de Configuración Spring
 * 
 * @author Daniel Vargas Villanueva
 * @since  8/Enero/2019
 */
@Configuration
public class GenerarReporteBDConfig {

	//static final Logger LOGG = Logger.getLogger("generarReporteLog");
	@Value("${jndi.name}")
	private String jndiname;
	
	/**
	 * Conección con la base de Círculo
	 */
	@Bean
	public DataSource dataSource() {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		try {
			jndiObjectFactoryBean.setJndiName(jndiname);
			jndiObjectFactoryBean.setResourceRef(true);
			jndiObjectFactoryBean.setProxyInterface(DataSource.class);
			jndiObjectFactoryBean.afterPropertiesSet();
		} catch(IllegalArgumentException ex) {
			//LOGG.error(ex);
		} catch (NamingException ex) {
			//LOGG.error(ex);
		}
		return (DataSource) jndiObjectFactoryBean.getObject();
	}
	
	/**
	 * Crea el JdbcTemplate
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
}
