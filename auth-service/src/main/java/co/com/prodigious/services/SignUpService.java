package co.com.prodigious.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.prodigious.dto.request.SignUpRequest;
import co.com.prodigious.dto.response.ApiResponse;
import co.com.prodigious.entities.UserEntity;
import co.com.prodigious.repositories.UsersRepository;

@Service
public class SignUpService {

	private final UsersRepository usersRepository;
	private final PasswordEncoder passwordEncoder;

	public SignUpService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
		this.usersRepository = usersRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public ResponseEntity<ApiResponse> registerUser(SignUpRequest signUpRequest) {

		if (usersRepository.existsByDocumentNumber(signUpRequest.getDocumentNumber())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		usersRepository.save(getUserEntity(signUpRequest));

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse(true, "User registered successfully"));
	}

	
	private UserEntity getUserEntity(SignUpRequest signUpRequest) {
		UserEntity user = new UserEntity();
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setAddress(signUpRequest.getAddress());
		user.setAge(signUpRequest.getAge());
		user.setDocumentNumber(signUpRequest.getDocumentNumber());
		user.setEmail(signUpRequest.getEmail());
		user.setFkDocumentTypeId(signUpRequest.getDocumentTypeId());
		user.setFkUserStatusId(1);
		user.setName(signUpRequest.getName());
		user.setPhoneNumber(signUpRequest.getPhoneNumber());
		user.setSurname(signUpRequest.getSurname());
		return user;
	}
}
