package com.richa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    @JsonProperty("x")
   public double x;

    @JsonProperty("y")
    public double y;
  
    public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	public Location(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}


	public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Location location2) {
        return Math.sqrt(Math.pow(this.x - location2.x, 2) + Math.pow(this.y - location2.y, 2));
    }

    @Override
    public String toString() {
        return "Location [x=" + x + ", y=" + y + "]";
    }
}
