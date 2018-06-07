package org.wecancodeit.virtual_pets_amok;

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
		if (response.toLowerCase() == "quit" || response.toLowerCase() == "exit") {
			System.exit(0);
		}
		
//		Game Loop
		while (true) {
			// Pet Status
			petShelter.allPetStatus();
			// Menu
			
			// Tick
			break;
			
		}  // End Game Loop
		

	} // End Main
	
	

} // End VirtualPetShelterApp()
