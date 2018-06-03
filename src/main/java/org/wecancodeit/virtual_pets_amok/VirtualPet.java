package org.wecancodeit.virtual_pets_amok;

public class VirtualPet {

	// Constants
	private static final int DEFAULT_PET_HEALTH = 10;
	private static final int DEFAULT_PET_HAPPINESS = 5;
	
	// Variables
	private String petName;
	private int petHealth = DEFAULT_PET_HEALTH;
	private int petHappiness = DEFAULT_PET_HAPPINESS;

	// Constructor
	public VirtualPet(String petName) {
		this.petName = petName;
	}
	
	// Getters
	public String getPetName() {
		return petName;
	}

	public int getHealth() {
		return petHealth;
	}

	public int getHappiness() {
		return petHappiness;
	}

}
