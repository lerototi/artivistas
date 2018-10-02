package com.artivistas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hability_base")
public class HabilityBase {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "HabilityBase")
	private List<HabBaseProfileUser> habBaseProfileUsers;
	
	@ManyToMany(mappedBy = "habilitiesBase")
	private List<HabilityClassification> Classification = new ArrayList<HabilityClassification>();

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

	public List<HabBaseProfileUser> getHabBaseProfileUsers() {
		return habBaseProfileUsers;
	}

	public void setHabBaseProfileUsers(List<HabBaseProfileUser> habBaseProfileUsers) {
		this.habBaseProfileUsers = habBaseProfileUsers;
	}

	public List<HabilityClassification> getClassification() {
		return Classification;
	}

	public void setClassification(List<HabilityClassification> classification) {
		Classification = classification;
	}

	


}
