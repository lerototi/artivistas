package com.artivistas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_user")
	private Integer idUser;
	
	@Column(name = "mail", nullable = false, length = 50, unique=true)
	private String mail;
	@Column(name="cellphone", nullable =  false, length = 17)
	private String cellphone;
	@Column(name = "password", nullable = false, length = 150)
	private String password;
	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ProfileUser pflUser;
	
	@ManyToMany
	@JoinTable(name="user_auth", joinColumns  = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "auth_id"))
	private List<Authority> authorities;
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public ProfileUser getPflUser() {
		return pflUser;
	}
	public void setPflUser(ProfileUser pflUser) {
		this.pflUser = pflUser;
	}
		
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", mail=" + mail + ", cellphone=" + cellphone + ", password=" + password
				+ ", pflUser=" + pflUser + "]";
	}
	

	
	
}
