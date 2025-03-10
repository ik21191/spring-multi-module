package com.mypack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSON_IDENTITY")
public class PersonIdentity {

	@Id
	/*@SequenceGenerator(sequenceName = "PERSON_IDENTITY_ID_SEQ", initialValue = 1, allocationSize = 1, name = "PERSON_IDENTITY_ID_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_IDENTITY_ID_SEQ_GENERATOR")*/
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_IDENTITY_ID")
	private Long id;
	
	
	@Column(name = "PERSON_IDENTITY_NAME")
	private String personIdentityName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", nullable = false)
	private PersonEntity personEntity;
	
	public PersonIdentity() {
		System.out.println("Object of PersonIdentity created.");
	}

	public PersonIdentity(String personIdentityName) {
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

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	
	
	
}
