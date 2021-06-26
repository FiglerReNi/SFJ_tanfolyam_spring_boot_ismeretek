package com.springproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	//kimentjük az aktív profilt egy változóba
	@Value("${spring.profiles.active}")
	private String selectProfile;
	
	//profilból kiolvasás
	@Value("${text}")
	private String text;
	
	private String name;
	private int age;
	
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public String getSelectProfile() {
		return selectProfile;
	}

	public void setSelectProfile(String selectProfile) {
		this.selectProfile = selectProfile;
	}

	@Override
	public String toString() {
		return "Person [selectProfile=" + selectProfile + ", text=" + text + "]";
	}
	
}

