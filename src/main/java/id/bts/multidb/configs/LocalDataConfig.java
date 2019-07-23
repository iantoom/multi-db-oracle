package id.bts.multidb.configs;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "LocalEntityManagerFactory", basePackages = { "id.bts.multidb.localdb.repositories" })
public class LocalDataConfig {

	@Bean("localDataSource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().url("jdbc:oracle:thin:@192.168.83.39:1521/ORCLCDB.localdomain")
				.username("dummy").password("dummy").driverClassName("oracle.jdbc.OracleDriver").build();
	}
	
}
