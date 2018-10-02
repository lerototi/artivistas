package com.artivistas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hability_classification")
public class HabilityClassification implements Serializable {
	private static final long serialVersionUID = -1863924516765427865L;

	@Id
	@GeneratedValue
	@Column(name = "id_category")
	private Integer idCategory;
	
	@Column(length=40)
	private String name;
	
	@ManyToMany
	@JoinTable(name="Category_Habilities", 
	joinColumns = @JoinColumn(name="fk_category"), 
	inverseJoinColumns = @JoinColumn(name ="fk_habilities"))
	public List<HabilityBase> habilitiesBase = new ArrayList<HabilityBase>(); 

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HabilityBase> getHabilitiesBase() {
		return habilitiesBase;
	}

	public void setHabilitiesBase(List<HabilityBase> habilitiesBase) {
		this.habilitiesBase = habilitiesBase;
	}


}
