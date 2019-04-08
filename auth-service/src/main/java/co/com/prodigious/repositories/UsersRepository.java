package co.com.prodigious.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import co.com.prodigious.entities.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, BigInteger> {

	UserEntity findByDocumentNumber(String documentNumber);
}
