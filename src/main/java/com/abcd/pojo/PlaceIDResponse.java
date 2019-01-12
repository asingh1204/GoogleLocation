package com.abcd.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceIDResponse implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("status")
private String status;

	@JsonProperty("predictions")
private List<Predictions> predictions;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

public List<Predictions> getPredictions() {
	return predictions;
}
public void setPredictions(List<Predictions> predictions) {
	this.predictions = predictions;
}
}