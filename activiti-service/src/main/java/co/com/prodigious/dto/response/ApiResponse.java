package co.com.prodigious.dto.response;

import java.io.Serializable;

import co.com.prodigious.constants.APIConstants;

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

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static ApiResponse getSuccessfulResponse() {
		return new ApiResponse(APIConstants.OK, APIConstants.MESSAGE_OK);
	}
}
