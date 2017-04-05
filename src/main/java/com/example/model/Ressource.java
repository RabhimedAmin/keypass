package com.example.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(value = { AuditingEntityListener.class })
public class Ressource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "x")
	private String x;
	
	@Column(name = "date_creation")
	@CreatedDate
	private Date dateCreation;
	
	@Column(name = "date_fin")
	private Date dateFin;

	/**
	 * 
	 */
	public Ressource() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idRessources
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the x
	 */
	public String getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(String x) {
		this.x = x;
	}
	/**
	 * @return the dateDeCreation
	 */
	public Date getDateDeCreation() {
		return dateCreation;
	}
	/**
	 * @param dateDeCreation the dateDeCreation to set
	 */
	public void setDateDeCreation(Date dateDeCreation) {
		this.dateCreation = dateDeCreation;
	}
	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
