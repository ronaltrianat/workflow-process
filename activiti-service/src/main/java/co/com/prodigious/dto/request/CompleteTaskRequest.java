package co.com.prodigious.dto.request;

import java.io.Serializable;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

public class CompleteTaskRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String taskId;
	private Map<String, Object> variables;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Map<String, Object> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}

}
