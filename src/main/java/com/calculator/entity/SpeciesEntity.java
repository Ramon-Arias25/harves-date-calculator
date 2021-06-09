package com.calculator.entity;
import org.springframework.stereotype.Component;
/**
 * @author ramon.arias
 * date: 03/06/2021
 * current version: 1.2
 */
@Component
public class SpeciesEntity{
	private String name;
	private float possibleSeedlings;
	private String harvestDate;
	
	public SpeciesEntity() {
		super();
	}

	public String getSpecies() {
		return name;
	}
	
	public void setSpecies(String name) {
		this.name= name;
	}
	public float getPossibleSeedlings() {
		return possibleSeedlings;
	}
	public void setPossibleSeedlings(float possibleSeedlings) {
		this.possibleSeedlings = possibleSeedlings;
	}

	public String getHarvestDate() {
		return harvestDate;
	}

	public void setHarvestDate(String harvestDate) {
		this.harvestDate = harvestDate;
	}
	
}