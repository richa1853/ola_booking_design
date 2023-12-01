package com.richa.entity;

public class Trip {
	
	private String tripId;
	private Cab cab;
	private Rider rider;
	
	private Location currLoc;
	private Location startLocation;
	private Location endLocation;
	
//	private double price;
	
	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Trip(String tripId, Cab cab, Rider rider, Location currLoc, Location startLocation, Location endLocation) {
//		this.tripId = tripId;
//		this.cab = cab;
//		this.rider = rider;
//		this.currLoc = currLoc;
//		this.startLocation = startLocation;
//		this.endLocation = endLocation;
//		//this.price = price;
//	}
	  public Trip(String tripId, Cab cab, Rider rider, Location currLoc, Location startLocation, Location endLocation) {
	        this.tripId = tripId;
	        this.cab = cab;
	        this.rider = rider;
	        this.currLoc = currLoc;
	        this.startLocation = startLocation;
	        this.endLocation = endLocation;
	    }

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
		
	}
	

	public Location getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	public Location getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	public Location getCurrLoc() {
		return currLoc;
	}

	public void setCurrLoc(Location currLoc) {
		this.currLoc = currLoc;
	}

//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
	
	

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", cab=" + cab + ", rider=" + rider + ", currLoc=" + currLoc
				+ ", startLocation=" + startLocation + ", endLocation=" + endLocation + "]";
	}

	
	
	
	

}
