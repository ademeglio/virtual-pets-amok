package org.wecancodeit.virtual_pets_amok;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetTest {
	
	PetBox testPetBox;
	VirtualPet testPet1;
	
	@Before
	public void setUp() {
		testPetBox = new PetBox();
		testPet1 = new VirtualPet("Bob");
	}
	
	@Test
	public void shouldAddPet() {
		// setup in setUp()

		// Act
		int petCountStart = testPetBox.getSize();
		testPetBox.addPet(testPet1);
		int petCountEnd = testPetBox.getSize();
		String petName = testPet1.getPetName();
		
		// Assert
		assertEquals(petCountEnd - 1, petCountStart);
		assertEquals(petName, "Bob" );
	}
	
	@Test
	public void shouldReturnHealth() {
		// setup
		// Act
		testPetBox.addPet(testPet1);
		int petHealth = testPet1.getHealth();
		// Assert
		assertEquals(petHealth, 10);
	}
	
	@Test
	public void shouldReturnHappiness() {
		// setup
		// Act
		testPetBox.addPet(testPet1);
		int petHappy = testPet1.getHappiness();
		// Assert
		assertEquals(petHappy, 5);
	}
	
	@Test
	public void shouldGetOrganicPetBoredom() {
		// Act
		testPetBox.addPet(testPet1);
		int petBoredom = testPet1.getBoredomLevel();
		// Assert
		assertEquals(petBoredom, 1);
	}
	
	// ROBO TEST 1
	
	@Test
	public void shouldAddRoboPet() {
		// setup
		RoboPet roboPet = new RoboPet("Copper");
		// Act
		int petCountStart = testPetBox.getSize();
		testPetBox.addPet(roboPet);
		int petCountEnd = testPetBox.getSize();
		String petName = roboPet.getPetName();
		//Assert
		assertEquals(petCountEnd -1, petCountStart);
		assertEquals(petName, "Copper");
	}
	
	@Test
	public void shouldAddTwoRoboPet() {
		// Setup
		RoboPet roboPet1 = new RoboPet("Copper");
		RoboPet roboPet2 = new RoboPet("Bytes");
		// Act
		testPetBox.addPet(roboPet1);
		testPetBox.addPet(roboPet2);
		int petCountStart = testPetBox.getSize();
		// Assert
		assertEquals(petCountStart, 2);
	}
	
	@Test
	public void shouldReturnRustLevel() {
	// setup
	RoboPet roboPet = new RoboPet("Copper");
	// Act
	testPetBox.addPet(roboPet);
	int petRustLevel = roboPet.getPetRustLevel();
	//Assert
	assertEquals(petRustLevel, 1);
	}
	
	@Test
	public void shouldReturnRobotHappiness() {
		// Setup
		RoboPet roboPet1 = new RoboPet("Copper");
		// Act
		testPetBox.addPet(roboPet1);
		int petHappiness1 = roboPet1.getHappiness();
		// Assert
		assertEquals(petHappiness1, 5);		
	}
	
}
