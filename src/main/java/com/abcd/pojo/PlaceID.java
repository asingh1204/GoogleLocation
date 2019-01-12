package com.abcd.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceID {
	
@JsonProperty("place_id")
private String placeId;

public String getPlaceId() {
	return placeId;
}

public void setPlaceId(String placeId) {
	this.placeId = placeId;
}

}
