package org.wecancodeit.virtual_pets_amok;

public class Dog extends VirtualPet{

	private static final int DEFAULT_WASTE_LEVEL = 0;
	private int wasteLevel = DEFAULT_WASTE_LEVEL;
	
	// Constructor
	public Dog(String petName) {
		super(petName);
	}

	// Getters
	public int getWaste() {
		// TODO Auto-generated method stub
		return wasteLevel;
	}

}
