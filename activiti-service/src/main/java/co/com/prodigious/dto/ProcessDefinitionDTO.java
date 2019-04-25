package co.com.prodigious.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProcessDefinitionDTO {

	private String processDefinitionKey;
	private String processDefinitionName;
}
