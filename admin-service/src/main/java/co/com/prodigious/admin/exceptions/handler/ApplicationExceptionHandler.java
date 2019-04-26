package co.com.prodigious.admin.exceptions.handler;

import java.util.Objects;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
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

	@ExceptionHandler(value = { DataIntegrityViolationException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		Throwable throwable = ExceptionUtils.getRootCause(ex);
		return handleExceptionInternal(ex, getErrorMessage(throwable), new HttpHeaders(), 
				HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleErrorGeneral(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, new ApiResponse(ex.getMessage()), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	private Object getErrorMessage(Throwable throwable) {
		
		ApiResponse apiResponse = new ApiResponse(APIConstants.GENERAL_ERROR_MESSAGE);
		
		if(Objects.isNull(throwable)) return new ApiResponse(APIConstants.GENERAL_ERROR_MESSAGE);
		
		// TODO: Dar manejo al mensaje de error
		apiResponse = new ApiResponse(throwable.getMessage());
		
		return apiResponse;
	}
}
