package com.example.turek.karol.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public class CatShowDTO {
	private String name;
	private int age;
	private String rase;

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

	public String getRase() {
		return rase;
	}

	public void setRase(String rase) {
		this.rase = rase;
	}
}
