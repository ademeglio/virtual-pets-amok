package org.wecancodeit.virtual_pets_amok;

public class Dog extends OrganicPet implements DogInterface{

	
	
	public Dog(String petName) {
		super(petName);
	}

	@Override
	public void takeForWalk() {
		wasteLevel -= 1;
		petHappiness += 1; 
	}

	public void tick() {
		//Increment Hunger and Decrease petHappiness over time
		
		//If Hunger reaches Max, pet dies
		
		//If petHappiness reaches Min, pet dies
	
		//If Waste reaches a max value, empty and fill the cage
		
	}

} // End Dog()
