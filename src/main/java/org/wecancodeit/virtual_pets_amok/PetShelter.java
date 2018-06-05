package org.wecancodeit.virtual_pets_amok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetShelter {

	Map<Integer, PetBox> petBoxes = new HashMap<Integer, PetBox>();
	
	
	// Getters
	public Collection<PetBox> getAllCagesAndBoxes() {
		return petBoxes.values();
	}

	public ArrayList<RoboPet> getAllRoboPets() {
		ArrayList<RoboPet> roboPets = new ArrayList<RoboPet>();
		for(PetBox petBox : petBoxes.values()) {
			roboPets.addAll(petBox.getAllRobotPets());	
		}
		return roboPets;
	}
	
	// Methods
	public void addToShelter(int cageNum, PetBox petBox) {
		petBoxes.put(cageNum, petBox);
	}

	public void removeFromShelter(int cageNum) {
		petBoxes.remove(cageNum);
	}

	public void oilAllRobots() {
		ArrayList<RoboPet> roboPets = new ArrayList<RoboPet>();
		for(PetBox petBox : petBoxes.values()) {
			roboPets.addAll(petBox.getAllRobotPets());	
		}
		for(RoboPet pet : roboPets) {
			pet.oilPet();
		}
	}



} // End PetShelter()
