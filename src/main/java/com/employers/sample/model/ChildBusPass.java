package com.employers.sample.model;

public class ChildBusPass {
	
	private Person person;

	public ChildBusPass() {
		
	}
	
	public ChildBusPass(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
