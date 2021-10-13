package com.codingdojo.dojosNinjas.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

@Table(name="ninjas")

public class Ninja {
	
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    
    @NotNull 
    @Size(min = 5, max = 150)
    private String firstName;
    
    @NotNull 
    @Size(min = 5, max = 150)
    private String lastName;
    
    @NotNull 
    @Min(5) 
    private int age;
    
    
    @Column(updatable=false)
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    
    @JoinColumn(name="dojo_id")
    
    private Dojo dojo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    
    
    
    
    public Ninja() {}   
    
    
    
    
    
    
    
    
    
    
    public Ninja(
    		
    		@NotNull @Size(min = 5, max = 150) String firstName,
    		
    		@NotNull @Size(min = 5, max = 150) String lastName,
    		
    		@NotNull @Min(5) int age) {
    	
		super();
		
		this.firstName = firstName;
		
		this.lastName = lastName;
		
		this.age = age;
		
		
	}
	
	


	public Ninja(
			
			@NotNull 
			@Size(min = 5, max = 150, message = "Ninj's name must be at least 5 chars long!") String firstName,
			
			@NotNull 
			@Size(min = 5, max = 150, message = "Ninj's name must be at least 5 chars long!") String lastName,
			
			@NotNull 
			@Min(value = 5, message = "No tiny Ninjs!!") int age, Dojo dojo) {
		
		super();
		
		this.firstName = firstName;
		
		this.lastName = lastName;
					
		this.age = age;
						
		this.dojo = dojo;
		
	}












	public Ninja(User user) {
		super();
		this.user = user;
	}










	public User getUser() {
		return user;
	}










	public void setUser(User user) {
		this.user = user;
	}










	public Long getId() {
		return id;
	}












	public void setId(Long id) {
		this.id = id;
	}












	public String getFirstName() {
		return firstName;
	}












	public void setFirstName(String firstname) {
		this.firstName = firstname;
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












	public Date getCreatedAt() {
		return createdAt;
	}












	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}












	public Date getUpdatedAt() {
		return updatedAt;
	}












	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Dojo getDojo() {
		return dojo;
	}












	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}



  
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		
		this.updatedAt = new Date();
	}   
    
    
}
