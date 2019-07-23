//package id.bts.multidb.configs;
//
//import java.util.Properties;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//@EnableJpaRepositories(entityManagerFactoryRef = "Oc12cEntityManagerFactory", basePackages = { "id.bts.multidb.oc12c.repositories" })
//public class Oc12cDataConfig {
//
//	@Bean("Oc12cDataSource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().url("jdbc:oracle:thin:@192.168.83.39:1521/ORCLCDB.localdomain")
//				.username("dummy").password("dummy").driverClassName("oracle.jdbc.OracleDriver").build();
//	}
//
//	@Bean(name = "Oc12cEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//			@Qualifier("Oc12cDataSource") DataSource dataSource) {
//		
//		LocalContainerEntityManagerFactoryBean localBuilder = builder.dataSource(dataSource).packages("id.bts.multidb.oc12c.domains").persistenceUnit("oc12c").build();
//		
//		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
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
//	@Bean(name = "Oc12cTransactionManager")
//	public PlatformTransactionManager transactionManager(@Qualifier("Oc12cEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}
//}
