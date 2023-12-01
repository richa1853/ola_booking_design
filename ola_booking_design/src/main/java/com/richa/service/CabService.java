package com.richa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.richa.entity.Cab;
import com.richa.entity.Location;
import com.richa.entity.Rider;
import com.richa.exceptions.CabAlreadyExists;
import com.richa.exceptions.CabNotFoundException;

import lombok.NonNull;

@Service
public class CabService {

	Map<String, Cab> cabs = new HashMap<>();

	public void createCab(@NonNull final Cab cab) {
		if (cabs.containsKey(cab.getId())) {
			throw new CabAlreadyExists();
		} else {   
		//	System.out.println("cab created is "+cab);
			cabs.put(cab.getId(), cab);
		}
	}
	public Cab getCab(@NonNull final String cabId) {
		if(!cabs.containsKey(cabId)) {
			throw new CabNotFoundException();
		}
		return cabs.get(cabId);
	}

	public void updateAvailability(String cabId ,Location source) {
		if (!cabs.containsKey(cabId)) {
			throw new CabNotFoundException();
		} else {
			Cab cab=cabs.get(cabId);
			Location cabLoc = cab.getCabLoc();
			double distance = cabLoc.distance(source);
			//System.out.println(distance);
			
			if ( distance <= 1000) {
				cab.setAvailable(true);
				//System.out.println(cab);
			} else {
//				System.out.println(cab);
				cab.setAvailable(false);
			}
		//	System.out.println(cab);
		}
	}
	
	public void updateCabLocation(String cabId,Location newLocation) {
		if (cabs.containsKey(cabId)) {
			cabs.get(cabId).setCabLoc(newLocation);		
		}
		else {
			throw new CabNotFoundException();
		}
	}
	
	public List<Cab> getAllCabs(Location source, double dest){
		List<Cab>cablist=new ArrayList<>();
		for(Map.Entry<String,Cab>mp:cabs.entrySet()) {
			Cab val=mp.getValue();
			if(val.getCabLoc().distance(source)<=dest && val.isAvailable()) {
				cablist.add(val);
			}
		}
		return cablist;
	}

}
