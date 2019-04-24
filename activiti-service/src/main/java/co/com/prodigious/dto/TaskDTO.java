package co.com.prodigious.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String category;
	private Date claimTime;
	private Date createTime;
	private String description;
	private Date dueDate;
	private String executionId;
	private String formKey;
	private String id;
	private String name;
	private String owner;
	private String parentTaskId;
	private int priority;
	private String processDefinitionId;
	private String processInstanceId;
	private Map<String, Object> processVariables;
	private String taskDefinitionKey;
	private Map<String, Object> taskLocalVariables;

}
