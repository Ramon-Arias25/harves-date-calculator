package com.calculator.entity;
import org.springframework.stereotype.Component;

@Component
public class SpeciesEntity{
	private String species;
	private float possibleSeedlings;
	private String harvestDate;
	
	public SpeciesEntity() {
		super();
	}

	public String getSpecies() {
		return species;
	}
	
	public void setSpecies(String species) {
		this.species = species;
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