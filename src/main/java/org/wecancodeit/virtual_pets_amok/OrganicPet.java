package org.wecancodeit.virtual_pets_amok;

public class OrganicPet extends VirtualPet{

	private static final int DEFAULT_THIRST_LEVEL = 1;
	private static final int DEFAULT_HUNGER_LEVEL = 1;
	private static final int DEFAULT_WASTE_LEVEL = 1;
	protected int wasteLevel = DEFAULT_WASTE_LEVEL;
	protected int hungerLevel = DEFAULT_HUNGER_LEVEL;
	protected int thirstLevel = DEFAULT_THIRST_LEVEL;

	// Constructor
	public OrganicPet(String petName) {
		super(petName);
	}

	// Getters
	public int getWasteLevel() {
		return wasteLevel ;
	}

	public int getHungerLevel() {
		return hungerLevel ;
	}

	public int getThirstLevel() {
		return thirstLevel ;
	}


}