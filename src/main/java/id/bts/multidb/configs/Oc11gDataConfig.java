//package id.bts.multidb.configs;
//
//import java.util.Properties;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = { "id.bts.multidb.oc11g.repositories" })
//public class Oc11gDataConfig {
//
//	private static final Logger log = LoggerFactory.getLogger(Oc11gDataConfig.class);
//
//	@Primary
//	@Bean(name = "dataSource")
////	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().url("jdbc:oracle:thin:@192.168.83.227:1521/EE.oracle.docker")
//				.username("dummy").password("dummy").driverClassName("oracle.jdbc.OracleDriver").build();
//	}
//
//	@Primary
//	@Bean(name = "entityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//			@Qualifier("dataSource") DataSource dataSource) {
//
//		log.debug(dataSource.toString());
//	    
//	    LocalContainerEntityManagerFactoryBean localBuilder = builder.dataSource(dataSource).packages("id.bts.multidb.oc11g.domains").persistenceUnit("oc11g").build();
//	    
//	    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		Properties properties = new Properties();
//	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//	    properties.setProperty("hibernate.hbm2ddl.auto", "update");
//	    
//	    localBuilder.setJpaVendorAdapter(vendorAdapter);
//	    localBuilder.setJpaProperties(properties);
//	    
//		return localBuilder;
//	}
//
//	@Primary
//	@Bean(name = "transactionManager")
//	public PlatformTransactionManager transactionManager(
//			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}
//
//}