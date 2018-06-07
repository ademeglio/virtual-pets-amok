package org.wecancodeit.virtual_pets_amok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
		ArrayList<OrganicPet> organicPets = new ArrayList<OrganicPet>();
		for(PetBox petBox : petBoxes.values()) {
			organicPets.addAll( petBox.getAllOrganicPets());
		}
		for (OrganicPet organicPet : organicPets) {
			organicPet.feedPet();
		}
	}

	public void waterAllPets() {
		ArrayList<OrganicPet> organicPets = new ArrayList<OrganicPet>();
		for(PetBox petBox : petBoxes.values()) {
			organicPets.addAll(petBox.getAllOrganicPets());
		}
		for (OrganicPet organicPet : organicPets) {
			organicPet.waterPet();
		}
	}

	public void walkAllDogs() {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		for (PetBox petBox : petBoxes.values()) {
			dogs.addAll(petBox.getAllDogs());
		}
		for (Dog dog : dogs) {
			dog.takeForWalk();
		}
		
	}

	public void runAllTicks() {
		ArrayList<VirtualPet> pets = new ArrayList<VirtualPet>();
		for (PetBox petBox : petBoxes.values()) {
			pets.addAll(petBox.getAllPets());
		}
		for (VirtualPet pet : pets) {
			pet.tick();
		}
	}
	
	// Iterate through pets for introductions.
	public void introducePets() {
		ArrayList<VirtualPet> pets = new ArrayList<VirtualPet>();
		for (PetBox petBox : petBoxes.values()) {
			pets.addAll(petBox.getAllPets());
		}
		Collections.sort(pets);
		for (VirtualPet pet : pets) {
			System.out.println("\t" + pet.getPetName() + ", " + pet.getPetDescription());
		}
	}
	
	// iterate through pets display current status
	public void allPetStatus() {
		// setup list of pets and sort by petName
		ArrayList<VirtualPet> pets = new ArrayList<VirtualPet>();
		for (PetBox petBox : petBoxes.values()) {
			pets.addAll(petBox.getAllPets());
		}
		Collections.sort(pets);
		
		// column headers
		System.out.println("\t\t| HAPPY\t|HEALTH\t|HUNGER\t|THIRST\t|WASTE\t|RUST");
		System.out.println("TYPE\t|NAME\t| LEVEL\t|LEVEL\t|LEVEL\t|LEVEL\t|LEVEL\t|LEVEL");
		System.out.println("--------|-------|-------|-------|-------|-------|-------|------");
		
		// Pet List
		for (VirtualPet pet : pets) {
			System.out.println(
					  pet.getClass().getSimpleName() + "\t|"
					+ pet.getPetName() + "\t|  "
					+ pet.getHappiness() + "\t|  "
					+ pet.getHealth() + "\t|  "
					+ "X" + "\t|  "
					+ "X" + "\t|  "
					+ "X" + "\t|  "
					+ "X");	
		}
		System.out.println("---------------------------------------------------------------");
	}



} // End PetShelter()
