package com.richa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.richa.entity.Cab;
import com.richa.entity.Location;
import com.richa.entity.Rider;
import com.richa.entity.Trip;
import com.richa.exceptions.CabNotFoundException;
import com.richa.exceptions.TripNotFoundException;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TripService {

	private CabService cabService;

	private RiderService riderService;

//	private double price;

	public TripService(CabService cabService, RiderService riderService) {
		super();
		this.cabService = cabService;
		this.riderService = riderService;
//		this.price = price;
	}

	HashMap<String, Trip> trips = new HashMap<>();
	double maxDist = 50000.0;


	public static String generateUUID() {
		return UUID.randomUUID().toString();
}
	
	public void createTrip(String cabId, String riderId, Location startLocation, Location endLocation) {
	    double checkDistance = startLocation.distance(endLocation);
	    if (checkDistance <= maxDist) {
	        String tripId = generateUUID(); // Generate the tripId
	        Trip trip = new Trip(tripId,cabService.getCab(cabId), riderService.getRider(riderId), null, startLocation, endLocation);
	        
	        Cab cab = cabService.getCab(cabId);
	        cab.setCurrentTrip(trip);
	        cab.setTripId(tripId);
	        trip.setTripId(tripId);
	        trip.setCab(cab);
	       
	        System.out.println("Cab created in trip is " + cab);
	        System.out.println("Trip created is " + trip);
	        
	        trips.put(trip.getTripId(), trip);
	    }
	}
	public void endTrip(String tripId, Location endLocation) {

	    System.out.println("Ending trip with ID: " + tripId);
	    if (!trips.containsKey(tripId)) {
	        System.out.println("Trips map contents: " + trips);
	        throw new TripNotFoundException();
	    }
	    Trip trip = trips.get(tripId);

	    Cab cab = trip.getCab();
	    if (cab == null) {
	        throw new CabNotFoundException();
	    }

	    trip.setEndLocation(endLocation);
	    cab.setCurrentTrip(null);
	    System.out.println("Trip ended is " + trip);
	    
	    //trips.remove(tripId);
	}


	public List<Trip> fetchTripHistory() {
		List<Trip> allTrips = new ArrayList<>();
		for (Map.Entry<String, Trip> mp : trips.entrySet()) {
			Trip val = mp.getValue();
			allTrips.add(val);
		}
		return allTrips;

	}

}
