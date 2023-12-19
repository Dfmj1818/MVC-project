 package com.uptc.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
	private int id;
	private String name;
	private String lastName;
	private List<BookModel>userBooksList;
	
	public UserModel(){
		userBooksList=new ArrayList<BookModel>();
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setUserBooksList(List<BookModel>userBooksList){
		this.userBooksList=userBooksList;
	}
	
	public List<BookModel>getUserBooksList(){
		return userBooksList;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		StringBuilder userInformation=new StringBuilder();
		userInformation.append(getId())
		.append(getName()).append(" ")
		.append(getLastName()).append(" ");
		
		return userInformation.toString();
	}
	
}
