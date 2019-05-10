package co.com.prodigious.exceptions.manager.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.exception.ExceptionUtils;

import co.com.prodigious.commons.util.dto.response.ApiResponse;

public class ErrorMessageUtil {

	private static final Map<Integer, String> ERROR_MAP = createMap();
	
	
	private static Map<Integer, String> createMap() {
        Map<Integer, String> result = new HashMap<Integer, String>();
        result.put("Duplicate entry 'FormularioInicioTest2' for key 'process_form_name_UNIQUE'".hashCode(), "Ya existe un formulario de proceso con ese nombre.");
        return Collections.unmodifiableMap(result);
    }
	
	public static ApiResponse getErrorMessage(RuntimeException ex) {

		Throwable throwable = ExceptionUtils.getRootCause(ex);
		
		if (Objects.isNull(throwable))
			return ApiResponse.failedGenericResponse();

		// TODO: Dar manejo al mensaje de error
		String message = ERROR_MAP.get(throwable.getMessage().hashCode());

		return ApiResponse.failedResponse(Objects.nonNull(message) ? message : throwable.getMessage());
	}
}
