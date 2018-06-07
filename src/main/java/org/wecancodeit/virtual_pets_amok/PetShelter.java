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

	public Collection<VirtualPet> getAllPets() {
		ArrayList<VirtualPet> pets = new ArrayList<VirtualPet>();
		for(PetBox petBox : petBoxes.values()) {
			pets.addAll(petBox.getAllPets());
		}
		return pets;
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
	
	public ArrayList<Dog> getAllShelterDogs() {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		for(PetBox petBox : petBoxes.values()) {
			dogs.addAll(petBox.getAllDogs());
		}
		return dogs;
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
	
	// iterate through pets to display current status
	public void allPetStatus() {
		// setup list of organic pets
		ArrayList<OrganicPet> organicPets = new ArrayList<OrganicPet>();
		for (PetBox petBox : petBoxes.values()) {
			organicPets.addAll(petBox.getAllOrganicPets());
		}
		// setup list of robotic pets
		ArrayList<RoboPet> roboPets = new ArrayList<RoboPet>();
		for (PetBox petBox : petBoxes.values()) {
			roboPets.addAll(petBox.getAllRobotPets());
		}
		
		// column headers
		System.out.println("\t\t| HAPPY\t|HEALTH\t|HUNGER\t|THIRST\t|CAGE/LB|RUST");
		System.out.println("TYPE\t|NAME\t| LEVEL\t|LEVEL\t|LEVEL\t|LEVEL\t|DIRTY\t|LEVEL");
		System.out.println("--------|-------|-------|-------|-------|-------|-------|------");
		
		// Organic Pet List
		for (OrganicPet pet : organicPets) {
			System.out.println(
					  pet.getClass().getSimpleName() + "\t|"
					+ pet.getPetName() + "\t|  "
					+ pet.getHappiness() + "\t|  "
					+ pet.getHealthStatus() + "\t|  "
					+ pet.getHungerLevel() + "\t|  "
					+ pet.getThirstLevel() + "\t|  "
					+ pet.petBox.isBoxClean() + "\t|  "
					+ "n/a");	
		}
		// Robotic Pet List
		for (RoboPet pet : roboPets) {
			System.out.println(
					  pet.getClass().getSimpleName() + "\t|"
					+ pet.getPetName() + "\t|  "
					+ pet.getHappiness() + "\t|  "
					+ pet.getHealth() + "\t|  "
					+ "n/a" + "\t|  "
					+ "n/a" + "\t|  "
					+ pet.petBox.isBoxClean() + "\t|  "
					+ pet.getPetRustLevel());	
		}
		System.out.println("---------------------------------------------------------------");
	}




} // End PetShelter()
