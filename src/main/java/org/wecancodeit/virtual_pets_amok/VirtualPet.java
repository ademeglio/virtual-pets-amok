package org.wecancodeit.virtual_pets_amok;

public class VirtualPet implements Comparable<VirtualPet>{

	// Constants
	private static final int DEFAULT_PET_HEALTH = 10;
	private static final int DEFAULT_PET_HAPPINESS = 5;
	
	// Variables
	protected String petName;
	protected int petHealth = DEFAULT_PET_HEALTH;
	protected int petHappiness = DEFAULT_PET_HAPPINESS;
	protected String petDescription;
	protected PetBox petBox;

	// Constructor
	public VirtualPet(String petName) {
		this.petName = petName;
	}
	
	public VirtualPet(String petName, String petDescription) {
		this.petName = petName;
		this.petDescription = petDescription;
	}
	
	// Getters
	public String getPetName() {
		return petName;
	}

	public int getHealth() {
		return petHealth;
	}
	
	public String getHealthStatus() { // used for pet status
		String petHealthStatus;
		if (petHealth <= 0) {
			petHealthStatus = "DEAD";
		} else
			petHealthStatus =  Integer.toString(petHealth);
		return petHealthStatus;
	}

	public int getHappiness() {
		return petHappiness;
	}
	
	public String getPetDescription() {
		return petDescription;
	}
	
	public int getPetBoxID() {
		return petBox.getBoxID();
	}
	// Comparable
	public int compareTo(VirtualPet s) {
		return petName.compareTo(s.getPetName());
	}
	
	// Methods
	public void assignBox(PetBox petBox) {
		this.petBox = petBox;
	}
	
	public void unAssignBox() {
		this.petBox = null;
	}
	public void tick() { 
		// To be overridden by sub classes
	}
	
	public void play() {
		petHappiness ++;
	}
	


} // End VirtualPet()
