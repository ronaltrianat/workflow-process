package co.com.prodigious.dto.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtAuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accessToken;
	private String tokenType;

}
