package com.richa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cab {

	private String id;
	private String driverName;
//	private String cabNo;
	private Location cabLoc;
	private boolean isAvailable;

	@JsonIgnore
	private Trip currentTrip;
	private String tripId;

	public Cab() {
		// TODO Auto-generated constructor stub
	}

	public Cab(String id, String driverName, Location cabLoc, Trip currentTrip) {
		this.id = id;
		this.driverName = driverName;
		this.cabLoc = cabLoc;
		this.isAvailable = true;
		this.currentTrip = currentTrip;

		// Initialize tripId to an empty string
		this.tripId = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Location getCabLoc() {
		return cabLoc;
	}

	public void setCabLoc(Location cabLoc) {
		this.cabLoc = cabLoc;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Trip getCurrentTrip() {
		return currentTrip;
	}

	public void setCurrentTrip(Trip currentTrip) {
		this.currentTrip = currentTrip;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	@Override
	public String toString() {
		String tripDetails = (currentTrip != null) ? currentTrip.getTripId() : "No current trip";
		return "Cab [id=" + id + ", driverName=" + driverName + ", cabLoc=" + cabLoc + ", isAvailable=" + isAvailable
				+ ", currentTrip=" + tripDetails + ", tripId=" + tripId + "]";
	}

}
