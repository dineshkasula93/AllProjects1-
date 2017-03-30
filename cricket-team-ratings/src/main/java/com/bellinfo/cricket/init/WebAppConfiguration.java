package com.bellinfo.cricket.init;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Configuration
@ComponentScan("com.bellinfo.cricket")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class WebAppConfiguration {

	
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";	
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW = "hibernate.show_sql";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA = "hibernate.default_schema";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		return dataSource;
	}
	
	
	private Properties hibProperties(){
		Properties prop = new Properties();
		prop.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		prop.put(PROPERTY_NAME_HIBERNATE_SHOW, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW));
		prop.put(PROPERTY_NAME_HIBERNATE_FORMAT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT));
		prop.put(PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA));
		prop.put(PROPERTY_NAME_HIBERNATE_HBM2DDL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL));
		
		return prop;
	}
		
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dataSource());
		sf.setPackagesToScan(env.getRequiredProperty("hibernate.entitymanager.packages.to.scan"));
		sf.setHibernateProperties(hibProperties());
		return sf;		
	}
	
	@Bean
	public HibernateTransactionManager trasanctionMgr(){
		HibernateTransactionManager hibtxnMgr = new HibernateTransactionManager();
		hibtxnMgr.setSessionFactory(sessionFactory().getObject());
		return hibtxnMgr;		
	}
	
	@Bean
	public UrlBasedViewResolver setupViewResolver(){
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);		
		return resolver;
	}
	
	
	
}








