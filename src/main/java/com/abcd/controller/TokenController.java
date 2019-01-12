package com.abcd.controller;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcd.pojo.PlaceIDInfo;
import com.abcd.pojo.PlaceIDResponse;
import com.abcd.services.LocationServiceLayer;


@RestController
@RequestMapping(path="/auth")
public class TokenController {
	
	@Autowired 
	LocationServiceLayer locationServiceLayer;
	
	@GetMapping(path="/location",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PlaceIDResponse getPlaceID(@RequestParam("input") String input)
	{
		
		PlaceIDResponse placeId=null;
		if(input !=null) {
			try {
				placeId= locationServiceLayer.getPlaceIddetails(input);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return placeId;
		
		
	}
	
	
	@GetMapping(path="/locationInfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PlaceIDInfo getPlaceIDInfo(@RequestParam("placeID") String input)
	{
		
		PlaceIDInfo placeId=null;
		if(input !=null) {
			try {
				placeId= locationServiceLayer.getPlaceIdinfo(input);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return placeId;
		
		
	}
	
	@GetMapping(path="/online",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String welcome()
	{
		
		String placeId="Welcome";
		
		return placeId;
		
		
	}

}
