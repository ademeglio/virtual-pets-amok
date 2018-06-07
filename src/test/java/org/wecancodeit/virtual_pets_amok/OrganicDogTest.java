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
		testCage = new Cage(1);
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
		int wasteLevel = testDog.getWasteLevel();
		// Assert
		assertEquals(wasteLevel, 1);
	}
	
	@Test
	public void shouldReduceWasteAfterWalk() {
		// setup
		int wasteLevelStart = testDog.getWasteLevel();
		testDog.takeForWalk();
		int wasteLevelEnd = testDog.getWasteLevel();
		// Assert
		assertEquals(wasteLevelStart - 1, wasteLevelEnd);
	}
	
	@Test
	public void shouldEffectDogHungerHappinessThirstWhenTickIsRun() {
		// setup
		testCage.addPet(testDog);
		int dogHungerStart = testDog.getHungerLevel();
		int dogHappinessStart = testDog.getHappiness();
		int dogThirstStart = testDog.getThirstLevel();
		// Act
		testDog.tick();
		// Assert
		assertEquals(dogHungerStart + 1, 2);
		assertEquals(dogHappinessStart -1, 4);
		assertEquals(dogThirstStart + 1, 2);
	}
	
}
	
	
