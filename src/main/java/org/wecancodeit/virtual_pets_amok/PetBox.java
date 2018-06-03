package org.wecancodeit.virtual_pets_amok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetBox {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	private int dirtLevel = 0;
	
	
	// getters
	public int getSize() {
		return pets.size();
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}
	
	
	public ArrayList<RoboPet> getAllRobotPets() {
		ArrayList<RoboPet> roboPets = new ArrayList<>();
		for(VirtualPet pet : pets.values()) {
			if (pet instanceof RoboPet) {
				roboPets.add((RoboPet)pet);
			}
		}
		return roboPets;
	}

	public int getCleanliness() {
		return dirtLevel ;
	}
	
	// Methods
	public void addPet(VirtualPet pet) {
		pets.put(pet.getPetName(), pet);
	}
	
	public void makePetBoxDirty(int wasteLevel) {
		dirtLevel += wasteLevel;
	}
	
	public void scrubPetBox() {
		dirtLevel --;	
	}

	public void removePet(VirtualPet pet) {
		pets.remove(pet.getPetName());	
	}


}
