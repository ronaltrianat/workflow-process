package co.com.prodigious.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.prodigious.commons.util.dto.response.ApiResponse;
import co.com.prodigious.dto.TaskDTO;
import co.com.prodigious.dto.request.CompleteTaskRequest;
import co.com.prodigious.mappers.TaskMapper;

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
			if(Objects.nonNull(task)) response.add(TaskMapper.activitiTaskToTaskDTO(task));
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
			if(Objects.nonNull(task)) response.add(TaskMapper.activitiTaskToTaskDTO(task));
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
		return ApiResponse.successfulResponse();
	}
	
}
