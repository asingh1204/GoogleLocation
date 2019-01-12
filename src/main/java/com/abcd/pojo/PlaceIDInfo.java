package com.abcd.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceIDInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("result")
private Result result;
}
