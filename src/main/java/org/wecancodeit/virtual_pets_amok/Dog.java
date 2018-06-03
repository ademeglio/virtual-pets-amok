package org.wecancodeit.virtual_pets_amok;

public class Dog extends OrganicPet{

	
	
	public Dog(String petName) {
		super(petName);
	}

	public void takeForWalk() {
		wasteLevel -= 1;
		petHappiness += 1; 
	}



}
