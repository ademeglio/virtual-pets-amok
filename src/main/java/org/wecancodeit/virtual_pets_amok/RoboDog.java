package org.wecancodeit.virtual_pets_amok;

public class RoboDog extends RoboPet implements DogInterface{

	// Constructors
	public RoboDog(String petName) {
		super(petName);
	}

	public RoboDog(String petName, String petDescription) {
		super(petName);
		this.petDescription = petDescription;
	}
	
	// Methods
	@Override
	public void takeForWalk() {
		petHappiness += 1; 
	}
}
