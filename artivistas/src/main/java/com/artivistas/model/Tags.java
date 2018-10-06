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
	
	@Column(nullable = false, name  = "name", unique=true)
	private String nameTag;
	
	@ManyToMany(mappedBy = "tags")
	private List<HabilityUser> habilityUsers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameTag() {
		return nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

	public List<HabilityUser> getHabilityUsers() {
		return habilityUsers;
	}

	public void setHabilityUsers(List<HabilityUser> habilityUsers) {
		this.habilityUsers = habilityUsers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((habilityUsers == null) ? 0 : habilityUsers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameTag == null) ? 0 : nameTag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tags other = (Tags) obj;
		if (habilityUsers == null) {
			if (other.habilityUsers != null)
				return false;
		} else if (!habilityUsers.equals(other.habilityUsers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nameTag == null) {
			if (other.nameTag != null)
				return false;
		} else if (!nameTag.equals(other.nameTag))
			return false;
		return true;
	}
	
	
}
