package co.com.prodigious.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.prodigious.commons.util.dto.response.ApiResponse;
import co.com.prodigious.dto.request.SignUpRequest;
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

	public ApiResponse registerUser(SignUpRequest signUpRequest) {
		usersRepository.save(getUserEntity(signUpRequest));
		return ApiResponse.successfulResponse();
	}

	private UserEntity getUserEntity(SignUpRequest signUpRequest) {
		return UserEntity.builder()
				.password(passwordEncoder.encode(signUpRequest.getPassword()))
				.address(signUpRequest.getAddress())
				.age(signUpRequest.getAge())
				.documentNumber(signUpRequest.getDocumentNumber())
				.email(signUpRequest.getEmail())
				.fkDocumentTypeId(signUpRequest.getDocumentTypeId())
				.fkUserStatusId(1)
				.name(signUpRequest.getName())
				.phoneNumber(signUpRequest.getPhoneNumber())
				.surname(signUpRequest.getSurname())
				.build();
	}
}
