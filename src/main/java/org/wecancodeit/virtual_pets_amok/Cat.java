package org.wecancodeit.virtual_pets_amok;

public class Cat extends OrganicPet{

	// Constructor
	public Cat(String petName) {
		super(petName);
	}

	public void tick(PetBox litterBox) {
		//Increment Hunger and Decrease petHappiness over time
		hungerLevel ++;
		thirstLevel ++;
		petHappiness --;
		
		//If Hunger reaches Max, pet dies
		if (hungerLevel >= 10) {
			// pet dies
		}
		//If petHappiness reaches Min, pet dies
		if (petHappiness <= 0) {
			// pet dies
		}
		//If Waste reaches a max value, empty and fill the litter box
		if (wasteLevel >= 8) {
			// set WasteLevel to 0 and then dirty the litter box)
			litterBox.makePetBoxDirty(wasteLevel);
			wasteLevel -= wasteLevel;
		}
		
	}
	
}  // End Cat()
