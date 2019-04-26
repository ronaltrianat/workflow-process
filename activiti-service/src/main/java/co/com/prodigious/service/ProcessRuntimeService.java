package co.com.prodigious.service;

import java.util.Objects;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.prodigious.commons.util.dto.response.ApiResponse;
import co.com.prodigious.dto.request.StartProcessInstanceRequest;
import co.com.prodigious.dto.response.StartProcessInstanceResponse;

@Service
public class ProcessRuntimeService {

	private final RuntimeService runtimeService;

	public ProcessRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	/**
	 * Metodo encargado de dar inicio a una instancia de proceso.
	 * @param request Objeto que contiene el id de proceso a iniciar y sus variables iniciales.
	 * @return co.com.prodigious.dto.response.StartProcessInstanceResponse Que contiene el id del
	 * proceso en caso de ser exitoso.
	 */
	@Transactional
	public StartProcessInstanceResponse startProcessInstance(StartProcessInstanceRequest request) throws Exception {

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(request.getProcessKey(),
				request.getVariables());

		StartProcessInstanceResponse response = null;
		
		if (Objects.nonNull(processInstance) && Objects.nonNull(processInstance.getProcessInstanceId())) {
			response = StartProcessInstanceResponse.builder()
					.processInstanceId(processInstance.getProcessInstanceId())
					.apiResponse(ApiResponse.getSuccessfulResponse()).build();
		}

		return response;
	}
	
}
