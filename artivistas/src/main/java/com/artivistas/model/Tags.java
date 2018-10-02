package com.artivistas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tags {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String tag;
	
	@ManyToMany(mappedBy = "tags")
	private List<HabilityUser> habilityUsers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<HabilityUser> getHabilityUsers() {
		return habilityUsers;
	}

	public void setHabilityUsers(List<HabilityUser> habilityUsers) {
		this.habilityUsers = habilityUsers;
	}
	
	
	
	
	
	
}
