package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.dao"})
public class MyConfig {
	
	@Bean
	public JdbcTemplate meth1() {
		JdbcTemplate j = new JdbcTemplate();
		j.setDataSource(meth2());
		return j;
	}
	
	private DriverManagerDataSource meth2() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dmds.setUsername("root");
		dmds.setPassword("Mysqsk45@123");
		return dmds;
	}
}
