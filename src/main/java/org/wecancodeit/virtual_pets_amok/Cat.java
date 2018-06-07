package org.wecancodeit.virtual_pets_amok;

public class Cat extends OrganicPet {

	// Constructor
	public Cat(String petName) {
		super(petName);
	}

	public Cat(String petName, String petDescription) {
		super(petName);
		this.petDescription = petDescription;
	}
	
	// Methods
	
	public void tick() {
		//Increment Hunger and Decrease petHappiness over time
		hungerLevel ++;
		thirstLevel ++;
		petHappiness --;
		
		//If Hunger reaches Max, pet dies
		if (hungerLevel >= 10) {
			// pet dies
			petHealth = 0;
		}
		//If petHappiness reaches Min, pet dies
		if (petHappiness < 0) {
			// pet dies
			petHealth = 0;
		}
		//If Waste reaches a max value, empty and fill the litter box
		if (wasteLevel >= 6) {
			// set WasteLevel to 0 and then dirty the litter box)
			petBox.makePetBoxDirty(wasteLevel);
			wasteLevel -= wasteLevel;
		}
		
	}
	
}  // End Cat()
