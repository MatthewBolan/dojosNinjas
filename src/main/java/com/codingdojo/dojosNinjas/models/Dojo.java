package com.codingdojo.dojosNinjas.models;

import java.sql.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

@Table(name="dojos")

public class Dojo {
    
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    private String name;
    
    @Column(updatable=false)
    
    private Date createdAt;
    
    private Date updatedAt;
    
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    
    private List<Ninja> ninjas;
    
    public Dojo() {
        
    }

    
    
    
    
    

	public Dojo(
			
		@NotNull @Size(min = 3, max = 25, message = "Dojo Name Needs to be within 3 - 25 letters!") String name) {
		
		super();
		
		this.name = name;
		
	}




	public Dojo(
			
		@NotNull @Size(min = 3, max = 25, message = "Dojo Name Needs to be within 3 - 25 letters!") String name,
		
		List<Ninja> ninjas) {
		
		super();
		
		this.name = name;
		
		this.ninjas = ninjas;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
    
    // getters and setters removed for brevity
    
    
    
    
    
    
    
    
  
}

