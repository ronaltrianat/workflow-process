package co.com.prodigious.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.prodigious.dto.request.LoginRequest;
import co.com.prodigious.dto.request.SignUpRequest;
import co.com.prodigious.services.SignInService;
import co.com.prodigious.services.SignUpService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final SignInService signInService;
	private final SignUpService signUpService;

	public AuthController(SignInService signInService, SignUpService signUpService) {
		this.signInService = signInService;
		this.signUpService = signUpService;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(signInService.authenticateUser(loginRequest));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		return ResponseEntity.ok(signUpService.registerUser(signUpRequest));
	}
}
