package co.com.prodigious.dto.response;

public class ProcessDefinitionResponse extends ApiResponse {

	private static final long serialVersionUID = 1L;
	private String processDefinitionId;
	
	public ProcessDefinitionResponse(boolean success, String message, String processDefinitionId) {
		super(success, message);
		this.processDefinitionId = processDefinitionId;
	}
	
	public ProcessDefinitionResponse(boolean success, String message) {
		super(success, message);
	}

	public ProcessDefinitionResponse(String message) {
		super(message);
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

}
