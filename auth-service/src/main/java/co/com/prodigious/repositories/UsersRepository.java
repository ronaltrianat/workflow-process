package co.com.prodigious.repositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.com.prodigious.entities.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, BigInteger> {

	Optional<UserEntity> findByDocumentNumber(String documentNumber);
	
	Boolean existsByDocumentNumber(String documentNumber);
	
}
