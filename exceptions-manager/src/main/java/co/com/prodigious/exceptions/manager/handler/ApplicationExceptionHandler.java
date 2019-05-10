package co.com.prodigious.exceptions.manager.handler;

import java.util.Objects;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
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
import co.com.prodigious.exceptions.manager.configuration.ExceptionsConfiguration;
import co.com.prodigious.exceptions.manager.constants.TechnicalMessagesConstants;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ExceptionsConfiguration exceptionsConfiguration;

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleErrorGeneral(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, getErrorMessage(ex, "Exception"), 
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { DataIntegrityViolationException.class })
	protected ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest request) {

		ConstraintViolationException cve = (ConstraintViolationException) ex.getCause();

		String errorMessage = TechnicalMessagesConstants.GENERAL_DATABASE_ERROR;
		
		if (exceptionsConfiguration.getSqlErrors().containsKey(cve.getConstraintName())) {
			errorMessage = exceptionsConfiguration.getSqlErrors().get(cve.getConstraintName());
		}

		return handleExceptionInternal(ex, getErrorMessage(ex, errorMessage), 
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	

	private ApiResponse getErrorMessage(RuntimeException ex, String businessMessage) {

		ex.printStackTrace();

		String technicalErrorMessage = ExceptionUtils.getRootCauseMessage(ex);

		if (Objects.isNull(technicalErrorMessage) || technicalErrorMessage.isEmpty())
			return ApiResponse.builder().technicalMessage(APIConstants.GENERAL_ERROR_MESSAGE).build();

		return ApiResponse.builder().technicalMessage(technicalErrorMessage).businessMessage(businessMessage).build();
	}

}
