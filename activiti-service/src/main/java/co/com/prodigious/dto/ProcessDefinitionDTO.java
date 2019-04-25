package co.com.prodigious.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProcessDefinitionDTO {
	private String processDefinitionKey;
	private String processDefinitionName;
	private List<String> formKeyList;
}
