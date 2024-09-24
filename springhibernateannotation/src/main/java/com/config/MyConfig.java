package com.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.dao","com.service"})
@EnableTransactionManagement
public class MyConfig {
	@Bean
	public LocalSessionFactoryBean meth() {
		LocalSessionFactoryBean obj = new LocalSessionFactoryBean();
		obj.setPackagesToScan("com.model");
		obj.setDataSource(meth1());
		obj.setHibernateProperties(meth2());
		return obj;
	}
	private DriverManagerDataSource meth1() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dmds.setUsername("root");
		dmds.setPassword("Mysqsk45@123");
		return dmds;
	}
	private Properties meth2() {
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect.class");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.format_sql", "true");
		return p;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager meth3() {
		return new HibernateTransactionManager(meth().getObject());
	}
}
