package com.calculator.entity;

import java.util.List;

public class SowingCalendar {
	private String species;
	private float distance;
	private List<?> seedTime;
	private int dayCount;
	
	public SowingCalendar(String species, float distance, List<?> seedTime, int dayCount) {
		super();
		this.species = species;
		this.distance = distance;
		this.seedTime = seedTime;
		this.dayCount = dayCount;
	}

	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}
	public List<?> getSeedTime() {
		return seedTime;
	}
	public void setSeedTime(List<?> seedTime) {
		this.seedTime = seedTime;
	}
}
