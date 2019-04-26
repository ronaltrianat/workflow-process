package co.com.prodigious.admin.exceptions.handler;

import java.util.Objects;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.prodigious.commons.util.constants.APIConstants;
import co.com.prodigious.commons.util.dto.response.ApiResponse;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { AdminServiceException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, getErrorMessage(ex), new HttpHeaders(), 
				HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleErrorGeneral(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, getErrorMessage(ex), new HttpHeaders(), 
				HttpStatus.BAD_REQUEST, request);
	}
	
	private ApiResponse getErrorMessage(RuntimeException ex) {
		
		String errorMessage = ExceptionUtils.getRootCauseMessage(ex);
		
		if(Objects.isNull(errorMessage) || errorMessage.isEmpty()) 
			return new ApiResponse(APIConstants.GENERAL_ERROR_MESSAGE);
		
		return new ApiResponse(errorMessage);
	}
	
	
}
