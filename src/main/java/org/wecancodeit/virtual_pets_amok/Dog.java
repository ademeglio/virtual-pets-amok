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



}
