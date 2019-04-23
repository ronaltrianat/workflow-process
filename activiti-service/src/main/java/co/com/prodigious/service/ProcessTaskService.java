package co.com.prodigious.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.prodigious.dto.TaskDTO;
import co.com.prodigious.dto.request.CompleteTaskRequest;
import co.com.prodigious.dto.response.ApiResponse;

@Service
public class ProcessTaskService {

	private final TaskService taskService;
	

	public ProcessTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	

	/**
	 * Metodo encargado de obtener la lista de tareas abiertas y asignadas a un usuario.
	 * @param assignee Usuario a consultar las tareas.
	 */
	public List<TaskDTO> getOpenTasks(String assignee) {
		Optional<List<Task>> tasks = Optional.ofNullable(taskService.createTaskQuery().taskAssignee(assignee).list());
		List<TaskDTO> response = new ArrayList<>();
		tasks.ifPresent(taskList -> taskList.forEach(task -> {
			if(Objects.nonNull(task)) response.add(getInfoTask(task));
		}));
		return response;
	}
	

	/**
	 * Metodo encargado de obtener las tareas disponibles por rol de usuario.
	 * @param role Role del usuario a consultar las tareas disponibles.
	 */
	public List<TaskDTO> getTasksAvailable(String role) {
		Optional<List<Task>> tasks = Optional.ofNullable(taskService.createTaskQuery().taskCandidateGroup(role).list());
		List<TaskDTO> response = new ArrayList<>();
		tasks.ifPresent(taskList -> taskList.forEach(task -> {
			if(Objects.nonNull(task)) response.add(getInfoTask(task));
		}));
		return response;
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
	
	
	/**
	 * 
	 * @param task
	 * @return
	 */
	private TaskDTO getInfoTask(Task task) {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setCategory(task.getCategory());
		taskDTO.setClaimTime(task.getClaimTime());
		taskDTO.setCreateTime(task.getCreateTime());
		taskDTO.setDelegationStateName(Objects.isNull(task.getDelegationState()) ? "" : task.getDelegationState().name());
		taskDTO.setDescription(task.getDescription());
		taskDTO.setDueDate(task.getDueDate());
		taskDTO.setExecutionId(task.getExecutionId());
		taskDTO.setFormKey(task.getFormKey());
		taskDTO.setId(task.getId());
		taskDTO.setName(task.getName());
		taskDTO.setOwner(task.getOwner());
		taskDTO.setParentTaskId(task.getParentTaskId());
		taskDTO.setPriority(task.getPriority());
		taskDTO.setProcessDefinitionId(task.getProcessDefinitionId());
		taskDTO.setProcessInstanceId(task.getProcessInstanceId());
		taskDTO.setProcessVariables(task.getProcessVariables());
		taskDTO.setTaskDefinitionKey(task.getTaskDefinitionKey());
		taskDTO.setTaskLocalVariables(task.getTaskLocalVariables());
		return taskDTO;
	}
}
