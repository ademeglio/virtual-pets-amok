package org.wecancodeit.virtual_pets_amok;

public class RoboDog extends RoboPet implements DogInterface{

	public RoboDog(String petName) {
		super(petName);
	}

	@Override
	public void takeForWalk() {
		petHappiness += 1; 
	}
}
