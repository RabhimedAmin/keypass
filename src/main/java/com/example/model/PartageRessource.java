package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class PartageRessource
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(orphanRemoval = false)
	@JoinColumn(name = "PartageRessourceId")
	private List<Demande> demandePartageRessource;
	
	@OneToMany(orphanRemoval = false)
	@JoinColumn(name = "PartageRessourceId")
	private List<Ressource> ressourceApartager;
	
	@CreatedDate
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	@LastModifiedDate
	@Column(name = "modif_date")
	private LocalDateTime modificationDate;
	
	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;
	
	/**
	 * 
	 */
	public PartageRessource()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}
	
	/**
	 * @param demandePartageRessource
	 *            the demandePartageRessource to set
	 */
	public void setDemandePartageRessource(
			List<Demande> demandePartageRessource)
	{
		this.demandePartageRessource = demandePartageRessource;
	}
	
	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(LocalDateTime creationDate)
	{
		this.creationDate = creationDate;
	}
	
	/**
	 * @param modificationDate
	 *            the modificationDate to set
	 */
	public void setModificationDate(LocalDateTime modificationDate)
	{
		this.modificationDate = modificationDate;
	}
	
	/**
	 * @param expirationDate
	 *            the expirationDate to set
	 */
	public void setExpirationDate(LocalDateTime expirationDate)
	{
		this.expirationDate = expirationDate;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PartageRessource [id=" + id + ", demandePartageRessource="
				+ demandePartageRessource + ", creationDate=" + creationDate
				+ ", modificationDate=" + modificationDate + ", expirationDate="
				+ expirationDate + "]";
	}
	
}
