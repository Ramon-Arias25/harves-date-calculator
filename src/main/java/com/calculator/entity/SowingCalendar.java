package com.calculator.entity;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ramon.arias 
 * date: 03/06/2021 
 * current version: 1.2
 */
@Entity
@Table(name = "especie")
public class SowingCalendar {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "especie")
	private String species;// especie

	@Column(name = "distancia")
	private float distance;// distancia

	@Column(name = "plantacion")
	private String seedTime;// plantacion

	@Column(name = "dias")
	private int dayCount;// dias

	public SowingCalendar() {
		super();
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

	public String getSeedTime() {
		return seedTime;
	}

	public void setSeedTime(String seedTime) {
		this.seedTime = seedTime;
	}

	@Override
	public String toString() {
		return "SowingCalendar [id=" + id + ", species=" + species + ", distance=" + distance + ", seedTime=" + seedTime
				+ ", dayCount=" + dayCount + "]";
	}
}
