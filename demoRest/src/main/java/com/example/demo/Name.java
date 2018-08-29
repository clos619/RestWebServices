package com.example.demo;


public class Name {


	public long id;
	public String firstName;
	public String lastName;
	public String hobbies;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public Name() {
		
	}
	public Name(long id, String firstName, String lastName, String hobbies) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hobbies = hobbies;
	}
	@Override
	public String toString() {
		return "Name [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hobbies=" + hobbies + "]";
	}
	

	
}
