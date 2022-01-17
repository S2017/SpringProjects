package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private final UUID personId;
	private final String personName;

	public Person(@JsonProperty("id") UUID personId, @JsonProperty("name") String personName) {
		super();
		this.personId = personId;
		this.personName = personName;
	}

	public UUID getPersonId() {
		return personId;
	}

	public String getPersonName() {
		return personName;
	}

}
