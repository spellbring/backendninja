package com.udemy.model;

import org.springframework.stereotype.Component;

@Component
public class ContactModel {
	
	private int id;
	
	private String firstName;

	private String lastName;
	
	private String city;

	private String telephone;

	public ContactModel() {

	}
	

	public ContactModel(int id, String firstName, String lastName, String city, String telephone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.telephone = telephone;
	}


	


	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", telephone=" + telephone + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
