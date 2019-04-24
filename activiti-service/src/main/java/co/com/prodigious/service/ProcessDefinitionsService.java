package co.com.prodigious.service;

import java.util.Objects;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Service;

import co.com.prodigious.dto.request.ProcessDefinitionRequest;
import co.com.prodigious.dto.response.ApiResponse;
import co.com.prodigious.dto.response.ProcessDefinitionResponse;

@Service
public class ProcessDefinitionsService {

	private RepositoryService repositoryService;

	public ProcessDefinitionsService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	public ProcessDefinitionResponse uploadProcessDefinition(ProcessDefinitionRequest request) throws Exception {
		
		Deployment deployment = repositoryService.createDeployment()
				.key(request.getProcessKey())
				.name(request.getProcessName())
				.category(request.getProcessCategory())
				.addInputStream(request.getFile().getResource().getFilename(), request.getFile().getInputStream())
				.deploy();

		ProcessDefinitionResponse response = null;
		
		if(Objects.nonNull(deployment)) {
			response = ProcessDefinitionResponse.builder()
					.processDefinitionId(deployment.getId())
					.apiResponse(ApiResponse.getSuccessfulResponse())
					.build();
		}
		
		return response;

	}
}
