package id.bts.multidb.configs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource(value = "classpath:application.yml", ignoreResourceNotFound = false)
@ConfigurationProperties(prefix = "ocdb12c")
public class CustomProperties {

	private List<Ocdb12cProperty> list = new ArrayList<>();

	@Bean(name = "ocdb12cDataSources")
	public List<DataSOurceEntity> dataSources() {
		List<DataSOurceEntity> dataSources = new ArrayList<>();
		
		for (Iterator<Ocdb12cProperty> iterator = this.list.iterator(); iterator.hasNext();) {
			Ocdb12cProperty ocdb12cProperty = (Ocdb12cProperty) iterator.next();
			
			dataSources.add(new DataSOurceEntity(ocdb12cProperty));
		}
		return dataSources;
	}

	public List<Ocdb12cProperty> getProperties() {
		return list;
	}

	public void setProperties(List<Ocdb12cProperty> properties) {
		this.list = properties;
	}
	
	
}
