package org.wecancodeit.virtual_pets_amok;

public class RoboPet extends VirtualPet{

	private static final int DEFAULT_RUST_LEVEL = 1;
	private int petRustLevel = DEFAULT_RUST_LEVEL;

	// Constructor
	public RoboPet(String petName) {
		super(petName);
	}

	// Getters
	public int getPetRustLevel() {
		return petRustLevel ;
	}

	// Methods
	public void oilPet() {
		petRustLevel --;
		petHappiness ++;
		petHealth ++;
	}
	
	public void tick() {
		// Decrease petHappiness over time increase rust
		petHappiness --;
		petRustLevel ++;
		petHealth --;
		
		// If rust level reaches max, pet dies
		if (petRustLevel >= 10) {
			// pet dies
		}
		
		// If petHappiness reaches min, pet dies
		if (petHappiness <= 0) {
			// pet dies			
		}
		
	}
	
} // End RoboPet()
