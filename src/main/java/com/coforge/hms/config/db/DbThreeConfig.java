package com.coforge.hms.config.db;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "db4EntityManagerFactory",
		transactionManagerRef = "db4TransactionManager",
		basePackages = "com.coforge.hms.repository"
		)
public class DbThreeConfig {
	//DataSource
		@Primary
		@Bean
		@ConfigurationProperties(prefix="db4.datasource")
		public DataSource db4DataSource() {
			return DataSourceBuilder.create().build();
		}

		//EntityManagerFactory
		@Primary    //"Primary" indicates this one should be started first.
		@Bean
		public LocalContainerEntityManagerFactoryBean db4EntityManagerFactory(
				EntityManagerFactoryBuilder emfb) 
		{
			HashMap<String, Object> properties = new HashMap<>();
			properties.put("hibernate.hbm2ddl.auto", "create");
			properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
			return emfb
					.dataSource(db4DataSource())
					.packages("com.coforge.hms.model")
					.properties(properties)
					.persistenceUnit("db4")
					.build();
		}

		//TransactionManager
		@Primary
		@Bean
		public PlatformTransactionManager db4TransactionManager(
				@Qualifier("db4EntityManagerFactory") EntityManagerFactory entityManagerFactory4) 
		{
			return new JpaTransactionManager(entityManagerFactory4);
		}
}
