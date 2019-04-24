package co.com.prodigious.mappers;

import org.activiti.engine.task.Task;

import co.com.prodigious.dto.TaskDTO;

public class TaskMapper {

	public static TaskDTO activitiTaskToTaskDTO(Task task) {
		return TaskDTO.builder()
				.category(task.getCategory())
				.claimTime(task.getClaimTime())
				.createTime(task.getCreateTime())
				.description(task.getDescription())
				.dueDate(task.getDueDate())
				.executionId(task.getExecutionId())
				.formKey(task.getFormKey())
				.id(task.getId())
				.name(task.getName())
				.owner(task.getOwner())
				.parentTaskId(task.getParentTaskId())
				.priority(task.getPriority())
				.processDefinitionId(task.getProcessDefinitionId())
				.processInstanceId(task.getProcessInstanceId())
				.processVariables(task.getProcessVariables())
				.taskDefinitionKey(task.getTaskDefinitionKey())
				.taskLocalVariables(task.getTaskLocalVariables())
				.build();
	}
}
