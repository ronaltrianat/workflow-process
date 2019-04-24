package co.com.prodigious.dto.request;

import java.io.Serializable;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class StartProcessInstanceRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String processKey;
	
	private Map<String, Object> variables;

}
