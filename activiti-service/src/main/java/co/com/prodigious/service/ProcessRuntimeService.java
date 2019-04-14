package co.com.prodigious.service;

import java.util.Objects;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import co.com.prodigious.constants.APIConstants;
import co.com.prodigious.dto.request.StartProcessInstanceRequest;
import co.com.prodigious.dto.response.StartProcessInstanceResponse;

@Service
public class ProcessRuntimeService {

	private final RuntimeService runtimeService;

	public ProcessRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	public StartProcessInstanceResponse startProcessInstance(StartProcessInstanceRequest request) {

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(request.getProcessKey(),
				request.getVariables());

		if (Objects.nonNull(processInstance) && Objects.nonNull(processInstance.getProcessInstanceId())) {
			return new StartProcessInstanceResponse(APIConstants.OK, APIConstants.MESSAGE_OK,
					processInstance.getProcessInstanceId());
		}

		return null;
	}
}
