package org.wecancodeit.virtual_pets_amok;

public class Cat extends VirtualPet{

	private static final int DEFAULT_WASTE_LEVEL = 0;
	private int wasteLevel = DEFAULT_WASTE_LEVEL;

	public Cat(String petName) {
		super(petName);
	}

	// Getters
	public int getWaste() {
		return wasteLevel;
	}

}
