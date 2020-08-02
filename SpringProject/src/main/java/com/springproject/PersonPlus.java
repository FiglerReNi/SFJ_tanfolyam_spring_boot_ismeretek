package com.springproject;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//itt mondom meg mivel akarom összekötni az osztályváltozókat a properties-ből
@ConfigurationProperties(prefix = "person-plus")
//A csoportos konfigurációhoz (hogy ki tudjunk olvasni a propertiesből értékeket) bean-nek kell lennie
@Component
public class PersonPlus {

	//Értékeket állítunk be hozzájuk a properties fájlban., de meg lehet csinálni úgy az összekötést, hogy nem egyesével kell a @Value
	//annotációval. Fontos, hogy a propertiesben a változó nevek ugyanígy szerepeljenek, vagy kötőjellel:
	// firstName vagy first-name
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String phoneNumber;
	
	public PersonPlus() {}
	
	public PersonPlus(String firstName, String lastName, int age, String address, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
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
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
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
		return "PersonPlus [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
