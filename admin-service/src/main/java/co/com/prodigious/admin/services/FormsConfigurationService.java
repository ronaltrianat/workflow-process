package co.com.prodigious.admin.services;

import org.springframework.stereotype.Service;

import co.com.prodigious.admin.dto.request.FormConfigurationRequest;
import co.com.prodigious.commons.util.dto.response.ApiResponse;
import co.com.prodigious.entities.ProcessFormsEntity;
import co.com.prodigious.repositories.ProcessFormsRepository;

@Service
public class FormsConfigurationService {

	private final ProcessFormsRepository processFormsRepository;
	
	public FormsConfigurationService(ProcessFormsRepository processFormsRepository) {
		this.processFormsRepository = processFormsRepository;
	}

	/**
	 * Metodo encargado de almacenar la configuracion de un formulario de proceso en base de datos.
	 * @param request Objeto que contiene la informacion del formulario a almacenar.
	 * @return Objeto con la respuesta de la configuracion del formulario.
	 */
	public ApiResponse configureForm(FormConfigurationRequest request) {
		
		ProcessFormsEntity entity = ProcessFormsEntity.builder()
				.contentForm(request.getContentForm())
				.description(request.getDescription())
				.name(request.getName()).build();
		
		processFormsRepository.save(entity);
		
		return ApiResponse.getSuccessfulResponse();
	}
}
