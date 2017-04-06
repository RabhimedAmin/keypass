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
	@JoinColumn(name = "id", nullable = false, updatable = false)
	private Ressource ressource;
	
	@CreatedDate
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	@LastModifiedDate
	@Column(name = "modif_date")
	private LocalDateTime modificationDate;
	
	@Column(name = "expiry_date")
	private LocalDateTime expiryDate;
	
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
				+ getAgent() + ", getRessource()=" + getRessource()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * @return the agent
	 */
	public Agent getAgent()
	{
		return demandeur;
	}
	
	/**
	 * @param agent
	 *            the agent to set
	 */
	public void setAgent(Agent agent)
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
	
	/**
	 * 
	 */
	public Demande()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param agent
	 * @param ressource
	 */
	public Demande(long id, Agent agent, Ressource ressource)
	{
		super();
		this.id = id;
		this.demandeur = agent;
		this.ressource = ressource;
	}
	
}
