package com.richa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richa.entity.Cab;
import com.richa.entity.Location;
import com.richa.service.CabService;
import com.richa.service.TripService;

import lombok.NonNull;

@RestController
@RequestMapping("/cab")
public class CabController {
	
	private CabService cabService;
	private TripService tripService;

	public CabController(CabService cabService, TripService tripService) {
		this.cabService = cabService;
		this.tripService=tripService;
	}
	
	@PostMapping("/add")
	public void createCab(@RequestBody final Cab cab) {
		cabService.createCab(cab);
		
	}
	
	@PutMapping("/update/Availability/{cabId}")
	public void updateAvailability(@PathVariable String cabId, @RequestBody Location source) {
		cabService.updateAvailability(cabId,source);
		
	}
	
	@PutMapping("/update/cabs/Location")
	public void updateCabLocation(@PathVariable String cabId, @RequestBody Location newLocation) {
		cabService.updateCabLocation(cabId, newLocation);
	}
	
	@GetMapping("/{cabId}")
	public Cab getCab(@PathVariable @NonNull String cabId) {
	    Cab cabb = cabService.getCab(cabId);
	    return cabb;
	}

	
	@PutMapping("/end/trip/{tripId}")
	public void endTrip(@PathVariable String tripId,@RequestBody Location endLocation) {
		tripService.endTrip(tripId, endLocation);
	}
	

}
