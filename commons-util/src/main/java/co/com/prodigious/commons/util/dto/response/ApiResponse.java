package co.com.prodigious.commons.util.dto.response;

import java.io.Serializable;

import co.com.prodigious.commons.util.constants.APIConstants;
import lombok.Data;

@Data
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success;
	private String message;
	
	public ApiResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public ApiResponse(String message) {
		this.message = message;
	}

	public static ApiResponse getSuccessfulResponse() {
		return new ApiResponse(APIConstants.OK, APIConstants.MESSAGE_OK);
	}
}