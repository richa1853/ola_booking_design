package com.richa.entity;

public class Rider {
	
	private String id;
	private String riderName;
	private Location riderLoc;
	
	public Rider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rider(String id, String riderName) {
		super();
		this.id = id;
		this.riderName = riderName;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}

	public Location getRiderLoc() {
		return riderLoc;
	}

	public void setRiderLoc(Location riderLoc) {
		this.riderLoc = riderLoc;
	}
	@Override
	public String toString() {
		return "Rider [id=" + id + ", riderName=" + riderName + ", riderLoc=" + riderLoc + "]";
	}
	
	
}
