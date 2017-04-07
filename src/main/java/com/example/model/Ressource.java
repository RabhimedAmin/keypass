package com.example.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Ressource
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "x")
	private String x;
	
	@CreatedDate
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	@LastModifiedDate
	@Column(name = "modif_date")
	private LocalDateTime modificationDate;
	
	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;
	
	/**
	 * @param idRessource
	 * @param x
	 * @param dateDeCreation
	 * @param dateFin
	 */
	// public Ressource(Long id, String x, Date dateDeCreation, Date dateFin)
	// {
	// super();
	// this.id = id;
	// this.x = x;
	// this.dateCreation = dateDeCreation;
	// this.dateFin = dateFin;
	// }
	
	/**
	 * 
	 */
	public Ressource()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the idRessources
	 */
	public Long getId()
	{
		return id;
	}
	
	/**
	 * @return the x
	 */
	public String getX()
	{
		return x;
	}
	
	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(String x)
	{
		this.x = x;
	}

	/**
	 * @return the creationDate
	 */
	public LocalDateTime getCreationDate()
	{
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(LocalDateTime creationDate)
	{
		this.creationDate = creationDate;
	}

	/**
	 * @return the modificationDate
	 */
	public LocalDateTime getModificationDate()
	{
		return modificationDate;
	}

	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(LocalDateTime modificationDate)
	{
		this.modificationDate = modificationDate;
	}

	/**
	 * @return the expirationDate
	 */
	public LocalDateTime getExpirationDate()
	{
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(LocalDateTime expirationDate)
	{
		this.expirationDate = expirationDate;
	}
	
	
}
