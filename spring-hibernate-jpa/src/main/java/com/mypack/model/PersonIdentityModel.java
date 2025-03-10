package com.mypack.model;

public class PersonIdentityModel {
	private Long id;
	private String personIdentityName;

	public PersonIdentityModel() {
		System.out.println("Object of PersonIdentityModel created.");
	}

	public PersonIdentityModel(String personIdentityName) {
		this.personIdentityName = personIdentityName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonIdentityName() {
		return personIdentityName;
	}

	public void setPersonIdentityName(String personIdentityName) {
		this.personIdentityName = personIdentityName;
	}

	@Override
	public String toString() {
		return "PersonIdentityModel [id=" + id + ", personIdentityName=" + personIdentityName + "]";
	}
	
	
}
