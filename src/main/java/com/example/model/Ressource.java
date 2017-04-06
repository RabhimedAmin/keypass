package com.example.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Ressource
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "x")
	private String x;
	
	@Column(name = "date_creation")
	private Date dateCreation;
	
	@Column(name = "date_fin")
	private Date dateFin;
	
	/**
	 * @param idRessource
	 * @param x
	 * @param dateDeCreation
	 * @param dateFin
	 */
	public Ressource(Long id, String x, Date dateDeCreation, Date dateFin)
	{
		super();
		this.id = id;
		this.x = x;
		this.dateCreation = dateDeCreation;
		this.dateFin = dateFin;
	}
	
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
	public long getId()
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
	 * @return the dateDeCreation
	 */
	public Date getDateDeCreation()
	{
		return dateCreation;
	}
	
	/**
	 * @param dateDeCreation
	 *            the dateDeCreation to set
	 */
	public void setDateDeCreation(Date dateDeCreation)
	{
		this.dateCreation = dateDeCreation;
	}
	
	/**
	 * @return the dateFin
	 */
	public Date getDateFin()
	{
		return dateFin;
	}
	
	/**
	 * @param dateFin
	 *            the dateFin to set
	 */
	public void setDateFin(Date dateFin)
	{
		this.dateFin = dateFin;
	}
	
}
