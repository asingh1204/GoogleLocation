package com.abcd.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Predictions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("place_id")
    private String placeID;
	
	@JsonProperty("description")
	private String description;

	public String getPlaceID() {
		return placeID;
	}

	public void setPlaceID(String placeID) {
		this.placeID = placeID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

}