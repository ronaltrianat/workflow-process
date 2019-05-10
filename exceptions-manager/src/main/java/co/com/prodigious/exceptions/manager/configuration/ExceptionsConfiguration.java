package co.com.prodigious.exceptions.manager.configuration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "map-errors")
public class ExceptionsConfiguration {
	
	private Map<String, String> sqlErrors;
	
}