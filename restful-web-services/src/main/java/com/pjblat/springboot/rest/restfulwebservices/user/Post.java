package com.pjblat.springboot.rest.restfulwebservices.user;

import java.util.Date;

public class Post
{
	private Integer id;
	private String subject;
	private String details;
	private Date createdDate;
	
	
	public Post()
	{
		super();
	}

	public Post(Integer id, String subject, String details, Date createdDate)
	{
		super();
		this.id = id;
		this.subject = subject;
		this.details = details;
		this.createdDate = createdDate;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getDetails()
	{
		return details;
	}

	public void setDetails(String details)
	{
		this.details = details;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}
	
	
}
