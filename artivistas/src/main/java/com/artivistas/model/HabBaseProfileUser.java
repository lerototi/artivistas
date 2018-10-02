package com.artivistas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name ="hab_base_prof_user")
public class HabBaseProfileUser {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="fk_hability_user", referencedColumnName = "id")
	private HabilityUser habilityUser;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "fk_hability_base", referencedColumnName = "id")
	private HabilityBase HabilityBase;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HabilityUser getHabilityUser() {
		return habilityUser;
	}

	public void setHabilityUser(HabilityUser habilityUser) {
		this.habilityUser = habilityUser;
	}

	public HabilityBase getHabilityBase() {
		return HabilityBase;
	}

	public void setHabilityBase(HabilityBase habilityBase) {
		HabilityBase = habilityBase;
	}
	
}
