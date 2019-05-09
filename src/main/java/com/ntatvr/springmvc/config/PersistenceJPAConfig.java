package com.ntatvr.springmvc.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The com.example.spring.repository package will be scanned to detect repositories Spring Data JPA
 * and Hibernate Configuration using Java-based Spring configuration
 * 
 * @author AnhNT
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySources({
  @PropertySource({"classpath:jdbc.properties"}),
  @PropertySource({"classpath:hibernate.properties"})
})
@ComponentScan({"com.ntatvr.springmvc"})
@EnableJpaRepositories(basePackages = "com.ntatvr.springmvc.repository")
public class PersistenceJPAConfig {

  @Autowired
  private Environment env;

  public PersistenceJPAConfig() {
    super();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
        new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource());
    entityManagerFactoryBean.setPackagesToScan(new String[] {"com.ntatvr.springmvc.entity"});

    final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
    entityManagerFactoryBean.setJpaProperties(additionalProperties());

    return entityManagerFactoryBean;
  }

  final Properties additionalProperties() {
    final Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
        env.getProperty("hibernate.hbm2ddl.auto"));
    hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
    hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
    hibernateProperties.setProperty("hibernate.cache.use_second_level_cache",
        env.getProperty("hibernate.cache.use_second_level_cache"));
    hibernateProperties.setProperty("hibernate.cache.use_query_cache",
        env.getProperty("hibernate.cache.use_query_cache"));
    hibernateProperties.setProperty("hibernate.connection.charSet",
        env.getProperty("hibernate.connection.charSet"));
    hibernateProperties.setProperty("hibernate.connection.characterEncoding",
        env.getProperty("hibernate.connection.characterEncoding"));
    hibernateProperties.setProperty("hibernate.connection.useUnicode",
        env.getProperty("hibernate.connection.useUnicode"));
    return hibernateProperties;
  }

  @Bean(name = "dataSource")
  public DataSource dataSource() {

    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
    dataSource.setUrl(env.getProperty("jdbc.url"));
    dataSource.setUsername(env.getProperty("jdbc.username"));
    dataSource.setPassword(env.getProperty("jdbc.password"));
    return dataSource;
  }

  @Bean
  public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
    final JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }
}
