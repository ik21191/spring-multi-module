package com.mypack.model;

import java.util.List;

public class PersonModel {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private CityModel city;
	private List<PersonIdentityModel> personIdentityModelList;

	public PersonModel() {
	}

	public PersonModel(String firstName, String lastName, String email, CityModel city, List<PersonIdentityModel> personIdentityModelList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.personIdentityModelList = personIdentityModelList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CityModel getCity() {
		return city;
	}

	public void setCity(CityModel city) {
		this.city = city;
	}

	
	public List<PersonIdentityModel> getPersonIdentityModelList() {
		return personIdentityModelList;
	}

	public void setPersonIdentityModelList(List<PersonIdentityModel> personIdentityModelList) {
		this.personIdentityModelList = personIdentityModelList;
	}

	@Override
	public String toString() {
		return "PersonModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", city=" + city + ", personIdentityModelList=" + personIdentityModelList + "]";
	}

	
}
