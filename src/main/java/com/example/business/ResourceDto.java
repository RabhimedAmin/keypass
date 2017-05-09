/**
 * 
 */
package com.example.business;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.model.Resource;

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

	public Resource toModel()
	{
		Resource model = new Resource();
		model.setDescription(this.description);
		model.setExpirationDate(this.expirationDate);
		return model;
	}
	
}
