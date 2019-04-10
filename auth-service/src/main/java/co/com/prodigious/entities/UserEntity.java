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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFkDocumentTypeId() {
		return fkDocumentTypeId;
	}

	public void setFkDocumentTypeId(int fkDocumentTypeId) {
		this.fkDocumentTypeId = fkDocumentTypeId;
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

	public int getFkUserStatusId() {
		return fkUserStatusId;
	}

	public void setFkUserStatusId(int fkUserStatusId) {
		this.fkUserStatusId = fkUserStatusId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", name=" + name + ", surname=" + surname + ", age=" + age + ", email="
				+ email + ", fkDocumentTypeId=" + fkDocumentTypeId + ", documentNumber=" + documentNumber
				+ ", password=" + password + ", fkUserStatusId=" + fkUserStatusId + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
