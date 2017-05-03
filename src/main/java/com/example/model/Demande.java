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
	@JoinColumn(name = "id_requester", nullable = false, updatable = false)
	private Agent requester;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_approver", nullable = false, updatable = false)
	private Agent approver;
	
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
	
	public Demande()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the demandeur
	 */
	public Agent getRequester()
	{
		return requester;
	}
	
	/**
	 * @return the approber
	 */
	public Agent getApprover()
	{
		return approver;
	}
	
	/**
	 * @param approber
	 *            the approber to set
	 */
	public void setApprover(Agent approver)
	{
		this.approver = approver;
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
	 * @param expiryDate
	 *            the expiryDate to set
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
	public void setRequester(Agent agent)
	{
		this.requester = agent;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Demande [id=" + id + ", requester=" + requester + ", approver="
				+ approver + ", ressource=" + ressource + ", creationDate="
				+ creationDate + ", modificationDate=" + modificationDate
				+ ", expiryDate=" + expiryDate + ", goals=" + goals + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((approver == null) ? 0 : approver.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((goals == null) ? 0 : goals.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((modificationDate == null) ? 0
				: modificationDate.hashCode());
		result = prime * result
				+ ((requester == null) ? 0 : requester.hashCode());
		result = prime * result
				+ ((ressource == null) ? 0 : ressource.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demande other = (Demande) obj;
		if (approver == null)
		{
			if (other.approver != null)
				return false;
		} else if (!approver.equals(other.approver))
			return false;
		if (creationDate == null)
		{
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (expiryDate == null)
		{
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (goals == null)
		{
			if (other.goals != null)
				return false;
		} else if (!goals.equals(other.goals))
			return false;
		if (id != other.id)
			return false;
		if (modificationDate == null)
		{
			if (other.modificationDate != null)
				return false;
		} else if (!modificationDate.equals(other.modificationDate))
			return false;
		if (requester == null)
		{
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
			return false;
		if (ressource == null)
		{
			if (other.ressource != null)
				return false;
		} else if (!ressource.equals(other.ressource))
			return false;
		return true;
	}
	
}
