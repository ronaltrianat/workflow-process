package co.com.prodigious.admin.exceptions.handler;

public class AdminServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AdminServiceException(String message) {
		super(message);
	}

	public AdminServiceException(Throwable cause) {
        super(cause);
    }
	
	public AdminServiceException(String message, Throwable ex) {
		super(message, ex);
	}

}
