package org.wecancodeit.virtual_pets_amok;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class OrganicDogTest {

	Cage testCage;
	Dog testDog;
	
	@Before
	public void setUp() {
		testCage = new Cage();
		testDog = new Dog("Rover");
	}
		
	@Test
	public void shouldAddDogToCage() {
		// Setup
		// Act
		testCage.addPet(testDog);
		Collection<VirtualPet> checkPets = testCage.getAllPets();
		// Assert
		assertThat(checkPets, contains(testDog));
	}
	
	@Test
	public void shouldGetDogWasteLevel() {
		//setup
		// Act
		testCage.addPet(testDog);
		int wasteLevel = testDog.getWaste();
		// Assert
		assertEquals(wasteLevel, 0);
	}
	
	// For Cat & Dog: Food & Thirst 
}
	
	
