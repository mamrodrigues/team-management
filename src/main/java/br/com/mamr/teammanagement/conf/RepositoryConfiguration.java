package br.com.mamr.teammanagement.conf;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class RepositoryConfiguration {
	
	@Value("${datasource.url}")
	private String url;

	@Value("${datasource.username}")
	private String username;

	@Value("${datasource.password}")
	private String password;

	@Value("${datasource.driverClassName}")
	private String driverClassName;
	
	@Value("${datasource.default_schema}")
	private String default_schema;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String ddlAuto;
	
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	@Value("${hibernate.packagesToScan}")
	private String packagesToScan;

	@Bean
	public DataSource getDataSource() throws PropertyVetoException {
		/*
		 * Testando o DataSource do C3p0
		 * 
		 * ComboPooledDataSource dataSource = new ComboPooledDataSource();
		 * dataSource.setDriverClass(driverClassName);
		 * dataSource.setJdbcUrl(url);
		 * dataSource.setUser(username);
		 * dataSource.setPassword(password);
		 * 
		 * dataSource.setMinPoolSize(5);
		 * dataSource.setMaxPoolSize(10);
		 * 
		 * return dataSource;
		 */
		
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driverClassName);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);	    	    

	    return dataSourceBuilder.build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() throws PropertyVetoException {		
		LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		managerFactoryBean.setDataSource(getDataSource());
		managerFactoryBean.setPackagesToScan(new String[] { packagesToScan });
		
		Properties hibernateProperties = getHibernateProperties();
		managerFactoryBean.setJpaProperties(hibernateProperties);
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		managerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		return managerFactoryBean;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() throws PropertyVetoException {		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSource());
		sessionFactoryBean.setPackagesToScan(packagesToScan);

		Properties hibernateProperties = getHibernateProperties();
		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;
	}

	private Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", dialect);
		hibernateProperties.put("hibernate.show_sql", showSql);
		hibernateProperties.put("hibernate.hbm2ddl.auto", ddlAuto);
		hibernateProperties.put("hibernate.connection.pool_size", "1");
		return hibernateProperties;
	}

	@Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		System.out.println("Called transactionManager");

        return new HibernateTransactionManager(sessionFactory);
    }
	
	
}
