/**
 * 
 */
package com.example.business;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.model.Ressource;

import lombok.Data;

/**
 * @author user
 *
 */
@Data
public class ResourceDto implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	private LocalDateTime expirationDate;

	/**
	 * 
	 */
	public ResourceDto()
	{
		super();
	}

	public Ressource toModel()
	{
		Ressource model = new Ressource();
		model.setDescription(this.description);
		model.setExpirationDate(this.expirationDate);
		return model;
	}
	
}
