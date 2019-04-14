package co.com.prodigious.dto.response;

public class StartProcessInstanceResponse extends ApiResponse {

	private static final long serialVersionUID = 1L;
	private String processInstanceId;

	public StartProcessInstanceResponse(String message) {
		super(message);
	}

	public StartProcessInstanceResponse(boolean success, String message, String processInstanceId) {
		super(success, message);
		this.processInstanceId = processInstanceId;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

}
