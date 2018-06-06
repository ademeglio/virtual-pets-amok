package org.wecancodeit.virtual_pets_amok;

public class Dog extends OrganicPet implements DogInterface{

	
	
	public Dog(String petName) {
		super(petName);
	}

	@Override
	public void takeForWalk() {
		wasteLevel -= wasteLevel;
		petHappiness += 2; 
	}

	public void tick() {
		//Increment Hunger and Decrease petHappiness over time
		
		//If Hunger reaches Max, pet dies
		
		//If petHappiness reaches Min, pet dies
	
		//If Waste reaches a max value, empty and fill the cage
		
	}

	public void tick(PetBox petCage) {
		//Increment Hunger and Decrease petHappiness over time
		hungerLevel ++;
		thirstLevel ++;
		petHappiness --;
		
		//If Hunger reaches max, pet dies
		if (hungerLevel >= 10) {
			// pet dies
		}
		//If petHappiness reaches min, pet dies
		if (petHappiness <= 0) {
			// pet dies
		}
		//If Waste reaches a max value, empty and fill the litter box
		if (wasteLevel >= 8) {
			// set WasteLevel to 0 and then dirty the litter box)
			petCage.makePetBoxDirty(wasteLevel);
			wasteLevel -= wasteLevel;
		}
		
	}
	

} // End Dog()
