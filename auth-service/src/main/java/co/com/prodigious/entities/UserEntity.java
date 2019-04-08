package co.com.prodigious.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private BigInteger userId;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "age")
	private String age;

	@Column(name = "email")
	private String email;

	@Column(name = "document_number")
	private String documentNumber;

	@Column(name = "password")
	private String password;

	@Column(name = "fk_user_status_id")
	private String fkUserStatusId;

	@Column(name = "address")
	private String address;

	@Column(name = "fk_document_type_id")
	private String fkDocumentTypeId;

	public UserEntity() {
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFkUserStatusId() {
		return fkUserStatusId;
	}

	public void setFkUserStatusId(String fkUserStatusId) {
		this.fkUserStatusId = fkUserStatusId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFkDocumentTypeId() {
		return fkDocumentTypeId;
	}

	public void setFkDocumentTypeId(String fkDocumentTypeId) {
		this.fkDocumentTypeId = fkDocumentTypeId;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", name=" + name + ", surname=" + surname + ", age=" + age + ", email="
				+ email + ", documentNumber=" + documentNumber + ", password=" + password + ", fkUserStatusId="
				+ fkUserStatusId + ", address=" + address + ", fkDocumentTypeId=" + fkDocumentTypeId + "]";
	}

}
