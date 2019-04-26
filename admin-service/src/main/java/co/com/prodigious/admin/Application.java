package co.com.prodigious.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import co.com.prodigious.commons.util.constants.APIConstants;

@SpringBootApplication
@ComponentScan(basePackages = { APIConstants.BASE_PACKAGE })
@EntityScan(basePackages = { APIConstants.BASE_PACKAGE })
@EnableJpaRepositories(basePackages = { APIConstants.BASE_PACKAGE })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
