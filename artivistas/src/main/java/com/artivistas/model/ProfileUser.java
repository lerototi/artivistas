package com.artivistas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profile_user")
public class ProfileUser implements Serializable {
	private static final long serialVersionUID = -1863924516765427865L;

	@Id
	@GeneratedValue
	@Column(name = "id_profile")
	private Integer idProfile;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "surname", nullable = false, length = 50)
	private String surname;

	// TODO carregar imagem
	// @Column(name="image", nullable = true)
	// private String Image;

	@Column(name = "description", nullable = true, length = 500)
	private String description;

	@Column(name = "facebook", nullable = true, length = 50)
	private String facebook;

	@Column(name = "instagram", nullable = true, length = 50)
	private String instagram;

	@Column(name = "date_brithday", nullable = false)
	private Date dateOfBrithday;

	@Column(name = "date_creation_pf", nullable = false)
	private Date dateOfCreationProfile;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private User user;
	
	@OneToMany(mappedBy = "pflUser")
	private List<ProfileColetive> pflsColetive;
	
	
	@OneToMany(mappedBy = "pflUser") 
	private List<ProfileIndividual> pflsIndividual;
	

	// @Column(name = "Country", nullable = false)
	// private Country country;

	// TODO Reationament ProfileIndividual to Category
	// private Category category;

	// TODO Relationament ProfileIndividual to followers
	// @OneToMany
	// private List<Followers> flwing;

	

	// TODO Relationament profileUser to Coletive
	
	
	

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public Date getDateOfBrithday() {
		return dateOfBrithday;
	}

	public void setDateOfBrithday(Date dateOfBrithday) {
		this.dateOfBrithday = dateOfBrithday;
	}

	public Date getDateOfCreationProfile() {
		return dateOfCreationProfile;
	}

	public void setDateOfCreationProfile(Date dateOfCreationProfile) {
		this.dateOfCreationProfile = dateOfCreationProfile;
	}
	

}
