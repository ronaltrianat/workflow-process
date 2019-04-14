package co.com.prodigious.dto.request;

import java.io.Serializable;
import java.util.Map;

public class StartProcessInstanceRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> variables;
	private String processKey;

	public Map<String, Object> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

}
