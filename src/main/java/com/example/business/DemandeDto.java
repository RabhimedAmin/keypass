/**
 * 
 */
package com.example.business;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.model.Demande;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.Data;

/**
 * @author user
 *
 */
@Data
public class DemandeDto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1257838457849716002L;
	
	private Long id_Requester;
	
	private Long id_Approver;
	
	//@JsonFormat(pattern="yy-mm-dd HH:mm:ss")
	@JsonDeserialize(using= LocalDateTimeDeserializer.class)
	private LocalDateTime expiryDate;
	
	private Long id_resource;
	
	private String goals;


	public Demande toModel()
	{
		Demande model = new Demande();
		model.setGoals(this.goals);
		model.setExpiryDate(this.expiryDate);
		return model;
	}
	
}
