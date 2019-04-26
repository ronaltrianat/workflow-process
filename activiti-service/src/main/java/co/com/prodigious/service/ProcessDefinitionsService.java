package co.com.prodigious.service;

import java.util.Objects;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Service;

import co.com.prodigious.commons.util.dto.response.ApiResponse;
import co.com.prodigious.dto.ProcessDefinitionDTO;
import co.com.prodigious.dto.request.ProcessDefinitionRequest;
import co.com.prodigious.dto.response.ProcessDefinitionResponse;
import co.com.prodigious.util.ProcessDefinitionUtil;

@Service
public class ProcessDefinitionsService {

	private RepositoryService repositoryService;

	public ProcessDefinitionsService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	/**
	 * Metodo encargado de cargar un nuevo proceso al motor de activiti.
	 * @param request Informacion del proceso a cargar.
	 * @return co.com.prodigious.dto.response.ProcessDefinitionResponse Resultado de la operacion.
	 * @throws Exception
	 */
	public ProcessDefinitionResponse uploadProcessDefinition(ProcessDefinitionRequest request) throws Exception {
		
		ProcessDefinitionResponse response = null;
		
		ProcessDefinitionDTO processDefinitionDTO = ProcessDefinitionUtil.getProcessParameters(request);
		
		Deployment deployment = repositoryService.createDeployment()
				.key(processDefinitionDTO.getProcessDefinitionKey())
				.name(processDefinitionDTO.getProcessDefinitionName())
				.category(request.getProcessCategory())
				.addInputStream(request.getFile().getResource().getFilename(), request.getFile().getInputStream())
				.deploy();
		
		if(Objects.nonNull(deployment) && Objects.nonNull(deployment.getId())) {
			response = ProcessDefinitionResponse.builder().processDefinitionId(deployment.getId())
					.apiResponse(ApiResponse.getSuccessfulResponse()).build();
		}
		
		return response;

	}
}
