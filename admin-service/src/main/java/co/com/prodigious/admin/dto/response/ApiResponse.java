package co.com.prodigious.admin.dto.response;

import java.io.Serializable;

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
		return new ApiResponse(true, "");
	}
}
