package com.pjblat.springboot.rest.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*
 * Adding comment to test my tag.
 *
 * Adding more comments
 */
@ApiModel(description="All details about the User")
public class User 
{
	private Integer id;
	
	@Size(min = 2, message="Name should have at least 2 characters")
	@ApiModelProperty(notes="name should have at least 2 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes="birthday should be in the past")
	private Date birthDate;
	
	// This is required for the POST Create User API
	protected User() {
		
	}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
