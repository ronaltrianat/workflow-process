package co.com.prodigious.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignUpRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotBlank
	private String name;

	@NotNull
	@NotBlank
	private String surname;

	@NotNull
	private Integer age;

	@NotNull
	@NotBlank
	private String email;

	@NotNull
	private Integer documentTypeId;

	@NotNull
	@NotBlank
	private String documentNumber;

	@NotNull
	@NotBlank
	private String password;

	private String address;

	private String phoneNumber;

}
