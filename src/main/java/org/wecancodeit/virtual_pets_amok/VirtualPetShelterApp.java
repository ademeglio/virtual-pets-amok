package org.wecancodeit.virtual_pets_amok;

import java.util.Collection;
import java.util.Scanner;

import org.wecancodeit.virtual_pet_shelter.VirtualPet;

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
		Cage cage1 = new Cage();
		Cage cage2 = new Cage();
		Cage cage3 = new Cage();
		LitterBox litterBox = new LitterBox();
		
		// Assign the pets to cages or litter box
		cage1.addPet(dog1);
		cage2.addPet(dog2);
		cage3.addPet(roboDog1);
		litterBox.addPet(cat1);
		litterBox.addPet(cat2);
		litterBox.addPet(roboCat1);
		
		// Add cages to shelter		
		petShelter.addToShelter(1, cage1);
		petShelter.addToShelter(2, cage2);
		petShelter.addToShelter(3, cage3);
		petShelter.addToShelter(4, litterBox);
		
		Collection<VirtualPet> petCollection = petShelter.getAllPets();
		
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
			System.out.println(" 1. Feed the pets\t\t4. Adopt a pet"
					   + "\n 2. Water the pets\t\t5. Admit a pet"
					   + "\n 3. Play with a pet\t\t6. Quit");
			
			response = userInput.nextLine();
			
			switch(response) {
			case "1" : // Feed the pets
				petShelter.feedAllPets();
				break;
			
			case "2" : // Water the pets
				petShelter.waterAllPets();
				break;
			
			case "3": // Play with a pet
				System.out.println("How fun! Who would you like to play with? Please choose one or \"Quit\":");
				boolean selectionMade = false;
				
				while (!selectionMade) { // loop through until a proper selection is made.
					for (VirtualPet pet : petCollection) {
						System.out.println("[" + pet.getPetName() + "] " + pet.getPetDescription() );
					}
					response = userInput.nextLine();
					VirtualPet currentPet = petShelter.findPet(response);
							
					if (petCollection.contains(currentPet)) {
						petShelter.playWith(response, 2);
						System.out.println("I think " + currentPet.getPetName() + " is having a great time with you!");
						selectionMade = true;
					} else if (response.toLowerCase().equals("quit")){
						break;
					} else {
						System.out.println("Please pick a name from the list or 'quit'. Thank you.");
					}
				} // end pick a pet to play with	
				break;
				
			case "4": // Adopt a pet
				System.out.println("We knew you couldn't resist! Who would you like to adopt? Type their name or quit to cancel");
				selectionMade = false;
				while (!selectionMade) {
					for (VirtualPet pet : petCollection) {
						System.out.println("[" + pet.getPetName() + "] " + pet.getPetDescription() );
					}
					response = userInput.nextLine();
					
					VirtualPet currentPet = petShelter.findPet(response);
					
					if (petCollection.contains(currentPet)) {
						petShelter.adoptPet(petShelter.findPet(response));
						System.out.println("I think " + currentPet.getPetName() + " and you will have a happy life!");
						selectionMade = true;
					} else if (response.toLowerCase().equals("quit")){
						break;
					} else {
						System.out.println("Please pick a name from the list or 'quit'. Thank you.");
					}
					
				} // end adopt a pet 
				break;				
				
			case "5": // Admit a pet
				System.out.println("Please choose a name for our new guest...");
				String newPetName = userInput.nextLine();
				System.out.println("Please give a brief description of our new guest...");
				String newPetDescription = userInput.nextLine();
				petShelter.addPet(new VirtualPet.Builder().name(newPetName).description(newPetDescription).build());
				System.out.println(petShelter.findPet(newPetName).getPetName() + ", welcome to the family!");

				break;				

			case "6": // Quit
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
