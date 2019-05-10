package co.com.prodigious.commons.util.dto.response;

import java.io.Serializable;

import co.com.prodigious.commons.util.constants.APIConstants;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success;
	private String businessMessage;
	private String technicalMessage;

	public static ApiResponse successfulResponse() {
		return ApiResponse.builder().success(APIConstants.OK).businessMessage(APIConstants.MESSAGE_OK).build();
	}
	
	public static ApiResponse failedGenericResponse() {
		return ApiResponse.builder().businessMessage(APIConstants.GENERAL_ERROR_MESSAGE).build();
	}
	
	public static ApiResponse failedResponse(String message) {
		return ApiResponse.builder().businessMessage(message).build();
	}
}
