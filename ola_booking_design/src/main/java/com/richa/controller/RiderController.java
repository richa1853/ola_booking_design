package com.richa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.richa.entity.Cab;
import com.richa.entity.Location;
import com.richa.entity.Rider;
import com.richa.entity.Trip;
import com.richa.service.RiderService;
import com.richa.service.TripService;

@RestController
@RequestMapping("/rider")
public class RiderController {
	
	private RiderService riderService;
	private TripService tripService;
	
	public RiderController(RiderService riderService, TripService tripService) {
		super();
		this.riderService = riderService;
		this.tripService = tripService;
	}
	
	@PostMapping("/register")
	public void registerRider(@RequestBody final Rider newRider) {
		riderService.registerRider(newRider);
	}

	
	@PostMapping("/addtrip/{cabId}/{riderId}")
	public void createTrip(
	   @PathVariable String cabId,
	   @PathVariable String riderId,
	   @RequestBody Map<String, Location> requestBody
	) {
	   Location startLocation = requestBody.get("startLocation");
	   Location endLocation = requestBody.get("endLocation");
	   tripService.createTrip(cabId, riderId, startLocation, endLocation);
	}
	
	@GetMapping("/alltrips")
	public List<Trip>fetchTripHistory(){
		List<Trip> trips=tripService.fetchTripHistory();
		return trips;	
	}
	
	
	
	
	
	

}
