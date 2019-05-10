package co.com.prodigious.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String username;

	@NotBlank
	private String password;

}
