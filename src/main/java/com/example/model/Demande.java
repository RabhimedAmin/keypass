package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(value = { AuditingEntityListener.class })
public class Demande
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_demandeur", nullable = false, updatable = false)
	private Agent demandeur;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_approber", nullable = false, updatable = false)
	private Agent approber;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_ressource", nullable = false, updatable = false)
	private Ressource ressource;
	
	@CreatedDate
	@Column(name = "creation_date", columnDefinition = "DATETIME")
	private LocalDateTime creationDate;
	
	@LastModifiedDate
	@Column(name = "modif_date", columnDefinition = "DATETIME")
	private LocalDateTime modificationDate;
	
	@Column(name = "expiry_date", columnDefinition = "DATETIME")
	private LocalDateTime expiryDate;
	
	private String goals;
	
	/**
	 * @return the demandeur
	 */
	public Agent getDemandeur()
	{
		return demandeur;
	}
	
	/**
	 * @return the approber
	 */
	public Agent getApprober()
	{
		return approber;
	}
	
	
	/**
	 * @param approber the approber to set
	 */
	public void setApprober(Agent approber)
	{
		this.approber = approber;
	}

	/**
	 * @return the creationDate
	 */
	public LocalDateTime getCreationDate()
	{
		return creationDate;
	}
	
	/**
	 * @return the modificationDate
	 */
	public LocalDateTime getModificationDate()
	{
		return modificationDate;
	}
	
	/**
	 * @return the expiryDate
	 */
	public LocalDateTime getExpiryDate()
	{
		return expiryDate;
	}
	
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(LocalDateTime expiryDate)
	{
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}
	
	/**
	 * @param agent
	 *            the agent to set
	 */
	public void setDemandeur(Agent agent)
	{
		this.demandeur = agent;
	}
	
	/**
	 * @return the ressource
	 */
	public Ressource getRessource()
	{
		return ressource;
	}
	
	/**
	 * @param ressource
	 *            the ressource to set
	 */
	public void setRessource(Ressource ressource)
	{
		this.ressource = ressource;
	}
	
	public String getGoals()
	{
		return goals;
	}

	public void setGoals(String goals)
	{
		this.goals = goals;
	}

	/**
	 * 
	 */
	public Demande()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Demande [id=" + id + ", agent=" + demandeur + ", ressource="
				+ ressource + ", getId()=" + getId() + ", getAgent()="
				+ getDemandeur() + ", getRessource()=" + getRessource()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
