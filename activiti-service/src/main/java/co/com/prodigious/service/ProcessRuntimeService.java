package co.com.prodigious.service;

import java.util.Objects;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.prodigious.constants.APIConstants;
import co.com.prodigious.dto.request.CompleteTaskRequest;
import co.com.prodigious.dto.request.StartProcessInstanceRequest;
import co.com.prodigious.dto.response.ApiResponse;
import co.com.prodigious.dto.response.StartProcessInstanceResponse;

@Service
public class ProcessRuntimeService {

	private final RuntimeService runtimeService;
	private final TaskService taskService;

	public ProcessRuntimeService(RuntimeService runtimeService, TaskService taskService) {
		this.runtimeService = runtimeService;
		this.taskService = taskService;
	}

	/**
	 * Metodo encargado de dar inicio a una instancia de proceso.
	 * @param request Objeto que contiene el id de proceso a iniciar y sus variables iniciales.
	 * @return co.com.prodigious.dto.response.StartProcessInstanceResponse Que contiene el id del
	 * proceso en caso de ser exitoso.
	 */
	@Transactional
	public StartProcessInstanceResponse startProcessInstance(StartProcessInstanceRequest request) {

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(request.getProcessKey(),
				request.getVariables());

		if (Objects.nonNull(processInstance) && Objects.nonNull(processInstance.getProcessInstanceId())) {
			return new StartProcessInstanceResponse(APIConstants.OK, APIConstants.MESSAGE_OK,
					processInstance.getProcessInstanceId());
		}

		return null;
	}
	
	
	/**
	 * Metodo encargado de completar una tarea. 
	 * @param request Objeto que contiene el id de la tarea y las variables necesarias para
	 * completar la tarea.
	 * @return co.com.prodigious.dto.response.ApiResponse que indica el estado de 
	 * la operacion de la tarea.
	 */
	@Transactional
	public ApiResponse completeTask(CompleteTaskRequest request) {
		taskService.complete(request.getTaskId(), request.getVariables());
		return ApiResponse.getSuccessfulResponse();
	}
	
}
