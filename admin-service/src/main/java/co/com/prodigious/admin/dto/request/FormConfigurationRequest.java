package co.com.prodigious.admin.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FormConfigurationRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull 
	@NotEmpty
	private String name;
	
	@NotNull 
	@NotEmpty
	private String description;

	@NotNull 
	@NotEmpty
	private String contentForm;
}
