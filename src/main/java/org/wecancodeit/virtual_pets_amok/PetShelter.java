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
	
	public ArrayList<OrganicPet> getAllOrganicPets() {
		ArrayList<OrganicPet> organicPets = new ArrayList<OrganicPet>();
		for(PetBox petBox : petBoxes.values()) {
			organicPets.addAll(petBox.getAllOrganicPets());
		}
		return organicPets;
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

	public void cleanAllCages() {
		ArrayList<Cage> cages = new ArrayList<Cage>();
		for(PetBox petBox : petBoxes.values()) {
			if(petBox instanceof Cage) {
				cages.add((Cage) petBox);
			}
		}
		for(Cage cage : cages) {
			cage.scrubPetBox();
		}
	}

	public void cleanAllLitterBoxes() {
		ArrayList<LitterBox> litterBoxes = new ArrayList<LitterBox>();
		for(PetBox petBox : petBoxes.values()) {
			if(petBox instanceof LitterBox) {
				litterBoxes.add((LitterBox) petBox);
			}
		}
		for (LitterBox litterBox : litterBoxes) {
			litterBox.scrubPetBox();
		}
	}

	public void feedAllPets() {
		ArrayList<CatsAndDogsInterface> organicPets = new ArrayList<CatsAndDogsInterface>();
		for(PetBox petBox : petBoxes.values()) {
			organicPets.addAll((Collection<? extends CatsAndDogsInterface>) petBox.getAllOrganicPets());
		}
		for (CatsAndDogsInterface organicPet : organicPets) {
			organicPet.feedPet();
		}
	}

	public void waterAllPets() {
		ArrayList<CatsAndDogsInterface> organicPets = new ArrayList<CatsAndDogsInterface>();
		for(PetBox petBox : petBoxes.values()) {
			organicPets.addAll((Collection<? extends CatsAndDogsInterface>) petBox.getAllOrganicPets());
		}
		for (CatsAndDogsInterface organicPet : organicPets) {
			organicPet.waterPet();
		}
	}



} // End PetShelter()
