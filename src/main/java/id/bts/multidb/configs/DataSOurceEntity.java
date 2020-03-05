package id.bts.multidb.configs;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

public class DataSOurceEntity {

	private final DataSource dataSource;
	private final String id;
	
	public DataSOurceEntity(Ocdb12cProperty property) {
		this.dataSource = DataSourceBuilder.create().url(property.getUrl())
				.username(property.getUsername()).password(property.getPassword()).driverClassName(property.getDriverClass()).build();
		
		this.id = property.getUrl();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public String getId() {
		return id;
	}
}
