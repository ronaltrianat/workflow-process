package co.com.prodigious.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import co.com.prodigious.common.jwt.dto.JwtTokenDTO;
import co.com.prodigious.common.jwt.provider.JwtTokenProvider;
import co.com.prodigious.dto.request.LoginRequest;
import co.com.prodigious.dto.response.JwtAuthenticationResponse;


@Service
public class SignInService {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	

	public SignInService(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	
	public JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		JwtTokenDTO jwtToken = jwtTokenProvider.generateToken(authentication);
		
		JwtAuthenticationResponse response = new JwtAuthenticationResponse();
		response.setAccessToken(jwtToken.getAccessToken());
		response.setTokenType(jwtToken.getTokenType());
		
		return response;
	}

	
}
