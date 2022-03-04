package com.circulodecredito.generarreporte.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class GenericDao extends JdbcDaoSupport{
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	 @PostConstruct
	 private void initialize() {
		 setJdbcTemplate(jdbcTemplate);
	 }
	 
}
