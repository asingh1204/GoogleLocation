package com.abcd.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("formatted_address")
	private String address;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("url")
	private String url; 
	
	@JsonProperty("geometry")
	private Geometry geometry;

}
