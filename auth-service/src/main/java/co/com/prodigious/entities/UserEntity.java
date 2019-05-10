package co.com.prodigious.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
@Builder
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private BigInteger userId;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "age")
	private int age;

	@Column(name = "email")
	private String email;

	@Column(name = "fk_document_type_id")
	private int fkDocumentTypeId;

	@Column(name = "document_number")
	private String documentNumber;

	@Column(name = "password")
	private String password;

	@Column(name = "fk_user_status_id")
	private int fkUserStatusId;

	@Column(name = "address")
	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;

}
