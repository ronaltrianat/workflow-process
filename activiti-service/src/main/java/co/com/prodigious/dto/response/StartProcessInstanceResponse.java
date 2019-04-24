package co.com.prodigious.dto.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StartProcessInstanceResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String processInstanceId;
	private ApiResponse apiResponse;
	
}
