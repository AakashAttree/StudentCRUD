package com.CarSchool.Student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "students")
public class StudentInfo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	
	@Column(name = "name")
	 private String name;
	 
	
	@Column(name = "email")
	 private String email;
	 
	@Column(name = "number")
	private String number;
	 
	@Column(name = "address")
	 private String address;
	 
	
	@Column(name = "zipCode")
	 private String zipCode;
	
	
	@Lob
	@Column(name = "photo")
	 private MultipartFile photo;
	
	@Lob
	@Column(name = "dl")
	 private MultipartFile dl;
	
	@Column(name = "amount") 
	 private Number amount;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "result")
	 private String result;
	 
	@Column(name = "gender")
	 private String gender;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public MultipartFile getDl() {
		return dl;
	}

	public void setDl(MultipartFile dl) {
		this.dl = dl;
	}

	public Number getAmount() {
		return amount;
	}

	public void setAmount(Number amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public StudentInfo(long id, String name, String email, String number, String address, String zipCode,
			MultipartFile photo, MultipartFile dl, Number amount, String status, String result, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
		this.address = address;
		this.zipCode = zipCode;
		this.photo = photo;
		this.dl = dl;
		this.amount = amount;
		this.status = status;
		this.result = result;
		this.gender = gender;
	}
	public StudentInfo() {
		
	}

	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + ", address="
				+ address + ", zipCode=" + zipCode + ", photo=" + photo + ", dl=" + dl + ", amount=" + amount
				+ ", status=" + status + ", result=" + result + ", gender=" + gender + "]";
	}

}