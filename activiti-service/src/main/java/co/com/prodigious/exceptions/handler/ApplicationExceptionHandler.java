package co.com.prodigious.exceptions.handler;

import org.activiti.engine.ActivitiObjectNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.prodigious.dto.response.ApiResponse;
import co.com.prodigious.exceptions.ProcessDefinitionException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ActivitiObjectNotFoundException.class, ProcessDefinitionException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, new ApiResponse(ex.getMessage()), 
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleErrorGeneral(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, new ApiResponse(ex.getMessage()), 
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
