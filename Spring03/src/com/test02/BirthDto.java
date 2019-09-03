package com.test02;

public class BirthDto {
	
	private String name;
	private String birth;
	
	public BirthDto() {
		super();
	}
	
	public BirthDto(String name, String birth) {
		super();
		this.name = name;
		this.birth = birth;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		
		return "name : " + name + " / birth : " + birth;
	}
	
}
