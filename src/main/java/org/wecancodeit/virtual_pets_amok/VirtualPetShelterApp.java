package org.wecancodeit.virtual_pets_amok;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class VirtualPetShelterApp {

	/*
	 * WeCanCodeIT Module Project 4 by Anthony J. DeMeglio in partnership with
	 * Siddiqa Abdullah 6/6/2018
	 * 
	 * Virtual Pet Shelter Volunteer at the pet shelter and take care of the the
	 * pets! Now we have some robotic pets to deal with too!
	 * 
	 * https://github.com/ademeglio/virtual-pets-amok
	 * 
	 */

	public static void main(String[] args) {
		
		String userName = "";
		String response = "";
		boolean yesNo = true;
		int shelterCageID = 0;
		
		Scanner userInput = new Scanner(System.in);
		QuestionAsker asker = new QuestionAsker(userInput);
		
// 		Setup Shelter		
		PetShelter petShelter = new PetShelter();
		
		// Add pets to shelter
		Dog dog1 = new Dog("Riley", "likes to run in circles!");
		Dog dog2 = new Dog("Jordan", "is so cute!");
		RoboDog roboDog1 = new RoboDog("Angel", "is futurastic!");
		Cat cat1 = new Cat("Felix", "looks like a tiger!");
		Cat cat2 = new Cat("Buster", "is so playful!");
		RoboCat roboCat1 = new RoboCat("Titan", "is so shiny!");
		
		// Add cages/litter box(es) to shelter
		Cage cage1 = new Cage(shelterCageID++);
		Cage cage2 = new Cage(shelterCageID++);
		Cage cage3 = new Cage(shelterCageID++);
		LitterBox litterBox = new LitterBox(shelterCageID++);
		
		// Assign the pets to cages or litter box
		cage1.addPet(dog1);
		cage2.addPet(dog2);
		cage3.addPet(roboDog1);
		litterBox.addPet(cat1);
		litterBox.addPet(cat2);
		litterBox.addPet(roboCat1);
		
		// Add cages to shelter		
		petShelter.addToShelter(cage1.getBoxID(), cage1);
		petShelter.addToShelter(cage2.getBoxID(), cage2);
		petShelter.addToShelter(cage3.getBoxID(), cage3);
		petShelter.addToShelter(litterBox.getBoxID(), litterBox);
		
		// Map out all pets
		Map<String, VirtualPet> petCollection = new HashMap<String, VirtualPet>();
		for(VirtualPet pet : petShelter.getAllPets()) {
			petCollection.put(pet.getPetName(), pet);
		}
		
// 		Welcome
		userName = asker.verifyString("Hello, what is your first name?");
		
		System.out.println("\nWelcome " + userName + " to the AJD Animal Rescue Shelter."
				+ " Thank you for volunteering!"
				+ "\nAll we ask is that you care for our pets by simply keeping the"
				+ " the animals happy\nby feeding, walking (where appropriate!),"
				+ " playing with them and keeping their cages and\nlitter box tidy\n");
			
		// opportunity to exit the game or be introduced to current pet list to start
		yesNo = asker.yesOrNo("Would you like to meet the animals (Y or N)?");
		if (yesNo) {
			System.out.println(userName + ", let me introduce you to our pets...");
			petShelter.introducePets();			
		} else {
			System.out.println("Well, thanks for stopping by, maybe next time!");
			System.exit(0);
		}
		
		
		/*
		 *  The following helps space out text if the console is short and accepts
		 *  quit or exit to stop the game before you go into the game loop
		 */
		System.out.println("\nWhen you are ready to check on the animals, hit enter...");
		response = userInput.nextLine();
		if (response.toLowerCase().equals("quit") || response.toLowerCase().equals("exit")
											 || response.toLowerCase().equals("q")) {
			System.exit(0);
		}
		
//		Game Loop
		while (true) {
			// Pet Status
			petShelter.allPetStatus();
			
			// Menu
			System.out.println("What would you like to do (1 - 6)?\n");
			System.out.println(" 1. Feed the pets\t\t6. Clean the litter box"
					   + "\n 2. Water the pets\t\t7. Oil all RoboPets"
					   + "\n 3. Play with a pet\t\t8. Adopt a pet"
					   + "\n 4. Walk the Dogs\t\t9. Admit a pet"
					   + "\n 5. Clean dog cage(s)\t\t10. Quit");
			
			response = userInput.nextLine();
			
			switch(response) {
			case "1" : // Feed the pets
				petShelter.feedAllPets();
				break;
			
			case "2" : // Water the pets
				petShelter.waterAllPets();
				break;
			
			case "3": // Play with a pet
				
				while(true) {
					System.out.println("Awesome! Who would you like to play with? Type their name or \"Quit\" to cancel:");
					petShelter.introducePets();	
					response = userInput.nextLine();
					
					if(response.toLowerCase().equals("quit")) {							// user decides not to play with pet
						break; 
					} else if (petShelter.getAllPets().contains(petCollection.get(response))){		// validate user selection
						petShelter.playWith(response);
						break;
					} else {
						System.out.println("Please enter a valid selection.");
						continue;
					}
						
				} // End while
				break;
				
			case "4" : // Walk the dogs
				petShelter.walkAllDogs();
				break;
				
			case "5" : // Clean the dog cages
				// gather all the dogs and list them along with cageID as options to clean
				Collection<Dog> dogs = petShelter.getAllShelterDogs();
				for (Dog dog : dogs) {
					System.out.println(dog.getPetName() + "Cage: " + dog.getPetBoxID());
				}
				boolean continueClean = true;
				while (continueClean) {
					System.out.println("Which cage would you like to clean? "
							+ "\n Enter cage id or type 'All' to clean all cages.");
					response = userInput.nextLine();
					if (response.toLowerCase().equals("all")) { // Cleans all cages
						petShelter.cleanAllCages();
					} else if (response.toLowerCase().equals("quit") || response.toLowerCase().equals("q") // changed mind about cleaning
							|| response.toLowerCase().equals("exit")) {
						break;
					} else {
						// try response and it throws an error, start again.
						try {
							int cageID = Integer.parseInt(response); 
							petShelter.cleanCage(cageID);	
							break;
						} catch ( NumberFormatException e){
							System.out.println("Please enter a valid selection.");
							continue;
						} // end catch
							
					} // end else
				} // end while loop
				break;
				
			case "6": // clean the litter box(es)	
				petShelter.cleanAllLitterBoxes();
				break;
				
			case "7": //oil all RoboPets
				petShelter.oilAllRobots();
				break;

				
			case "8": // Adopt a pet
				System.out.println("We knew you couldn't resist! Who would you like to adopt? Type their name or \"Quit\" to cancel");
				boolean selectionMade = false;
				while (!selectionMade) {
					petShelter.introducePets();
					response = userInput.nextLine();
					
					if(response.toLowerCase().equals("quit")) {
						break;
					} else if (petShelter.getAllPets().contains(petCollection.get(response))) {
						System.out.println("I think " + petCollection.get(response).getPetName() + " and you will have a happy life!");
						petShelter.adoptPet(response);
						selectionMade = true;
						break;
					} else {
						System.out.println("Please pick a name from the list or 'quit'. Thank you.");
					}
					
				} // end adopt a pet 
				break;				
				
			case "9": // Admit a pet
				System.out.println("Please select the type of animal to admit... ");
				System.out.println("1. Cat\t\t3. RoboCat"
								+  "2. Dog\t\t4. RoboDog");
				String newPetType = userInput.nextLine();
				String newPetName = asker.verifyString("Please choose a name for our new guest...");
				String newPetDescription = asker.verifyString("Please give a brief description of our new guest...");
				
				// How to create the pet depends on the pet type
				switch (newPetType) {
				
				}
//				petShelter.addPet(new VirtualPet.Builder().name(newPetName).description(newPetDescription).build());
//				System.out.println(petShelter.findPet(newPetName).getPetName() + ", welcome to the family!");

				break;				

			case "10": // Quit
				userInput.close();
				System.exit(0);
				
			default :
				System.out.println("Please make a valid selection (1 - 6)");
			} // End switch
			
			// Tick
			petShelter.runAllTicks();
			break;
		}  // End Game Loop
		

	} // End Main
	
	

} // End VirtualPetShelterApp()
