package co.com.prodigious.exceptions;

public class ProcessDefinitionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProcessDefinitionException(String message) {
		super(message);
	}

	public ProcessDefinitionException(String message, Throwable ex) {
		super(message, ex);
	}
}
