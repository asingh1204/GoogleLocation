package com.abcd.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

import com.abcd.pojo.PlaceID;
import com.abcd.pojo.PlaceIDInfo;
import com.abcd.pojo.PlaceIDResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;


@Service
public class LocationServiceLayer {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	public PlaceIDResponse getPlaceIddetails(String input) throws Exception {
		//PlaceID placeid= new PlaceID();
		//byte[] binput= input.getBytes();
		StringBuilder uri = new StringBuilder("https://maps.googleapis.com/maps/api/place/autocomplete/json?input=");
		
		final String stri= (uri.append(new String(java.net.URLEncoder.encode(input, "UTF-8").replaceAll("\\+", "%20"))).append("&").append("key=**************************************")).toString();
                                                                                                                                                                                       
		URL url = new URL(stri);
		HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/x-www-form-urlencoded");
		http.setRequestProperty("charset", "UTF-8");
		http.setRequestProperty("User-Agent", "Mozilla/5.0");
		http.setRequestMethod("GET");
		
		http.connect();
		StringBuilder str = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
			str = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				str.append(line + "\n");
			}
			//System.out.println(str.toString());
			http.disconnect();
			reader.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		ObjectReader reader=mapper.readerFor(PlaceIDResponse.class);
		PlaceIDResponse placeIDResponse= reader.readValue(str.toString());
		
		return placeIDResponse;
		
	}
	
	public PlaceIDInfo getPlaceIdinfo(String input) throws Exception {
		byte[] binput= input.getBytes();
		StringBuilder uri = new StringBuilder("https://maps.googleapis.com/maps/api/place/details/json?placeid=");
		final String stri= (uri.append(new String(binput, "UTF-8")).append("&").append("key=**************************************")).toString();
		//final String stri="https://www.google.com/" ;
		//Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.0.0", 8080));
		URL url = new URL(stri);
		HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/x-www-form-urlencoded");
		http.setRequestProperty("charset", "UTF-8");
		http.setRequestProperty("User-Agent", "Mozilla/5.0");
		http.setRequestMethod("GET");
		
		http.connect();
		StringBuilder str = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
			str = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				str.append(line + "\n");
			}
			//System.out.println(str.toString());
			http.disconnect();
			reader.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		ObjectReader reader=mapper.readerFor(PlaceIDInfo.class);
		PlaceIDInfo placeIDInfo= reader.readValue(str.toString());
		
		return placeIDInfo;
		
	}
	
}
