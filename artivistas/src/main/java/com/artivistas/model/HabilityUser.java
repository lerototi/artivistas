package com.artivistas.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name ="hability_user")
public class HabilityUser {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Date since;
	
	@Column
	private Date until;
	
	@Column(name = "current_date", nullable = false)
	private boolean untilToday;
	
	@OneToMany(mappedBy = "habilityUser", fetch = FetchType.LAZY)
	private List<HabBaseProfileUser> habBasesProfileUsers;
	
	@ManyToOne
	@JoinColumn(name = "fk_profile_user")
	private ProfileUser profileUser;
	
	@ManyToMany
	@JoinColumn(name = "fk_tag")
	private List<Tags> tags;

	public Long getId() {
		return id;
	}
	
	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSince() {
		return since;
	}

	public void setSince(Date since) {
		this.since = since;
	}

	public Date getUntil() {
		return until;
	}

	public void setUntil(Date until) {
		this.until = until;
	}

	public List<HabBaseProfileUser> getHabBasesProfileUsers() {
		return habBasesProfileUsers;
	}

	public void setHabBasesProfileUsers(List<HabBaseProfileUser> habBasesProfileUsers) {
		this.habBasesProfileUsers = habBasesProfileUsers;
	}

}
