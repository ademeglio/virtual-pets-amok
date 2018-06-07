package org.wecancodeit.virtual_pets_amok;

public class Dog extends OrganicPet implements DogInterface {

	// Constructor
	public Dog(String petName) {
		super(petName);
	}

	public Dog(String petName, String petDescription) {
		super(petName);
		this.petDescription = petDescription;
	}
	
	// Methods
	@Override
	public void takeForWalk() {
		wasteLevel -= wasteLevel;
		petHappiness += 2; 
	}

	public void tick() {
		//Increment Hunger and Decrease petHappiness over time
		hungerLevel ++;
		thirstLevel ++;
		petHappiness --;
		
		//If Hunger reaches max, pet dies
		if (hungerLevel >= 10) {
			// pet dies
			petHealth = 0;
		}
		//If petHappiness reaches min, pet dies
		if (petHappiness < 0) {
			// pet dies
			petHealth = 0;
		}
		//If Waste reaches a max value, empty and fill the cage
		if (wasteLevel >= 6) {
			// set WasteLevel to 0 and then dirty the cage)
			petBox.makePetBoxDirty(wasteLevel);
			wasteLevel -= wasteLevel;
		}
		
	}
	

} // End Dog()
